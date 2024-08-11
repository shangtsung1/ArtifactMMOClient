package com.artifactmmo.frump;

import com.artifactmmo.frump.smtest.JsonCommentRemover;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Util {
    public static String loadToken(){
        return readFromFile("token.txt");
    }

    public static String readFromFile(Path fileP) {
        try {
            return JsonCommentRemover.removeComments(new String(Files.readAllBytes(fileP)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readFromFile(String fileP) {
        return readFromFile(Paths.get(fileP));
    }
}
