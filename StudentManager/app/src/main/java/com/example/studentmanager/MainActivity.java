package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<StudentModel> students = StudentData.getStudentData();
        ListView listView = findViewById(R.id.listStudent);
        StudentAdapter adapter = new StudentAdapter(students,this);
        listView.setAdapter(adapter);

        String path = getFilesDir() + "/mydb";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        createTable();
    }

    public void createTable() {
        db.beginTransaction();
        try {
            db.execSQL("create table tblSTUDENT(" +
                    "id integer PRIMARY KEY autoincrement," +
                    "studentId text," +
                    "name text," +
                    "email text, birth text)");

            db.execSQL("insert into tblSTUDENT(studentId, name, email, birth) values('20183764', 'Huy', '', '')");
            db.execSQL("insert into tblSTUDENT(studentId, name, email, birth) values('20183764', 'Huy', '', '')");
            db.execSQL("insert into tblSTUDENT(studentId, name, email, birth) values('20183764', 'Huy', '', '')");

            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}