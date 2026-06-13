package com.artic.clans.api;

public enum ClanRole {
    OWNER,    // владелец
    OFFICER,  // офицер
    MEMBER,   // участник
    RECRUIT;  // новобранец

    public boolean canInvite() {
        return this == OWNER || this == OFFICER;
    }

    public boolean canKick() {
        return this == OWNER || this == OFFICER;
    }

    public boolean canPromote() {
        return this == OWNER;
    }
}