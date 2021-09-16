package com.oops;

public class Child extends Parent {
    public void childFunction() {
        System.out.println("running inside child");
    }

    @Override
    /**
     * overriding with sub return type
     */
    public Integer walk() {
        return 0;
    }


    /**
     * demonstrtating method overloading with automatic promotion
     * @param a
     */
    public void show(int a) {
        System.out.println("hello int method");
    }

    public void show(String a) {
        System.out.println("hello string methid");
    }

    public void show(float a) {
        super.parentFunction();
        System.out.println("hello float method");
    }


    public static void main(String[] args) {
        Child child = new Child();
        child.show(0);
//        child.walk();
//        below line should not work
//        parent.childFunction();
    }
}
