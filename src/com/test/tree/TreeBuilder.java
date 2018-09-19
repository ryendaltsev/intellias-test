package com.test.tree;

import java.util.*;

public class TreeBuilder {

    public static TreeNode build(Map<String, Integer> map) {
        Map<Integer, List<TreeNode>> source = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );

        map.forEach((word, value) -> {
            SourceNode node = new SourceNode(word, value);
            source.computeIfAbsent(value, ArrayList::new);
            source.get(value).add(node);
        });
        List<TreeNode> result = new ArrayList<>();

        source.values().forEach(items -> {
            result.add(buildRoot(items));
        });
        return buildRoot(result);
    }

    /**
     * Method reduses amount of elements and return new list
     * @param source
     *
     * @return list of new created Leafs
     */
    private static List<TreeNode> buildNextLevel(List<TreeNode> source) {
        List<TreeNode> result = new ArrayList<>();
        if (source.size() > 1) {
            TreeNode[] childs = new TreeNode[1];
            source.forEach(leaf -> {
                if (childs[0] == null) {
                    childs[0] = leaf;
                }
                else {
                    result.add(new TreeNode(leaf, childs[0]));
                    childs[0] = null;
                }
            });
            // if odd numbers of elements ?
            if (childs[0] != null) {
                TreeNode leaf = result.remove(result.size() - 1);
                result.add(new TreeNode(leaf, childs[0]));
            }
        }
        return result;
    }

    /**
     * Calculate root element based on list values
     *
     * @param source
     *
     * @return TreeNode
     */
    private static TreeNode buildRoot(List<TreeNode> source) {
        List<TreeNode> items = source;
        while (items.size() > 1) {
            items = buildNextLevel(items);
        }
        return items.get(0);
    }

    private static class SourceNode extends TreeNode {
        String sourceWord;

        SourceNode(String word, int value) {
            super(value);
            sourceWord = word;
        }
    }
}
