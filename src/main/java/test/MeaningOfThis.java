package test;

/**
 * @Author lipengxiang
 * @Date 2020/7/31 16:38
 * @description
 */
public class MeaningOfThis
{
    public final int value = 4;
    public void doIt()
    {
        int value = 6;
        Runnable r = new Runnable(){
            public final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
    public static void main(String...args)
    {
        //答案是5，因为this指的是包含它的Runnable，而不是外面的类MeaningOfThis
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}