package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Day5 extends DailyPuzzle{


    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return calculateUnits(readFile(nameFile).collect(Collectors.joining()));
    }

    public static int calculateUnits(String polymer) {
        while (true) {
            boolean reaction = false;
            for (int i = 0; i < polymer.length()-1; i++) {
                char c = polymer.charAt(i);
                char c2 = polymer.charAt(i+1);
                if (Math.abs(c-c2) == 32) {
                    polymer = polymer.substring(0,i)+polymer.substring(i+2);
                    i--;
                    reaction = true;
                }
            }

            if (!reaction) {
                return polymer.length();
            }
        }
    }

    public static int executePart2(String nameFile) throws URISyntaxException, IOException {
        return calculateOptimalUnit(readFile(nameFile).collect(Collectors.joining()));
    }

    public static int calculateOptimalUnit(String polymer) {
        int minSize = Integer.MAX_VALUE;
        //Find all the different units
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < polymer.length(); i++) {
            if (polymer.charAt(i) <= 90) {
                set.add(polymer.charAt(i));
            }
        }

        for (char c : set) {
            int localSize = calculateUnits(
            polymer.replaceAll("(?i)"+String.valueOf(c), ""));
            if (localSize < minSize) {
                minSize = localSize;
            }
        }
        return minSize;
    }
}