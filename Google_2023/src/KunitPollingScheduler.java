public class KunitPoolingScheduler implements Runnable {
    private final long poolingInterval;
    private final KunitCache<String, List<Kunit>> cache;

    public KunitPoolingScheduler(KunitCache<String, List<Kunit>> cache, long poolingInterval) {
        this.poolingInterval = poolingInterval;
        this.cache = new KunitCache<String, List<Kunit>>(poolingInterval);
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
