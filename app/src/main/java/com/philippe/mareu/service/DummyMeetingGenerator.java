package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETING = Arrays.asList(


            new Meeting(1, "Reunion A", Calendar.getInstance().getTime(), "Peach", "Arthur@gmail.com"),
            new Meeting(2, "Reunion B", Calendar.getInstance().getTime(), "Mario", "Marco@gmail.com"),
            new Meeting(3, "Reunion C", Calendar.getInstance().getTime(), "Luigi", "Hugo@gmail.com")

    );

    private static List<Place> DUMMYPLACE = Arrays.asList(
            new Place(1, "Peach"),
            new Place(2, "Mario"),
            new Place(3, "Luigi")
    );

    static List<Place> generatePlaces() {
        return new ArrayList<>(DUMMYPLACE);
    }

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETING);
    }


}
