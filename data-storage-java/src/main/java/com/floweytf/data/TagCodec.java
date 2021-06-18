package com.floweytf.data;

import com.floweytf.data.internal.StandardByteReader;
import com.floweytf.data.internal.StandardByteWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;

import static com.floweytf.data.AbstractTag.*;

public class TagCodec {
    private static class StackFrame {
        CollectionTag tag;
        int index;
        int size;
        String name;

        public StackFrame(CollectionTag tag, int index, int size, String name) {
            this.tag = tag;
            this.index = index;
            this.size = size;
            this.name = name;
        }
    }

    private static AbstractTag getFromInt(byte type) {
        switch (type) {
            case TAG_OBJECT:
                return new ObjectTag();
            case TAG_ARRAY:
                return new ArrayTag();
            case TAG_BYTE:
                return new ByteTag();
            case TAG_SHORT:
                return new ShortTag();
            case TAG_INT:
                return new IntTag();
            case TAG_LONG:
                return new LongTag();
            case TAG_STRING:
                return new StringTag();
            case TAG_FLOAT:
                return new FloatTag();
            case TAG_DOUBLE:
                return new DoubleTag();
        }

        throw new IllegalStateException("Invalid type, you data is corrupted!");
    }


    public static ObjectTag deserialize(InputStream i) throws IOException {
        // the reader that we will use to read things in a standard fashion
        StandardByteReader input = new StandardByteReader(i);
        // stack frames to emulate recursive algo
        Stack<StackFrame> stack = new Stack<>();

        StackFrame frame = new StackFrame(
            new ObjectTag(),
            0,
            input.readInt(),
            ""
        );

        boolean state = false; // false for object, true for array

        while (true) {
            while (frame.index == frame.size && stack.size() != 0) {
                // we have reached the end of the iteration
                StackFrame newFrame = stack.pop();
                newFrame.tag.put(newFrame.name, frame.tag);
                frame = newFrame;
                state = !(frame.tag instanceof ObjectTag);
            }
            if (stack.size() == 0 && frame.index == frame.size)
                break;
            // the state for an object
            frame.index++;

            if (state) {
                // we have/are reading another object
                // read the type
                byte type = input.readByte();
                // obtain the tag
                AbstractTag t = getFromInt(type);
                if (t instanceof ObjectTag) {
                    // push to stack
                    stack.push(frame);
                    frame = new StackFrame((CollectionTag) t, 0, input.readInt(), "");
                    state = false;
                }
                else if (t instanceof ArrayTag) {
                    stack.push(frame);
                    frame = new StackFrame((CollectionTag) t, 0, input.readInt(), "");
                    state = true;
                }
                else {
                    ((PrimitiveTag<?>) t).readFrom(input);
                    frame.tag.put(frame.name, t);
                }
            }
            else {
                // we have/are reading another object
                // read the name and type
                frame.name = input.readString();
                byte type = input.readByte();
                // obtain the tag
                AbstractTag t = getFromInt(type);
                if (t instanceof ObjectTag) {
                    stack.push(frame);
                    frame = new StackFrame((CollectionTag) t, 0, input.readInt(), "");
                    state = false;
                }
                else if (t instanceof ArrayTag) {
                    stack.push(frame);
                    frame = new StackFrame((CollectionTag) t, 0, input.readInt(), "");
                    state = true;
                }
                else {
                    ((PrimitiveTag<?>) t).readFrom(input);
                    frame.tag.put(frame.name, t);
                }
            }
        }

        return (ObjectTag) frame.tag;
    }

    public static void serialize(OutputStream o) throws IOException {
        StandardByteWriter writer = new StandardByteWriter(o);


    }
}
