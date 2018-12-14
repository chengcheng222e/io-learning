package com.cyblogs.io.learn.niocase;

/**
 * Created with io-learn
 * Description：
 * User：chenyuan
 * Date：2018/12/14
 * Time：11:47 AM
 */
public class PrintSelectorProviderCase {

    public static void main(String[] args) {
        String cn = System.getProperty("java.nio.channels.spi.SelectorProvider");
        System.out.println(cn);
    }
}
