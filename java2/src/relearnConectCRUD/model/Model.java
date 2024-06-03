package relearnConectCRUD.model;

import relearnConectCRUD.connectDTB.MySqlConnect;
import relearnConectCRUD.entity.*;

import java.lang.reflect.Field;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model<T extends Entity<?>> implements ModelDAO{
    private Class<T> entityClass;



    private List<T> entities = new ArrayList<>();// T dai dien cho cac thuc the entity( Product, Customer....)
    public static Connection connection;
    public static Connection openConnection() throws SQLException {
        connection = MySqlConnect.getMySQLConnection();
        return connection;
    }
    public static PreparedStatement pstm;
    public static PreparedStatement openPstm(String query) throws SQLException {
        pstm = openConnection().prepareStatement(query);
        return pstm;
    }
    public static boolean exUpdate() throws SQLException {
        int check = pstm.executeUpdate();
        return check>0;
    }
    public static ResultSet exQuery() throws SQLException {
        ResultSet rs = pstm.executeQuery();
        return rs;
    }
    private String getTableName(Class<T> entityClass){
        String tableName = entityClass.getSimpleName();
        return tableName;
    }
    private StringBuilder queryInsert(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("insert into ");
        query.append(tableName).append(" (");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i<fields.length;i++){
            if (i>0){
                query.append(", ");
            }
            query.append(fields[i].getName());
        }
        query.append(") values (");
        for (int i = 0 ; i<fields.length;i++){
            if (i>0){
                query.append(", ");
            }
            query.append("?");
        }
        query.append(")");
        return query;
    }
    private StringBuilder queryUpdate(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("update ");
        query.append(tableName).append(" set ");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 1 ; i< fields.length;i++){
            if (i > 1){
                query.append(", ");
            }
            query.append(fields[i].getName()).append(" = ?");
        }
        query.append(" where ").append(fields[0].getName()).append(" = ?");


        return query;
    }
    private StringBuilder queryDelete(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("delete from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");

        return query;
    }
    private StringBuilder queryGetAll(Class<T> entityClass) {
        String tableName = getTableName(entityClass);
        StringBuilder query = new StringBuilder("select * from ");
        query.append(tableName);
        return query;
    }
    private StringBuilder queryGetEntityById(Entity entity){
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("select * from ");
        query.append(tableName).append(" where ");
        Field[] fields = entity.getClass().getDeclaredFields();
        query.append(fields[0].getName()).append(" = ?");
        return query;
    }
    @Override
    public boolean insert(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryInsert(entity).toString();
        pstm = openPstm(query);
        int parameterIndex = 1;
        for (Field field : fields){
            field.setAccessible(true);
            Object value = field.get(entity);
            pstm.setObject(parameterIndex++, value);
        }
        boolean check = exUpdate();
        return check;
    }

    @Override
    public boolean update(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryUpdate(entity).toString();
        System.out.println(query);
        pstm  = openPstm(query);
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(entity);
            pstm.setObject(i, value);
        }
        fields[0].setAccessible(true);
        Object value1 = fields[0].get(entity);
        pstm.setObject(fields.length,value1);
        boolean rowsUpdated = exUpdate();

        return rowsUpdated;
    }

    @Override
    public boolean delete(Entity entity) throws IllegalAccessException, SQLException {
        String query = queryDelete(entity).toString();
        System.out.println(query);
        pstm = openPstm(query);
        Field[] fields = entity.getClass().getDeclaredFields();
        fields[0].setAccessible(true);
        Object value = fields[0].get(entity);
        System.out.println(value);
        pstm.setObject(1,value);
        boolean rowsUpdated = exUpdate();
        return rowsUpdated;
    }





    @Override
    public List<T> getAll(Class entityClass) throws SQLException {
        List<T> entities = new ArrayList<>();
        String query = queryGetAll(entityClass).toString();
        System.out.println(query);
        pstm = openPstm(query);
        ResultSet rs = exQuery();
        while (rs.next()) {
            T newEntity = (T) createEntityFromResultSet(rs, entityClass);
            entities.add(newEntity);
        }

        return entities;
    }

    private T createEntityFromResultSet(ResultSet rs, Class<T> entityClass) throws SQLException {
        try {
            if (entityClass == null) {
                throw new IllegalStateException("entityClass has not been initialized");
            }

            T newEntity = entityClass.newInstance();
            Field[] fields = entityClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = rs.getObject(field.getName());
                field.set(newEntity, value);
            }

            return newEntity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Entity<?> getEntityById(Entity entity) throws SQLException, IllegalAccessException {
        String query = queryGetEntityById(entity).toString();
        openPstm(query);
        Field[] fields = entity.getClass().getDeclaredFields();
        fields[0].setAccessible(true);
        Object value = fields[0].get(entity);
        System.out.println(value);
        pstm.setObject(1, value);
        ResultSet rs = exQuery();

        Entity newEntity = null; // Khởi tạo một đối tượng Entity mới

        if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên của ResultSet
            if (entity instanceof Customer) {
                newEntity = new Customer();
            } else if (entity instanceof Product){
                newEntity = new Product();
            }else if (entity instanceof Orders){
                newEntity = new Orders();
            }else if (entity instanceof Orderdetail){
                newEntity = new Orderdetail();
            }

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String columnName = rs.getMetaData().getColumnName(i);

                Field field = Arrays.stream(fields)
                        .filter(f -> f.getName().equals(columnName))
                        .findFirst()
                        .orElse(null);
                if (field != null) {
                    field.setAccessible(true);
                    Object fieldValue = rs.getObject(i);
                    if (field.getType() == int.class) {
                        field.setInt(newEntity, (int) fieldValue);
                    } else if (field.getType() == String.class) {
                        field.set(newEntity, fieldValue.toString());
                    } else if (field.getType() == double.class) {
                        field.setDouble(newEntity, (double) fieldValue);
                    } // Thêm các kiểu dữ liệu khác nếu cần
                    // Các kiểu dữ liệu khác
                }
            }
        }

        return newEntity;
    }


    @SuppressWarnings("unchecked")
    private T castEntity(Entity entity) {
        return (T) entity;
    }

}
