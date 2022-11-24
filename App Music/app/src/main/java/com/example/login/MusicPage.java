package com.example.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class MusicPage extends Fragment {
    FirebaseFirestore firestoreDb = FirebaseFirestore.getInstance();

    private RecyclerView recyclerView;
    private ArrayList<MusicGroup> parentModelClassArrayList = new ArrayList<>();
    private ArrayList<Song> childModelClassList = new ArrayList<>();
    private ArrayList<Song> recentlyList = new ArrayList<>();
    private ArrayList<Song> favoriteList = new ArrayList<>();
    private ArrayList<Song> latestList = new ArrayList<>();
    private MusicGroupAdapter parentAdapter;

    public MusicPage() {
        // Required empty public constructor
        fetchSongs(latestList);
        fetchSongs(recentlyList);
        fetchSongs(favoriteList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_parent);
        parentAdapter = new MusicGroupAdapter(parentModelClassArrayList, getContext());

        parentModelClassArrayList.add(new MusicGroup("Latest List", latestList));
        parentModelClassArrayList.add(new MusicGroup("Recently List",recentlyList));
        parentModelClassArrayList.add(new MusicGroup("Favorite List",favoriteList));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(parentAdapter);

        parentAdapter.notifyDataSetChanged();
    }

    public void fetchSongs(ArrayList<Song> songList) {
        firestoreDb.collection("songs")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> data = document.getData();
                                songList.add(new Song(
                                        (String) data.get("image"),
                                        (String) data.get("name"),
                                        (String) data.get("description")
                                ));
                                parentAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}