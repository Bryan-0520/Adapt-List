package com.example.recyclerview;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{

    private ArrayList<Contact> dataList;

    public ListAdapter(ArrayList<Contact> dataList) {
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
    Contact contact = dataList.get(position);
    holder.textViewName.setText(contact.name);
    holder.textViewPhoneNumber.setText(contact.number);

    holder.constraintLayout.setOnClickListener(v ->{
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + contact.number));
        v.getContext().startActivity(intent);

    });

}

@Override
public int getItemCount() {
    return dataList.size();
}

static class ListViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewPhoneNumber;

    ConstraintLayout constraintLayout;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textView);
        textViewPhoneNumber = itemView.findViewById(R.id.textView2);
        constraintLayout = itemView.findViewById(R.id.item_id);
    }
}
}
