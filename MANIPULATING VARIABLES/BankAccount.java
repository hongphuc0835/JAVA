public class BankAccount {
  	public static void main(String[] args){
      double balance = 1000.75;
      double amountToWithdraw = 250;
      double updatedBalance = balance - amountToWithdraw;
      double amountForEachFriend = updatedBalance / 3;
      //co du tien mua ve gia ve 250
      boolean canPurchaseTicket = amountForEachFriend != 250;
      System.out.println(canPurchaseTicket);
      //so tien ban da cho ban be
      System.out.println("I gave each friend " + amountForEachFriend + "...");
    }       
}
