package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.PriorityQueue;

class Point {
    int x;
    int y;
    int diff;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.diff = Math.abs(x - y);
    }
}

public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getDiff() > o2.getDiff()) {
                return -1;
            } else if (o1.getDiff() < o2.getDiff()) {
                return 1;
            } else return 0;
        });
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (pq.size() < k) {
                    pq.add(new Point(nums[i], nums[j]));
                } else if (Math.abs(nums[i] - nums[j]) < pq.peek().getDiff()) {
                    pq.poll();
                    pq.add(new Point(nums[i], nums[j]));
                }
            }
        }
        return pq.peek().getDiff();
    }

    @Test
    public void test() {
        smallestDistancePair(new int[]{1,3,1},1);
    }
}