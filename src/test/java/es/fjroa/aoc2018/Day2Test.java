package es.fjroa.aoc2018;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(DataProviderRunner.class)
public class Day2Test {

    @Test
    @DataProvider(value = {
            "false|false|abcdef",
            "true |true |bababc",
            "true |false|abbcde",
            "false|true |abcccd",
            "true |false|aabcdd",
            "true |false|abcdee",
            "false|true |ababab"
    }, splitBy = "\\|")
    public void whenExecute_getChecksum(boolean expectedTwoTimes, boolean expectedThreeTimes, String label) {
        Pair<Boolean, Boolean> result = Day2.checkLabel(label);
        Assert.assertEquals(result.getKey(), expectedTwoTimes);
        Assert.assertEquals(result.getValue(), expectedThreeTimes);
    }

    @Test
    @DataProvider(value = {
            "fgij|abcde|fghij|klmno|pqrst|fguij|axcye|wvxyz",
            "fgij|abcde|fgijh|klmno|pqrst|fgiju|axcye|wvxyz",
            "fgij|abcde|hfgij|klmno|pqrst|ufgij|axcye|wvxyz"
    }, splitBy = "\\|")
    public void testLabels(String expectedResult, String... words) {
        String id = Day2.findBoxes(Arrays.asList(words));
        Assert.assertEquals(expectedResult, id);
    }
}
