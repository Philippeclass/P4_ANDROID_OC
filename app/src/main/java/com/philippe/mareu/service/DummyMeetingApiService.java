package com.philippe.mareu.service;

import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;
import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();
    private List<Place>  places = DummyMeetingGenerator.generatePlaces();




    /**
     * {@inheritDoc}
     */
    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public List<Meeting> sortByDates(String date) {
        List<Meeting> meetingList = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getDateFormated().equals(date)) {

                meetingList.add(meeting);

            }

        }
        return meetingList;
    }

    @Override
    public List<Meeting> sortByPlaces(Place place) {
        List<Meeting> meetingList2 = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getPlace().equals(place)) {

                meetingList2.add(meeting);
            }
        }
        return meetingList2;
    }


    @Override
    public List<Place> getPlaces() {
        return places;
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





