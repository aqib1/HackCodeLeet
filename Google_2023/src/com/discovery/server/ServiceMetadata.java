package com.discovery.server;

public record ServiceMetadata(
        String clusterId,
        String serviceId,
        String port,
        String ipAddress,
        String registrationName,
        String healthCheckUrl) {
    @Override
    public String clusterId() {
        return clusterId;
    }

    @Override
    public String serviceId() {
        return serviceId;
    }

    @Override
    public String port() {
        return port;
    }

    @Override
    public String ipAddress() {
        return ipAddress;
    }

    @Override
    public String registrationName() {
        return registrationName;
    }

    @Override
    public String healthCheckUrl() {
        return healthCheckUrl;
    }
}
