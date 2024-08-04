package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conditions")
public class Result extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ResultName name;

    @NotNull
    private String description;

    public ResultName getName() {
        return name;
    }

    public void setName(ResultName name) {
        this.name = name;
        this.setDescription(name);
    }

    public String getMatchComment() {
        return description;
    }

    public void setMatchComment(String matchcomment) {
        this.matchcomment = matchcomment;
    }

    private void setMatchComment(ResultName name) {
        String matchcomment = "";

        switch (name) {
            case WIN -> matchcomment = "The home team win the game";
            case DRAW -> matchcomment = "The game finished in draw";
            case LOSE -> matchcomment = "The home team lose the game";
            case CANCELLED -> matchcomment = "The match is ended due to technical or weather reasons ";
        }

        this.matchcomment = matchcomment;
    }
}
