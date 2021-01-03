package com.icommerce.product.core.userlog;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserLog {

    private String id;
    private String username;
    private LocalDateTime createdOn;
    private UserAction action;
    private String description;

    public UserLog(String username, UserAction action, String description) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.action = action;
        this.description = description;
        this.createdOn = LocalDateTime.now();
    }

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

    public UserAction getAction() {
        return action;
    }

    public void setAction(UserAction action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
