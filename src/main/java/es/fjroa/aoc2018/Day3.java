package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 extends DailyPuzzle{


    public static int executePart1(String nameFile) throws URISyntaxException, IOException {
        return getOverlappedInches(readFile(nameFile).map(Claim::new).collect(Collectors.toList()));
    }

    public static int getOverlappedInches(List<Claim> claims) {
        int [][] fabric = calculateFabric(claims);

        //counting result
        int overlapCounter = 0;
        for (int[] row : fabric)
        {
            for (int value : row)
            {
                if (value > 1) {
                    overlapCounter++;
                }
            }
        }
        return overlapCounter;
    }

    private static int[][] calculateFabric(List<Claim> claims) {
        int [][] fabric = new int[1000][1000];
        claims.forEach(c -> {
            for (int i = 0; i < c.height; i++) {
                for (int j = 0; j < c.width; j++) {
                    fabric[c.topEdge + i][c.leftEdge + j]++;
                }
            }
        });
        return fabric;
    }


    public static String executePart2(String nameFile) throws URISyntaxException, IOException {
        return findNotOverlapClaim(readFile(nameFile).map(Claim::new).collect(Collectors.toList()));
    }

    public static String findNotOverlapClaim(List<Claim> claims) {
        int [][] fabric = calculateFabric(claims);
        for (Claim c: claims) {
            boolean claimed = false;
            for (int i = 0; i < c.height; i++) {
                for (int j = 0; j < c.width; j++) {
                    if (fabric[c.topEdge + i][c.leftEdge + j] != 1) {
                        claimed = true;
                    }
                }
            }
            if (!claimed) return c.id;
        }
        return null;
    }

    public static class Claim {
        String id;
        int leftEdge;
        int topEdge;
        int width;
        int height;

        public Claim(String s) {
             //#1 @ 1,3: 4x4
            this.id = s.substring(s.indexOf("#")+1, s.indexOf("@")).trim();
            this.leftEdge = Integer.parseInt(s.substring(s.indexOf("@")+1, s.indexOf(",")).trim());
            this.topEdge = Integer.parseInt(s.substring(s.indexOf(",")+1, s.indexOf(":")).trim());
            this.width = Integer.parseInt(s.substring(s.indexOf(":")+1, s.indexOf("x")).trim());
            this.height = Integer.parseInt(s.substring(s.indexOf("x")+1).trim());
        }
    }
}