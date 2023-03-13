package com.factory;

public class PushNotifications implements Notification {
    @Override
    public void sendNotifications() {
        System.out.println("Push notifications");
    }
}
