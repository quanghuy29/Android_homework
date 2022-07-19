package com.example.studentmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<StudentModel> students;
    Context context;

    public StudentAdapter(List<StudentModel> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.student_item,null);
            viewHolder = new MyViewHolder();
            viewHolder.studentIdView = view.findViewById(R.id.studentId);
            viewHolder.studentNameView = view.findViewById(R.id.studentName);
            view.setTag(viewHolder);
        }
        else
            viewHolder = (MyViewHolder) view.getTag();
        StudentModel student = students.get(i);
        viewHolder.studentNameView.setText(student.name);
        viewHolder.studentIdView.setText(student.studentId);
        return view;
    }
    class MyViewHolder{
        TextView studentIdView;
        TextView studentNameView;
    }
}
