package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x < arr[0]) {
            int[] ans = Arrays.copyOfRange(arr, 0, k);
            return Arrays.stream(ans).boxed().collect(Collectors.toList());
        }
        if (x > arr[arr.length - 1]) {
            int ans[] = Arrays.copyOfRange(arr, arr.length - k, arr.length);
            return Arrays.stream(ans).boxed().collect(Collectors.toList());
        }
        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] > x) {
                if (min > Math.abs(arr[mid] - x)) {
                    min = Math.min(min, Math.abs(arr[mid] - x));
                    index = mid;
                }
                right = mid;
            } else {
                if (min > Math.abs(arr[mid] - x)) {
                    min = Math.min(min, Math.abs(arr[mid] - x));
                    index = mid;
                }
                left = mid + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        left = index - 1;
        right = index + 1;
        int count=1;
        while (count < k && left >= 0 && right < arr.length) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        while (left >= 0 && count < k) {
            count++;
            left--;

        }
        while (right <arr.length && count < k) {
            count++;
            right++;

        }
        for(int i=left+1;i<right;i++)
        {
            ans.add(arr[i]);
        }
        return ans;
    }
    @Test
    public void test()
    {
        findClosestElements(new int[]{1,2,3,4,5},4,3);
    }
}
