package org.activityplanner.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    int id;

    String title;
    String location;
    String description;
    Date date;
    Time time;

    // 1 to n mapping to comments
    @OneToMany(mappedBy = "eventId")
    private Set<Comment> comments = new HashSet<>();

    // n to 1 mapping for the owner of this event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerId", nullable = false)
    private User ownerId;

    // n to m mapping for the invited users
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "invitedTo",
            joinColumns = { @JoinColumn(name = "eventId", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "userId", nullable = false)
    })
    private Set<User> users;

    // **************** Constructors **********************
    public Event(int id, String title, String location, String description,
                 Date date, Time time, Set<Comment> comments, User ownerId, Set<User> users) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
        this.date = date;
        this.time = time;
        this.comments = comments;
        this.ownerId = ownerId;
        this.users = users;
    }

    public Event(String title) {
        this.title = title;
    }

    public Event() {}

    // ******************** Getters and Setters **************************

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }
    public void setTime(Time time) {
        this.time = time;
    }

    public Set<Comment> getComments() {
        return comments;
    }
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addComment(Comment c) {
        comments.add(c);
    }

    public void addUser(User u) {
        users.add(u);
    }
}
