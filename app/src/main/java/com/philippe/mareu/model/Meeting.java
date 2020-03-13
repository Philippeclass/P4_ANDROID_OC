package com.philippe.mareu.model;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

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


    /**
     * Constructor
     *
     * @param id
     * @param date
     * @param place

     * @param entrantMail

     */
    public Meeting(Integer id,String name, Date date, String place, String entrantMail
    ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.place = place;
        this.entrantMail = entrantMail;

    }


    public static final Comparator<Meeting> byDate= new Comparator<Meeting>() {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", Locale.FRANCE);
            String dateStr1 = (m1.getDate().toString()+ " " + m1.getDate().toString()).toString() ;
            String dateStr2 = (m2.getDate().toString()+ " " + m2.getDate().toString()).toString() ;

            try {
                return mSimpleDateFormat.parse(dateStr1).compareTo(mSimpleDateFormat.parse(dateStr2));
            }catch (ParseException e){
                throw new IllegalArgumentException(e);
            }
        }
    };




    public StringBuilder getTimeFormated() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        StringBuilder time = new StringBuilder(dateFormat.format(this.date));

        return time;

    }

public String getDateFormated() {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy");
        return  dateFormat.format(this.date);
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



}
