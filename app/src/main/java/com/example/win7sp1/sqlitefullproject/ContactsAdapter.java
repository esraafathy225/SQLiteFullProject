package com.example.win7sp1.sqlitefullproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    ArrayList<Contact> contacts;
    Context context;
    ContactListener contactListener;

    public ContactsAdapter(ArrayList<Contact> contacts, Context context,ContactListener contactListener) {
        this.contacts = contacts;
        this.context = context;
        this.contactListener=contactListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_row,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Contact currentContact=contacts.get(position);
        holder.nameTV.setText(currentContact.getName());
        holder.phoneTV.setText(currentContact.getPhone());

        if(contactListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contactListener.onContactClicked(currentContact.getId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nameTV,phoneTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=(TextView) itemView.findViewById(R.id.txt);
            phoneTV=(TextView) itemView.findViewById(R.id.txt2);
        }
    }
}
