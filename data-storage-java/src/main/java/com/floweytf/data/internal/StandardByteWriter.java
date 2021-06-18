package com.floweytf.data.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class StandardByteWriter {
    OutputStream os;
    public StandardByteWriter(OutputStream is) {
        this.os = os;
    }

    public void write(byte b) throws IOException {
        os.write(b);
    }

    public void write(short s) throws IOException {
        os.write(new byte[]{(byte)(s & 0x00FF),(byte)((s & 0xFF00)>>8)});
    }

    public void write(int a) throws IOException {
        os.write(new byte[] {
            (byte) ((a >> 24) & 0xFF),
            (byte) ((a >> 16) & 0xFF),
            (byte) ((a >> 8) & 0xFF),
            (byte) (a & 0xFF)
        });
    }

    public void write(long value) throws IOException {
        os.write(new byte[] {
            (byte) (value >> 56),
            (byte) (value >> 48),
            (byte) (value >> 40),
            (byte) (value >> 32),
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        });
    }

    public void write(String s) throws IOException {
        write(s.length());
        byte[] ba = s.getBytes(StandardCharsets.UTF_8);
        for(byte b : ba)
            write(b);
    }

    public void write(float f) throws IOException {
        write(Float.floatToRawIntBits(f));
    }

    public void write(double f) throws IOException {
        write(Double.doubleToRawLongBits(f));
    }

}
