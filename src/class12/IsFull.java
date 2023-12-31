package class12;

import genericmethods.TreeElements.*;

public class IsFull {

    public static boolean isFull(NodeWithParent head) {
        if (head == null) {
            return true;
        }
        Info info = process(head);
        return info.nodeCount == (1 << info.height - 1);
    }

    public static Info process(NodeWithParent nodeWithParent) {
        if (nodeWithParent == null) {
            return new Info(0, 0);
        }
        int height = 1;
        int nodeCount = 1;
        Info leftInfo = process(nodeWithParent.left);
        Info rightInfo = process(nodeWithParent.right);
        height += Math.max(leftInfo.height, rightInfo.height);
        nodeCount += (leftInfo.nodeCount + rightInfo.nodeCount);
        return new Info(height, nodeCount);
    }

    public static class Info {
        public int height;
        public int nodeCount;

        public Info(int height, int nodeCount) {
            this.height = height;
            this.nodeCount = nodeCount;
        }
    }


}
