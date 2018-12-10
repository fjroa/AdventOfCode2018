package es.fjroa.aoc2018;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Day7Test {

    @Test
    public void testPart1() throws IOException, URISyntaxException {
        Assert.assertEquals(
                "CABDFE", Day7.executePart1("day7Test.txt"));
    }

   /* @Test
    public void testPart2() throws IOException, URISyntaxException {
        Assert.assertEquals(
                99*45, Day4.executePart2("day4Test.txt"));
    }*/
}
