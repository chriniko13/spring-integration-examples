package com.chriniko.spring.integration.example.client.error;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.support.ErrorMessage;


public class DefaultErrorHandler {

    public void handle(Message<?> message) {

        if (message instanceof ErrorMessage
                && ((ErrorMessage)message).getPayload() instanceof MessageHandlingException) {

            ErrorMessage errorMessage = (ErrorMessage) message;

            MessageHandlingException messageHandlingException = (MessageHandlingException) errorMessage.getPayload();

            System.out.println("[thread = " + Thread.currentThread().getName() + "] --- detailMessage = " + messageHandlingException.getMessage() + "\n");

        } else {
            throw new IllegalStateException("something terrible wrong is going to the system!");
        }

    }
}
