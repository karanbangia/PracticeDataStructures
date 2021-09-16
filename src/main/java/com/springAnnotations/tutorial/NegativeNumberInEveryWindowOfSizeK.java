package com.springAnnotations.tutorial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NegativeNumberInEveryWindowOfSizeK {
    public long[] printFirstNegativeInteger(long[] A, int N, int K)
    {
        Queue<Integer> q=new LinkedList<>();
        List<Long> al=new ArrayList<>();
        int i=0,j=0;
        while(j<N)
        {
            if(A[j]<0)
            {
                q.add(j);
            }
            if(j-i+1<K)
            {

                j++;
            }
            else
            {
                if(q.isEmpty())
                {
                    al.add(0L);
                }
                else
                {
                    if(q.peek()>i)
                    {
                        al.add(A[q.peek()]);
                    }
                    else
                    {
                        al.add(A[q.poll()]);
                    }
                }

                j++;
                i++;
            }
        }
        long[] ans=new long[al.size()];
        for (int i1 = 0; i1 < ans.length; i1++) {
            ans[i1]=al.get(i1);
        }
        return ans;
    }

    @Test
    public void test()
    {
       long ans[]= printFirstNegativeInteger(new long[]{12, -1, -7, 8, -15, 30, 16, 28},8,3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("ans[i] = " + ans[i]);
        }
    }
}
