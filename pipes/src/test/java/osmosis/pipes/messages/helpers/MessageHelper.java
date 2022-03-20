package osmosis.pipes.messages.helpers;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.CustomEmoji;
import org.javacord.api.entity.message.*;
import org.javacord.api.entity.message.component.HighLevelComponent;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.sticker.StickerItem;
import org.javacord.api.entity.user.User;
import org.javacord.api.listener.ObjectAttachableListener;
import org.javacord.api.listener.interaction.ButtonClickListener;
import org.javacord.api.listener.interaction.MessageComponentCreateListener;
import org.javacord.api.listener.interaction.MessageContextMenuCommandListener;
import org.javacord.api.listener.interaction.SelectMenuChooseListener;
import org.javacord.api.listener.message.*;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveAllListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;
import org.javacord.api.util.event.ListenerManager;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class MessageHelper {
    public static Message createMessage(String content) {
        return createMessage(content, false);
    }

    public static Message createMessage(String content, boolean fromBot) {
        MessageAuthor messageAuthor = MessageAuthorHelper.createAuthor(fromBot);
        return new Message() {
            @Override
            public String getContent() {
                return content;
            }

            @Override
            public Optional<Instant> getLastEditTimestamp() {
                return Optional.empty();
            }

            @Override
            public List<MessageAttachment> getAttachments() {
                return null;
            }

            @Override
            public List<CustomEmoji> getCustomEmojis() {
                return null;
            }

            @Override
            public MessageType getType() {
                return null;
            }

            @Override
            public TextChannel getChannel() {
                return null;
            }

            @Override
            public Optional<MessageActivity> getActivity() {
                return Optional.empty();
            }

            @Override
            public boolean isPinned() {
                return false;
            }

            @Override
            public boolean isTts() {
                return false;
            }

            @Override
            public boolean mentionsEveryone() {
                return false;
            }

            @Override
            public List<Embed> getEmbeds() {
                return null;
            }

            @Override
            public Optional<User> getUserAuthor() {
                return Optional.empty();
            }

            @Override
            public MessageAuthor getAuthor() {
                return messageAuthor;
            }

            @Override
            public Optional<MessageReference> getMessageReference() {
                return Optional.empty();
            }

            @Override
            public Optional<Message> getReferencedMessage() {
                return Optional.empty();
            }

            @Override
            public boolean isCachedForever() {
                return false;
            }

            @Override
            public void setCachedForever(boolean b) {

            }

            @Override
            public List<Reaction> getReactions() {
                return null;
            }

            @Override
            public List<HighLevelComponent> getComponents() {
                return null;
            }

            @Override
            public List<User> getMentionedUsers() {
                return null;
            }

            @Override
            public List<Role> getMentionedRoles() {
                return null;
            }

            @Override
            public Optional<String> getNonce() {
                return Optional.empty();
            }

            @Override
            public Set<StickerItem> getStickerItems() {
                return null;
            }

            @Override
            public CompletableFuture<Void> addReactions(String... strings) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeReactionByEmoji(User user, String s) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeReactionByEmoji(String s) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeReactionsByEmoji(User user, String... strings) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeReactionsByEmoji(String... strings) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeOwnReactionByEmoji(String s) {
                return null;
            }

            @Override
            public CompletableFuture<Void> removeOwnReactionsByEmoji(String... strings) {
                return null;
            }

            @Override
            public int compareTo(Message message) {
                return 0;
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
            public ListenerManager<MessageComponentCreateListener> addMessageComponentCreateListener(MessageComponentCreateListener messageComponentCreateListener) {
                return null;
            }

            @Override
            public List<MessageComponentCreateListener> getMessageComponentCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<ButtonClickListener> addButtonClickListener(ButtonClickListener buttonClickListener) {
                return null;
            }

            @Override
            public List<ButtonClickListener> getButtonClickListeners() {
                return null;
            }

            @Override
            public ListenerManager<SelectMenuChooseListener> addSelectMenuChooseListener(SelectMenuChooseListener selectMenuChooseListener) {
                return null;
            }

            @Override
            public List<SelectMenuChooseListener> getSelectMenuChooseListeners() {
                return null;
            }

            @Override
            public ListenerManager<MessageContextMenuCommandListener> addMessageContextMenuCommandListener(MessageContextMenuCommandListener messageContextMenuCommandListener) {
                return null;
            }

            @Override
            public List<MessageContextMenuCommandListener> getMessageContextMenuCommandListeners() {
                return null;
            }

            @Override
            public ListenerManager<ReactionRemoveAllListener> addReactionRemoveAllListener(ReactionRemoveAllListener reactionRemoveAllListener) {
                return null;
            }

            @Override
            public List<ReactionRemoveAllListener> getReactionRemoveAllListeners() {
                return null;
            }

            @Override
            public ListenerManager<ReactionAddListener> addReactionAddListener(ReactionAddListener reactionAddListener) {
                return null;
            }

            @Override
            public List<ReactionAddListener> getReactionAddListeners() {
                return null;
            }

            @Override
            public ListenerManager<ReactionRemoveListener> addReactionRemoveListener(ReactionRemoveListener reactionRemoveListener) {
                return null;
            }

            @Override
            public List<ReactionRemoveListener> getReactionRemoveListeners() {
                return null;
            }

            @Override
            public ListenerManager<MessageEditListener> addMessageEditListener(MessageEditListener messageEditListener) {
                return null;
            }

            @Override
            public List<MessageEditListener> getMessageEditListeners() {
                return null;
            }

            @Override
            public ListenerManager<CachedMessageUnpinListener> addCachedMessageUnpinListener(CachedMessageUnpinListener cachedMessageUnpinListener) {
                return null;
            }

            @Override
            public List<CachedMessageUnpinListener> getCachedMessageUnpinListeners() {
                return null;
            }

            @Override
            public ListenerManager<MessageDeleteListener> addMessageDeleteListener(MessageDeleteListener messageDeleteListener) {
                return null;
            }

            @Override
            public List<MessageDeleteListener> getMessageDeleteListeners() {
                return null;
            }

            @Override
            public ListenerManager<CachedMessagePinListener> addCachedMessagePinListener(CachedMessagePinListener cachedMessagePinListener) {
                return null;
            }

            @Override
            public List<CachedMessagePinListener> getCachedMessagePinListeners() {
                return null;
            }

            @Override
            public <T extends MessageAttachableListener & ObjectAttachableListener> Collection<ListenerManager<T>> addMessageAttachableListener(T t) {
                return null;
            }

            @Override
            public <T extends MessageAttachableListener & ObjectAttachableListener> void removeMessageAttachableListener(T t) {

            }

            @Override
            public <T extends MessageAttachableListener & ObjectAttachableListener> Map<T, List<Class<T>>> getMessageAttachableListeners() {
                return null;
            }

            @Override
            public <T extends MessageAttachableListener & ObjectAttachableListener> void removeListener(Class<T> aClass, T t) {

            }
        };
    }
}
