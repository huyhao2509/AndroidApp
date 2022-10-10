package com.example.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link secondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class secondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public secondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment secondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static secondFragment newInstance(String param1, String param2) {
        secondFragment fragment = new secondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    private RecyclerView recyclerView;
    private ArrayList<ParentModelClass> parentModelClassArrayList;
    private ArrayList<ChildModelClass> childModelClassList;
    private ArrayList<ChildModelClass> recentlyList;
    private ArrayList<ChildModelClass> favoriteList;
    private ArrayList<ChildModelClass> latestList;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_parent);
        parentModelClassArrayList=new ArrayList<>();
        childModelClassList=new ArrayList<>();
        recentlyList=new ArrayList<>();
        favoriteList=new ArrayList<>();
        latestList=new ArrayList<>();
        ParentAdapter parentAdapter;


        latestList.add(new ChildModelClass(R.drawable.img1));
        latestList.add(new ChildModelClass(R.drawable.img12));
        latestList.add(new ChildModelClass(R.drawable.img3));
        latestList.add(new ChildModelClass(R.drawable.img4));
        latestList.add(new ChildModelClass(R.drawable.img5));
        latestList.add(new ChildModelClass(R.drawable.img6));
        parentModelClassArrayList.add(new ParentModelClass("Latest List",latestList));

        recentlyList.add(new ChildModelClass(R.drawable.img7));
        recentlyList.add(new ChildModelClass(R.drawable.img8));
        recentlyList.add(new ChildModelClass(R.drawable.img9));
        recentlyList.add(new ChildModelClass(R.drawable.img10));
        recentlyList.add(new ChildModelClass(R.drawable.img11));
        recentlyList.add(new ChildModelClass(R.drawable.img12));
        parentModelClassArrayList.add(new ParentModelClass("Recently List",recentlyList));

        favoriteList.add(new ChildModelClass(R.drawable.img8));
        favoriteList.add(new ChildModelClass(R.drawable.img14));
        favoriteList.add(new ChildModelClass(R.drawable.img15));
        favoriteList.add(new ChildModelClass(R.drawable.img1));
        favoriteList.add(new ChildModelClass(R.drawable.img7));
        favoriteList.add(new ChildModelClass(R.drawable.img7));
        parentModelClassArrayList.add(new ParentModelClass("Favorite List",favoriteList));


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        parentAdapter=new ParentAdapter(parentModelClassArrayList, getContext());
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();

    }
}