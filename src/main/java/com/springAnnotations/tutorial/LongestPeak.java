package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.Arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.
        int longestLength = 0;
        for (int i = 0; i < array.length; i++) {
            int subArray[] = findRange(i, array);
            longestLength = Math.max(longestLength, subArray[1] - subArray[0] - 1);
        }
        return longestLength;
    }

    private static int[] findRange(int peakIndex, int[] array) {
        int i = peakIndex - 1;
        int j = peakIndex + 1;
        if (i == -1 || j == array.length) {
            return new int[]{0, 2};
        }
        if(array[i]>=array[peakIndex])
        {
            return new int[]{0,2};
        }
        if(array[j]>=array[peakIndex])
        {
            return new int[]{0,2};
        }
        while (i >= 0) {
            if (array[i] >= array[i + 1]) {
                break;
            }
            i--;
        }
        while (j < array.length) {
            if (array[j] >= array[j - 1]) {
                break;
            }
            j++;
        }
        return new int[]{i, j};
    }

    @Test
    public void test() {
        int ans[]=new int[]{5, 4, 3, 2, 1, 2, 1};
        int x[]= Arrays.copyOf(ans,ans.length);
        for (int i : x) {
            System.out.print("i = " + i);
        }
        System.out.println("ans = " + Arrays.toString(ans));
    }
}
