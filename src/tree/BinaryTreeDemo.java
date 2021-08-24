package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "吴用");
        HeroNode heroNode3 = new HeroNode(3, "卢梭");
        HeroNode heroNode4 = new HeroNode(4, "林冲");
        HeroNode heroNode5 = new HeroNode(5, "宋江");
        tree.setRoot(root);
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);

        System.out.println("pre order");
        tree.preOrder();
        System.out.println("infix order");
        tree.infixOrder();
        System.out.println("post order");
        tree.postOrder();
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

}