package me.orangeflare.mombot;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;

public class mombot {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No API Token was Provided!");
            System.err.println("    In the startup script please add an API token after the jar");
            System.err.println("    Ex: 'java -jar MomBot.jar [API TOKEN]'");
            return;
        }
        IDiscordClient bot = new ClientBuilder()
                .withToken(args[0])
                .build();
        bot.getDispatcher().registerListener(new responder());
        bot.login();
    }
}
