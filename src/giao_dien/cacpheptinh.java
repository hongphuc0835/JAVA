package giao_dien;

public class cacpheptinh implements Anima{
    private int a;
    private  int b;

    public cacpheptinh(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void cong() {
       a = a +b;
    }

    @Override
    public void tru() {
       b = a - b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}


