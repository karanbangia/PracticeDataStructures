package com.dynamicProgramming.leetCode;

import org.junit.Test;

import java.util.HashMap;

//https://leetcode.com/problems/interleaving-string/
public class P1_InterleavingString
{
    HashMap<String, Boolean> hm = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3)
    {
        if (s3.length() != s1.length() + s2.length())
        {
            return false;
        }
        return solve(s1, s2, s3, 0, 0, 0);
    }

    private boolean solve(String s1, String s2, String s3, int i, int j, int k)
    {
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        String key=new StringBuilder().append(i).append("*").append(j).append("*").append(k).toString();
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        boolean b1 = false;
        boolean b2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
        {
            b1 = solve(s1, s2, s3, i + 1, j, k + 1);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
        {
            b2 = solve(s1, s2, s3, i, j + 1, k + 1);
        }
        hm.put(key,b1||b2);
        return hm.get(key);
    }

    @Test
    public void test()
    {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        //        System.out.println(isInterleave("","",""));
    }
    //s1=a s2=b s3=ab;
}
