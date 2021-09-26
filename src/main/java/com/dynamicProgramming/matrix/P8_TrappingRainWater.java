package com.dynamicProgramming.matrix;

import org.junit.Test;

public class P8_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int max=height[0];
        for(int i=1;i<n;i++)
        {
            left[i]=max;
            max=Math.max(max,height[i]);
        }
        max=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i]=max;
            max=Math.max(max,height[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            int tempH=Math.min(left[i],right[i]);
            ans+=(tempH-height[i])<=0?0:(tempH-height[i]);
        }
        return ans;
    }
    @Test
    public void  test()
    {
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
