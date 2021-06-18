package com.floweytf.data.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("all")
public class StandardByteReader {
    InputStream is;
    public StandardByteReader(InputStream is) {
        this.is = is;
    }


    /**
     * Reads 8 bytes from the stream, then uses it to create one long. The bytes are converted as little endian.
     * @return The long read
     * @throws IOException Underlying IO error
     */
    public long readLong() throws IOException {
        byte[] bytes = new byte[8];
        is.read(bytes);
        return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getLong();
    }

    /**
     * Reads 4 bytes from the stream, then uses it to create one integer. The bytes are converted as little endian.
     * @return The integer read
     * @throws IOException Underlying IO error
     */
    public int readInt() throws IOException {
        byte[] bytes = new byte[4];
        is.read(bytes);
        return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
    }

    /**
     * Reads 2 bytes from the stream, then uses it to create one short. The bytes are converted as little endian.
     * @return The short read
     * @throws IOException Underlying IO error
     */
    public short readShort() throws IOException {
        byte[] bytes = new byte[2];
        is.read(bytes);
        return ByteBuffer.wrap(bytes).order(java.nio.ByteOrder.LITTLE_ENDIAN).getShort();
    }

    /**
     * reads one byte
     * @return The byte read
     * @throws IOException Underlying IO error
     */
    public byte readByte() throws IOException {
        byte[] bytes = new byte[1];
        is.read(bytes);
        return bytes[0];
    }

    /**
     * Reads one integer from the stream (n), then reads n bytes from the stream. The bytes are then converted to string using UT8
     * @return The string read
     * @throws IOException Underlying IO error
     */
    public String readString() throws IOException {
        int size = readInt();
        byte[] bytes = new byte[size];
        is.read(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }
}
