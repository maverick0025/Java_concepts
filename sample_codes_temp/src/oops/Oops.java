package oops;

public class Oops {
    public static void swap(Integer x , Integer y){
        Integer temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args){

        System.out.println("Hello World!");

        Integer a = 10;
        Integer b = 20;
        swap(a,b);

        System.out.println("a: "+ a + " b: "+ b);
    }
}
