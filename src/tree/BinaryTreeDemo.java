package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢梭");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "武松");
        HeroNode heroNode6 = new HeroNode(6, "武大郎");
        HeroNode heroNode7 = new HeroNode(7, "潘金莲");




        tree.setRoot(root);
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        heroNode2.setLeft(heroNode6);
        heroNode2.setRight(heroNode7);

        System.out.println("pre order");
        tree.preOrder();
//        System.out.println("infix order");
//        tree.infixOrder();
//        System.out.println("post order");
//        tree.postOrder();

//        tree.infixSearch(5);

        System.out.println("-------------after delete---------------------");
        tree.delNode(4);
        tree.preOrder();
    }


}
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root!=null) {
            this.root.preOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root!=null) {
            this.root.midOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }
    public void postOrder() {
        if (this.root!=null) {
            this.root.postOrder();
        }else {
            System.out.println("空，无法遍历");
        }
    }
    public void preSearch(int no) {
        if (this.root!=null) {
            this.root.preOrdersearch(no);
        }else {
            System.out.println("空，无法遍历");
        }
    }
    public void infixSearch(int no) {
        if (this.root!=null) {
            this.root.infixOrdersearch(no);
        }else {
            System.out.println("空，无法遍历");
        }
    }
    public void postSearch(int no) {
        if (this.root!=null) {
            this.root.postOrdersearch(no);
        }else {
            System.out.println("空，无法遍历");
        }
    }

    public void delNode(int no) {
        if (root!=null) {
            if (root.getNo()==no) {root=null;}
            else{
                this.root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除");
        }
    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public HeroNode(int no, String name) {
        this.no=no;
        this.name=name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //递归删除节点
    //叶节点删除，子节点删除子树
    public void delNode(int no) {
        if (this.left!=null && this.left.no==no) {
            this.left=null;
            return;
        }
        if (this.right!=null && this.right.no==no) {
            this.right=null;
            return;
        }

        //向左递归删除
        if (this.left!=null) {
            this.left.delNode(no);
        }
        //向右递归删除
        if (this.right!=null) {
            this.right.delNode(no);
        }
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this.no+","+this.name);
        if(this.left!=null) {
            this.left.preOrder();
        }
        if (this.right!=null) {
            this.right.preOrder();
        }

    }

    //中序遍历
    public void midOrder() {

        if(this.left!=null) {
            this.left.preOrder();
        }
        System.out.println(this.no+","+this.name);
        if (this.right!=null) {
            this.right.preOrder();
        }
    }

    //后序遍历

    public void postOrder() {
        if(this.left!=null) {
            this.left.postOrder();
        }
        if (this.right!=null) {
            this.right.postOrder();
        }
        System.out.println(this.no+","+this.name);
    }
    public HeroNode preOrdersearch(int no) {
        //比较当前节点是不是
        if (this.no==no) {
            return this;
        }
        HeroNode resNode=null;
        if (this.left!=null) {
            resNode=this.left.preOrdersearch(no);
        }
        if (resNode!=null) {
            return resNode;
        }
        if (this.right!=null) {
            resNode=this.right.preOrdersearch(no);

        }
        return resNode;
    }
    public HeroNode infixOrdersearch(int no) {
        HeroNode resNode=null;
        if (this.left!=null) {
            resNode=this.left.infixOrdersearch(no);
        }
        //如果左递归过程中找到了，直接返回上一层
        if (resNode!=null) {
            return resNode;
        }
        //比较当前节点是不是
        if (this.no==no) {
            return this;
        }
        if (this.right!=null) {
            resNode=this.right.infixOrdersearch(no);
        }
        return resNode;
    }
    public HeroNode postOrdersearch(int no) {
        HeroNode resNode=null;
        if (this.left!=null) {
            resNode=this.left.postOrdersearch(no);
        }
        //如果左递归过程中有返回resNode值就不为null
        if (resNode!=null) {
            return resNode;
        }
        if (this.right!=null) {
            resNode=this.right.postOrdersearch(no);

        }
        if (resNode!=null) {
            return resNode;
        }
        //比较当前节点是不是
        if (this.no==no) {
            return this;
        }

        return resNode;

    }
}