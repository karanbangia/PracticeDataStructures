package com.dynamicProgramming.longestIncreasingSubsequence;

//https://leetcode.com/problems/maximum-sum-circular-subarray/
public class P6_MaximumSumCircularSubarray
{
    public int maxSubarraySumCircular(int[] nums)
    {
        int best=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int max_end_here=0;
            //alwas including that current number
            int max_so_far=Integer.MIN_VALUE;
            //kitta max ho skta hai including ya not including
            for(int j=i;j<nums.length+i;j++)
            {
                max_end_here=max_end_here+nums[j%nums.length];
                max_end_here=Math.max(max_end_here,nums[j% nums.length]);
                max_so_far=Math.max(max_so_far,max_end_here);
            }
            best = Math.max(best, max_so_far);
        }
        return best;
    }
}
