package com.factory;

public class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification getNotificationType() {
        return new SMSNotifications();
    }
}
