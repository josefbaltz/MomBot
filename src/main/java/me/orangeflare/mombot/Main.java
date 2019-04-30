package me.orangeflare.mombot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.util.logging.ExceptionLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        configManager config = new configManager();

        String APIToken = config.read("discordAPI");
        if (APIToken.isEmpty()) {
            System.err.println("No API Token Provided!");
            System.exit(0);
        }

        FileInputStream input;
        try {
            input = new FileInputStream("./responseCounter.txt");
            if (input.read() == -1) {
                try {
                    String data = "counter=0";
                    Files.write(Paths.get("./responseCounter.txt"), data.getBytes());
                } catch (IOException e1) {
                    System.err.println(e1);
                    System.exit(0);
                }
            }
        } catch (IOException e0) {
            System.out.println("No responseCounter.txt file found!\nGenerating one for you now\n...");
            System.out.println("Done!");
            try {
                String data = "counter=0";
                Files.write(Paths.get("./responseCounter.txt"), data.getBytes());
            } catch (IOException e1) {
                System.err.println(e1);
                System.exit(0);
            }
        }

        new DiscordApiBuilder()
                .setToken(APIToken)
                .setRecommendedTotalShards().join()
                .loginAllShards()
                .forEach(shardFuture -> shardFuture
                        .thenAccept(Main::core)
                        .exceptionally(ExceptionLogger.get())
                );
    }

    public static void commandIssued(MessageCreateEvent event, String command) {
        System.out.println(event.getMessageAuthor().asUser().map(User::getDiscriminatedName).get() + " issued command '" + command + "'");
    }

    public static void deleteCommandIssued(MessageCreateEvent event, String command) {
        event.getMessage().delete();
        System.out.println(event.getMessageAuthor().asUser().map(User::getDiscriminatedName).get() + " issued command '" + command + "'");
    }

    private static void core(DiscordApi mom) {
        mom.addMessageCreateListener(new responder());
        mom.addMessageCreateListener(new general());
        mom.addServerJoinListener(new serverJoinReporter());
    }
}