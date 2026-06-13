package com.artic.clans.api;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public interface Clan {
    UUID getId();
    String getName();
    String getTag();
    UUID getOwnerId();
    Map<UUID, ClanRole> getMembers();
    Date getCreatedAt();

    CompletableFuture<Boolean> addMember(UUID playerId, ClanRole role);
    CompletableFuture<Boolean> removeMember(UUID playerId);
    CompletableFuture<Boolean> setRole(UUID playerId, ClanRole newRole);
    CompletableFuture<Boolean> disband();
}