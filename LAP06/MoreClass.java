package LAP06;

public class MoreClass {

    public static void main(String[] args) {
        Object obj1 = new Object();
        System.out.println(obj1);

        Object obj2 = new Object(){
            @Override
            public String toString() {
                return "this is obj2";
            }
        };
        System.out.println(obj2);

    }
}

/**
 * 1 khi chạy chương trình sout(obj1) sẽ hiển thị ra đoạn mã có dạng hashcode của đối tượng obj1
 *
 * 2 sự khác biệt giữa hai dốid tượng là obj2 đã được ghi đè phuong thức toString() khi đươcj in ra
 */
