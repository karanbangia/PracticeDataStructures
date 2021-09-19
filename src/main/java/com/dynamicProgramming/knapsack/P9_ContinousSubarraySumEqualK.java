package com.dynamicProgramming.knapsack;

import java.util.HashMap;
//TODO very very important
//https://leetcode.com/problems/subarray-sum-equals-k/
public class P9_ContinousSubarraySumEqualK
{
    public int subarraySumBruteForce(int[] arr, int sum)
    {
        int[] prefix = new int[arr.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (i == 0)
            {
                prefix[i] = arr[i];
            }
            else
            {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        for (int i = 1; i < arr.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (prefix[i] - prefix[j] == sum)
                {
                    count++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
        {
            if (prefix[i] == sum)
            {
                count++;
            }
        }
        return count;
    }

    public int subarrayOtimized(int[] arr, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            prefixSum += arr[i];

            if (prefixSum == sum)
            {
                count++;
            }
            if (hm.containsKey(prefixSum - sum))
            {
                count += hm.get(prefixSum-sum);
            }
            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
