package com.se.screens;

import com.se.Question;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Screen {

    public ArrayList<Question> questions = new ArrayList<>();
    protected int currentIdx = 0;
    private String returnData;

    public Screen() {
        initQuestions();
    }

    /**
     * Fill up questions array in this method's implementation
     */
    protected abstract void initQuestions();

    /**
     * Shows all questions in sequence and returns the final answer
     *
     * @return answer of the last question. It can ignored also.
     */
    public String showQuestions() {
        Scanner sc = new Scanner(System.in);

        for (; currentIdx < questions.size(); ) {
            Question q = questions.get(currentIdx);
            System.out.println(q.text);

            boolean goBack = false;

            while (true) {
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase("back")) {
                    goBack = true;
                    break;
                }

                returnData = ans;
                if (q.isValidAnswer(ans)) {
                    break;
                } else {
                    System.out.println("Invalid answer :(");
                }

            }

            if (goBack) {
                currentIdx--;
                if (currentIdx < 0) {
                    currentIdx = 0;
                }
            } else {
                currentIdx++;
            }

        }
        return returnData;
    }

}
