package relearnConectCRUD;

import relearnConectCRUD.view.View;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        View view = new View();
        view.choiceMenu();
//        view.getAllProduct();
    }
}
