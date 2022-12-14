package com.wanji.etcxobu.util;


import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    // 队列存储消息的最大数量
    private final static int MAX_SIZE = 5;
    // 保存消息数据的容器
    private static ArrayBlockingQueue messageQueue = new ArrayBlockingQueue(MAX_SIZE);

    // 生产消息
    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
//            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            consume();
            messageQueue.offer(msg);
        }
    }// 消费消息

    public static String consume() {
        String msg = (String) messageQueue.poll();
        if(msg !=null) {// 消费条件满足情况，从消息容器中取出一条消息
//            System.out.println("已经消费消息："+ msg +"，当前暂存的消息数量是："+ messageQueue.size());
        }else{            System.out.println("消息处理中心内没有消息可供消费！");        }
        return msg;
    }

    public static boolean isEmpty(){
        return messageQueue.isEmpty();
    }
}

