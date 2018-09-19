package com.test.tree;

import java.util.stream.IntStream;

public class TreeNode {

    private int value;
    private TreeNode childLeft = null;
    private TreeNode childRight = null;
    private String prefix = "  ";

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode childLeft, TreeNode childRight) {
        this(childLeft.value + childRight.value);
        this.childLeft = childLeft;
        this.childRight = childRight;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return childLeft;
    }

    public TreeNode getRight() {
        return childRight;
    }

    void getTextHierarhy(StringBuilder buffer, int idx, TreeNode child) {
        buffer.append("\r\n");
        String prefix = IntStream.range(0, idx).collect(
                StringBuilder::new,
                (sb, i) -> sb.append("  "),
                StringBuilder::append
        ).toString();
        buffer.append(prefix);
        buffer.append("->");
        buffer.append(child.toString());

        if (child.childLeft != null) {
            getTextHierarhy(buffer, idx + 1, child.childLeft);
        }
        if (child.childRight != null) {
            getTextHierarhy(buffer, idx + 1, child.childRight);
        }
    }

    public String getTextHierarhy() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("#").append(value).append("#");
        if (childLeft != null) {
            getTextHierarhy(buffer, 1, childLeft);
        }
        if (childRight != null) {
            getTextHierarhy(buffer, 1, childRight);
        }
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "#" + value + "#";
    }
}
