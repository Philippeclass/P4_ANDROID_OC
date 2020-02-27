package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */

public class DummyMeetingApiService implements MeetingApiService  {

        private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();


        /**
         * {@inheritDoc}
         */
        @Override
        public List<Meeting> getMeetings() {
            return meetings;
        }





        /**
         * {@inheritDoc}
         */
        @Override
        public void deleteMeeting(Meeting meeting) {
            meetings.remove(meeting);
        }

    @Override
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }


}





