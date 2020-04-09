package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;

import java.util.List;


    /**
     * Meeting API client
     */
    public interface MeetingApiService {

        /**
         * Get all my Meetings
         *
         * @return {@link List}
         */
        List<Meeting>getMeetings();

        List<Meeting>sortByDates(String date);

        List<Meeting>sortByPlaces(Place place);

        List<Place>getPlaces();


        /**
         * Deletes a meeting
         *
         * @param meeting
         */
        void deleteMeeting(Meeting meeting);


        void addMeeting(Meeting meeting);


    }




