package com.wangjx.common.util.concurrent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/2/27
 * Time: 10:46
 */
public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {

    private final transient ReentrantLock lock = new ReentrantLock();

    private transient volatile Map<K, V> internalMap;

    public CopyOnWriteMap() {
        internalMap = new HashMap<>();
    }

    public CopyOnWriteMap(Map<? extends K, ? extends V> m) {
        internalMap = new HashMap<>(m);
    }

    @Override
    public int size() {
        return internalMap.size();
    }

    @Override
    public boolean isEmpty() {
        return internalMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return internalMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return internalMap.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return internalMap.get(key);
    }

    @Override
    public V put(K key, V value) {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            HashMap<K, V> newHashMap = new HashMap<>(internalMap);
            V val = newHashMap.put(key, value);
            internalMap = newHashMap;

            return val;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            HashMap<K, V> newHashMap = new HashMap<>(internalMap);
            V val = newHashMap.remove(key);
            internalMap = newHashMap;

            return val;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        final ReentrantLock lock = this.lock;
        lock.lock();

        try {
            HashMap<K, V> newHashMap = new HashMap<>(internalMap);
            newHashMap.putAll(m);
            internalMap = newHashMap;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        internalMap.clear();
    }

    @Override
    public Set<K> keySet() {
        return internalMap.keySet();
    }

    @Override
    public Collection<V> values() {
        return internalMap.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return internalMap.entrySet();
    }
}
