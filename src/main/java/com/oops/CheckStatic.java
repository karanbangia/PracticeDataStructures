package com.oops;

public class CheckStatic {
    int a;
    public void message()
    {
        System.out.println("true = " + true);
    }
    public static void showMessage()
    {

        //non static method/variable cannot be referenced from static context
//        message();
    }
}
