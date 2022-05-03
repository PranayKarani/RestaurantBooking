
package com.se;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {


    }

    // Only for testing purpose. Delete this later on...
    private static void testQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is your name", Question.Format.TXT));
        questions.add(new Question("What is your age", Question.Format.NUM));
        questions.add(new Question("Do you like pizza?", Question.Format.YN));

        Scanner sc = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println(q.text);

            while (true) {
                String ans = sc.nextLine();
                if (q.isValidAnswer(ans)) {
                    break;
                } else {
                    System.out.println("Invalid answer :(");
                }

            }

        }

        System.out.println("done!");
    }

}
