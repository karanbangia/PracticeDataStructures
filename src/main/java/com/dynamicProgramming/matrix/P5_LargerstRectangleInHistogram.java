package com.dynamicProgramming.matrix;

import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class P5_LargerstRectangleInHistogram
{
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (s.isEmpty())
            {
                left[i] = 0;
            }
            else
            {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i])
                {
                    s.pop();
                }
                left[i] = s.isEmpty() ? 0 : s.peek() + 1;

            }
            s.push(i);

        }
        s.clear();
        for (int i = n - 1; i >= 0; i--)
        {
            if (s.isEmpty())
            {
                right[i] = n - 1;
            }
            else
            {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i])
                {
                    s.pop();
                }
                right[i] = s.isEmpty() ? n - 1 : s.peek() - 1;
            }
            s.push(i);

        }
        int max_area = 0;
        for (int i = 0; i < n; i++)
        {
            max_area = Math.max(max_area, (right[i] - left[i] + 1) * heights[i]);
        }
        return max_area;
    }

    @Test
    public void test()
    {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
