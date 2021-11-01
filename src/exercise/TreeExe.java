package exercise;


import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeExe {
    public static void main(String[] args) {
        MyTreeNode node0 = new MyTreeNode(1);
        MyTreeNode node1 = new MyTreeNode(2);
        MyTreeNode node2 = new MyTreeNode(3);
        MyTreeNode node3 = new MyTreeNode(4);
        MyTreeNode node4 = new MyTreeNode(2);
        MyTreeNode node5 = new MyTreeNode(4);
        MyTreeNode node6 = new MyTreeNode(4);

        node0.left = node1;
        node1.left = node3;
        node0.right = node2;
        node2.left = node4;
        node4.left = node5;
        node2.right = node6;

        List<MyTreeNode> res = findDuplicateSubtrees(node0);
        for (MyTreeNode s:
             res) {
            System.out.println(s.val);
        }
    }
    private static int t;
    private static Map<String, Integer> trees;
    private static Map<Integer, Integer> count;
    private static List<MyTreeNode> ans;
    //L625 寻找重复的子树,假设每棵子树都有一个唯一标识符：只有当两个子树的 id 相同时，认为这两个子树是相同的。只需要遍历一遍即可完成任务。
    public static List<MyTreeNode> findDuplicateSubtrees(MyTreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }
    public static int lookup(MyTreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        //子树序列的键值为uid
        int uid = trees.computeIfAbsent(serial, x-> t++);
        //count再把uid对应为计数
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        //把uid返回给序列化。
        return uid;
    }



}
