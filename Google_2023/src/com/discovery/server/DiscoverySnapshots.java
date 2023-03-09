package com.discovery.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DiscoverySnapshots {
    private final Path snapshotsDir;

    public DiscoverySnapshots(Path snapshotsDir) {
        this.snapshotsDir = snapshotsDir;
    }

    public void writeSnapshots(byte[] data) throws IOException {
        Files.write(snapshotsDir, data,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public List<ServiceMetadata> readSnapshots() {
        try {
            // logic for reading snapshots from file and
            // parsing data to list of service metadata,

            return List.of();
        } catch(RuntimeException ex) {
            // this catch block will be replaced by proper
            // IO exceptions or Integrity check failure,
            throw ex;
        }
    }

}
