package com.dynamicProgramming.longestIncreasingSubsequence;
//TODO very very important

public class P5_KadanesAlgo {
    public int maxSubArray(int[] nums) {
        int max_end_here=0;
        //alwas including that current number
        int max_so_far=Integer.MIN_VALUE;
        //kitta max ho skta hai including ya not including
        for(int i=0;i<nums.length;i++)
        {
            max_end_here=max_end_here+nums[i];
            max_end_here=Math.max(max_end_here,nums[i]);
            max_so_far=Math.max(max_so_far,max_end_here);
        }
        return max_so_far;
    }

}
