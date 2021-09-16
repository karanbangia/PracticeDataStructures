package com.springAnnotations.tutorial;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> pHashMap = new HashMap<>();
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pHashMap.put(p.charAt(i), pHashMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            sHashMap.put(s.charAt(j), sHashMap.getOrDefault(s.charAt(j), 0) + 1);
            if (j - i + 1 < p.length()) {
                j++;
            } else if (j - i + 1 == p.length()) {
                if (sHashMap.equals(pHashMap)) {
                    answer.add(i);
                }
                if (sHashMap.get(s.charAt(i)) > 1) {
                    sHashMap.put(s.charAt(i), sHashMap.get(s.charAt(i)) - 1);
                }
                else
                {
                    sHashMap.remove(s.charAt(i));
                }
                i++;
                j++;
            }

        }
        return answer;
    }
    public List<Integer> findAnagramsUsingArray(String s, String p) {
        HashMap<Character, Integer> hm= new HashMap<>();
        LocalDate date= LocalDate.now();
        if(p.length()>s.length())return null;
        int[] pArray=new int[26];
        int[] sArray=new int[26];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i)-'a']++;
        }
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            sArray[s.charAt(j)-'a']++;
            if (j - i + 1 < p.length()) {
                j++;
            } else if (j - i + 1 == p.length()) {
                if (Arrays.equals(pArray,sArray)) {
                    answer.add(i);
                }
                sArray[s.charAt(i)-'a']--;
                i++;
                j++;
            }

        }
        return answer;


    }

    @Test
    public void test() {
        List<Integer> ans = findAnagrams("cbaebabacd", "abc");
    }
}
