import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/6.
 */
import org.jetbrains.annotations.Contract;
import java.util.Scanner;

 class Math {
    @Contract(pure = true)
    public static int X(int a, int b){
        int r = 1;

        if(a < b) {
            int t = a;
            a = b;
            b = t;
        }

        r = a % b;
        while( r != 0) {
            int t = r;
            r = b % r;
            b = t;
        }
        return b;
    }
    @Contract(pure = true)
    public static int Y(int a, int b){
        int r = 0;
        r = a * b / X(a, b);
        return r;
    }

}
class Fraction {
    public int a;
    public int b;

    public  Fraction(int a,int b){
        this.a=a;
        this.b=b;
    }
    public  double toDouble(){
        double tmp=(double)a;
        return a/b;
    }
    public  void print(){
        int r=Math.X(this.a,this.b);
        int tmpa=a/r;
        int tmpb=b/r;
        if(tmpa%tmpb==0){
            System.out.print(tmpa/tmpb);
        } else {
            System.out.print(tmpa);
            System.out.print("/");
            System.out.print(tmpb);
        }
    }

    public  Fraction multiply(Fraction b){
        int tmpa=this.a*b.a;
        int tmpb=this.b*b.b;
        return new Fraction(tmpa,tmpb);
    }

    public  Fraction plus(Fraction b) {
        int r=Math.Y(this.b,b.b);
        int tmpb=r;
        int tmpa=this.a*(r/this.b)+b.a*(r/b.b);
        return new Fraction(tmpa,tmpb);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        in.close();
    }

}
