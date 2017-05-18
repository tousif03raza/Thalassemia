package com.example.thalassemia.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.thalassemia.*;
import com.example.thalassemia.Models.Student;
import com.example.thalassemia.ORM.DbHelper;

public class Register extends AppCompatActivity {
    EditText editEmail,editName,editPassword,editConfirmPassword;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        editEmail=(EditText)findViewById(R.id.editEmail);
        editName=(EditText) findViewById(R.id.editName);
        editPassword=(EditText)findViewById(R.id.editPassword);
        editConfirmPassword=(EditText)findViewById(R.id.editPassword1);

        editConfirmPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (editPassword.getText()!=editConfirmPassword.getText()){
                    editConfirmPassword.setError("Password should be same");
                }
            }
        });

        final RadioGroup radioGroupGender=(RadioGroup)findViewById(R.id.radioGroupGender);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student=new Student();
                student.setName(editName.getText().toString());
                student.setPassword(editPassword.getText().toString());
                student.setEmail(editEmail.getText().toString());
                String gender=((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
                student.setGender(gender);
                new DbHelper(v.getContext()).insertStudent(student);
                Toast.makeText(v.getContext(), "You have successfully registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(v.getContext(),MainActivity.class));
            }
        });

    }
}
