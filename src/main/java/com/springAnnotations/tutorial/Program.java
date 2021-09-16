package com.springAnnotations.tutorial;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;


public class Program {


    public boolean wordPattern(String queryString) throws UnsupportedEncodingException {
        Queue<Integer> q=new LinkedList<>();
        String decode= URLDecoder.decode(queryString,"UTF-8");
        Map<String, String> mp = Arrays.asList(queryString.split("&"))
                .stream()
                .filter(c -> !c.contains(Constant.LIMIT) && !c.contains(Constant.OFFSET) && !c.contains(Constant.FIELDS))
                .map(s -> s.split(Constant.EQUAL, 2))
                .collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
        return true;
    }


    @Test
    public void TestCase() throws UnsupportedEncodingException {


    }
}

