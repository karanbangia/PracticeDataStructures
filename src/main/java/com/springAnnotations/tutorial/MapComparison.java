package com.springAnnotations.tutorial;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapComparison {
    @Test
    public void mapComparison()
    {
        Map<String, Integer> hm= new HashMap<>();
        hm.put("a",1);
        hm.put("b",2);
        hm.put("c",3);
        Map<String, Integer> hm2= new HashMap<>();
        hm2.put("a",1);
        hm2.put("b",2);
        hm2.put("c",3);
        hm2.put("d",3);
        Assert.assertTrue(hm2.equals(hm));
    }
}
