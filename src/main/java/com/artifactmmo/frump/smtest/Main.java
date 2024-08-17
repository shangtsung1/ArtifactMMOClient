package com.artifactmmo.frump.smtest;

import com.artifactmmo.Client;
import com.artifactmmo.frump.Util;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client(Util.loadToken());
        for (String SS : new String[]{"Frumpy1", "Frumpy2", "Frumpy3", "Frumpy4", "Frumpy5"}) {
            new Thread(new Runnable() {
                public void run() {
                    CharWrapper cw = new CharWrapper(SS, client);
                    StateMachine sm = new StateMachine("./script/", cw,SS.equals("Frumpy3"));
                    System.out.println("Loaded StateMachine " + sm.size() + " States.");
                    while (true) {
                        try {
                            sm.process();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                //throw new RuntimeException(e);
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                            sm = new StateMachine("./script/", cw,SS.equals("Frumpy2"));
                        }
                    }
                }
            }).start();
        }
    }
}
