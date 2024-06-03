package generics_toi_uu_code.entity;

public class Product extends Entity<Integer>{
    private int product_id;
    private String product_name;
    private String description;
    private double price;

    public Product(int product_id, String product_name, String description, double price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

    public Product(Integer id, int product_id, String product_name, String description, double price) {
        super(id);
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
