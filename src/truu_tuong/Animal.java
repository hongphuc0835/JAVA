package truu_tuong;

public abstract class Animal
{
    /**
     * Phương thức trừu tượng: chỉ có thể được sử dụng trong một lớp trừu tượng và nó không có phần thân. Phần thân được cung cấp bởi lớp con (được kế thừa từ).
     */
    public  abstract  void animalSound();
    public void Sleep(){
        System.out.println("zzz");
    }
}


/**
 * Trừu tượng hóa dữ liệu là quá trình ẩn một số chi tiết nhất định và chỉ hiển thị thông tin cần thiết cho người dùng.
 * Sự trừu tượng hóa có thể đạt được bằng các lớp hoặc giao diện trừu tượng (bạn sẽ tìm hiểu thêm về điều này trong chương tiếp theo).
 */