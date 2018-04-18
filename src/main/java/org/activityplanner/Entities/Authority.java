package org.activityplanner.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authority {
    @Id
    private String username;

    private String authority;

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Authority() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
