package com.cyblogs.io.learn.niocase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with io-learn
 * Description： 读取数据从Buffer中获取
 * User：chenyuan
 * Date：2018/12/13
 * Time：4:15 PM
 */
public class ReadDataFromBuffer {

    public static void main(String[] args) throws IOException {

        String outPath = "/Users/chenyuan/Workspaces/Github/io-learn/src/main/resources/write.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(outPath, true);
        FileInputStream fileInputStream = new FileInputStream(ReadDataFromBuffer.class.getResource("/read.txt").getFile());
        FileChannel fileIn = fileInputStream.getChannel();
        FileChannel fileOut = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(128);
        try {
            while (fileIn.read(buffer) != -1) {
                buffer.flip();
                fileOut.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }

    }

}
