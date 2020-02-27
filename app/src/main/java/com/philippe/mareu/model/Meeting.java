package com.philippe.mareu.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Meeting implements Serializable {


    /**
     * Identifier
     */
    private Integer id;
    /**
     *  name
     */
    private String name;


    /**
     * Time
     */
    private Date date;

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
     * @param date
     * @param place
     * @param subject
     * @param entrantMail
     * @param avatarColor
     */
    public Meeting(Integer id,String name, Date date, String place, String subject, String entrantMail, String avatarColor
    ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.subject = subject;
        this.entrantMail = entrantMail;
        this.avatarColor = avatarColor;


    }

    public StringBuilder getTimeFormated() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        StringBuilder time = new StringBuilder(dateFormat.format(this.date));
        return time;

    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() { return name; }
    public void setName(String place) { this.name = name;}
    public Date getDate() { return date; }
    public void setDate(Date time) { this.date = date; }
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
