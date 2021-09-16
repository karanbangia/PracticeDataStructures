package com.oops;

import java.io.IOException;

public class ExceptionHandler {
    //    public static void main(String[] args) {
//        try {
//            //code that may raise exception
//            int data = 100 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println(e);
//        }
//        //rest code of the program
//        System.out.println("rest of the code...");
//    }
//}
    public static void main(String[] args) {
        int data = 100 / 0;
    }
}

class Excep6 {
    public static void main(String args[]) {
        try {
            try {
                System.out.println("going to divide");
                int b = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            try {
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }

            System.out.println("other statement");
        } catch (Exception e) {
            System.out.println("handeled");
        }

        System.out.println("normal flow..");
    }
}
class TestExceptionPropagation2{
    void m() throws IOException {
        throw new java.io.IOException("device error");//checked exception
    }
    void n() throws IOException {
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){System.out.println("exception handeled");}
    }
    public static void main(String args[]){
        TestExceptionPropagation2 obj=new TestExceptionPropagation2();
        obj.p();
        System.out.println("normal flow");
    }
}
 class MultipleCatchBlock1 {

    public static void main(String[] args) {

        try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("rest of the code");
    }
}
