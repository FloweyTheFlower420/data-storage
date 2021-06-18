package com.floweytf.data;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.floweytf.data.AbstractTag.*;

public class Main {
    public static void main(String... arg) throws IOException {
        ObjectTag uwu = TagCodec.deserialize(new ByteArrayInputStream(new byte[]{
            0x03, 0x00, 0x00, 0x00, // size
            0x03, 0x00, 0x00, 0x00, 'j', 'o', 'e',
            TAG_INT,
            0x00, 0x01, 0x02, 0x04,
            0x06, 0x00, 0x00, 0x00, 'p', 'e', 'r', 's', 'o', 'n',
            TAG_OBJECT,
                0x02, 0x00, 0x00, 0x00,
                0x04, 0x00, 0x00, 0x00, 'n', 'a', 'm', 'e',
                TAG_STRING,
                0x03, 0x00, 0x00, 0x00, 'j', 'o', 'e',
                0x03, 0x00, 0x00, 0x00, 'a', 'g', 'e',
                TAG_INT,
                0x03, 0x00, 0x00, 0x00,
            0x06, 0x00, 0x00, 0x00, 'p', 'e', 'o', 'p', 'l', 'e',
            TAG_ARRAY,
                0x02, 0x00, 0x00, 0x00,
                TAG_OBJECT,
                    0x02, 0x00, 0x00, 0x00,
                    0x04, 0x00, 0x00, 0x00, 'n', 'a', 'm', 'e',
                    TAG_STRING,
                    0x03, 0x00, 0x00, 0x00, 'j', 'o', 'e',
                    0x03, 0x00, 0x00, 0x00, 'a', 'g', 'e',
                    TAG_INT,
                    0x03, 0x00, 0x00, 0x00,
                TAG_OBJECT,
                    0x02, 0x00, 0x00, 0x00,
                    0x04, 0x00, 0x00, 0x00, 'n', 'a', 'm', 'e',
                    TAG_STRING,
                    0x03, 0x00, 0x00, 0x00, 'j', 'o', 'e',
                    0x03, 0x00, 0x00, 0x00, 'a', 'g', 'e',
                    TAG_INT,
                    0x03, 0x00, 0x00, 0x00,
        }));
    }
}
