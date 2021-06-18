package com.floweytf.data;

import com.floweytf.data.internal.StandardByteReader;
import com.floweytf.data.internal.StandardByteWriter;

import java.io.IOException;

public  abstract class PrimitiveTag <T> extends AbstractTag{
    protected T delegate;
    public void set(T val) {
        delegate = val;
    }

    public T get() {
        return delegate;
    }
    public abstract void readFrom(StandardByteReader reader) throws IOException;
    public abstract void writeTo(StandardByteWriter writer) throws IOException;
}
