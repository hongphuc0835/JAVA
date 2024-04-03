package danhsachmang;
import java.util.ArrayList;
public class main {
    public static void main(String[] args) {
        ArrayList<String> myObj = new ArrayList<String>();
        // them phan tu vao mang
        myObj.add("asdfg");
        myObj.add("qewrytruy");
        myObj.add("asdfghj");
        System.out.println(myObj);
        //get() hien thi
        System.out.println(myObj.get(1));

        //set() thay doi phan tu
        myObj.set(1,"wertyui");
        System.out.println(myObj.get(1));

        //remove() xoa phan tu bang chi muc
        // size() kich thuoc cua mang

    }
}
