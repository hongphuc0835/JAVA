package relearnConectCRUD.model;

import relearnConectCRUD.entity.Entity;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface ModelDAO <T extends Entity<?>>{
    public boolean insert(Entity entity) throws SQLException, IllegalAccessException;
    public boolean update(Entity entity) throws SQLException, IllegalAccessException;
    public boolean delete(Entity entity) throws IllegalAccessException, SQLException;

    public T getEntityById(Entity entity) throws SQLException, IllegalAccessException;

    public List getAll(Class entityClass) throws SQLException;
}
