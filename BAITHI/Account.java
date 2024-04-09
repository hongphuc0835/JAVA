package BAITHI;

import java.util.Scanner;

public class Account {
    private String customerCode;
    private String customerName;
    private int accNumber;
    private long amount;

    public Account() {
    }


    public void input(){
        Scanner scanner = new Scanner(System.in);


        //nhâp customerCode
    while (true){
        System.out.println("Nhập mã khách hàng (5 ký tự):");
        String code = scanner.nextLine();
        if (code.length() == 5){
            this.customerCode = code;
            break;
        }else {
            System.out.println("Mã khách hàng phải đúng 5 ký tự!!!");
        }
    }
        System.out.print("nhap ten khach hang: ");
        this.customerName = scanner.nextLine();
    while (true){
        System.out.println("Nhập số nhận dạng tài khoản (6 chữ số bắt đầu bằng '100'):");
        int sotaikhoan = scanner.nextInt();
        if (String.valueOf(sotaikhoan).length() == 6 && String.valueOf(sotaikhoan).startsWith("100")){
            this.accNumber = sotaikhoan;
            break;
        }else {
            System.out.println("số nhận dạng tài khoản phải 6 chữ số vài bắt đầu bằng '100'!!!");
        }
    }
    this.amount = 0; // so tien mac dinh
    }
    public void depositAndWithdraw(long money, int type) {
       if (type == 0){
            if (money >0){
                this.amount += money;
                System.out.println("Gưi tien thanh công");
            }else {
                System.out.println("so tien phai la so dung");
            }
       }else if (type == 1 ){
           if (money >0 && money <= this.amount){
               this.amount -= money;
               System.out.println("rut tien thanh cong");
           } else {
               System.out.println("rut tien k thanh cong!!!");
           }
        }
        }

    @Override
    public String toString() {
        return
                "Mã khách hàng:" + customerCode + '\n' +
                "Tên khách hàng:" + customerName + '\n' +
                "Số nhận dạng tài khoản:" + accNumber +'\n'+
                "Số tiền:" + amount ;
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.input();

        Scanner scanner = new Scanner(System.in);
        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.print("Bạn muốn gửi tiền(0), rút tiền(1) hay thoát(2)? ");
            int type = scanner.nextInt();

            if (type == 2) {
                continueTransaction = false;
                break;
            }

            if (type != 0 && type != 1) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            System.out.print("Nhập số tiền: ");
            long money = scanner.nextLong();
            account.depositAndWithdraw(money, type);

            System.out.println(account.toString());
        }
    }
}

