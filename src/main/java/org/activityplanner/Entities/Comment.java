package org.activityplanner.Entities;

import javax.persistence.*;

@Entity
public class Comment {

    // ************** Attributes *******************
    @Id
    private int id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId", nullable = false)
    private Event eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    //*************** Constructors *************************
    public Comment(int id, String title, String content, Event event) {
        this.id = id;
        this.title = title;
        this.content = content;
 //       this.event = event;
    }

    public Comment() {}

    //*************** Getters and Setters *********************
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Event getEventId() {
        return eventId;
    }
    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
}
