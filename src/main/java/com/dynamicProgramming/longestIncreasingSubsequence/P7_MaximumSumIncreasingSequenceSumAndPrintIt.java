package com.dynamicProgramming.longestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P7_MaximumSumIncreasingSequenceSumAndPrintIt
{
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array)
    {
        // Write your code here.
        int index = 0;
        int[] msis = Arrays.copyOf(array, array.length);
        int best = array[0];
        for (int i = 1; i < array.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (array[j] < array[i])
                {
                    msis[i] = Math.max(msis[i], msis[j] + array[i]);
                }
                if (msis[i] > best)
                {
                    best = msis[i];
                    index = i;
                }
            }
        }
        List<Integer> max = Collections.singletonList(best);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(max);
        List<Integer> seq = new ArrayList<>();
        for (int i = index; i >= 0; i--)
        {
            if (best == 0)
            {
                break;
            }
            if (best == msis[i])
            {
                seq.add(array[i]);
                best = best - array[i];
            }
        }
        Collections.reverse(seq);
        ans.add(seq);
        return ans;
    }
}
