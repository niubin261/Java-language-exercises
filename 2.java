/**
 * Created by Administrator on 2017/6/7.
 */
import java.util.Scanner;
public class Display{
    private int value=0;
    private int limit=0;
    public Display(int limit){
        this.limit=limit;
    }
    public void increase(){
        value++;
        if(value==limit){
            value=0;
        }
    }
    public int getValue(){
        return value;
    }
    public int getLimit(){
        return limit;
    }
    public void setValue(int value){
        this.value=value;
    }
    public void setLimit(int limit){
        this.limit=limit;
    }
    public String toString(){
        return String.valueOf(value);//将int转换为string的方法
        // 1.) String s = String.valueOf(i);
     //2.) String s = Integer.toString(i);
     //3.) String s = "" + i;
    }

}
/**
 * Created by Administrator on 2017/6/7.
 */

public class Clock{
    private Display hour=new Display(24);
    private Display minute=new Display(60);
    private Display second=new Display(60);
    public Clock(int hour,int minute,int second){
        this.hour.setValue(hour);
        this.minute.setValue(minute);
        this.second.setValue(second);
    }
    public String toString(){
        String string=String.format(hour.toString());
        string+=":"+String.format(minute.toString());
        string+=":"+String.format(second.toString());
        return string;
    }
    public void tick(){
        second.increase();
        if(second.getValue()==0){
            minute.increase();
        }
        if(minute.getValue()==0){
            hour.increase();
        }
    }
}


/**
 * Created by Administrator on 2017/6/6.
 */



public class Main {
    public static void main(String[]argv){
        Scanner in=new Scanner(System.in);

        Clock clock=new Clock(in.nextInt(),in.nextInt(),in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}

