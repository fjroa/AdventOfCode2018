package es.fjroa.aoc2018;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day5Test {

    @Test
    public void testPart1(){
        Assert.assertEquals(
                10, Day5.calculateUnits("dabAcCaCBAcCcaDA"));
    }

    @Test
    public void testPart2(){
        Assert.assertEquals(
                4, Day5.calculateOptimalUnit("dabAcCaCBAcCcaDA"));
    }
}
