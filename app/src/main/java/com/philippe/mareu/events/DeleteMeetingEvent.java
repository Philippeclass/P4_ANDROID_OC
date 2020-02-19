package com.philippe.mareu.events;

import com.philippe.mareu.model.Meeting;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteMeetingEvent {



        /**
         * Neighbour to delete
         */
        public Meeting meeting;

        /**
         * Constructor.
         * @param meeting
         */
        public DeleteMeetingEvent(Meeting meeting) {
            this.meeting = meeting;
        }
    }


