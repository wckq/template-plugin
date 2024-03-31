package me.wckq.plugin.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public class MessageUtil {

    public static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();

    private MessageUtil() {
    }

    public static Component convertStringToMessage(
            final String message,
            final TagResolver... tagResolvers
    ) {
        return MINI_MESSAGE.deserialize(
                message,
                tagResolvers
        );
    }
}
