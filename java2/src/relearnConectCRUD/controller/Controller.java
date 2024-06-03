package relearnConectCRUD.controller;

import relearnConectCRUD.entity.Entity;
import relearnConectCRUD.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Controller <T extends Entity<?>> {
    private Model model = new Model<>();

    public Controller(Model model) {
        this.model = model;
    }

    public void insert(Entity entity) throws SQLException, IllegalAccessException {
        model.insert(entity);
    }
    public void  update(Entity entity) throws SQLException, IllegalAccessException {
        model.update(entity);
    }
    public void delete(Entity entity) throws SQLException, IllegalAccessException {
        model.delete(entity);
    }
    public List<T> list(Entity entity) throws SQLException {
        List<T> list = model.getAll(entity.getClass());
        return list;
    }
    public Entity<T> getEntityById(Entity entity) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        System.out.println(entity.toString());
        Entity<T> entity1 = model.getEntityById(entity);
        return entity1;
    }

}
