package com.floweytf.data;

import com.floweytf.data.internal.StandardByteReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;

public abstract class AbstractTag {
    public static final int TAG_NULL = 0;

    public static final int TAG_OBJECT = 1;
    public static final int TAG_ARRAY = 2;

    public static final int TAG_BYTE = 3; // 8 bit
    public static final int TAG_SHORT = 4; // 16 bit
    public static final int TAG_INT = 5; // 32 bit
    public static final int TAG_LONG = 6; // 64 bit

    public static final int TAG_FLOAT = 7;
    public static final int TAG_DOUBLE = 8;

    public static final int TAG_STRING = 9;

    public abstract byte getType();
}
