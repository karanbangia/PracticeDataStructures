package com.springAnnotations.tutorial;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Heap {
    public void maxHeapify(int[] array, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;
        if (left < size && array[left] > array[index]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(array, index, largest);
            maxHeapify(array, largest,size );
        }
    }

    public void buildHeap(int array[])
    {
        for(int i = ((int)Math.floor((double) array.length/2) -1); i>=0; i--)
        {
            maxHeapify(array,i,array.length );
        }
    }

    public int extractMax(int[] array)
    {
        if(array.length<1)
        {
            return -1;
        }
        int max=array[0];
        array[0]=array[array.length-1];
        array = Arrays.copyOf(array, array.length - 1);
        maxHeapify(array,0, array.length);
        System.out.println(array);
        return max;
    }

    /**
     *
     * @param array
     * @param index
     * @param key
     */
    public void increaseElement(int[] array,int index,int key)
    {
        if(key<array[index])
        {
            throw new RuntimeException("key is less than the current element");
        }
        array[index]=key;
        while (index>=0 && (int)Math.ceil((double) index/2)-1>=0 && array[(int)Math.ceil((double) index/2)-1]<array[index])
        {
            swap(array,index,(int)Math.ceil((double) index/2)-1);
            index=(int)Math.ceil((double)index/2)-1;
        }
    }

    public void insertElement(int[] array,int val)
    {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length-1]=val;
        int index=array.length-1;
        while (index>=0 && (int)Math.ceil((double) index/2)-1>=0 && array[(int)Math.ceil((double) index/2)-1]<array[index])
        {
            swap(array,index,(int)Math.ceil((double) index/2)-1);
            index=(int)Math.ceil((double)index/2)-1;
        }
    }
    public void heapsort(int[] array)
    {
        buildHeap(array);
        for(int i=array.length-1;i>0;i--)
        {
            swap(array,i,0);
            maxHeapify(array,0, i);
        }
    }
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Test
    public void testMaxHeapify() {
        int input[]=new int[]{1,14,10,8,7,9,3,2,4,6};
        maxHeapify(input,0,input.length );
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //14,8,10,4,7,9,3,2,1,6
    }
    @Test
    public void testBuildHeap() {
        int input[]=new int[]{1,2,3,4,5,6,7,};
        buildHeap(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //8,5,7,4,1,6,3,2
    }
    @Test
    public void testExtractMax() {
        int input[]=new int[]{14,8,10,4,7,9,3,2,1,6};
        System.out.println(extractMax(input));
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //8,5,7,4,1,6,3,2
    }

    @Test
    public void testIncreaseElement() {
        int input[]=new int[]{14,8,10,4,7,9,3,2,1,6};
        increaseElement(input,8,100);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //8,5,7,4,1,6,3,2
    }
    @Test
    public void testInsertElement() {
        int input[]=new int[]{14,8,10,4,7,9,3,2,1,6};
        insertElement(input,100);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //8,5,7,4,1,6,3,2
    }

    @Test
    public void testHeapSort()
    {
        int input[]=new int[]{5,2,6,3,8,3,6,3,5,7};
        heapsort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
            Queue<Integer> q=new LinkedList<>();
        }
    }
}
