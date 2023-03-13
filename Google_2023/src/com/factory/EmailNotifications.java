package com.factory;

public class EmailNotifications implements Notification {
    @Override
    public void sendNotifications() {
        System.out.println("Send email");
    }
}
