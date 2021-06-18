package com.floweytf.data.internal;

import com.floweytf.data.CollectionTag;

public class DeserializeStackFrame {
    public CollectionTag tag;
    public int index;
    public int size;
    public String name;

    public DeserializeStackFrame(CollectionTag tag, int index, int size, String name) {
        this.tag = tag;
        this.index = index;
        this.size = size;
        this.name = name;
    }
}
