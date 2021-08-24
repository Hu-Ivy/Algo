package hashtable;

public class HashTabDemo {
    public static void main(String[] args) {
        Employee emp0 = new Employee(0,"aaa");
        Employee emp1 = new Employee(1,"bbb");
        Employee emp2 = new Employee(2,"ccc");
        Employee emp3 = new Employee(3,"ddd");
        Employee emp4 = new Employee(4,"eee");
        Employee emp5 = new Employee(5,"fff");
        Employee emp6 = new Employee(6,"ggg");

        HashTab tab = new HashTab(5);

        tab.add(emp0);
        tab.add(emp1);
        tab.add(emp2);
        tab.add(emp3);
        tab.add(emp4);
        tab.add(emp5);
        tab.add(emp6);
        tab.list();


    }


}
class Employee {
    public int id;
    public String name;
    Employee next;
    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
class HashTab {
    private final EmployeeLinkedList[] empLists;
    private final int size;

    public HashTab(int size) {
        this.size=size;
        empLists=new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLists[i]= new EmployeeLinkedList();
        }
    }

    //添加雇员
    public void add(Employee emp) {
        int empListsNo = hashFun(emp.id);
        empLists[empListsNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.println("第"+i+"行：");
            empLists[i].list();
        }
    }
    //编写散列函数
    public int hashFun(int id) {
        return id%size;
    }
}
class EmployeeLinkedList {
    private Employee head = null;
    //添加雇员到链表
    public void add(Employee emp) {
        if (head==null) {
            head=emp;
            return;
        }
        Employee curEmp = head;
        while (curEmp.next!=null) {
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }
    //遍历雇员信息
    public void list() {
        if (head==null) {
            System.out.println("当前链表为空");
            return;
        }
        Employee curEmp = head;

        while (curEmp!=null) {
            System.out.println("id:"+curEmp.id+" name:"+curEmp.name);
            curEmp=curEmp.next;
        }
    }
}