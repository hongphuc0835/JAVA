package LAP06;

public class Client {
     /**
      * Constructor for objects of class Client
      */
     public Client() {

     }

     public void doUnchecked(String value) {
          // Can phai check exception, neu khong --> bug
          int result=canThrowUncheckedException(value);
          System.out.println("result="+result);
     }

     private int canThrowUncheckedException(String value) {
          return Integer.parseInt(value);
     }

     public void doChecked() {
          try {
               // Buoc phai check exceptions o day! Khong cach nao khac
               canThrowCheckedException();
               System.out.println("OK");
          }catch(Exception ex) {
               System.out.println(ex);
          }
     }

     private void canThrowCheckedException() throws Exception{
          throw new Exception("Failure");
     }
}

/**
 * 1. Phân biệt giữa Checked Exception và Unchecked Exception:
 * Checked Exception:
 * là ngoại lệ mà trình biên dich yêu cầu xử lý hoặc khai báo (throw) trong mã nguồn
 * Unchecked Exception:
 * là các ngoại lệ không bắt buôc phải được xư lý hoạc khai báo trong mã nguồn
 */

/**
 *2. Sử dụng Checked Exceptions và Unchecked Exceptions:
 * Checked Exceptions  thường đươc sử dụng  trong các tình huôngs mad chương trìnhf có thể dự đoán và sử lý trước khi chạy
 * Unchecked Exceptions thường được sử dụng trong các tình huống không thể dự đoán được trước, như lỗi logic trong chương trình.
 */

/**
 * 3. tại sao không nên bắt toàn bộ (Exception ex)
 * Bắt toàn bộ Exception (Exception ex) có thể làm mất đi thông tin chi tiết về loại ngoại lệ cụ thể xảy ra trong chương trình.
 * Việc bắt toàn bộ Exception cũng có thể làm cho mã nguồn trở nên khó hiểu và khó debug hơn
 */