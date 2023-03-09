package com.discovery.server;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DiscoveryServer {

    private DiscoveryCache discoveryCache;
    private final DiscoverySnapshots discoverySnapshots;
    private final DDBMapper ddbMapper;

    public DiscoveryServer() {
     this.discoveryCache = new DiscoveryCache();
     this.discoverySnapshots = new DiscoverySnapshots(Paths.get(""));
     // will inject aws credentials and region here.
     this.ddbMapper = new DDBMapper();
    }

    public boolean registerService(String clusterId, ServiceMetadata metadata) throws IOException {
        this.discoveryCache.add(clusterId, metadata);
        // This can be replaced with proper responses.
        byte[] data = {};
        // data = metadata; convert metadata to byte array,
        // we can use different techniques for it for example can use object mapper.
        this.discoverySnapshots.writeSnapshots(data);
        return true;
    }

    public ServiceMetadata fetchRegistry(String clusterId) throws IOException {
        try {
            if (this.discoveryCache.isEmpty()) {
                this.discoveryCache =
                        new DiscoveryCache(this.discoverySnapshots.readSnapshots());
            }
        } catch (RuntimeException ex) {
            // read from DDB
            List<ServiceMetadata> metadataList = this.ddbMapper.readSnapshots();
            this.discoveryCache = new DiscoveryCache(metadataList);

            byte[] data = {};
            // data = metadataList; convert metadata to byte array,
            // we can use different techniques for it for example can use object mapper.
            this.discoverySnapshots.writeSnapshots(data);
        }
        // here we will implement proper load balancer
        return this.discoveryCache.get(clusterId).get(0);
    }
}
