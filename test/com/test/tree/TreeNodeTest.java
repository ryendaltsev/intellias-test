package com.test.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TreeNodeTest {

    @Test
    public void getValue() {
        TreeNode node = new TreeNode(1);
        assertEquals(1, node.getValue());
    }

    @Test
    public void compositeConstructporWithLeftAndRight() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(one, two);

        assertEquals(one, three.getLeft());
        assertEquals(two, three.getRight());
        assertEquals(3, three.getValue());
    }

    @Test
    public void getTextHierarhySingleNode() {
        TreeNode one = new TreeNode(1);
        assertEquals("#1#", one.toString());
    }

    @Test
    public void getTextHierarhy() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(one, two);
        String test = three.getTextHierarhy();
        assertEquals("#3#\r\n  ->#1#\r\n  ->#2#", test);
    }
}
