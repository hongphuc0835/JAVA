package ke_thua;

public class Car extends Vehicle {
    private String modeName = "mustang";

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.honk();
        System.out.println(myCar.brand + " " + myCar.modeName);
    }
}

/**
 * Tại sao và khi nào nên sử dụng "Kế thừa"?
 * - Hữu ích cho khả năng sử dụng lại mã: sử dụng lại các thuộc tính và phương thức của một lớp hiện có khi bạn tạo một lớp mới.
 *
 * Mẹo: Ngoài ra, hãy xem chương tiếp theo, Đa hình , chương này sử dụng các phương thức kế thừa để thực hiện các tác vụ khác nhau.
 */
