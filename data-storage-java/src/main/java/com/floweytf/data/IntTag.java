package com.floweytf.data;

import com.floweytf.data.internal.StandardByteReader;
import com.floweytf.data.internal.StandardByteWriter;

import java.io.IOException;

public class IntTag extends PrimitiveTag<Integer> {
    @Override
    public void readFrom(StandardByteReader reader) throws IOException {
        delegate = reader.readInt();
    }

    @Override
    public void writeTo(StandardByteWriter writer) throws IOException {
        writer.write(delegate);
    }

    @Override
    public byte getType() {
        return TAG_INT;
    }
}
