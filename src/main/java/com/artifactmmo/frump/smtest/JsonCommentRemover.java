package com.artifactmmo.frump.smtest;

public class JsonCommentRemover {

    public static String removeComments(String json) {
        // Remove single-line comments (//)
        json = json.replaceAll("//.*(?=\\n)", "");
        // Remove multi-line comments (/* */)
        json = json.replaceAll("/\\*.*?\\*/", "");
        return json;
    }
}