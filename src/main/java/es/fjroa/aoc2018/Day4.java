package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4 extends DailyPuzzle{


    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return strategy1(readFile(nameFile).sorted().collect(Collectors.toList()));
    }

    private static int strategy1(List<String> notes) {

        Map<Integer, List<Integer>> guardDays = new HashMap<>();
        boolean[][] sleepTable = populateMatrix(notes, guardDays);

        //Guard with more asleep minutes and best minute
        int maxMinutes = 0;
        int candidateGuard = 0;
        int bestMinute = 0;

        for (Map.Entry<Integer, List<Integer>> guardDay : guardDays.entrySet()) {
            int asleepMinutes = 0;
            int[] minutesArray = new int[60];
            for (Integer i : guardDay.getValue()) {
                for (int j = 0; j < 60; j++) {
                    if (sleepTable[i][j]) {
                        asleepMinutes++;
                        minutesArray[j]++;
                    }
                }
            }
            if (asleepMinutes > maxMinutes) {
                maxMinutes = asleepMinutes;
                candidateGuard = guardDay.getKey();
                int maxDifferentDaysSleeping = 0;
                int guardBestMinute = 0;
                for (int j = 0; j < 60; j++) {
                    if (minutesArray[j] > maxDifferentDaysSleeping) {
                        maxDifferentDaysSleeping = minutesArray[j];
                        guardBestMinute = j;
                    }
                }
                bestMinute = guardBestMinute;
            }
        }

        return candidateGuard*bestMinute;
    }

    private static boolean[][] populateMatrix(List<String> notes, Map<Integer, List<Integer>> guardDays) {
        List<String> days = notes.stream().filter(l -> l.contains("Guard")).collect(Collectors.toList());
        boolean[][] sleepTable = new boolean[days.size()][60];
        int asleepMinute = 0;
        int day = -1;
        for (String note : notes) {
            if (note.contains("Guard")) {
                Integer id = Integer.parseInt(note.split(" ")[3].substring(1));
                List<Integer> aux = guardDays.get(id);
                if (!guardDays.containsKey(id)) {
                    aux = new ArrayList<>();
                }
                aux.add(++day);
                guardDays.put(id, aux);
            } else
            if (note.contains("falls")) {
                asleepMinute = Integer.parseInt(note.substring(15,17));
            } else {
                for (int i = asleepMinute; i < Integer.parseInt(note.substring(15,17)); i++) {
                    sleepTable[day][i] = true;
                }
            }
        }
        return sleepTable;
    }

    public static int executePart2(String nameFile) throws URISyntaxException, IOException {
        return strategy2(readFile(nameFile).sorted().collect(Collectors.toList()));
    }

    private static int strategy2(List<String> notes) {

        Map<Integer, List<Integer>> guardDays = new HashMap<>();
        boolean[][] sleepTable = populateMatrix(notes, guardDays);

        //Guard with best global minute
        int candidateGuard = 0;
        int bestMinute = 0;
        int maxOccurrences = 0;

        for (Map.Entry<Integer, List<Integer>> guardDay : guardDays.entrySet()) {
            int[] minutesArray = new int[60];
            for (Integer i : guardDay.getValue()) {
                for (int j = 0; j < 60; j++) {
                    if (sleepTable[i][j]) {
                        minutesArray[j]++;
                    }
                }
            }
            int maxLocalOccurences = 0;
            int bestLocalMinute = 0;
            for (int j = 0; j < 60; j++) {
                if (minutesArray[j] > maxLocalOccurences) {
                    maxLocalOccurences = minutesArray[j];
                    bestLocalMinute = j;
                }
            }
            if (maxLocalOccurences > maxOccurrences) {
                maxOccurrences = maxLocalOccurences;
                candidateGuard = guardDay.getKey();
                bestMinute = bestLocalMinute;
            }
        }

        return candidateGuard*bestMinute;
    }
}