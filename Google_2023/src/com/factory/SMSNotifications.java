package com.factory;

public class SMSNotifications implements Notification{
    @Override
    public void sendNotifications() {
        System.out.println("Sending SMS");
    }
}
