package com.se.screens;

import com.se.Question;

public class SignupScreen extends Screen {

    private String[] signupData; // if several lines of input data need to be accessed

    @Override

    protected void initQuestions() {
        signupData= new String[2];// username # password

        questions.add(new Question("New username:", Question.Format.TXT));
        questions.add(new Question("New password:", Question.Format.TXT));

    }

    @Override
    public void processData() {
        signupData[currentIdx]=returnData;
        //System.out.println(returnData);
    }

//    public String printAllData(){
//        String out = "";
//        for (String i: signupData)
//            out += i + "#";
//        return out;
//    }
    public String[] getSignupData() {
        return signupData;
    }
}