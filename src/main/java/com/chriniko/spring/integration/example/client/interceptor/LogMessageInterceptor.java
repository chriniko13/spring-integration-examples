package com.chriniko.spring.integration.example.client.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class LogMessageInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel messageChannel) {

        if (message == null) {
            return message;
        }

        String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#preSend, message = "
                + message
                + ", messageChannel = "
                + messageChannel);

        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel messageChannel, boolean sent) {
        String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#postSend, message = "
                + message
                + ", messageChannel = "
                + messageChannel
                + ", sent = "
                + sent);
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel messageChannel, boolean sent, Exception error) {
        String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#postSend, message = "
                + message
                + ", messageChannel = "
                + messageChannel
                + ", sent = "
                + sent
                + ", error = "
                + error);
    }

    @Override
    public boolean preReceive(MessageChannel messageChannel) {
        /*String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#preReceive, "
                + " messageChannel = "
                + messageChannel);*/

        return true;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel messageChannel) {
        if (message == null) {
            return message;
        }

        String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#postReceive, message = "
                + message
                + ", messageChannel = "
                + messageChannel);

        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel messageChannel, Exception error) {

        if (message == null) {
            return;
        }

        String threadName = Thread.currentThread().getName();

        System.out.println("[threadName = "
                + threadName
                + "] LogMessageInterceptor#afterReceiveCompletion, message = "
                + message
                + ", messageChannel = "
                + messageChannel
                + ", error = "
                + error);
    }
}
