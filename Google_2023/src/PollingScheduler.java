import java.util.ArrayDeque;
import java.util.Deque;

public record PollingScheduler(Cache<String, Deque<String>> cache,
                               long pollingInterval) implements Runnable {
    public PollingScheduler(Cache<String, Deque<String>> cache) {
        this(cache, 60000);
    }

    public PollingScheduler(Cache<String, Deque<String>> cache, long pollingInterval) {
        this.pollingInterval = pollingInterval;
        this.cache = cache;
    }

    // This method will do initial fetching for our cache
    public void init() {
        Deque<String> testingCache = new ArrayDeque<>();
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

    }

    // this method will effectively close scheduler
    // and clear cache
    public void clear() {
        this.cache.clear();
    }
}
