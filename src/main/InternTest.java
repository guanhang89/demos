package main;

public class InternTest {

    public static void main(String[] args) {

        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern() == str);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        System.out.println("2");

    }
}
