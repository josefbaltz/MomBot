package me.orangeflare.mombot;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static me.orangeflare.mombot.Main.deleteCommandIssued;

public class general implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String formattedContent = event.getMessage().getContent().toLowerCase();
        if (formattedContent.equals("m.count") || formattedContent.equals("m.stats")) {
            deleteCommandIssued(event, "count");

            try {
                FileInputStream in = new FileInputStream("./responseCounter.txt");
                Properties counter = new Properties();
                counter.load(in);
                in.close();
                new MessageBuilder()
                        .setEmbed(new EmbedBuilder()
                                .setAuthor("MomBot")
                                .setTitle("Statistics")
                                .addField("Sever Count", Integer.toString(event.getApi().getServers().size()), true)
                                .addField("Responses Sent", counter.getProperty("counter"), true)
                                .setColor(Color.decode("#e91e63"))
                        )
                        .send(event.getChannel());
            } catch (IOException e0) {
                System.out.println("IOException: " + e0);
            }
        } else if (formattedContent.equals("m.help")) {
            deleteCommandIssued(event, "help");
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setAuthor("MomBot")
                            .setTitle("Help")
                            .addField("m.help", "Displays this Text", false)
                            .addField("m.count m.stats", "Displays information and statistics", false)
                            .addField("m.info", "Displays Information about the Current Build", false)
                            .addField("m.invite", "Sends a direct message to the user with an invite link for MomBot", false)
                            .setColor(Color.decode("#e91e63"))
                    )
                    .send(event.getChannel());
        } else if (formattedContent.equals("m.info")) {
            deleteCommandIssued(event, "info");
            new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setAuthor("MomBot")
                            .setTitle("Information")
                            .setDescription("Current Version: v1.2.3.1")
                            .addField("v1.2.3.1", "Internal Functionality", false)
                            .addField("v1.2.3-hf1", "Fixed Internal Bugs", false)
                            .addField("v1.2.3", "Ignores Other Bots *wipes sweat from brow*", false)
                            .addField("v1.2.2", "Added m.invite, Corrected some typos, Updated JavaCord to v3.0.1", false)
                            .addField("v1.2.1", "Added m.info", false)
                            .addField("v1.2", "Added m.help, Added m.stats as an alias to m.count", false)
                            .addField("v1.1", "Added Response Counter to m.count", false)
                            .addField("v1.0", "Rewrite in Javacord [Javacord > Discord4J]", false)
                            .setColor(Color.decode("#e91e63"))
                    )
                    .send(event.getChannel());
        } else if (formattedContent.equals("m.invite")) {
            deleteCommandIssued(event, "invite");
            event.getMessage().getChannel().sendMessage(event.getMessageAuthor().getDisplayName() + " check your DMs for the invite :thumbsup:");
            event.getMessageAuthor().asUser().get().sendMessage("https://discordapp.com/oauth2/authorize?client_id=452208083460947968&permissions=125952&scope=bot");
        }
    }
}
