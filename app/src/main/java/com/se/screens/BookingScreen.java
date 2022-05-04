package com.se.screens;

import com.se.Booking;
import com.se.Question;
import com.se.RestarauntManager;

public class BookingScreen extends Screen {

    @Override
    protected void initQuestions() {
        RestarauntManager m = new RestarauntManager();
        Booking newBooking = new Booking();
        questions.add(new Question("Date?", Question.Format.DATE).setAnswerListener(ans -> {
            newBooking.date = ans;
        }));
        questions.add(new Question("Time?", Question.Format.TXT).setAnswerListener(ans -> {
            newBooking.time = ans;
        }));
        questions.add(new Question("Noof of people?", Question.Format.NUM).setAnswerListener(ans -> {
            newBooking.noOfPeople = Integer.parseInt(ans);

            boolean available = m.checkAvailibility(newBooking.noOfPeople);
            if (available) {
                m.bookingList.add(newBooking);
                questions.add(new Question("Confirmed", Question.Format.NULL));
            } else {
                questions.add(new Question("Not Confirmed", Question.Format.NULL));
            }

        }));

    }
}
