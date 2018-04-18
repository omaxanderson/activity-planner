package org.activityplanner.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User {

    //*********** Attributes ********************
    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String password;

    private boolean enabled;

    private String firstName, lastName;

    @OneToMany(mappedBy = "ownerId")
    private Set<Event> ownedEvents;

    @OneToMany(mappedBy = "userId")
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.MERGE, CascadeType.PERSIST},
            mappedBy = "users")
    private Set<Event> events;

    // *************** Constructors *********************
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.firstName = "";
        this.lastName = "";
    }

    public User(String username, String password, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //************** Getters and Setters ********************
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void addOwnedEvent(Event e) {
        ownedEvents.add(e);
    }

    public void addEvent(Event e) {
        events.add(e);
    }

}
