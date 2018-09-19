package com.test.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class TreeBuilderTest {

    @Test
    public void buildUsingTwoLeafs() {
        Map<String, Integer> source = new HashMap<>();
        source.put("my", 1);
        source.put("test", 1);
        TreeNode result = TreeBuilder.build(source);
        assertEquals(2, result.getValue());
        assertEquals(1, result.getLeft().getValue());
        assertEquals(1, result.getRight().getValue());
    }

    @Test
    public void buildUsingThreeLeafs() {
        Map<String, Integer> source = new HashMap<>();
        source.put("my", 1);
        source.put("test", 1);
        source.put("application", 1);
        TreeNode result = TreeBuilder.build(source);
        assertEquals(3, result.getValue());
        assertEquals(2, result.getLeft().getValue());
        assertEquals(1, result.getRight().getValue());
    }

    @Test
    public void buildComplexThreeExample() {
        Map<String, Integer> source = new HashMap<>();
        source.put("she", 1);
        source.put("to", 1);
        source.put("problems", 1);
        source.put("address", 2);
        source.put("had", 2);
        TreeNode result = TreeBuilder.build(source);
        assertEquals(7, result.getValue());
        assertEquals(3, result.getLeft().getValue());
        assertEquals(4, result.getRight().getValue());
    }

}
