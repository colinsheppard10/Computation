package com.example.colin.computation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Random randomGenerator = new Random();
    long random1;
    long random2;
    long random3;
    long random4;
    long random5;
    long answer;
    float finalAnswer;
    int score = 0;
    int loops = 0;
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    long startTime;

    public Button startButton;
    public Button correctButton;
    public Button incorrectButton;
    public Button doneButton;

    TextView questionText;
    TextView answerText;
    TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = (TextView) findViewById(R.id.textView);
        answerText = (TextView) findViewById(R.id.textView2);
        results = (TextView) findViewById(R.id.textView3);


        startButton = (Button) findViewById(R.id.button);
        doneButton = (Button) findViewById(R.id.button2);
        incorrectButton = (Button) findViewById(R.id.button3);
        correctButton = (Button) findViewById(R.id.button4);

    }

    public void startComp(View view) {
        startTime = System.currentTimeMillis();
        generateQuestion(view);
    }

    public void generateQuestion(View view){
        answerText.setText("");
        random1 = 1+ randomGenerator.nextInt(19);
        random2 = 1+ randomGenerator.nextInt(19);
        random3 = 1+ randomGenerator.nextInt(19);
        random4 = 1+ randomGenerator.nextInt(19);
        random5 = 1+ randomGenerator.nextInt(19);

        questionText.setText(random1 + "  " + random2 + "  " + random3 + "  " + random4 + "  " + random5);
    }

    public void generateAnswer(View view) {
        answer = random1 + random2;
        answerText.append(answer + "  ");

        answer = answer - random3;
        answerText.append(answer + "  ");

        answer = answer * random4;
        answerText.append(answer + "  ");

        finalAnswer = (float)answer/random5;
        answerText.append(String.valueOf(finalAnswer));

        answerText.append("    " + loops);
        loops++;
    }

    public void answeredIncorrect(View view) {
        if (loops < 5){
            generateQuestion(view);
        }else{
            finished();
        }
    }

    public void answeredcorrect(View view) {
        score++;
        if (loops < 5){
            generateQuestion(view);
        }else {
            finished();
        }
    }

    public void finished() {
        long stopTime = System.currentTimeMillis() - startTime;
        Log.w("myApp", " in finished()");
        results.setText("you got " + score + " correct in: " + ((stopTime / 1000) / 60) + ":" + (stopTime / 1000) % 60);
    }
}
