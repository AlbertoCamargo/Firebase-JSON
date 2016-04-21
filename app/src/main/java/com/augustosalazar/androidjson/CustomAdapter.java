package com.augustosalazar.androidjson;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;

import java.util.List;

public class CustomAdapter extends BaseAdapter implements View.OnClickListener {

    private final Context context;
    private List<DataSnapshot> listEntries;

    public CustomAdapter(Context context, List<DataSnapshot> listEntries) {
        this.context = context;
        this.listEntries = listEntries;
    }

    @Override
    public int getCount() {
        return listEntries.size();
    }

    @Override
    public Object getItem(int position) {
        return listEntries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataSnapshot entry = listEntries.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout, null);
        }

        TextView f1 = (TextView) convertView.findViewById(R.id.tvField1);
        TextView f2 = (TextView) convertView.findViewById(R.id.tvField2);

        f1.setText(entry.child("user").child("fistName").getValue().toString());
        f2.setText(entry.child("user").child("lastName").getValue().toString());

        DataEntry dataEntry = new DataEntry();
        dataEntry.setFistName(entry.child("user").child("fistName").getValue().toString());
        dataEntry.setLastName(entry.child("user").child("lastName").getValue().toString());
        dataEntry.setGender(entry.child("user").child("gender").getValue().toString());
        dataEntry.setPicture(entry.child("user").child("picture").getValue().toString());

        convertView.setTag(dataEntry);

        Button delete = (Button) convertView.findViewById(R.id.delete);
        delete.setFocusableInTouchMode(false);
        delete.setFocusable(false);
        delete.setTag(entry);



        return convertView;
    }

    @Override
    public void onClick(View v) {
    }
}
