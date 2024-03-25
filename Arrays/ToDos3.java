import java.util.ArrayList;

class ToDos3 {
    
  public static void main(String[] args) {
    
    // Sherlock
    ArrayList<String> sherlocksToDos = new ArrayList<String>();
    
    sherlocksToDos.add("visit the crime scene");
    sherlocksToDos.add("play violin");
    sherlocksToDos.add("interview suspects");
    sherlocksToDos.add("solve the case");
    sherlocksToDos.add("apprehend the criminal");
    
    // Poirot
    ArrayList<String> poirotsToDos = new ArrayList<String>();
    
    poirotsToDos.add("visit the crime scene");
    poirotsToDos.add("interview suspects");
    poirotsToDos.add("let the little grey cells do their work");
    poirotsToDos.add("trim mustache");
    poirotsToDos.add("call all suspects together");
    poirotsToDos.add("reveal the truth of the crime");
    
    System.out.println("Sherlock's third to-do:");
    // Print Sherlock's third to-do:
    //truy  cap phan tu thu3 cua sherlocksToDos  dung hàm get()
    System.out.println(sherlocksToDos.get(2));
    System.out.println("=====================");
    //in dexOf dung de xac dinh vi tri
    System.out.println("vi tri " + sherlocksToDos.indexOf("apprehend the criminal"));
    
    System.out.println("----------------");
    //remove() xoa gia tri
    System.out.println("da xoa " + sherlocksToDos.remove("apprehend the criminal"));
    
    System.out.println("----------------");
    //set() thay doi gia tri
    sherlocksToDos.set(1,"le cong hong phuc");
    
    System.out.println(sherlocksToDos.get(1));

    
    System.out.println("\nPoirot's second to-do:");
    // Print Poirot's second to-do:
    //
    System.out.println(poirotsToDos.get(1));
    
    
  }
  
}