package com.artic.clans.bukkit.manager;

import com.artic.clans.api.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class BukkitClan implements Clan {
    private final UUID id;
    private final String name;
    private final String tag;
    private final UUID ownerId;
    private final Map<UUID, ClanRole> members;
    private final Date createdAt;

    public BukkitClan(UUID id, String name, String tag, UUID ownerId, Map<UUID, ClanRole> members, Date createdAt) {
        this.id = id; this.name = name; this.tag = tag; this.ownerId = ownerId; this.members = members; this.createdAt = createdAt;
    }

    @Override public UUID getId() { return id; }
    @Override public String getName() { return name; }
    @Override public String getTag() { return tag; }
    @Override public UUID getOwnerId() { return ownerId; }
    @Override public Map<UUID, ClanRole> getMembers() { return members; }
    @Override public Date getCreatedAt() { return createdAt; }

    @Override public CompletableFuture<Boolean> addMember(UUID playerId, ClanRole role) { /* ... */ return null; }
    @Override public CompletableFuture<Boolean> removeMember(UUID playerId) { /* ... */ return null; }
    @Override public CompletableFuture<Boolean> setRole(UUID playerId, ClanRole newRole) { /* ... */ return null; }
    @Override public CompletableFuture<Boolean> disband() { /* ... */ return null; }
}