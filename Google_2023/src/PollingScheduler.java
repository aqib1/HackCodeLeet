import java.util.List;

public record PollingScheduler(Cache<String, List<String>> cache,
                               long pollingInterval) implements Runnable {
    public PollingScheduler(Cache<String, List<String>> cache, long pollingInterval) {
        this.pollingInterval = pollingInterval;
        this.cache = new Cache<>(pollingInterval);
    }

    // This method will do initial fetching for our cache
    public void init() {

    }

    // this will run async to refresh our cache
    // by pooling interval.
    @Override
    public void run() {

    }

    // this method will effectively close scheduler
    // and clear cache
    public void close() {

    }
}
