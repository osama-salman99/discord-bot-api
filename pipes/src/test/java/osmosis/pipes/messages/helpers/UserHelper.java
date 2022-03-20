package osmosis.pipes.messages.helpers;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.DiscordClient;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.activity.Activity;
import org.javacord.api.entity.channel.PrivateChannel;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserFlag;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.listener.ObjectAttachableListener;
import org.javacord.api.listener.channel.group.GroupChannelChangeNameListener;
import org.javacord.api.listener.channel.group.GroupChannelCreateListener;
import org.javacord.api.listener.channel.group.GroupChannelDeleteListener;
import org.javacord.api.listener.channel.server.ServerChannelChangeOverwrittenPermissionsListener;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberJoinListener;
import org.javacord.api.listener.channel.server.voice.ServerVoiceChannelMemberLeaveListener;
import org.javacord.api.listener.channel.user.PrivateChannelCreateListener;
import org.javacord.api.listener.channel.user.PrivateChannelDeleteListener;
import org.javacord.api.listener.interaction.*;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;
import org.javacord.api.listener.server.member.ServerMemberBanListener;
import org.javacord.api.listener.server.member.ServerMemberJoinListener;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;
import org.javacord.api.listener.server.member.ServerMemberUnbanListener;
import org.javacord.api.listener.server.role.UserRoleAddListener;
import org.javacord.api.listener.server.role.UserRoleRemoveListener;
import org.javacord.api.listener.user.*;
import org.javacord.api.util.event.ListenerManager;

