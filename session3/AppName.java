package session3;

public class AppName {
    public static void main(String[] args) {
        Dog quick = new Dog("phuc", 5 , 12);
        quick.getAnimalName();
        System.out.println("Name: "+ quick.getName());
        System.out.println("Age: " + quick.getAge());
        System.out.println("================");



        Cat nguyen = new Cat("le dinh nguyen", 18,10);
        System.out.println("Name: " + nguyen.getName());
        System.out.println("age: "+ nguyen.getAge());
        System.out.println("height: " + nguyen.getHeight());
        System.out.println("=================");



        Micky chuot = new Micky("chuot micky","vang",12,10);
        System.out.println("name: " + chuot.getName());
        System.out.println("color: " + chuot.getColor());
        System.out.println("speed: "+ chuot.getSpeed());
        System.out.println("===================");


        // the hien tinh da hinh
        Dog quick2 = new PhuQuocDog("PQ Dog", 3, 130);

        System.out.println("Animal name: " + quick2.getAnimalName());
    }
}
