package com.discovery.server;

import java.util.List;

public class DDBMapper {

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
