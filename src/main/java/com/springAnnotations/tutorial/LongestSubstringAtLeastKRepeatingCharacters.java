package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.*;

public class LongestSubstringAtLeastKRepeatingCharacters {
    private int longestSubstring = 0;

    public int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }
        longestSubstringFun(s, k);
        return longestSubstring;
    }

    private void longestSubstringFun(String s, int k) {
        if (s.length() == 0) return;
        int freqArray[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i) - 'a']++;
        }
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (freqArray[i] < k && freqArray[i] != 0) {
                char character = (char) (i + 97);
                hs.add(character);
            }
        }
        if (hs.isEmpty()) {
            longestSubstring = Math.max(longestSubstring, s.length());
        } else {
            List<String> substrings = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (j < s.length()) {
                if (hs.contains(s.charAt(j))) {
                    if (i != j) {
                        substrings.add(s.substring(i, j));
                        i = j;
                    }
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            if (i < s.length()) {
                substrings.add(s.substring(i, j));
            }
            substrings.forEach(s1 -> longestSubstringFun(s1, k))    ;
        }
    }

    @Test
    public void test() {
        System.out.println(longestSubstring("cdaaacbbbd", 3));

    }
}
