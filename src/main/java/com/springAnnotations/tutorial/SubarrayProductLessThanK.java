package com.springAnnotations.tutorial;

import org.junit.Test;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int i = 0;
        int j = 0;
        int product = 1;
        int count = 0;
        while (j < nums.length) {
            product = product * nums[j];
            if (product < k) {
                count += j - i + 1;
            } else {
                for (; i <= j; i++) {
                    product = product / nums[i];
                    if (product < k) {
                        i++;
                        break;
                    }
                }
                count+= j - i + 1;
            }
            j++;
        }
        return count;
    }

    @Test
    public void testSubarrayProductLessThanK() {
        numSubarrayProductLessThanK(new int[] {10,5,2,6},100);
    }

}
