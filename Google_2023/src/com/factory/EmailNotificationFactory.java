package com.factory;

public class EmailNotificationFactory implements NotificationFactory{
    @Override
    public Notification getNotificationType() {
        return new EmailNotifications();
    }
}
