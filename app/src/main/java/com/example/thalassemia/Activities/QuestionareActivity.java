package com.example.thalassemia.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thalassemia.R;

import java.util.ArrayList;

public class QuestionareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        ListView listView=(ListView)findViewById(R.id.listViewQuestion);
        ArrayList<String> questionList=new ArrayList<String>();
        questionList.add("Introduce yourself?");
        questionList.add("What's ur name?");
        questionList.add("How r u?");
        questionList.add("What's up?");
        questionList.add("How u doin?");
        questionList.add("What's ur age?");
        questionList.add("Where do u work?");
        questionList.add("Why did u left ur last job?");
        questionList.add("What is ur goal?");
        questionList.add("What's ur dob?");
        questionList.add("Which is ur favourite song?");
        questionList.add("Who's ur favourite singer?");
        questionList.add("Who's ur favourite actor?");
        questionList.add("Who's ur favourite actress?");
        questionList.add("What is ur hobby?");
        questionList.add("What's ur college name?");
        questionList.add("What's ur favourite color?");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,questionList);
        listView.setAdapter(arrayAdapter);
    }
}
