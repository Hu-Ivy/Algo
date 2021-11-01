package exercise;



import javax.swing.tree.TreeNode;
import java.util.*;

public class L102 {
    public static void main(String[] args) {
        MyTreeNode node1 = new MyTreeNode(1);
        MyTreeNode node2 = new MyTreeNode(2);
        MyTreeNode node3 = new MyTreeNode(3);
        MyTreeNode node4 = new MyTreeNode(4);
        MyTreeNode node5 = new MyTreeNode(5);
        MyTreeNode node6 = new MyTreeNode(4);
        MyTreeNode node7 = new MyTreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//        List<List<Integer>> res = levelOrder(node1);
//        boolean res = isSymmetric(node1);
        boolean res = hasPathSum(node1,8);
        System.out.println (res);
    }

    public static List<List<Integer>> levelOrder(MyTreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int time = 0;
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int curSize = queue.size();
            for (int i = 0; i <curSize; i++) {
                MyTreeNode temp = queue.poll();
                if (temp.left!=null) {
                    queue.add(temp.left);
                }
                if (temp.right!=null) {
                    queue.add(temp.right);
                }
                if (time%2==0) {
                    curLevel.add(temp.val);
                }else {
                    curLevel.add(0,temp.val);
                }

            }
            res.add(curLevel);
            time++;
        }

        return res;
    }


    public static boolean isSymmetric(MyTreeNode root) {
        return isSymmetric2(root.left,root.right);
    }
    public static boolean isSymmetric2(MyTreeNode node1, MyTreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }else if (node1 == null || node2 == null) {
            return false;
        }else if (node1.val!=node2.val) {
            return false;
        } else {
            return isSymmetric2(node1.left,node2.right)&&isSymmetric2(node1.right,node2.left);
        }
    }

    //广度优先可以做。
    public static int maxDepth(MyTreeNode root) {
        int depth = 0;
        Deque<MyTreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            int curSize = que.size();
            for (int i = 0; i < curSize; i++) {
                MyTreeNode temp = que.poll();
                if (temp.left!=null) {
                    que.add(temp.left);
                }
                if (temp.right!=null) {
                    que.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }
    //深度优先做最大深度
    public static int maxDepth2(MyTreeNode root) {
        //叶子节点递归下去是null，深度为0.递归终止条件。
        if (root==null) {
            return 0;
        }else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            //返回时要+1
            return Math.max(leftHeight,rightHeight)+1;
        }

    }

    public static boolean hasPathSum(MyTreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        if (root.left==null&&root.right==null) {
            return targetSum== root.val;
        }
        //每递归一次就减去root节点。
        return hasPathSum(root.left, targetSum - root.val)||hasPathSum(root.right, targetSum - root.val);
    }

}
