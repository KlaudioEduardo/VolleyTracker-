package com.volleytracker.tracker.dto;

import com.volleytracker.tracker.enums.ActionType;
import jakarta.validation.constraints.NotNull;

public class PlayDto {

    @NotNull(message = "Point number is required")
    private Integer pointNumber;

    @NotNull(message = "Player ID is required")
    private Long playerId;

    @NotNull(message = "Team ID is required")
    private Long teamId;

    @NotNull(message = "Set ID is required")
    private Long setId;

    @NotNull(message = "Action type is required")
    private ActionType actionType;

    private boolean successful;

    public Integer getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(Integer pointNumber) {
        this.pointNumber = pointNumber;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
