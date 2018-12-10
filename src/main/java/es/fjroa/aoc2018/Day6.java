package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6 extends DailyPuzzle{


    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return calculateMaxArea(readFile(nameFile).map(Point::new).collect(Collectors.toList()));
    }

    private static int calculateMaxArea(List<Point> points) {
        int topLeft,topRight,bottomLeft,bottomRight = 0;

        for (Point point : points) {

        }
        return 0;
    }

    private static class Point {
        int x;
        int y;

        public Point(String s) {
            x = Integer.parseInt(s.substring(0, s.indexOf(",")).trim());
            y = Integer.parseInt(s.substring(s.indexOf(",")+1).trim());
        }


    }
}