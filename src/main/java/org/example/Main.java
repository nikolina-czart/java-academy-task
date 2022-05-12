package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String text = parseArgs(args);
        Map<Character, Long> map = getCharNumberMap(text);
        Map<Character, Long> sortedMap = getSortedMap(map);
        printResult(sortedMap);
    }

    public static String parseArgs(String[] args) {
        String text = String.join(" ", args);
        return text.toLowerCase().replaceAll( "\\s" ,  "" );
    }

    public static Map<Character, Long> getCharNumberMap(String text){
        Map<Character, Long> mapOfCharCount = new HashMap<>();

        for (char c :  text.toCharArray()) {
            Long count = text.chars().filter(ch -> ch == c).count();
            mapOfCharCount.put(c, count);
        }

        return mapOfCharCount;
    }

    public static Map<Character, Long> getSortedMap(Map<Character, Long> unsortedMap){
        return new TreeMap<>(unsortedMap);
    }

    private static void printResult(Map<Character, Long> map) {
        for (Map.Entry<Character, Long> element : map.entrySet()) {
            System.out.println(element.getKey() + " = " + element.getValue());
        }
    }
}