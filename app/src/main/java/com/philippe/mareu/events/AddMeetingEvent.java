package com.philippe.mareu.events;

import com.philippe.mareu.model.Meeting;

public class AddMeetingEvent {

    /**
     * Neighbour to delete
     */
    public Meeting meeting;

    /**
     * Constructor.
     * @param meeting
     */
    public AddMeetingEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}


