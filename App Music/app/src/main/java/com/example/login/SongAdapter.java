package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class
SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    List<Song> childModelClassList;
    Context context;

    public SongAdapter(List<Song> childModelClassList, Context context) {
        this.childModelClassList = childModelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.music_thumbnail, null,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song childModelClass = childModelClassList.get(position);
        holder.loadImage(childModelClassList.get(position).image);
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickToDetail(childModelClass);
            }
        });
    }

    private void onClickToDetail(Song childModelClass)
    {
        Intent intent = new Intent(context, SongDetail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", childModelClass);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return childModelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_child_image;
        RelativeLayout layoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_child_image=itemView.findViewById(R.id.iv_child_item);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }

        public void loadImage(String url) {
            Picasso.get()
                    .load(url)
                    .into(iv_child_image);
        }
    }
}
