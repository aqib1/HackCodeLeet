import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {

    private final long timeToLive;
    private final Map<K, CacheValue<V>> cache;

    public Cache() {
        this(60000);
    }

    public Cache(long timeToLive) {
        this.timeToLive = timeToLive;
        cache = new ConcurrentHashMap<>();
    }

    public V put(K key, V value) {
        CacheValue<V> newValue = cache.put(key, new CacheValue<>(value, System.currentTimeMillis()));
        return Objects.isNull(newValue) ? null : newValue.value;
    }

    public V get(K key) {
        CacheValue<V> value = cache.get(key);
        if(!Objects.isNull(value)) {
            value.lastAccessed = System.currentTimeMillis();
            return value.value;
        }
        return null;
    }

    public V remove(K key) {
        CacheValue<V> value = cache.remove(key);
        return Objects.isNull(value) ? null : value.value;
    }

    // We will use cleanUp method to remove everything from cache
    // which exceed TTL
    public void clear() {
        long current =  System.currentTimeMillis();
        Set<K> deleteKeys = new HashSet<>();
        cache.forEach((key, value) -> {
            if (current > timeToLive + value.lastAccessed)
                deleteKeys.add(key);
        });

        deleteKeys.forEach(cache::remove);
    }

    private static class CacheValue<V> {
        private final V value;
        private long lastAccessed;
        private CacheValue(V value, long lastAccessed) {
            this.value = value;
            this.lastAccessed = lastAccessed;
        }
    }
}