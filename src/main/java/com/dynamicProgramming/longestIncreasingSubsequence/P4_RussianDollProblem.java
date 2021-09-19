package com.dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Comparator;


public class P4_RussianDollProblem
{
    class Envelope
    {
        int l;
        int w;

        public Envelope(int l, int w)
        {
            this.l = l;
            this.w = w;
        }
    }

    public int maxEnvelopes(int[][] envelopes)
    {
        int n = envelopes.length;
        Envelope[] env=new Envelope[n];
        for(int i=0;i<n;i++)
        {
            env[i]=new Envelope(envelopes[i][1],envelopes[i][0]);
        }
        Arrays.sort(env, Comparator.comparingInt(o->o.l*o.w));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int best = 1;
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (env[j].l < env[i].l && env[j].w < env[i].w)
                {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }

            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
