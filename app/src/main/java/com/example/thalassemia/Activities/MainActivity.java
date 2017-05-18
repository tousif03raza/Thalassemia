package com.example.thalassemia.Activities;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thalassemia.Models.Student;
import com.example.thalassemia.ORM.DbHelper;
import com.example.thalassemia.R;

public class MainActivity extends AppCompatActivity {


    EditText ea,eb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView txtTitle=(TextView)findViewById(R.id.txtTitle);
        txtTitle.setTypeface(Typeface.createFromAsset(this.getAssets(), "Quicksand-Regular.otf"));

        Button btnRegister=(Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), Register.class);
                    startActivity(intent);
            }
            });

        ea=(EditText)findViewById(R.id.editEmail);
        eb=(EditText)findViewById(R.id.editpass) ;

        btnRegister.setTypeface(Typeface.createFromAsset(this.getAssets(), "Quicksand-Bold.otf"));
        ((TextView)findViewById(R.id.txtNotRegister)).setTypeface(Typeface.createFromAsset(this.getAssets(), "Quicksand-Regular.otf"));
        Button btnLogin=(Button)(findViewById(R.id.btnLogin));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s = ea.getText().toString();
                String s1 = eb.getText().toString();
                Student student=new DbHelper(v.getContext()).getStudent();
                if (student.getEmail().equals(s)&&student.getPassword().equals(s1)) {
                    Intent intent = new Intent(v.getContext(), QuestionareActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
