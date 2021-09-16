package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> s = new Stack<>();
        s.push(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int interval[] = s.peek();
            if (interval[1] < intervals[i][0]) {
                s.push(new int[]{intervals[i][0], intervals[i][1]});
            } else if (interval[1] >= intervals[i][0] && interval[1] < intervals[i][1]) {
                s.pop();
                s.push(new int[]{interval[0], intervals[i][1]});
            }
        }
        int newIntervals[][] = new int[s.size()][2];
        int i=0;
        while (!s.isEmpty()) {
            int a[]=s.pop();
            newIntervals[i][0]=a[0];
            newIntervals[i][1]=a[1];
            i++;
        }
        return newIntervals;
    }

    @Test
    public void test() {
        int[][] intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        mergeOverlappingIntervals(intervals);
    }
}
