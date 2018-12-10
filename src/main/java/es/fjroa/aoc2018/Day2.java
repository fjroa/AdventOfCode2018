package es.fjroa.aoc2018;

import javafx.util.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 extends DailyPuzzle{


    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return calculateChecksum(readFile(nameFile));
    }

    public static String executePart2(String nameFile) throws URISyntaxException, IOException {
        return findBoxes(readFile(nameFile).collect(Collectors.toList()));
    }

    private static int calculateChecksum(Stream<String> labels) {
        List<Pair<Boolean, Boolean>> results = new ArrayList<>();
        labels.forEach(s -> results.add(checkLabel(s)));
        int doubleSum = results.stream().mapToInt(b -> b.getKey() ? 1 : 0).sum();
        int tripleSum = results.stream().mapToInt(b -> b.getValue() ? 1 : 0).sum();
        return doubleSum * tripleSum;
    }

    public static Pair<Boolean, Boolean> checkLabel (String label) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, n = label.trim().length() ; i < n ; i++) {
            Character c = label.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        return new Pair<>(map.containsValue(2), map.containsValue(3));
    }

    public static String findBoxes(List<String> lines) {
        for(int i = 0; i < lines.get(0).length(); i++) {
            Set<String> temp = new HashSet<>();
            for (String line:lines){
                String word = line.substring(0, i)
                        +line.substring(i+1);
                if (!temp.add(word)){
                    return word;
                }
            }
        }
        return null;
    }
}