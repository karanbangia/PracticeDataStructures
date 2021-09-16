package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestKUniqueCharacterSubstring {
    public int longestkSubstr(String s, int k) {
        // code here
        HashSet<Character> hs = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }
        if (hs.size() < k) {
            return -1;
        } else if (hs.size() == k) {
            return s.length();
        } else {
            HashMap<Character, Integer> hm = new HashMap<>();
            int i = 0;
            int j = 0;
            while (j < s.length()) {
                hm.put(s.charAt(j), j);
                if (hm.size() <= k) {
                    j++;
                } else {
                    max = Math.max(max, j - i);
                    i = removeLeastUsedCharacters(hm);
                    i++;
                    j++;
                }
            }
            max=Math.max(max, j-i);
            return max;
        }

    }

    private int removeLeastUsedCharacters(HashMap<Character, Integer> hm) {
        int minIndex = Integer.MAX_VALUE;
        char character = 0;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (minIndex > entry.getValue()) {
                minIndex = entry.getValue();
                character = entry.getKey();
            }
        }
        hm.remove(character);
        return minIndex;
    }

    @Test
    public void test()
    {
        longestkSubstr("aabacbebebe",3);
    }
}
