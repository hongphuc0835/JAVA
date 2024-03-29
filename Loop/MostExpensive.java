import java.util.ArrayList;

class MostExpensive {
  
  public static void main(String[] args) {
    
    ArrayList<Double> expenses = new ArrayList<Double>();
    expenses.add(74.46);
    expenses.add(63.99);
    expenses.add(10.57);
    expenses.add(81.37);
    
    double mostExpensive = 0;
    
    // Iterate over expenses
    //Xây dựng vòng lặp for-each lặp qua từng vòng expenselặp trong expenses. Hiện tại, hãy để trống phần thân của vòng lặp.
    for(double expense : expenses ){
      //Bên trong vòng lặp for-each, kiểm tra xem expensecó lớn hơn mostExpensive.
  //   Nếu có, hãy đặt mostExpensivebằng expense.
      if(expense > mostExpensive){
        mostExpensive = expense;
      }

    }
    
    
    System.out.println(mostExpensive);
    
  }
  
}