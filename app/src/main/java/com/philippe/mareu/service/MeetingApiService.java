package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;

import java.util.List;


    /**
     * Neighbour API client
     */
    public interface MeetingApiService {

        /**
         * Get all my Neighbours
         *
         * @return {@link List}
         */
        List<Meeting> getMeetings();


        /**
         * Deletes a neighbour
         *
         * @param meeting
         */
        void deleteMeeting(Meeting meeting);


    }




