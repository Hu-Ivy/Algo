package queue;

public class MyQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;//用于存放数据

    //创建队列构造器
    public MyQueue(int arrMaxsize) {
        maxSize = arrMaxsize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;

    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }


    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;

    }

    //添加数据到队列
    public void addQue(int n) {
        //判断是否满
        if (isFull()) {
            System.out.println("队列已满...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    //出队列
    public int getQueue() {
        //判断是否空
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        int result = arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    //显示队列所有数据
    public void showQue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = front; i <= front + this.size(); i++) {
            System.out.println(String.format("arr[%d]=%d", i%maxSize, arr[i%maxSize]));
        }

    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    //显示头数据
    public int headQue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
}
