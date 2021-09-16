package com.springAnnotations.tutorial;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            } else return 0;
        });
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
          pq.offer(entry);
        }
        int count=0;
        int sum=0;
        while (!pq.isEmpty())
        {
            if(sum<arr.length/2)
            {
                count++;
                sum+=pq.poll().getValue();
            }
            else {
                break;
            }
        }
        return 0;
    }
}
