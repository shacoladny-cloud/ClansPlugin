package com.artic.clans.api;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ClanManager {
    CompletableFuture<Optional<Clan>> getClan(UUID clanId);
    CompletableFuture<Optional<Clan>> getPlayerClan(UUID playerId);
    CompletableFuture<Clan> createClan(String name, String tag, UUID ownerId);
    CompletableFuture<Boolean> deleteClan(UUID clanId);
    CompletableFuture<Boolean> invitePlayer(UUID clanId, UUID targetPlayerId, UUID inviterId);
    CompletableFuture<Boolean> acceptInvite(UUID clanId, UUID playerId);
    CompletableFuture<Boolean> kickPlayer(UUID clanId, UUID targetPlayerId, UUID executorId);
    CompletableFuture<Boolean> transferOwnership(UUID clanId, UUID newOwnerId);
}