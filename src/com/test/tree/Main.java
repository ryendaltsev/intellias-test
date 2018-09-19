package com.test.tree;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if (args.length == 1) {
            TreeNode result = TreeBuilder.build(parseFile(args[0]));
            System.out.println("Tree was build. Result:");
            System.out.println(result);
        }
        else {
            printHelp();
        }
    }

    private static Map<String, Integer> parseFile(String file) {
        try {
            System.out.println("Starting to parse file:" + file);
            HashMap<String, Integer> words = new HashMap<>();
            Files.lines(Paths.get(file)).forEach(
                    strLine -> {
                        Arrays.stream(strLine.split(" ")).map(String::trim).forEach(
                                word -> {
                                    words.compute(word, (key, value) -> {
                                        if (value == null) {
                                            value = 0;
                                        }
                                        value++;
                                        return value;
                                    });

                                });
                    }
            );
            return words;
        }
        catch (Exception e) {
            return Collections.<String, Integer>emptyMap();
        }
    }

    private static void printHelp() {
        System.out.println("The application waiting existing text file as parameter for start.");
    }

}
