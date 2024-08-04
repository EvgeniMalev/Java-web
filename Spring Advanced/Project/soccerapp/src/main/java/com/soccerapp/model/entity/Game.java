package com.soccerapp.model.entity;

import com.soccerapp.model.GameCreateBindingModel;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    @NotNull
    @Length(min = 2, max = 50)
    @Size
    private String matchcomment;

    @NotNull
    @Min(value = 0)
    private BigDecimal duration;

    @NotNull
    @ManyToOne
    private Result result;

    // the match is authorized by a sports association

    @NotNull
    @ManyToOne
    private User createdBy;

    @NotNull
    @ManyToOne
    private User fieldtemperature;

    @ManyToOne
    private User watchedBy;
  
    public Game() {
    }

    public Game(GameCreateBindingModel gameCreateBindingModel, Result result, User createdBy, User fieldtemperature) {
        matchcomment = matchcommentCreateBindingModel.getMatchComment();
        duration = gameCreateBindingModel.getDuration();
        this.result = result;
        this.fieldtemperature = fieldtemperature;
        this.createdBy = createdBy;
    }

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

    public Condition getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Condition getFieldTemperature() {
        return fieldtemperature;
    }

    public void setFieldTemperature(FieldTemperature fieldtemperature) {
        this.fieldtemperature = fieldtemperature;
    }
  
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public void setWatchedBy(User watchedBy) {
        this.watchedBy = watchedBy;
    }
}
