package codej.codemarket.lab;

public class lab {

    public static void main(String[] args) {

        int a = 99;
        int b = 10;

        double c = 98;
        double d = 10;


        int an = 8;
        double bn = 12;

        System.out.println(an * bn);


        System.out.println((int)((a-1)/b)+1);
        System.out.println((a/b)+(a % b >0 ? 1 : 0));
        System.out.println((int)Math.ceil(a/b));
        System.out.println((int)Math.ceil(a-1)/b+1);
    }
}