import java.awt.*;
import java.time.Instant;
import java.util.List;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class UserHelper {
    public static User createUser(boolean isBot) {
        return new User() {
            @Override
            public String getDiscriminator() {
                return null;
            }

            @Override
            public boolean isBot() {
                return isBot;
            }

            @Override
            public Set<Activity> getActivities() {
                return null;
            }

            @Override
            public UserStatus getStatus() {
                return null;
            }

            @Override
            public UserStatus getStatusOnClient(DiscordClient discordClient) {
                return null;
            }

            @Override
            public EnumSet<UserFlag> getUserFlags() {
                return null;
            }

            @Override
            public Optional<String> getAvatarHash() {
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
            public Optional<Icon> getServerAvatar(Server server) {
                return Optional.empty();
            }

            @Override
            public Optional<Icon> getServerAvatar(Server server, int i) {
                return Optional.empty();
            }

            @Override
            public Icon getEffectiveAvatar(Server server) {
                return null;
            }

            @Override
            public Icon getEffectiveAvatar(Server server, int i) {
                return null;
            }

            @Override
            public boolean hasDefaultAvatar() {
                return false;
            }

            @Override
            public Set<Server> getMutualServers() {
                return null;
            }

            @Override
            public String getDisplayName(Server server) {
                return null;
            }

            @Override
            public Optional<String> getNickname(Server server) {
                return Optional.empty();
            }

            @Override
            public boolean isPending(Server server) {
                return false;
            }

            @Override
            public boolean isSelfMuted(Server server) {
                return false;
            }

            @Override
            public boolean isSelfDeafened(Server server) {
                return false;
            }

            @Override
            public Optional<Instant> getJoinedAtTimestamp(Server server) {
                return Optional.empty();
            }

            @Override
            public List<Role> getRoles(Server server) {
                return null;
            }

            @Override
            public Optional<Color> getRoleColor(Server server) {
                return Optional.empty();
            }

            @Override
            public Optional<PrivateChannel> getPrivateChannel() {
                return Optional.empty();
            }

            @Override
            public CompletableFuture<PrivateChannel> openPrivateChannel() {
                return null;
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

            @Override
            public ListenerManager<InteractionCreateListener> addInteractionCreateListener(InteractionCreateListener interactionCreateListener) {
                return null;
            }

            @Override
            public List<InteractionCreateListener> getInteractionCreateListeners() {
                return null;
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
            public ListenerManager<AutocompleteCreateListener> addAutocompleteCreateListener(AutocompleteCreateListener autocompleteCreateListener) {
                return null;
            }

            @Override
            public List<AutocompleteCreateListener> getAutocompleteCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserContextMenuCommandListener> addUserContextMenuCommandListener(UserContextMenuCommandListener userContextMenuCommandListener) {
                return null;
            }

            @Override
            public List<UserContextMenuCommandListener> getUserContextMenuCommandListeners() {
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
            public ListenerManager<SlashCommandCreateListener> addSlashCommandCreateListener(SlashCommandCreateListener slashCommandCreateListener) {
                return null;
            }

            @Override
            public List<SlashCommandCreateListener> getSlashCommandCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeSelfMutedListener> addUserChangeSelfMutedListener(UserChangeSelfMutedListener userChangeSelfMutedListener) {
                return null;
            }

            @Override
            public List<UserChangeSelfMutedListener> getUserChangeSelfMutedListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeSelfDeafenedListener> addUserChangeSelfDeafenedListener(UserChangeSelfDeafenedListener userChangeSelfDeafenedListener) {
                return null;
            }

            @Override
            public List<UserChangeSelfDeafenedListener> getUserChangeSelfDeafenedListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeDiscriminatorListener> addUserChangeDiscriminatorListener(UserChangeDiscriminatorListener userChangeDiscriminatorListener) {
                return null;
            }

            @Override
            public List<UserChangeDiscriminatorListener> getUserChangeDiscriminatorListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeServerAvatarListener> addUserChangeServerAvatarListener(UserChangeServerAvatarListener userChangeServerAvatarListener) {
                return null;
            }

            @Override
            public List<UserChangeServerAvatarListener> getUserChangeServerAvatarListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeActivityListener> addUserChangeActivityListener(UserChangeActivityListener userChangeActivityListener) {
                return null;
            }

            @Override
            public List<UserChangeActivityListener> getUserChangeActivityListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeMutedListener> addUserChangeMutedListener(UserChangeMutedListener userChangeMutedListener) {
                return null;
            }

            @Override
            public List<UserChangeMutedListener> getUserChangeMutedListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeDeafenedListener> addUserChangeDeafenedListener(UserChangeDeafenedListener userChangeDeafenedListener) {
                return null;
            }

            @Override
            public List<UserChangeDeafenedListener> getUserChangeDeafenedListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangePendingListener> addUserChangePendingListener(UserChangePendingListener userChangePendingListener) {
                return null;
            }

            @Override
            public List<UserChangePendingListener> getUserChangePendingListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserStartTypingListener> addUserStartTypingListener(UserStartTypingListener userStartTypingListener) {
                return null;
            }

            @Override
            public List<UserStartTypingListener> getUserStartTypingListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeNicknameListener> addUserChangeNicknameListener(UserChangeNicknameListener userChangeNicknameListener) {
                return null;
            }

            @Override
            public List<UserChangeNicknameListener> getUserChangeNicknameListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeAvatarListener> addUserChangeAvatarListener(UserChangeAvatarListener userChangeAvatarListener) {
                return null;
            }

            @Override
            public List<UserChangeAvatarListener> getUserChangeAvatarListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeStatusListener> addUserChangeStatusListener(UserChangeStatusListener userChangeStatusListener) {
                return null;
            }

            @Override
            public List<UserChangeStatusListener> getUserChangeStatusListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserChangeNameListener> addUserChangeNameListener(UserChangeNameListener userChangeNameListener) {
                return null;
            }

            @Override
            public List<UserChangeNameListener> getUserChangeNameListeners() {
                return null;
            }

            @Override
            public ListenerManager<GroupChannelCreateListener> addGroupChannelCreateListener(GroupChannelCreateListener groupChannelCreateListener) {
                return null;
            }

            @Override
            public List<GroupChannelCreateListener> getGroupChannelCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<GroupChannelChangeNameListener> addGroupChannelChangeNameListener(GroupChannelChangeNameListener groupChannelChangeNameListener) {
                return null;
            }

            @Override
            public List<GroupChannelChangeNameListener> getGroupChannelChangeNameListeners() {
                return null;
            }

            @Override
            public ListenerManager<GroupChannelDeleteListener> addGroupChannelDeleteListener(GroupChannelDeleteListener groupChannelDeleteListener) {
                return null;
            }

            @Override
            public List<GroupChannelDeleteListener> getGroupChannelDeleteListeners() {
                return null;
            }

            @Override
            public ListenerManager<PrivateChannelCreateListener> addPrivateChannelCreateListener(PrivateChannelCreateListener privateChannelCreateListener) {
                return null;
            }

            @Override
            public List<PrivateChannelCreateListener> getPrivateChannelCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<PrivateChannelDeleteListener> addPrivateChannelDeleteListener(PrivateChannelDeleteListener privateChannelDeleteListener) {
                return null;
            }

            @Override
            public List<PrivateChannelDeleteListener> getPrivateChannelDeleteListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerChannelChangeOverwrittenPermissionsListener> addServerChannelChangeOverwrittenPermissionsListener(ServerChannelChangeOverwrittenPermissionsListener serverChannelChangeOverwrittenPermissionsListener) {
                return null;
            }

            @Override
            public List<ServerChannelChangeOverwrittenPermissionsListener> getServerChannelChangeOverwrittenPermissionsListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerVoiceChannelMemberLeaveListener> addServerVoiceChannelMemberLeaveListener(ServerVoiceChannelMemberLeaveListener serverVoiceChannelMemberLeaveListener) {
                return null;
            }

            @Override
            public List<ServerVoiceChannelMemberLeaveListener> getServerVoiceChannelMemberLeaveListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerVoiceChannelMemberJoinListener> addServerVoiceChannelMemberJoinListener(ServerVoiceChannelMemberJoinListener serverVoiceChannelMemberJoinListener) {
                return null;
            }

            @Override
            public List<ServerVoiceChannelMemberJoinListener> getServerVoiceChannelMemberJoinListeners() {
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
            public ListenerManager<MessageCreateListener> addMessageCreateListener(MessageCreateListener messageCreateListener) {
                return null;
            }

            @Override
            public List<MessageCreateListener> getMessageCreateListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserRoleAddListener> addUserRoleAddListener(UserRoleAddListener userRoleAddListener) {
                return null;
            }

            @Override
            public List<UserRoleAddListener> getUserRoleAddListeners() {
                return null;
            }

            @Override
            public ListenerManager<UserRoleRemoveListener> addUserRoleRemoveListener(UserRoleRemoveListener userRoleRemoveListener) {
                return null;
            }

            @Override
            public List<UserRoleRemoveListener> getUserRoleRemoveListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerMemberLeaveListener> addServerMemberLeaveListener(ServerMemberLeaveListener serverMemberLeaveListener) {
                return null;
            }

            @Override
            public List<ServerMemberLeaveListener> getServerMemberLeaveListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerMemberBanListener> addServerMemberBanListener(ServerMemberBanListener serverMemberBanListener) {
                return null;
            }

            @Override
            public List<ServerMemberBanListener> getServerMemberBanListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerMemberUnbanListener> addServerMemberUnbanListener(ServerMemberUnbanListener serverMemberUnbanListener) {
                return null;
            }

            @Override
            public List<ServerMemberUnbanListener> getServerMemberUnbanListeners() {
                return null;
            }

            @Override
            public ListenerManager<ServerMemberJoinListener> addServerMemberJoinListener(ServerMemberJoinListener serverMemberJoinListener) {
                return null;
            }

            @Override
            public List<ServerMemberJoinListener> getServerMemberJoinListeners() {
                return null;
            }

            @Override
            public <T extends UserAttachableListener & ObjectAttachableListener> Collection<ListenerManager<T>> addUserAttachableListener(T t) {
                return null;
            }

            @Override
            public <T extends UserAttachableListener & ObjectAttachableListener> void removeUserAttachableListener(T t) {

            }

            @Override
            public <T extends UserAttachableListener & ObjectAttachableListener> Map<T, List<Class<T>>> getUserAttachableListeners() {
                return null;
            }

            @Override
            public <T extends UserAttachableListener & ObjectAttachableListener> void removeListener(Class<T> aClass, T t) {

            }
        };
    }
}
