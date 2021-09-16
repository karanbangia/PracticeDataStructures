package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class Coordinate {
    private int x;
    private int y;
    private double distance;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }
}

public class KclosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1.getDistance()>o2.getDistance())
            {
                return 1;
            }
            else if(o1.getDistance()<o2.getDistance())
            {
                return -1;
            }
            else return 0;
        });
        for (int i = 0; i < points.length; i++) {
            priorityQueue.add(new Coordinate(points[i][0], points[i][1]));
        }
        int ans[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            Coordinate coordinate = priorityQueue.poll();
            ans[i][0] = coordinate.getX();
            ans[i][1] = coordinate.getY();
        }
        return ans;
    }
    @Test
    public void test()
    {
        int point1[]=new int[]{1,3};
        int point2[]=new int[]{-2,2};
        int ans[][]=new int[][]{point1,point2};
        kClosest(ans,1);
    }

}
