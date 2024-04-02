public class UncheckedException{
    /**
     * Constructor for objects of class Client
     */
    public UncheckedException () {
        // To do:
    }

    public static void main(String[] args) {
        int i, n = 2;
        int a[] = new int[n];

        //Declare Scanner Object named input
        java.util.Scanner input = new java.util.Scanner(System.in);

        for(i=0; i<n; i++)
        {
            try {
                System.out.printf("a[%d] = ", i);
                a[i] = input.nextInt();
            }catch (Exception e){
                System.out.println("Exception occurred: " + e.getMessage());
            }
        }
}
}
