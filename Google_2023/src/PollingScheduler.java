import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.Collectors;

public record PollingScheduler(Cache<String, ConcurrentLinkedDeque<String>> cache,
                               long pollingInterval) implements Runnable {
    public PollingScheduler(Cache<String, ConcurrentLinkedDeque<String>> cache) {
        this(cache, 60000);
    }

    public PollingScheduler(Cache<String, ConcurrentLinkedDeque<String>> cache, long pollingInterval) {
        this.pollingInterval = pollingInterval;
        this.cache = cache;
    }

    // This method will do initial fetching for our cache
    public void init() {
        ConcurrentLinkedDeque<String> testingCache = new ConcurrentLinkedDeque<>();
        testingCache.addLast("DataReads1");
        testingCache.addLast("DataReads2");
        testingCache.addLast("DataReads3");
        testingCache.addLast("DataReads4");

        this.cache.put("Cluster1", testingCache);
    }

    // this will run async to refresh our cache
    // by pooling interval.
    @Override
    public void run() {
        Map<String, ConcurrentLinkedDeque<String>> cacheFromDb = listAllKunits();
        cacheFromDb.forEach((key, value) -> {
            if (!this.cache.containsKey(key)) {
                this.cache.put(key, value);
            } else {

                // removing all retried kunits keeping the order of existing kunits
                this.cache.get(key)
                        .removeAll(this.cache.get(key)
                                .stream()
                                .filter(oldValues -> !cacheFromDb.get(key).contains(oldValues))
                                .toList());

                // adding all new Kunits at the end of deque
                this.cache.get(key)
                        .addAll(cacheFromDb.get(key)
                                .stream()
                                .filter(newValues -> !this.cache.get(key).contains(newValues))
                                .toList());
            }
        });
    }

    // this method will effectively close scheduler
    // and clear cache
    public void clear() {
        this.cache.clear();
    }

    public Map<String, ConcurrentLinkedDeque<String>> listAllKunits() {
        Map<String, ConcurrentLinkedDeque<String>> result = new ConcurrentHashMap<>();
        ConcurrentLinkedDeque<String> testingCache = new ConcurrentLinkedDeque<>();
        testingCache.addLast("DataReads1");
        testingCache.addLast("DataReads2");
        testingCache.addLast("DataReads4");
        testingCache.addLast("DataReads5");
        testingCache.addLast("DataReads6");
        result.put("Cluster1", testingCache);
        return result;
    }
}
