package com.discovery.server;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiscoveryCache {
    private final ConcurrentMap<String, List<ServiceMetadata>>
            cache = new ConcurrentHashMap<>();
    public DiscoveryCache() {

    }

    public DiscoveryCache(List<ServiceMetadata> serviceMetadata) {
        this.cache.putAll(
          serviceMetadata.stream()
                  .collect(Collectors.groupingBy(ServiceMetadata::clusterId)));
    }

    public void add(String clusterId, ServiceMetadata metadata) {
        if(cache.containsKey(clusterId)) {
          cache.get(clusterId).add(metadata);
        } else {
            cache.put(clusterId, Stream.of(metadata).toList());
        }
    }

    public List<ServiceMetadata> get(String clusterId) {
        return this.cache.get(clusterId);
    }

    public void remove(String clusterId, ServiceMetadata metadata) {
        this.cache.remove(clusterId).remove(metadata);
    }

    public void removeAll(String clusterId) {
        this.removeAll(clusterId);
    }

    public boolean isEmpty() {
        return this.cache.isEmpty();
    }
}
