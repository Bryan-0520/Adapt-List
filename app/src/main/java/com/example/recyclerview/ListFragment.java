package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater. inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    public void init(@NonNull View view){
        RecyclerView recyclerView = view.findViewById(R.id.List_id);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        ListAdapter adapter = new  ListAdapter(getNameList());

        recyclerView.setAdapter(adapter);


        RecyclerView.ItemDecoration divider = new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(divider);



    }

    private ArrayList<Contact> getNameList(){
        ArrayList<Contact> dataList = new ArrayList<>();
        dataList.add(new Contact("3435234", "Bryan"));
        return dataList;
    }
}
