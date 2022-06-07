package com.example.gmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GmailAdapter extends BaseAdapter {
    List<MailModel> mails;
    Context context;
    public GmailAdapter(Context context, List<MailModel> mails) {
        this.mails = mails;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mails.size();
    }

    @Override
    public Object getItem(int i) {
        return mails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.gmail_item, null);
            viewHolder = new MyViewHolder();
            viewHolder.addressText = view.findViewById(R.id.address);
            viewHolder.topicText = view.findViewById(R.id.topic);
            viewHolder.contentText = view.findViewById(R.id.content);
            viewHolder.time = view.findViewById(R.id.time);
            viewHolder.avatar = view.findViewById(R.id.avatar);
            viewHolder.star = view.findViewById(R.id.star);
            view.setTag(viewHolder);
        } else
            viewHolder = (MyViewHolder) view.getTag();
        MailModel mail = mails.get(i);
        viewHolder.addressText.setText(mail.name);
        viewHolder.topicText.setText(mail.topic);
        viewHolder.contentText.setText(mail.content);

        if (mail.content.length() > 35){
            viewHolder.contentText.setText(mail.content.substring(0, 35) + "...");
        }
        if (mail.topic.length() > 30){
            viewHolder.topicText.setText(mail.topic.substring(0,30)+"...");
        }
        if (mail.name.length() > 15){
            viewHolder.addressText.setText(mail.name.substring(0,15)+"...");
        }

        viewHolder.time.setText(mail.time);
        viewHolder.avatar.setText(String.valueOf(viewHolder.addressText.getText().charAt(0)));
        viewHolder.avatar.setStrokeWidth(1);

        switch (viewHolder.avatar.getText().toString()){
            case "A":
                viewHolder.avatar.setStrokeColor("#F22970");
                viewHolder.avatar.setSolidColor("#F22970");
                break;
            case "B":
                viewHolder.avatar.setStrokeColor("#4291EB");
                viewHolder.avatar.setSolidColor("#4291EB");
                break;
            case "C":
                viewHolder.avatar.setStrokeColor("#AC17D1");
                viewHolder.avatar.setSolidColor("#AC17D1");
                break;
            case "D":
                viewHolder.avatar.setStrokeColor("#D16E17");
                viewHolder.avatar.setSolidColor("#D16E17");
                break;
            case "E":
                viewHolder.avatar.setStrokeColor("#5EB8A3");
                viewHolder.avatar.setSolidColor("#5EB8A3");
                break;
            case "H":
                viewHolder.avatar.setStrokeColor("#BD8C94");
                viewHolder.avatar.setSolidColor("#BD8C94");
                break;
            case "Y":
                viewHolder.avatar.setStrokeColor("#267360");
                viewHolder.avatar.setSolidColor("#267360");
                break;
            case "M":
                viewHolder.avatar.setStrokeColor("#5FE85D");
                viewHolder.avatar.setSolidColor("#5FE85D");
                break;
            default:
                viewHolder.avatar.setStrokeColor("#998E85");
                viewHolder.avatar.setSolidColor("#998E85");
        }
        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            boolean isFull = false;
            @Override
            public void onClick(View view) {
                if (!isFull)
                {
                    viewHolder.star.setImageResource(R.drawable.star_full);
                    isFull = true;
                } else {
                    viewHolder.star.setImageResource(R.drawable.star_empty);
                    isFull = false;
                }
            }
        });
        return view;
    }
    class MyViewHolder{
        TextView addressText;
        TextView topicText;
        TextView contentText;
        TextView time;
        CircularTextView avatar;
        ImageView star;
    }
}
