package com.example.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicGroupAdapter extends RecyclerView.Adapter<MusicGroupAdapter.ViewHolder> {

    List<MusicGroup> parentModelClassList;
    Context context;

    public MusicGroupAdapter(List<MusicGroup> parentModelClassList, Context context) {
        this.parentModelClassList = parentModelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public MusicGroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.music_group, null,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicGroupAdapter.ViewHolder holder, int position) {
            holder.tv_parent_title.setText(parentModelClassList.get(position).tittle);

            SongAdapter childAdapter;
            childAdapter = new SongAdapter(parentModelClassList.get(position).childModelClassList, context);
            holder.rv_child.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            holder.rv_child.setAdapter(childAdapter);
            childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentModelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_parent_title;
        RecyclerView rv_child;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_parent_title=itemView.findViewById(R.id.tv_parent_title);
            rv_child = itemView.findViewById(R.id.rv_child);
        }
    }
}
