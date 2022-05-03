package com.se.screens;

import com.se.Question;

public class FirstScreen extends Screen {

    @Override

    protected void initQuestions() {

        questions.add(new Question("Hello!", Question.Format.NULL));
        questions.add(new Question("Are you a new User?", Question.Format.YN));

    }

}
