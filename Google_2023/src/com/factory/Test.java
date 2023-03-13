package com.factory;

public class Test {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new SMSNotificationFactory();
        SendNotifications sendNotifications = new SendNotifications(notificationFactory);
        sendNotifications.setNotifications();
    }
}
