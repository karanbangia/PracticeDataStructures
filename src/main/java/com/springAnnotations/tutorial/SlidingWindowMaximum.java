package com.springAnnotations.tutorial;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class Node {
    int val;
    int index;

    public Node(int val, int node) {
        this.val = val;
        this.index = node;
    }

    public int getVal() {
        return val;
    }

    public int getIndex() {
        return index;
    }
}

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int right = k;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getVal() < o2.getVal()) {
                return 1;
            } else if (o1.getVal() > o2.getVal()) {
                return -1;
            } else return 0;
        });
        int ans[] = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new Node(nums[i], i));
        }
        ans[0] = pq.peek().getVal();
        int in = 1;
        while (right < nums.length) {
            pq.add(new Node(nums[right],right));
            while (pq.peek().getIndex()<=right-k)pq.poll();
            ans[in++] = pq.peek().getVal();
            right++;
        }
        return ans;

    }

    public int[] maxSlidingWindowSolution2(int[] nums, int k) {
        Deque<Node> dq= new ArrayDeque<Node>();
        int ans[] = new int[nums.length - k + 1];
        int i=0,j=0,in=0;
        while (j < nums.length) {
            if(!dq.isEmpty() && dq.peekFirst().getIndex() <=(j-k))
            {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast().getVal()<nums[j])
            {
                dq.pollLast();
            }
            dq.addLast(new Node(nums[j], j));
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                ans[in++]=dq.peekFirst().getVal();
                j++;
                i++;
            }
        }
        return ans;

    }

}
