public class GreaterLessThan {
	public static void main(String[] args) {   
		double creditsEarned = 176.5;
    double creditsOfSeminar = 8;
    double creditsToGraduate = 180;
    //in kiem tra so tin chi ban da kiem duoc co lon hon so tin can de tot nghiep
    System.out.println(creditsEarned > creditsToGraduate);
    //tao bien chua so tin chi kiem duoc sau buoi hoi thao
    double creditsAfterSeminar = creditsOfSeminar;
     creditsAfterSeminar += creditsEarned;
     System.out.println(creditsToGraduate < creditsAfterSeminar );
	}
}