package com.interview.util;

public enum Source {

    GRIND_75("https://leetcode.com/problems/"),
    LEETCODE("https://leetcode.com/problems/"),
    NEETCODE_75("https://neetcode.io/practice"),
    NEETCODE_150("https://neetcode.io/practice"),
    NEETCODE_ALL("https://neetcode.io/practice");

    private final String urlPrefix;
    private Source( String urlPrefix ){
        this.urlPrefix = urlPrefix;
    }

    public final String getUrlPrefix(){
        return urlPrefix;
    }


}
