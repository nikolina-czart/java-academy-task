package org.example;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void givenArgs_whenParseArgs_thenReturnText() {
        // given
        String[] args = {"MyApp", "JavaAcademy"};
        String expectedText = "myappjavaacademy";

        // when
        String text = Main.parseArgs(args);

        // then
        assertEquals(expectedText, text);
    }

    @Test
    public void givenText_whenGetCharNumberMap_thenReturnUnsortedMap() {
        // given
        String text = "myappjavaacademy";
        Map<Character, Long> expectedResult =  new HashMap<>();
        expectedResult.put('a', 5l);
        expectedResult.put('c', 1l);
        expectedResult.put('d', 1l);
        expectedResult.put('e', 1l);
        expectedResult.put('j', 1l);
        expectedResult.put('m', 2l);
        expectedResult.put('p', 2l);
        expectedResult.put('v', 1l);
        expectedResult.put('y', 2l);

        // when
        Map<Character, Long> map = Main.getCharNumberMap(text);

        // then
        assertEquals(expectedResult, map);
    }

    @Test
    public void givenUnsortedMap_whenGetSortedMap_thenReturnSortedMap() {
        // given
        Map<Character, Long> expectedMap =  new TreeMap<>();
        expectedMap.put('a', 5l);
        expectedMap.put('c', 1l);
        expectedMap.put('d', 1l);
        expectedMap.put('e', 1l);
        expectedMap.put('j', 1l);
        expectedMap.put('m', 2l);
        expectedMap.put('p', 2l);
        expectedMap.put('v', 1l);
        expectedMap.put('y', 2l);

        Map<Character, Long> unsortedMap =  new HashMap<>();
        unsortedMap.put('y', 2l);
        unsortedMap.put('c', 1l);
        unsortedMap.put('p', 2l);
        unsortedMap.put('a', 5l);
        unsortedMap.put('m', 2l);
        unsortedMap.put('j', 1l);
        unsortedMap.put('d', 1l);
        unsortedMap.put('e', 1l);
        unsortedMap.put('v', 1l);

        // when
        Map<Character, Long> map = Main.getSortedMap(unsortedMap);

        // then
        assertEquals(map, unsortedMap);
        assertEquals(expectedMap.keySet().toString(), map.keySet().toString());

    }
}