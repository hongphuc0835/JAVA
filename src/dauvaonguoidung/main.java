package dauvaonguoidung;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter name, age and salary:");

        // String input
        String name = myObj.nextLine();

        // Numerical input
        int age = myObj.nextInt();
        double salary = myObj.nextDouble();

        // Output input by user
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}

/**
 * nextBoolean() Đọc giá trị boolean từ người dùng
 *
 * nextByte() Đọc byte giá trị từ người dùng
 *
 * nextDouble() Đọc giá trị kép từ người dùng
 *
 * nextFloat() Đọc giá trị float từ người dùng
 *
 * nextInt() Đọc int value từ người dùng
 *
 * nextLine() Đọc chuỗi giá trị từ người dùng
 *
 * nextLong() Đọc một giá trị dài từ người dùng
 *
 * nextShort() Đọc một giá trị ngắn từ người dùng
 */
