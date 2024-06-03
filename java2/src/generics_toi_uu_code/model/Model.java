package generics_toi_uu_code.model;

import generics_toi_uu_code.entity.Entity;
import relearnConectCRUD.connectDTB.MySqlConnect;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Model<T extends Entity<?>> implements ModelDAO {
    private Class<T> entityClass;


    private List<T> entities = new ArrayList<T>(); //T dai dienj cho cac thuc the entity(customer, product...)
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
        return check > 0;
    }

    public static ResultSet exQuery() throws SQLException {
        ResultSet rs = pstm.executeQuery();
        return rs;
    }

    private String getTableName(Class<T> entityClass) {
        String tableName = entityClass.getSimpleName();
        return tableName;
    }

    private StringBuilder queryInsert(Entity entity) {
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("insert into ");
        query.append(tableName).append(" (");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                query.append(", ");
            }
            query.append(fields[i].getName());
        }
        query.append(") values (");
        for (int i = 0; i < fields.length; i++) {
            if (i > 0) {
                query.append(", ");
            }
            query.append("?");
        }
        query.append(")");
        return query;
    }

    private StringBuilder queryUpdate(Entity entity) {
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("update ");
        query.append(tableName).append("set");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            if (i > 1) {
                query.append(", ");
            }
            query.append(fields[i].getName()).append(" = ?");
        }
        query.append(" where ").append(fields[0].getName()).append(" = ?");

        return query;
    }

    private StringBuilder queryDelete(Entity entity) {
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

    private StringBuilder queryGetEntityById(Entity entity) {
        String tableName = getTableName((Class<T>) entity.getClass());
        StringBuilder query = new StringBuilder("select * from");
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
        for (Field field : fields) {
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
        pstm = openPstm(query);
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(entity);
            pstm.setObject(i, value);
        }
        fields[0].setAccessible(true);
        Object value1 = fields[0].get(entity);
        pstm.setObject(fields.length, value1);
        boolean rowsUpdated = exUpdate();

        return rowsUpdated;
    }

    @Override
    public boolean delete(Entity entity) throws SQLException, IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        String query = queryDelete(entity).toString();
        System.out.println(query);
        pstm = openPstm(query);
        fields[0].setAccessible(true);
        Object value = fields[0].get(entity);
        System.out.println(value);
        pstm.setObject(1, value);
        boolean rowsUpdated = exUpdate();

        return rowsUpdated;
    }

    @Override
    public Entity<?> getEntityById(Entity entity) throws SQLException, IllegalAccessException {

        return null;
    }

    @Override
    public List getAll(Class EntityClass) throws SQLException {
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
}