package com.floweytf.data;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectTag extends CollectionTag implements Iterable<Map.Entry<String, AbstractTag>>{
    private final Map<String, AbstractTag> delegate = new HashMap<>();
    @Override
    public void put(String tmp, AbstractTag tag) {
        delegate.put(tmp, tag);
    }

    public int size() {
        return delegate.size();
    }
    
    public void set(String key, AbstractTag tag) {
        delegate.put(key, tag);
    }

    public AbstractTag get(String key) {
        return delegate.get(key);
    }

    public void remove(String key) {
        delegate.remove(key);
    }

    public ObjectTag getObject(String key) {
        return (ObjectTag) get(key);
    }

    public ArrayTag getArray(String key) {
        return (ArrayTag) get(key);
    }

    public IntTag getInt(String key) {
        return (IntTag) get(key);
    }

    public StringTag getString(String key) {
        return (StringTag) get(key);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<Map.Entry<String, AbstractTag>> iterator() {
        return delegate.entrySet().iterator();
    }
}
