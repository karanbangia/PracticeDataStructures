package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.*;

public class Threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> hsAns = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = -nums[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if ((nums[j] + nums[k]) <= a) {
                    if ((nums[j] + nums[k]) == a) {
                        hsAns.add(Arrays.asList(-a, nums[j], nums[k]));
                    }
                    j++;
                } else if ((nums[j] + nums[k]) > a) {
                    k--;
                }

            }
        }
        for (List<Integer> x : hsAns) {
            ans.add(x);
        }
        return ans;
    }



    @Test
    public void test() {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}

