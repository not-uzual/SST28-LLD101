package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Global metrics registry - PROPER THREAD-SAFE SINGLETON.
 *
 * FIXED:
 * 1) Private constructor with reflection protection
 * 2) Thread-safe lazy initialization using Bill Pugh Singleton Holder pattern
 * 3) Serialization preserves singleton via readResolve()
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Long> counters = new HashMap<>();

    private MetricsRegistry() {
        // Block reflection-based multiple construction
        if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Singleton already constructed! Cannot create another instance.");
        }
    }

    private static class SingletonHolder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }
}
