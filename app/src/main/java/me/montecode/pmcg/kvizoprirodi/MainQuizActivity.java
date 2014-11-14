package me.montecode.pmcg.kvizoprirodi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;


public class MainQuizActivity extends Activity implements View.OnClickListener {
    private DatabaseHelper db;
    private int previousQuestionId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_quiz_activity_layout);
        db = new DatabaseHelper(getApplicationContext());

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(getRandomQuestion().question);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    private QuestionItem getRandomQuestion() {
        int lastId = db.getLastQuestionItemId();

        Random randomForQuestion = new Random();
        int randomQuestionId = randomForQuestion.nextInt(lastId) + 1;
        while (randomQuestionId == previousQuestionId) {
            randomQuestionId = randomForQuestion.nextInt(lastId) + 1;
        }
        previousQuestionId = randomQuestionId;

        return db.getQuestion(randomQuestionId);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_quiz_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}
