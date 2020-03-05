package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;

import java.util.List;


    /**
     * Meetingr API client
     */
    public interface MeetingApiService {

        /**
         * Get all my Meetings
         *
         * @return {@link List}
         */
        List<Meeting>getMeetings();



        List<Place>getPlaces();


        /**
         * Deletes a neighbour
         *
         * @param meeting
         */
        void deleteMeeting(Meeting meeting);


        void addMeeting(Meeting meeting);


    }




