package me.orangeflare.mombot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class responder {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String formattedMsg = event.getMessage().getContent().toLowerCase();
        if (formattedMsg.contains("?")) {
            if (event.getAuthor().getLongID() == 176108182056206336L) {
                System.out.println("[INFO] Not sending 'Ask your Father'");
                System.out.println("    Reason: " + event.getAuthor().getDisplayName(event.getGuild()) + " Sent Message");
            } else if (event.getMessage().getAuthor().isBot()){
                //do nothing
            } else {
                RequestBuffer.request(() -> {
                    try {
                        System.out.println("[INFO] Sending 'Ask your Father' at " + event.getAuthor().getDisplayName(event.getGuild()));
                        event.getChannel().sendMessage("Ask your father");
                    } catch (DiscordException error) {
                        System.err.println("[ERROR] Could Not Send 'Ask your Father'");
                        error.printStackTrace();
                    }
                });
            }
        } else if (formattedMsg.contains("mom")) {
            if (event.getAuthor().getLongID() == 176108182056206336L) {
                System.out.println("[INFO] Not sending 'Not now Sweetie'");
                System.out.println("    Reason: " + event.getAuthor().getDisplayName(event.getGuild()) + " Sent Message");
            } else if (event.getMessage().getAuthor().isBot()){
                //do nothing
            } else {
                RequestBuffer.request(() -> {
                    try {
                        System.out.println("[INFO] Sending 'Not now Sweetie' at " + event.getAuthor().getDisplayName(event.getGuild()));
                        event.getChannel().sendMessage("Not now sweetie");
                    } catch (DiscordException error) {
                        System.err.println("[ERROR] Could Not Send 'Not now Sweetie'");
                        error.printStackTrace();
                    }
                });
            }
        }
    }
}
