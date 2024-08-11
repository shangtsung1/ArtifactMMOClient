package com.artifactmmo.frump.smtest;

import com.artifactmmo.Client;
import org.openapitools.client.model.CharacterSchema;

import java.util.HashMap;
import java.util.Map;

public class CharWrapper {
    private final String name;
    private final Client client;

    public CharWrapper(String name, Client client) {
        this.name = name;
        this.client = client;
    }
    //Rate Limit char data.
    private static final long DEFAULT_RATE_LIMIT = 500;
    private Map<String, Long> lastActionTimes = new HashMap<>();
    private CharacterSchema cSchema;

    private boolean isRateLimited(String actionKey, long rateLimit) {
        long currentTime = System.currentTimeMillis();
        long lastTime = lastActionTimes.getOrDefault(actionKey, 0L);
        if (currentTime - lastTime > rateLimit) {
            lastActionTimes.put(actionKey, currentTime);
            return false;
        }
        return true;
    }
    public CharacterSchema getCharacter() {
        if (!isRateLimited("getCharacter", DEFAULT_RATE_LIMIT) || cSchema == null) {
            cSchema = client.getCharacter(name).getData();
        }
        return cSchema;
    }

    public Client getClient(){
        return client;
    }
}
