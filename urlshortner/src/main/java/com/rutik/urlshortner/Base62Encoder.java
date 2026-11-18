package com.rutik.urlshortner;

public class Base62Encoder {
    private static final String BASE62 = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long id){
        StringBuilder shortCode = new StringBuilder();
        while(id > 0){
            shortCode.append( BASE62.charAt((int) (id%62))); //converting to base 62
            id /= 62;
        }
        return shortCode.reverse().toString();
    }
}
