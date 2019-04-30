package me.orangeflare.mombot;

import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.listener.server.ServerJoinListener;

public class serverJoinReporter implements ServerJoinListener {
    @Override
    public void onServerJoin(ServerJoinEvent event) {
        System.out.println("MomBot joined " + event.getServer().getName() + "!");
    }
}
