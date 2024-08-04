package com.soccerapp.model;

import com.soccerapp.model.enums.ResultName;

import java.math.BigDecimal;

public class GameCreateBindingModel {

    private String matchcomment;
    private BigDecimal duration;
    private ResultName result;

    public String getMatchComment() {
        return matchcomment;
    }

    public void setMatchComment(String matchcomment) {
        this.matchcomment = matchcomment;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public ResultName getResult() {
        return result;
    }

    public void setResult(ResultName result) {
        this.result = result;
    }
}
