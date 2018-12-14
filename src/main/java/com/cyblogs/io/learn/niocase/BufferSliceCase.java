package com.cyblogs.io.learn.niocase;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created with io-learn
 * Description：
 * User：chenyuan
 * Date：2018/12/13
 * Time：6:17 PM
 */
public class BufferSliceCase {

    public static void main(String[] args) throws IOException {
        // 写入数据
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }
        // 数据分片
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();
        // 对分片数据特殊处理
        for (int i = 0; i < slice.capacity(); ++i) {
            byte b = slice.get(i);
            b *= 11;
            slice.put(i, b);
        }
        // 重新设置位置，打印全部buffer
        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.remaining() > 0) {
            System.out.println(buffer.get());
        }
    }
}
