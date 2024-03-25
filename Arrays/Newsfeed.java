public class Newsfeed {
  
  
  public Newsfeed(){
    
  }
  
  // Create getTopics() below:
  public String[] getTopics(){
    String[] topics = {"Opinion", "Tech", "Science", "Health"};
    return topics;
  }

  

  public static void main(String[] args){
    Newsfeed sampleFeed = new Newsfeed();
    
    String[] topics = sampleFeed.getTopics();

    //in ra dia chi mang ,khong in ra phan tu mang
    System.out.println(topics);
    
  }
}
