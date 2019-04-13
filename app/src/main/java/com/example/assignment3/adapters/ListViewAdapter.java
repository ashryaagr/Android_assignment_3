package com.example.assignment3.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment3.R;
import com.example.assignment3.models.contact;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter {
    List<contact> contacts ;
    Activity context;

    public ListViewAdapter(Activity context, List objects) {
        super(context, R.layout.item_view, objects);
        this.context = context ;
        this.contacts = objects ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater() ;
        View v = (View) inflater.inflate(R.layout.item_view, null, false);
        TextView name = v.findViewById(R.id.name) ;
        TextView number = v.findViewById(R.id.number);
        TextView email_id = v.findViewById(R.id.email_id);
        name.setText(contacts.get(position).getName());
        number.setText(contacts.get(position).getNumber());
        email_id.setText(contacts.get(position).getEmail_id());
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You can contact this guy for support", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
