package com.lzj.queue;

/**
 * 数组队列。
 * 使用数组来模拟队列。
 *
 * @Author Sakura
 * @Date 2019/9/22 15:17
 */
public class ArrayQueue {
    private final int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public ArrayQueue(int size) {
        this.maxSize = size; // 队列的最大容量。
        this.front = -1; // 对头指针，指向队列元素的前一个位置。
        this.rear = -1; // 队尾指针，指向队列元素所在的位置。
        this.arr = new int[size]; // 用来模拟队列的数组容器。
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 从队尾添加元素。
     * 因为rear就代表元素的位置，所以将新元素n放到数组的rear++的位置。
     *
     * @param n 待添加的新元素。
     */
    public void addFromRear(int n) {
        if (isFull()) {
            throw new RuntimeException("队列已满，不能再添加元素。");
        }

        rear++;
        arr[rear] = n;
    }

    /**
     * 从队头获取元素。
     * 因为front代表队头元素的前一个位置，所以++front表示队头元素。
     *
     * @return 队头元素。
     */
    public int getFromFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无元素");
        }

        return arr[++front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        } else {
            for (int i = 0; i < maxSize; i++) {
                System.out.printf("%d\t", arr[i]);
            }
            System.out.println();
        }
    }

    /**
     * 从队头读取元素，并非取出。
     *
     * @return 队头元素。
     */
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无元素");
        }

        return arr[front + 1];
    }
}
