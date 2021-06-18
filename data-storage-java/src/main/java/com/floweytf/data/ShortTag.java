package com.floweytf.data;

import com.floweytf.data.internal.StandardByteReader;
import com.floweytf.data.internal.StandardByteWriter;

import java.io.IOException;

public class ShortTag extends PrimitiveTag<Short> {
    @Override
    public void readFrom(StandardByteReader reader) throws IOException {
        delegate = reader.readShort();
    }

    @Override
    public void writeTo(StandardByteWriter writer) throws IOException {
        writer.write(delegate);
    }
}
