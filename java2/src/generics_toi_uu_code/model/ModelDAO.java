package generics_toi_uu_code.model;

import generics_toi_uu_code.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface ModelDAO <T extends Entity<?>>{

    public boolean insert(Entity entity) throws SQLException, IllegalAccessException;
    public boolean update(Entity entity) throws SQLException, IllegalAccessException;
    public boolean delete(Entity entity) throws SQLException, IllegalAccessException;
    public T getEntityById(Entity entity) throws SQLException, IllegalAccessException;
   public  List getAll(Class EntityClass) throws SQLException;
}
