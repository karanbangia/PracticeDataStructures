package com.dynamicProgramming.longestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Comparator;



public class P3_BoxStackingProblem
{
     class Box
    {
        int l;
        int w;
        int h;

        public Box(int l, int w, int h)
        {
            this.l = l;
            this.w = w;
            this.h = h;
        }
    }
    public int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[] boxes = new Box[3 * n];
        for (int i = 0; i < n; i++)
        {
            boxes[3 * i] = new Box(Math.max(height[i], width[i]), Math.min(height[i], width[i]), length[i]);
            boxes[3 * i + 1] = new Box(Math.max(height[i], length[i]), Math.min(height[i], length[i]), width[i]);
            boxes[3 * i + 2] = new Box(Math.max(length[i], width[i]), Math.min(length[i], width[i]), height[i]);
        }
        Arrays.sort(boxes, Comparator.comparingInt(o -> o.l * o.w));
        for (Box b : boxes)
        {
            System.out.println(b.h + " " + b.l + " " + b.w);
        }
        int best=boxes[0].h;
        int dp[]=new int[3*n];
        for(int i=0;i<3*n;i++)
        {
            dp[i]=boxes[i].h;
        }
        for(int i=1;i<3*n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(boxes[j].l < boxes[i].l && boxes[j].w < boxes[i].w)
                {
                    dp[i]=Math.max(dp[i],boxes[i].h+dp[j]);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }

}
