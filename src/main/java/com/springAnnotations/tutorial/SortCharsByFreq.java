package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharsByFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) {
                return 1;
            } else if (o1.getValue() > o2.getValue()) {
                return -1;
            } else return o1.getKey().compareTo(o2.getKey());
        });
        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> entry:hm.entrySet())
        {
            pq.add(entry);
        }
        String ans="";
        while(!pq.isEmpty())
        {
            Map.Entry<Character,Integer> removed=pq.poll();
            int freq=removed.getValue();
            String c=String.valueOf(removed.getKey());
            String temp="";
            while(freq!=0)
            {
                temp+=c;
                freq--;
            }
            ans+=temp;
        }
        return ans;

    }
    @Test
    public void test()
    {
        System.out.println(frequencySort("cccaaa"));
    }
}
