package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.*;

class Student
{
    String  name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class Solution {
    public void mergeKLists() {
       List<Student> al = new ArrayList<>();
       al.add(new Student("karan",1234));
       al.add(new Student("karghhan",13452));
       al.add(new Student("xccvkaran",5612));
       al.add(new Student("xcvkaran",64512));
       al.add(new Student("dvsdkaran",512));
        Collections.sort(al,Comparator.comparing(Student::getMarks).reversed());
        Collections.sort(al, Comparator.comparingInt(Student::getMarks));
        Collections.sort(al, Collections.reverseOrder());
        al.forEach(x-> System.out.println(x.getMarks()+x.getName()));

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<Map.Entry<Integer,Integer>>(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()));
        PriorityQueue<Map.Entry<Integer,Integer>> pq1=new PriorityQueue<Map.Entry<Integer,Integer>>((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else return o1.getKey().compareTo(o2.getKey());
        });
//            else if (o1.getValue()==o2.getValue())
//            {
//                if(o1.getKey()<o2.getKey()
//                {
//                    return -1;
//                }
//                e
//            });
        }

    @Test
    public void test()
    {
        mergeKLists();
    }
}

