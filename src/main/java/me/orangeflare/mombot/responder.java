package me.orangeflare.mombot;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.*;
import java.util.Properties;

import static me.orangeflare.mombot.Main.commandIssued;

public class responder implements MessageCreateListener {
    configManager config = new configManager();
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        String formattedContent = event.getMessage().getContent().toLowerCase();
        if (formattedContent.contains("aichmomancy") || formattedContent.contains("anemometer")
                || formattedContent.contains("anemometric") || formattedContent.contains("anemometrograph") || formattedContent.contains("anemometry")
                || formattedContent.contains("arithmoman") || formattedContent.contains("arithmometer") || formattedContent.contains("armomancy")
                || formattedContent.contains("astigmometer") || formattedContent.contains("atmometer") || formattedContent.contains("bromomenorrh")
                || formattedContent.contains("bromomet") || formattedContent.contains("camomile") || formattedContent.contains("cardamom")
                || formattedContent.contains("causimomancy") || formattedContent.contains("chamomile") || formattedContent.contains("chemometr")
                || formattedContent.contains("chresmomancy") || formattedContent.contains("chromom") || formattedContent.contains("thermomet")
                || formattedContent.contains("desmoma") || formattedContent.contains("dromomerycid") || formattedContent.contains("dynamomet")
                || formattedContent.contains("electrohaemometer") || formattedContent.contains("electrohemometer") || formattedContent.contains("entomomancy")
                || formattedContent.contains("gamomania") || formattedContent.contains("grammomancy") || formattedContent.contains("haemochromometer")
                || formattedContent.contains("haemodromometer") || formattedContent.contains("haemomanometer") || formattedContent.contains("haemometer")
                || formattedContent.contains("hemochromometer") || formattedContent.contains("hemodromometer") || formattedContent.contains("hemomanometer")
                || formattedContent.contains("hemometer") || formattedContent.contains("homomer") || formattedContent.contains("homomor")
                || formattedContent.contains("kinemometer") || formattedContent.contains("microseismomet") || formattedContent.contains("moment")
                || formattedContent.contains("myrmomancy") || formattedContent.contains("onomomancy") || formattedContent.contains("ophthalmom")
                || formattedContent.contains("paromomycin") || formattedContent.contains("plasmoma") || formattedContent.contains("pneumomediastinum")
                || formattedContent.contains("pneumomycoasis") || formattedContent.contains("racemomethylate") || formattedContent.contains("rhythmometer")
                || formattedContent.contains("seismomet") || formattedContent.contains("sphygmom") || formattedContent.contains("squamomastoid")
                || formattedContent.contains("stalagmom") || formattedContent.contains("strabismometer") || formattedContent.contains("thermomechani")
                || formattedContent.contains("thermomot") || formattedContent.contains("thumomancy") || formattedContent.contains("tromometer")
                || formattedContent.contains("volumometr") || formattedContent.contains("zymometer") || formattedContent.contains("http://")
                || formattedContent.contains("https://")) {
            //Do Nothing
        } else if (formattedContent.contains("?")) {
            if (event.getMessageAuthor().getId() == Long.parseLong(config.read("ownerID"))) {
                System.out.println("Ignoring Owner ...");
            } else if (event.getMessageAuthor().asUser().map(User::isBot).get()) {
                System.out.println("Ignoring Bot ...");
            } else {
                commandIssued(event, "?");
                event.getChannel().sendMessage("Ask your father");
                try {
                    FileInputStream in = new FileInputStream("./responseCounter.txt");
                    Properties counter = new Properties();
                    counter.load(in);
                    in.close();

                    FileOutputStream out = new FileOutputStream("./responseCounter.txt");
                    counter.setProperty("counter", Integer.toString(Integer.parseInt(counter.getProperty("counter"))+1));
                    counter.store(out, null);
                    out.close();
                } catch (IOException e0) {
                    System.out.println("IOException: " + e0);
                }
            }
        } else if (formattedContent.contains("mom") || formattedContent.contains("mum") || formattedContent.contains("mother")) {
            if (event.getMessageAuthor().getId() == Long.parseLong(config.read("ownerID"))) {
                System.out.println("Ignoring Owner ...");
            } else if (event.getMessageAuthor().asUser().map(User::isBot).get()) {
                System.out.println("Ignoring Bot ...");
            } else {
                commandIssued(event, "mom");
                event.getChannel().sendMessage("Not now sweetie");
                try {
                    FileInputStream in = new FileInputStream("./responseCounter.txt");
                    Properties counter = new Properties();
                    counter.load(in);
                    in.close();

                    FileOutputStream out = new FileOutputStream("./responseCounter.txt");
                    counter.setProperty("counter", Integer.toString(Integer.parseInt(counter.getProperty("counter"))+1));
                    counter.store(out, null);
                    out.close();
                } catch (IOException e0) {
                    System.out.println("IOException: " + e0);
                }
            }
        }
    }
}
