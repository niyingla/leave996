package com.imooc.zhangxiaoxi.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueueTest {

    /**
     * puts操作
     * add(E e) : 添加成功返回true，失败抛IllegalStateException异常
     * offer(E e) : 成功返回 true，如果此队列已满，则返回 false（如果添加了时间参数，且队列已满也会阻塞）
     * put(E e) :将元素插入此队列的尾部，如果该队列已满，则一直阻塞
     *
     * takes操作
     * remove(Object o) :移除指定元素,成功返回true，失败返回false
     * poll() : 获取并移除此队列的头元素，若队列为空，则返回 null（如果添加了时间参数，且队列中没有数据也会阻塞）
     * take()：获取并移除此队列头元素，若没有元素则一直阻塞。
     * peek() :获取但不移除此队列的头；若队列为空，则返回 null。
     *
     * other操作
     * contains(Object o)：队列中是否包含指定元素
     * drainTo(Collection<? super E> c)：队列转化为集合
     * @throws InterruptedException
     */
    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        /**
         * 基于数组的有界阻塞队列，遵循FIFO原则的阻塞队列，队列初始化时必须指定队列的长度
         */
        ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(10);

        // 循环向队列添加元素
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加值：" + i);
        }
    }

    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        /**
         * 基于链表的、有界的、遵循FIFO原则的阻塞队列，队列默认的最大长度为Integer.MAX_VALUE
         */
        LinkedBlockingQueue queue = new LinkedBlockingQueue<Integer>(10);

        // 循环向队列添加元素
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加值：" + i);
        }
    }

    @Test
    public void test() throws InterruptedException {
        /**
         * 同步移交阻塞队列 要有接收者才能放入
         */
        SynchronousQueue queue = new SynchronousQueue<Integer>();

        // 插入值
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("插入成功1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 删除值
        new Thread(() -> {
            try {
                Object take = queue.take();
                System.out.println("删除成功" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 插入值
        new Thread(() -> {
            try {
                queue.put(2);
                System.out.println("插入成功2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 删除值
        new Thread(() -> {
            try {
                Object take = queue.take();
                System.out.println("删除成功" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000L * 60);
    }

}
