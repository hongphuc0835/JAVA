import java.util.Arrays;

public class Newsfeed2 {
  
  String[] topics = {"Opinion", "Tech", "Science", "Health"};
  int[] views = {0, 0, 0, 0};
  String[] favoriteArticles;
  
  public Newsfeed2(){
    // Initialize favoriteArticles here:
    //tao mang co kich thuoc la 10 phan tu
    favoriteArticles = new String[10];
    
  }
  
  public void setFavoriteArticle(int favoriteIndex, String newArticle){
    // Add newArticle to favoriteArticles:
   favoriteArticles[favoriteIndex]  = newArticle;
    
    
  }
    
  public static void main(String[] args){
    Newsfeed2 sampleFeed = new Newsfeed2();
    
    sampleFeed.setFavoriteArticle(2, "Humans: Exterminate Or Not?");
    sampleFeed.setFavoriteArticle(3, "Organic Eye Implants");
    sampleFeed.setFavoriteArticle(0, "Oil News");
    
    System.out.println(Arrays.toString(sampleFeed.favoriteArticles));
  }
}
