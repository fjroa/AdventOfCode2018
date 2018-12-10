package es.fjroa.aoc2018;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class Day3Test {

    @Test
    @DataProvider(value = {
            "4 | #1 @ 1,3: 4x4 | #2 @ 3,1: 4x4 |  #3 @ 5,5: 2x2"
    }, splitBy = "\\|")
    public void getOverlappedInches(int expectedInches, Day3.Claim... claims) {
        Assert.assertEquals(expectedInches, Day3.getOverlappedInches(Arrays.asList(claims)));
    }

    @Test
    @DataProvider(value = {
            "3 | #1 @ 1,3: 4x4 | #2 @ 3,1: 4x4 |  #3 @ 5,5: 2x2"
    }, splitBy = "\\|")
    public void findNotOverlapClaim(String expectedId, Day3.Claim... claims) {
        Assert.assertEquals(expectedId, Day3.findNotOverlapClaim(Arrays.asList(claims)));
    }
}
