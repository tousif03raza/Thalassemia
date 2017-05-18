package com.example.thalassemia.ORM;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.thalassemia.Models.Student;

/**
 * Created by Tousif on 1/18/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
String str="Create table Student(Name text,Email text,Password text,Gender text)";

    public DbHelper(Context context) {
        super(context, "MyDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertStudent(Student student){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",student.getName());
        contentValues.put("Email",student.getEmail());
        contentValues.put("Password",student.getPassword());
        contentValues.put("Gender",student.getGender());
        db.insert("Student",null,contentValues);
    }

    public Student getStudent(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select *from Student",null);
        cursor.moveToFirst();
        Student student=new Student();
        student.setName(cursor.getString(cursor.getColumnIndex("Name")));
        student.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
        student.setPassword(cursor.getString(cursor.getColumnIndex("Password")));
        student.setGender(cursor.getString(cursor.getColumnIndex("Gender")));
        return student;
    }
}
