import java.util.Deque;

public class PublisherClient {

    private final Cache<String, Deque<String>> cache;
    private final PollingScheduler scheduler;

    private PublisherClient() {
        this.cache = new Cache<>();
        scheduler = new PollingScheduler(cache);
    }

    public PublisherClient init() {
        scheduler.init();
        return this;
    }

    // Time complexity : O(1)
    public String getKunitStream(String clusterId) {
        String stream = cache.get(clusterId).removeFirst();
        cache.get(clusterId).addLast(stream);
        return stream;
    }

    public void clear() {
        scheduler.clear();
    }

    private static class LazyHolder {
        private static final PublisherClient INSTANCE = new PublisherClient();
    }

    public static PublisherClient getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
       PublisherClient client = PublisherClient.getInstance()
                .init();
        for(int x = 0; x < 10; x++) {
            System.out.println(client.getKunitStream("Cluster1"));
        }
    }
}
