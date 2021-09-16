package com.springAnnotations.tutorial;

import org.junit.Test;

public class SubsequenceOfString {

    public void subSequnceOfString(char str[])
    {
        int noOfSubsequences=(1<<str.length)-1;
        for(int i=0;i<=noOfSubsequences;i++)
        {
            masking(i,str);
            System.out.println();
        }
    }

    private void masking(int no, char[] str) {
        int indexOfString=0;
        while(no>0)
        {
            if((no&1)==1)
            {
                System.out.print(str[indexOfString]);
            }
            else
            {
                System.out.print("");
            }
            no=no>>1;
            indexOfString++;
        }
    }
    @Test
    public void test()
    {
        subSequnceOfString(new char[]{'a','b','c'});
    }
}
