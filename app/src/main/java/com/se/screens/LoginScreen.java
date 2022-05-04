package com.se.screens;

import com.se.Question;

public class LoginScreen extends Screen {

    private String[] loginData; // if several lines of input data need to be accessed

    @Override

    protected void initQuestions() {
        loginData= new String[2];// username # password

        questions.add(new Question("Username:", Question.Format.TXT));
        questions.add(new Question("Password:", Question.Format.TXT));

    }

    @Override
    public void processData() {
        loginData[currentIdx]=returnData;
        //System.out.println(returnData);
    }

//    public String printAllData(){
//        String out = "";
//        for (String i: loginData)
//            out += i + "#";
//        return out;
//    }
    public String[] getLoginData() {
        return loginData;
    }
}