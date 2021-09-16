package com.leetcodeRandom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PossiblePermutationOfArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> hsAns=new HashSet<>();
        permute(hsAns,nums,0,nums.length-1);
        return ans;
    }
    public void permute(HashSet<List<Integer>> ans,int[] nums,int l,int r)
    {
        for(int i=l;i<=r;i++)
        {
            swap(nums,i,l);
             permute(ans,nums,l+1,r);
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            swap(nums,i,l);
        }
    }
    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    @Test
    public void test()
    {
        permute(new int[]{1,2,3});
    }
}
