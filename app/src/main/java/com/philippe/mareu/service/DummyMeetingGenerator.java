package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETING = Arrays.asList(



    new Meeting(1,160, "Salle 1", "Paech", "Mals","Vlue" ),
    new Meeting(1,160, "Salle 1", "Paech", "Mals","Vlue"),
    new Meeting(1,160, "Salle 1", "Paech", "Mals","Vlue")



    );


    static List<Meeting> generateNeighbours() {
        return new ArrayList<>(DUMMY_MEETING);
    }


}
