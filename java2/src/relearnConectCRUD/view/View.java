package relearnConectCRUD.view;

import relearnConectCRUD.controller.Controller;
import relearnConectCRUD.entity.*;
import relearnConectCRUD.model.Model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class View {
    Model<Customer> customerModel = new Model<>();
    Model<Product> productModel = new Model<>();
    Model<Orders> ordersModel = new Model<>();
    Model<Orderdetail>orderdetailModel = new Model<>();
    Controller<Customer> customerController = new Controller<>(customerModel);
    Controller<Product> productController = new Controller<>(productModel);
    Controller<Orders> ordersController = new Controller<>(ordersModel);
    Controller<Orderdetail> orderdetailController = new Controller<>(orderdetailModel);
    public void menu(){
        System.out.println("  Enter your selection =>");
        System.out.println("1. Customer");
        System.out.println("2. Product");
        System.out.println("3. Orders");
        System.out.println("4. Orders Detail");
        System.out.println("0. Exit");
    }
    public void choiceMenu() throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("CUSTOMER");
                    customerChoice();
                case 2:
                    System.out.println("PRODUCT");
                    productChoice();
            }
        }
    }
    public void menuProduct(){
        System.out.println(" Enter your selection =>");
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get All");
        System.out.println("5. Search");
        System.out.println("0. Back");
    }
    public void productChoice(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuProduct();
            int chose = scanner.nextInt();
            try {
                switch (chose) {
                    case 1:
                        System.out.println("Create");
                        break;
                    case 2:
                        System.out.println("Update");
                        break;
                    case 3:
                        System.out.println("Delete");
                        break;
                    case 4:
                        System.out.println("Get all");

                        break;
                    case 5:
                        System.out.println("Search");
                        break;
                    case 0:
                        choiceMenu();
                        exit = true;
                        break;
                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }
            }catch (Exception e){
                System.out.println("da bi loi data!");
            }
        }
    }
    public void menuCustomer(){
        System.out.println(" Enter your selection =>");
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get All");
        System.out.println("5. Search");
        System.out.println("0. Back");
    }
    public void customerChoice() throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            menuCustomer();
            int chose = scanner.nextInt();

                switch (chose) {
                    case 1:
                        System.out.println("Create");
                        createCustomer();
                        break;
                    case 2:
                        System.out.println("Update");
                        updateCustomer();
                        break;
                    case 3:
                        System.out.println("Delete");
                        deleteCustomer();
                        break;
                    case 4:
                        System.out.println("Get All");
                        getAllCustomer();
                        break;
                    case 5:
                        System.out.println("Search");
                        getCustomerById();
                        break;
                    case 0:
                        choiceMenu();
                        exit = true;
                        break;
                    default:
                        System.out.println("Khong co lua chon nay");
                        break;
                }

        }
    }
    public void createCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new Customer Id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the first name:");
        String fName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(id,fName,lname,email,phone);
        customerController.insert(customer);
    }
    public void updateCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the  Customer Id update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the first name:");
        String fName = scanner.nextLine();
        System.out.println("Enter the last name:");
        String lname = scanner.nextLine();
        System.out.println("Enter the email:");
        String email = scanner.nextLine();
        System.out.println("Enter the phone number:");
        int phone = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(id,fName,lname,email,phone);
        customerController.update(customer);
    }
    public void deleteCustomer() throws SQLException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Customer Id delete:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer();
        customer.setCustomer_id(id);
        customerController.delete(customer);
    }
    public void getAllCustomer() throws SQLException {
        Customer customer = new Customer();
        List<Customer> list = customerController.list(customer) ;
        for (Customer l : list){
            System.out.println(l.toString());
        }
    }
    public void getAllProduct() throws SQLException {
        Product product = new Product();
        List<Product> list = productController.list(product) ;
        for (Product l : list){
            System.out.println(l.toString());
        }
    }

    public  void getCustomerById() throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id customer search");
        int id = scanner.nextInt();
        Customer customer = new Customer(id,null,null,null,0);

        Entity entity = customerController.getEntityById(customer);
        System.out.println(entity.toString());
    }
}
