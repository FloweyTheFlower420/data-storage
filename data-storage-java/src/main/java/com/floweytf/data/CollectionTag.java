package com.floweytf.data;

import java.util.Collection;

public abstract class CollectionTag extends AbstractTag {
    protected abstract void put(String tmp, AbstractTag tag);
    public abstract int size();
}
