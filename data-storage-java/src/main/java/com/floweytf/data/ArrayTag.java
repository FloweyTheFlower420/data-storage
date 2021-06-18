package com.floweytf.data;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayTag extends CollectionTag implements Iterable<AbstractTag> {
    private final List<AbstractTag> delegate = new ArrayList<>();
    @Override
    protected void put(String tmp, AbstractTag tag) {
        delegate.add(tag);
    }

    public int size() {
        return delegate.size();
    }

    public void add(AbstractTag tag) {
        delegate.add(tag);
    }

    public void set(int index, AbstractTag tag) {
        delegate.set(index, tag);
    }

    public AbstractTag get(int index) {
        return delegate.get(index);
    }

    public void remove(int index) {
        delegate.remove(index);
    }

    public void remove(AbstractTag tag) {
        delegate.remove(tag);
    }

    public ObjectTag getObject(int index) {
        return (ObjectTag) get(index);
    }

    public ArrayTag getArray(int index) {
        return (ArrayTag) get(index);
    }

    public IntTag getInt(int index) {
        return (IntTag) get(index);
    }

    public StringTag getString(int index) {
        return (StringTag) get(index);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<AbstractTag> iterator() {
        return delegate.iterator();
    }

    @Override
    public byte getType() {
        return TAG_ARRAY;
    }
}
