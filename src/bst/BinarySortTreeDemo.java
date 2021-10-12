package bst;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr= {7,3,10,12,5,1,9};
        BST bst = new BST();
        for (int j : arr) {
            bst.add(new Node(j));
        }
        bst.infixOrder();
    }
}
//创建二叉排序树
class BST{
    private Node root;

    public Node search(int value) {
        if (root==null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root==null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value) {
        if (root==null) {
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode==null) {
                return;
            }
            //  如果二叉树只有一个节点
            if (targetNode.left==null&&targetNode.right==null) {
                root=null;
                return;
            }
            Node parent = searchParent(value);
            //如果要删除叶子节点
            if (targetNode.left==null&&targetNode.right==null) {

            }

        }
    }

    public void add(Node node) {
        if (root==null) {
            root=node;
            return;
        }
        root.add(node);
    }

    //中序遍历
    public void infixOrder() {
        if (root!=null) {
            root.infixOrder();
        }else {
            System.out.println("为空");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
    //查找节点
    public Node search(int value) {
        if (value==this.value) {
            return this;
        } else if (value<this.value){
            if (this.left==null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找父节点
    public Node searchParent(int value) {
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
            return this;
        }else {
            if (value<this.value&&this.left!=null) {
                return this.left.searchParent(value);
            }else if (value>=this.value&&this.right!=null) {
                return this.right.searchParent(value);
            } else {
                //没有父节点
                return null;
            }
        }
    }
    //递归形式添加节点
    public void add(Node node) {
        if (node==null) {
            return;
        }
        if (node.value<this.value) {
            if (this.left==null) {
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right==null) {
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void infixOrder() {
        if (this.left!=null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right!=null) {
            this.right.infixOrder();
        }
    }
}