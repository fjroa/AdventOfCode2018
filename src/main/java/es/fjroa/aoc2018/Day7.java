package es.fjroa.aoc2018;

import javafx.util.Pair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

public class Day7 extends DailyPuzzle{


    public static String executePart1(String nameFile) throws URISyntaxException, IOException {
        return findOrder(readFile(nameFile).collect(Collectors.toList()));
    }

    private static String findOrder(List<String> instructions) {
        Set<Character> steps = new HashSet<>();
        Set<Character> rightSteps = new HashSet<>();

        List<Pair<Character, Character>> pairs = new ArrayList<>();
        instructions.forEach(s->{
            steps.add(s.charAt(5));
            steps.add(s.charAt(36)); rightSteps.add(s.charAt(36));
            pairs.add(new Pair<>(s.charAt(5), s.charAt(36)));
        });

        Character root = steps.stream().filter(c->!rightSteps.contains(c)).findFirst().get();
        Tree tree = new Tree(root);
        StringBuffer sb = new StringBuffer();

        return sb.toString();
    }

    public static class Tree<T> {
        private Node<T> root;

        public Tree(T rootData) {
            root = new Node<T>();
            root.data = rootData;
            root.children = new ArrayList<Node<T>>();
        }

        public static class Node<T> {
            private T data;
            private Node<T> parent;
            private List<Node<T>> children;
        }
    }
}