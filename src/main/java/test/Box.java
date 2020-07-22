package test;

/**
 * @Author lipengxiang
 * @Date 2020/7/8 17:12
 * @description
 * 父类的静态字段——>父类静态代码块——>子类静态字段——>子类静态代码块——>
 *
 * 父类成员变量（非静态字段）——>父类非静态代码块——>父类构造器——>子类成员变量——>子类非静态代码块——>子类构造器
 */

class A {
    private static int numA;
    private int numA2;

    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }

    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }

    public A() {
        System.out.println("A的构造器");
    }
}

class B extends A {
    private static int numB;
    private int numB2;

    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }

    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }

    public B() {
        System.out.println("B的构造器");
    }
}

public class Box {
    public static void main(String[] args) {
        A ab = new B();
        System.out.println("---");
        ab = new B();
    }


}
