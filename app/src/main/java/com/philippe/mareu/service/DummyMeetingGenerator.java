package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public abstract class DummyMeetingGenerator {

    static List<Place> generatePlaces() {
        return new ArrayList<>(DUMMYPLACE);
    }

    static Calendar mCalendar = Calendar.getInstance();

    private static List<Place> DUMMYPLACE = Arrays.asList(
            new Place("Peach", "#c5c5c5"),
            new Place("Mario", "#b4ebe8"),
            new Place("Luigi", "#f3ef74")
    );


    public static List<Meeting> DUMMY_MEETING = Arrays.asList(


            new Meeting(1, "Reunion A", setDate(2020,3, 3,9,30), generatePlaces().get(0), "Arthur@gmail.com"),
            new Meeting(2, "Reunion B", setDate(2020,3, 10,9,30), generatePlaces().get(1), "Marco@gmail.com"),
            new Meeting(3, "Reunion C", Calendar.getInstance().getTime(), generatePlaces().get(2), "Hugo@gmail.com")

    );

    static Date setDate(int year, int month, int day, int hours, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hours, minutes);
        return calendar.getTime();
    }


    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETING);
    }


}
