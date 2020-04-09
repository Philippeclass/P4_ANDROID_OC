package com.philippe.mareu;

import com.philippe.mareu.di.DI;
import com.philippe.mareu.model.Meeting;
import com.philippe.mareu.model.Place;
import com.philippe.mareu.service.DummyMeetingGenerator;
import com.philippe.mareu.service.MeetingApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;






/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MaReuUnitTest {

    private MeetingApiService service;


    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetingWithSuccess() {
        List<Meeting> meetings = service.getMeetings();
        List<Meeting> expectedMeetings = DummyMeetingGenerator.DUMMY_MEETING;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    @Test
    public void deleteMeetingWithSuccess() {
        Meeting meetingsToDelete = service.getMeetings().get(0);
        service.deleteMeeting(meetingsToDelete);
        assertFalse(service.getMeetings().contains(meetingsToDelete));
    }

    @Test
    public void addMeetingWithSucess () {
        Meeting meetingToAdd = new Meeting(4,"Reunion C", Calendar.getInstance().getTime(), service.getPlaces().get(0), "Marcopolo@hotmail.fr");
        service.addMeeting(meetingToAdd);
        assertTrue(service.getMeetings().contains(meetingToAdd));
    }

    @Test
    public void sortByDatesWitchSucess () {
       Calendar calendar  = Calendar.getInstance();
       calendar.set(2020,2,20);
        Meeting meetingToAdd = new Meeting(5,"Reunion D", calendar.getTime() , service.getPlaces().get(0), "Marcopolo@hotmail.fr");
        service.addMeeting(meetingToAdd);
       List<Meeting> meetingList  = service.sortByDates("03/04/2020");

       for (Meeting meeting : meetingList) {
           assertEquals("03/04/2020",meeting.getDateFormated());
       }

    }

    @Test
    public void sortByPlacesWithSucess () {
        List<Meeting> meetingList  = service.sortByPlaces(service.getPlaces().get(0));
        for (Meeting meeting : meetingList) {
            assertEquals(service.getPlaces().get(0),meeting.getPlace());
        }

    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}