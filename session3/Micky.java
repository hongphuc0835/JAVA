package session3;

public class Micky extends Animal{
    private String color;
    private int speed;
    private int height;
    public Micky(String name, String color,int speed, int height){
        super(name);
        this.color = color;
        this.speed = speed;
        this.height = height;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getAnimalName() {
        return "Micky";
    }
}
