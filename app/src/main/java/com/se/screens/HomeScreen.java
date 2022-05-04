package com.se.screens;

import com.se.Question;

public class HomeScreen extends Screen {

	@Override
	protected void initQuestions() {
		questions.add(new Question("Please select the operation you would like to perform", Question.Format.NULL));
		questions.add(new Question("1. New Booking",  Question.Format.NUM));
		questions.add(new Question("2. View Bookings",  Question.Format.NUM));
		questions.add(new Question("3. Cancel Booking",  Question.Format.NUM));
		questions.add(new Question("4. Logout",  Question.Format.NUM));
		
	}

}
