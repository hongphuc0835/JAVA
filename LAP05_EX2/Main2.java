package LAP05_EX2;
//interface Moveble{
//    void moveUp();
//     void moveDown();
//     void moveLeft();
//    void moveRight();
//}
//class movablePoint implements Moveble{
//    private int x;
//    private int y;
//
//    public movablePoint(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public void moveUp() {
//        y++;
//    }
//
//    @Override
//    public void moveDown() {
//        y--;
//    }
//
//    @Override
//    public void moveLeft() {
//        x++;
//    }
//
//    @Override
//    public void moveRight() {
//        x--;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//}
//
//public class Main2 {
//    public static void main(String[] args) {
//        movablePoint sodo2 = new movablePoint(7,8);
//        sodo2.moveDown();
//        System.out.println(sodo2.getX()+","+sodo2.getY());
//    }
//}
//
//
//




// 2 //
interface Moveble{
    void moveUp();
    void moveRight();

}
class MoveblePoint implements Moveble{
    private int x;
    private int y;

    public MoveblePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveRight() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class Main2 {
    public static void main(String[] args) {
        MoveblePoint sodo2 = new MoveblePoint(78,56);
        sodo2.moveRight();
        System.out.println(sodo2.getX()+","+sodo2.getY());
    }
}
