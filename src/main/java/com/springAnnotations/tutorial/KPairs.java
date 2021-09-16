//package com.springAnnotations.tutorial;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//
//class Point {
//    int x;
//    int y;
//    int diff;
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public int getDiff() {
//        return diff;
//    }
//
//    public void setDiff(int diff) {
//        this.diff = diff;
//    }
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
////        this.diff = Math.abs(x + y);
//    }
//}
//
//public class KPairs {
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
//            if (o1.getDiff() > o2.getDiff()) {
//                return -1;
//            } else if (o1.getDiff() < o2.getDiff()) {
//                return 1;
//            } else return 0;
//        });
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if(pq.size()<k)
//                {
//                    pq.add(new Point(nums1[i],nums2[j]));
//                }
//                else if(nums1[i]+nums2[j]<pq.peek().getDiff())
//                {
//                    pq.poll();
//                    pq.add(new Point(nums1[i],nums2[j]));
//                }
//
//            }
//        }
//        List<Integer> ans ;
//        List<List<Integer>> mainAns = new ArrayList<>();
//        for(int i=0;i<k;i++)
//        {
//            if(pq.isEmpty())
//            {
//                break;
//            }
//            Point p=pq.poll();
//            ans=new ArrayList<>();
//            ans.add(p.getX());
//            ans.add(p.getY());
//            List<Integer> copied = new ArrayList<>(ans);
//            mainAns.add(copied);
//        }
//        return mainAns;
//
//    }
//}
