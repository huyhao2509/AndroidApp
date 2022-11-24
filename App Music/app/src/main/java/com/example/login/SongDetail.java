package com.example.login;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class SongDetail extends AppCompatActivity {
    private ImageView imageView;
    private TextView textViewName, textViewDescribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null)
        {
            return;
        }
        Song childModelClass = (Song) bundle.get("object");

        imageView = findViewById(R.id.img_detail);
        textViewName = findViewById(R.id.tv_name);
        textViewDescribe = findViewById(R.id.tv_describe);

        this.loadImage(childModelClass.image);
        textViewName.setText(childModelClass.name);
        textViewDescribe.setText(childModelClass.describe);

    }

    public void loadImage(String url) {
        Picasso.get()
                .load(url)
                .into(imageView);
    }
}