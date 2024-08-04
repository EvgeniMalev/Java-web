package com.soccerapp.model;

import com.soccerapp.model.entity.Game;

public class OtherGameDTO extends MyGameDTO {

    private String announcingUsername;

    public OtherGamesDTO() {
    }

    public OtherGamesDTO(Game game) {
        super(game);
        announcingUsername = game.getCreatedBy().getUsername();
    }

    public String getSellerUsername() {
        return announcingUsername;
    }

    public void setAnnouncingUsername(String announcingUsername) {
        this.announcingUsername = announcingUsername;
    }
}
