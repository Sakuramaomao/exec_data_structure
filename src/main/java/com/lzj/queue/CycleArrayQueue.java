package com.lzj.queue;

/**
 * 用数组实现的循环队列。
 *
 * @Author Sakura
 * @Date 2019/9/23 21:47
 */
public class CycleArrayQueue {
    private final int maxSize;
    private int front;  // 指向队头元素的位置。
    private int rear; // 指向队尾元素的后一个位置，故意空出一个位置。
    private final int[] arr;

    public CycleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front; //
    }

    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 从队尾插入元素。
     * <p>
     * 用rear的位置存放新元素n，同时rear的位置变为取模后的位置。
     * 其实rear所在的位置始终是空的。
     *
     * @param n 新元素。
     */
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队头获取元素。
     * <p>
     * 要先把元素临时存储起来，之所以这么做是因为后面要对front做更改。
     *
     * @return 队头元素。
     */
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 查看队头元素，并非删除。
     *
     * @return 队头元素。
     */
    public int head() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，没有元素");
        }
        int size = getSize();
        for (int i = front; i < front + size; i++) {
            int index = i % maxSize;
            System.out.printf("arr[%d]=%d\t", index, arr[index]);
        }
    }

    /**
     * 获取队列中有效元素的个数。
     *
     * @return 有效元素个数。
     */
    public int getSize() {
        return (rear - front + maxSize) % maxSize;
    }
}