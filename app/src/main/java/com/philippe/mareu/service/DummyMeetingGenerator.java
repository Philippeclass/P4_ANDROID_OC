package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETING = Arrays.asList(


    new Meeting(1, "Reunion A", Calendar.getInstance().getTime(), "Salle A", "Paech", "Mals","Vlue" ),
    new Meeting(2, "Reunion B",Calendar.getInstance().getTime(), "Salle B", "Mario", "Mals","Vlue"),
    new Meeting(3,"Reunion C",Calendar.getInstance().getTime(), "Salle C", "Luigi", "Mals","Vlue")

    );


    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETING);
    }


}
