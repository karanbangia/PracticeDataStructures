package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public  int lenOfLongSubarr (int nums[], int N, int K) {
        int[] prefixSum = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        prefixSum[0] = nums[0];
        hm.put(prefixSum[0], 0);
        int max_count = 0;
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < N; i++) {
            if (prefixSum[i] == K) {
                max_count = Math.max(max_count, i + 1);
            } else if (hm.containsKey(prefixSum[i] - K)) {
                max_count = Math.max(max_count, hm.get(prefixSum[i]) - hm.get(prefixSum[i] - K));
            }
            if (!hm.containsKey(prefixSum[i]))
            {
                hm.put(prefixSum[i], i);
            }
        }
        return max_count;
    }
    @Test
    public void testLongestSubarrayWithSum()
    {
        lenOfLongSubarr(new int[]{4,1,1,0,-2,2},6,5);
    }

}
