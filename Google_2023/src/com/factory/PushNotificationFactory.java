package com.factory;

public class PushNotificationFactory implements NotificationFactory {
    @Override
    public Notification getNotificationType() {
        return new PushNotifications();
    }
}
