package me.orangeflare.mombot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class serverCount {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] argArray = event.getMessage().getContent().split(" ");
        if (argArray.length == 0) { return; }
        if (!argArray[0].toLowerCase().startsWith("m.")) { return; }
        String command = argArray[0].substring(2).toLowerCase();
        List<String> argsList = new ArrayList<>(Arrays.asList(argArray));
        argsList.remove(0);

        switch(command) {
            case "count":
                serverCount(event);
                System.out.println("[INFO] 'ping' Command Received!");
                System.out.println("       Command sent by " + event.getAuthor().getDisplayName(event.getGuild()));
        }
    }
    private void serverCount(MessageReceivedEvent event){
        event.getChannel().sendMessage("I am currently in " + event.getClient().getGuilds().size() + " servers.");
    }
}
