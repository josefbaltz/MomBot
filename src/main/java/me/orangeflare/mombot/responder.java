package me.orangeflare.mombot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RequestBuffer;

public class responder {
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {
        String formattedMsg = event.getMessage().getContent().toLowerCase();
        if (formattedMsg.contains("aichmomancy") || formattedMsg.contains("anemometer")
        || formattedMsg.contains("anemometric") || formattedMsg.contains("anemometrograph") || formattedMsg.contains("anemometry")
                || formattedMsg.contains("arithmoman") || formattedMsg.contains("arithmometer") || formattedMsg.contains("armomancy")
                || formattedMsg.contains("astigmometer") || formattedMsg.contains("atmometer") || formattedMsg.contains("bromomenorrh")
                || formattedMsg.contains("bromomet") || formattedMsg.contains("camomile") || formattedMsg.contains("cardamom")
                || formattedMsg.contains("causimomancy") || formattedMsg.contains("chamomile") || formattedMsg.contains("chemometr")
                || formattedMsg.contains("chresmomancy") || formattedMsg.contains("chromom") || formattedMsg.contains("thermomet")
                || formattedMsg.contains("desmoma") || formattedMsg.contains("dromomerycid") || formattedMsg.contains("dynamomet")
                || formattedMsg.contains("electrohaemometer") || formattedMsg.contains("electrohemometer") || formattedMsg.contains("entomomancy")
                || formattedMsg.contains("gamomania") || formattedMsg.contains("grammomancy") || formattedMsg.contains("haemochromometer")
                || formattedMsg.contains("haemodromometer") || formattedMsg.contains("haemomanometer") || formattedMsg.contains("haemometer")
                || formattedMsg.contains("hemochromometer") || formattedMsg.contains("hemodromometer") || formattedMsg.contains("hemomanometer")
                || formattedMsg.contains("hemometer") || formattedMsg.contains("homomer") || formattedMsg.contains("homomor")
                || formattedMsg.contains("kinemometer") || formattedMsg.contains("microseismomet") || formattedMsg.contains("moment")
                || formattedMsg.contains("myrmomancy") || formattedMsg.contains("onomomancy") || formattedMsg.contains("ophthalmom")
                || formattedMsg.contains("paromomycin") || formattedMsg.contains("plasmoma") || formattedMsg.contains("pneumomediastinum")
                || formattedMsg.contains("pneumomycoasis") || formattedMsg.contains("racemomethylate") || formattedMsg.contains("rhythmometer")
                || formattedMsg.contains("seismomet") || formattedMsg.contains("sphygmom") || formattedMsg.contains("squamomastoid")
                || formattedMsg.contains("stalagmom") || formattedMsg.contains("strabismometer") || formattedMsg.contains("thermomechani")
                || formattedMsg.contains("thermomot") || formattedMsg.contains("thumomancy") || formattedMsg.contains("tromometer")
                || formattedMsg.contains("volumometr") || formattedMsg.contains("zymometer")) {
            //do nothing
        } else if (formattedMsg.contains("?")) {
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
        } else if (formattedMsg.contains("mom") || formattedMsg.contains("mum")) {
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
