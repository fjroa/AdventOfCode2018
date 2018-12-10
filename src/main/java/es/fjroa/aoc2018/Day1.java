package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class Day1 extends DailyPuzzle{

    public static int firstCalibration(int[] frequencyChanges, int frequency) {
        for (int i : frequencyChanges) {
            frequency += i;
        }
        return frequency;
    }

    public static int secondCalibration(int[] frequencyChanges, int frequency) {
        Set<Integer> frequencyHistory = new HashSet<>();
        frequencyHistory.add(frequency);
        while (true) {
            for (int i : frequencyChanges) {
                frequency += i;
                if (!frequencyHistory.add(frequency)) {
                    return frequency;
                }
            }
        }
    }

    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return firstCalibration(readFile(nameFile).mapToInt(Integer::parseInt).toArray(), 0);
    }

    public static int executePart2(String nameFile) throws URISyntaxException, IOException {
        return secondCalibration(readFile(nameFile).mapToInt(Integer::parseInt).toArray(), 0);
    }
}
