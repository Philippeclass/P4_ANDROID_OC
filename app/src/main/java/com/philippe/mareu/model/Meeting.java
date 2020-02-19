package com.philippe.mareu.model;

import java.io.Serializable;

public class Meeting implements Serializable {


    /**
     * Identifier
     */
    private Integer id;

    /**
     * Time
     */
    private Integer time;

    /**
     * Place
     */
    private String place;

    /**
     * Subject
     */
    private String subject;


    /**
     * Entrants mails adress
     */
    private String entrantMail;

    /**
     * AvatarColor
     */
    private String avatarColor;

    /**
     * Constructor
     *
     * @param id
     * @param time
     * @param place
     * @param subject
     * @param entrantMail
     * @param avatarColor
     */
    public Meeting(Integer id, Integer time, String place, String subject, String entrantMail, String avatarColor
    ) {
        this.id = id;
        this.time = time;
        this.place = place;
        this.subject = subject;
        this.entrantMail = entrantMail;
        this.avatarColor = avatarColor;


    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTtime() {
        return time;
    }
    public void setTime(Integer time) {
        this.time = time;
    }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getEntrantMail() { return entrantMail; }
    public void setEntrantMails(String entrantMail) { this.entrantMail = entrantMail; }
    public String getAvatarColor() {
        return avatarColor;
    }
    public void setAvatarColor(String avatarColor) { this.avatarColor = avatarColor; }


}
