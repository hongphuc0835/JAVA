package session3;

public class PhuQuocDog extends Dog{
    public PhuQuocDog(String name, int age, int height) {
        super(name, age, height);
    }

    @Override // the hien theo cach doi tuong muon(tinh da hinh trong OOP)
    public String getAnimalName() {
        return "PhuQuocDog";
    }
}
