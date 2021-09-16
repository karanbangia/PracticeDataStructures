package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.Arrays;

public class MinimumSlidingWindow {
    public String minWindow(String s, String t) {
        if(t.length()==0)return "";
        if (t.length() > s.length()) return "";
        else if (t.length() == s.length()) {
            char tchar[] = t.toCharArray();
            Arrays.sort(tchar);
            char schar[] = s.toCharArray();
            Arrays.sort(schar);
            return toString(tchar).equals(toString(schar)) ? s : "";

        } else {
            int[] patternHm = new int[256];
            int[] stringHm = new int[256];
            for (int i = 0; i < t.length(); i++) {
                patternHm[t.charAt(i)]++;
            }
            int i = 0;
            int j = 0;
            for (int k = 0; k < s.length(); k++) {
                if (patternHm[s.charAt(k)]>0) {
                    i = k;
                    j = k;
                    break;
                }
            }
            int[] ans = new int[2];
            int minSize = Integer.MAX_VALUE;
            while (j < s.length()) {
                if (patternHm[s.charAt(j)]>0) {
                    stringHm[s.charAt(j)]++;
                }

                while (frequencyGreatOrEqual(stringHm, patternHm)) {
                    if (minSize > j - i + 1) {
                        minSize = j - i + 1;
                        ans[0] = i;
                        ans[1] = j + 1;
                    }
                        stringHm[s.charAt(i)]--;
                    i++;
                    while (i < s.length() && patternHm[s.charAt(i)]==0) {
                        i++;
                    }
                }

                j++;

            }
            if (frequencyGreatOrEqual(stringHm, patternHm)) {
                if (minSize > j - i) {
                    minSize = j - i ;
                    ans[0] = i;
                    ans[1] = j ;
                }

            }
            return s.substring(ans[0], ans[1]);
        }
    }

    private String toString(char[] a) {
        String string = new String(a);
        return string;
    }

    private boolean frequencyGreatOrEqual(int[] stringHm, int[] patternHm) {

        for(int i=0;i<256;i++)
        {
            if(stringHm[i]<patternHm[i])
            {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(minWindow("bbaac", "aba"));
    }
}
