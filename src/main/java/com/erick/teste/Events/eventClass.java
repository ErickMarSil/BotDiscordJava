package com.erick.teste.Events;

import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class eventClass extends ListenerAdapter {

    //private final String mainMessages = "alguem escreveu no chat (chatName) !, Vá até lá ver (ChatMention)";

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().isBot()) {
            TextChannel txtChannel = event.getGuild().getTextChannelsByName("chat-geral", true).get(0);

            Channel channelObj = event.getChannel();
            String channelName = channelObj.getName();
            String channelMentionClickable = channelObj.getAsMention();

            String FinalMessage = "alguem escreveu no chat '" + channelName + "' !, Vá até lá ver " + channelMentionClickable;
            txtChannel.sendMessage(FinalMessage).queue();
        }
    }


}
