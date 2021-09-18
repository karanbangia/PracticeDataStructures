package com.dynamicProgramming.knapsack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

public class P9_MinimumNumberOfOperationsToReduceXto0
{
    HashMap<String, Integer> hm = new HashMap<>();

    public int minOperations(int[] nums, int x)
    {
        int ans = minOps(nums, 0, nums.length - 1, x);
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int minOps(int[] nums, int i, int n, int x)
    {
        if (x == 0)
            return 0;
        if (i > n)
            return Integer.MAX_VALUE;
        String key = new StringBuilder().append(i).append(":").append(n).append(":").append(x).toString();
        if (hm.containsKey(key))
        {
            return hm.get(key);
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (nums[i] <= x)
        {
            int temp = minOps(nums, i + 1, n, x - nums[i]);
            if (temp == Integer.MAX_VALUE)
            {
                a = Integer.MAX_VALUE;
            }
            else
            {
                a = temp + 1;
            }
        }
        if (nums[n] <= x)
        {
            int temp = minOps(nums, i, n - 1, x - nums[n]);
            if (temp == Integer.MAX_VALUE)
            {
                b = Integer.MAX_VALUE;
            }
            else
            {
                b = temp + 1;
            }

        }
        return hm.put(key, Math.min(a, b));
    }

    HashMap<Integer, Integer> hm1 = new HashMap<>();

    public int minOpsOptimal(int[] nums, int x)
    {
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];
        }
        int requiredSum = prefixSum - x;
        if(requiredSum==0)return nums.length;
        //max length continuous subarray with sum=x
        prefixSum = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++)
        {
            prefixSum += nums[i];
            if (prefixSum == requiredSum)
            {
                length = Math.max(length, i + 1);
            }
            if (hm1.containsKey(prefixSum - requiredSum))
            {
                length = Math.max(length, i - hm1.get(prefixSum - requiredSum));
            }
            if (!hm1.containsKey(prefixSum))
            {
                hm1.put(prefixSum, i);
            }
        }
        return length == 0 ? -1 : nums.length - length;
    }

    @Test
    public void test()
    {
        minOperations(new int[] { 1, 10, 1 }, 5);
    }
}
