package me.orangeflare.mombot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class responder {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String formattedMsg = event.getMessage().getContent();
        if (formattedMsg.contains("?")) {
            if (event.getAuthor().getLongID() == 176108182056206336L || event.getAuthor().getLongID() == 253733469778083840L || event.getAuthor().getLongID() == 241685759348703232L) {
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
        }
    }
}
