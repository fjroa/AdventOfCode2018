package es.fjroa.aoc2018;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class Day1Test {

    @Test
    @DataProvider(value = {
            "3 |  1|-2| 3 |1",
            "3 |  1| 1| 1 ",
            "0 |  1| 1|-2 ",
            "-6| -1|-2|-3 "
    }, splitBy = "\\|")
    public void whenExecute_testCalibration(int expectedFrequency, int... frequencyChanges) {
        Assert.assertEquals(Day1.firstCalibration(frequencyChanges, 0), expectedFrequency);
    }
}
