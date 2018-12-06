package com.cyblogs.io.learn.biocase;

/**
 * Created with io-learn
 * Description：
 * User：chenyuan
 * Date：2018/12/6
 * Time：10:08 AM
 */
public class RequestHandler {
    public String handle(String request) {
        String response = "From BIOServer response ： " + request + "\n";
        return response;
    }
}
