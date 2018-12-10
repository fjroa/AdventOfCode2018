package es.fjroa.aoc2018;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DailyPuzzle {
    protected static Stream<String> readFile(String nameFile) throws URISyntaxException, IOException {
        Path path = Paths.get(Main.class.getClassLoader()
                .getResource(nameFile).toURI());
        return Files.lines(path);
    }
}
