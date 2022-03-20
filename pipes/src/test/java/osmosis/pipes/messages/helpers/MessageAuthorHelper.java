package osmosis.pipes.messages.helpers;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.user.User;

import java.util.Optional;

public class MessageAuthorHelper {
    public static MessageAuthor createAuthor(boolean isBot) {
        User user = UserHelper.createUser(isBot);
        return new MessageAuthor() {
            @Override
            public Message getMessage() {
                return null;
            }

            @Override
            public Optional<String> getDiscriminator() {
                return Optional.empty();
            }

            @Override
            public Icon getAvatar() {
                return null;
            }

            @Override
            public Icon getAvatar(int i) {
                return null;
            }

            @Override
            public boolean isUser() {
                return !isBot;
            }

            @Override
            public Optional<User> asUser() {
                return Optional.of(user);
            }

            @Override
            public boolean isWebhook() {
                return false;
            }

            @Override
            public DiscordApi getApi() {
                return null;
            }

            @Override
            public long getId() {
                return 0;
            }

            @Override
            public String getName() {
                return null;
            }
        };
    }
}
