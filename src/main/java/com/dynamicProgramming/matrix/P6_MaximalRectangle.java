package com.dynamicProgramming.matrix;

import java.util.Stack;

public class P6_MaximalRectangle
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

    public int maximalRectangle(char[][] matrix)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int maximalRectangleArea=0;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] == '1')
                {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (i != 0 && dp[i][j] != 0)
                {
                    dp[i][j] += dp[i - 1][j];
                }
            }
            maximalRectangleArea=Math.max(maximalRectangleArea,largestRectangleArea(dp[i]));
        }
        return maximalRectangleArea;

    }
}
