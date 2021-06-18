package com.floweytf.data.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class StandardByteWriter {
    OutputStream os;
    public StandardByteWriter(OutputStream os) {
        this.os = os;
    }

    public void write(byte b) throws IOException {
        os.write(b);
    }

    public void write(short s) throws IOException {
        os.write(new byte[] {
            (byte) s,
            (byte) ((s >> 8) & 0xFF)
        });
    }

    public void write(int i) throws IOException {
        os.write(new byte[] {
            (byte) i,
            (byte) ((i >> 8) & 0xFF),
            (byte) ((i >> 16) & 0xFF),
            (byte) ((i >> 24) & 0xFF)
        });
    }

    public void write(long l) throws IOException {
        os.write(new byte[]{
            (byte) l,
            (byte) (l >> 8),
            (byte) (l >> 16),
            (byte) (l >> 24),
            (byte) (l >> 32),
            (byte) (l >> 40),
            (byte) (l >> 48),
            (byte) (l >> 56),
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
