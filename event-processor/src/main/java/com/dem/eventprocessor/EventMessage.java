package com.dem.eventprocessor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="event_message")
public class EventMessage {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="topic_name")
    private String topicName;

    @Column(columnDefinition="text")
    private String content;

    @Column(name="received_at")
    private LocalDateTime receivedAt;

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTopicName(){return topicName;}
    public void setTopicName(String t){this.topicName=t;}
    public String getContent(){return content;}
    public void setContent(String c){this.content=c;}
    public LocalDateTime getReceivedAt(){return receivedAt;}
    public void setReceivedAt(LocalDateTime r){this.receivedAt=r;}
}
