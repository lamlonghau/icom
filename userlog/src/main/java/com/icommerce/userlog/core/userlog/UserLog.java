package com.icommerce.userlog.core.userlog;

import com.icommerce.userlog.core.shared.SelfValidating;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class UserLog extends SelfValidating<UserLog> {

    @NotEmpty
    private String id;
    @NotEmpty
    private String username;
    @NotNull
    private LocalDateTime createdOn;
    @NotEmpty
    private String action;
    @NotEmpty
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
