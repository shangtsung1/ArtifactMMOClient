package com.artifactmmo.frump.smtest;

import com.artifactmmo.Client;
import com.artifactmmo.frump.Util;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client(Util.loadToken());
        CharWrapper cw = new CharWrapper("Frumpy5",client);
        StateMachine sm = new StateMachine("./script/",cw);
        while(true){
            sm.process();
            Thread.sleep(500);
        }
    }
}
