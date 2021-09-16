package com.leetcodeRandom;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    int[] orignalArray;
    public ShuffleArray(int[] nums) {
        orignalArray= Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orignalArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        int ansArray[]=Arrays.copyOf(orignalArray, orignalArray.length);
        for(int i=ansArray.length-1;i>=0;i--)
        {
            int j=r.nextInt(i+1);
            int temp=ansArray[i];
            ansArray[i]=ansArray[j];
            ansArray[j]=temp;
        }
        return ansArray;
    }
    @Test
    public void testShuffle()
    {
        ShuffleArray array=new ShuffleArray(new int[]{1, 2, 3});
        array.shuffle();
        array.reset();
        array.shuffle();
    }
}
