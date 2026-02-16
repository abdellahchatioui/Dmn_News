package com.example.dmn_news.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dmn_news.R;

public class ArticleDetailsActivity extends AppCompatActivity {

    TextView txtTitle, txtBody;
    ImageView imgArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        txtTitle = findViewById(R.id.txtTitle);
        txtBody = findViewById(R.id.txtBody);
        imgArticle = findViewById(R.id.imgArticle);

        String title = getIntent().getStringExtra("title");
        String body = getIntent().getStringExtra("body");
        String image = getIntent().getStringExtra("image");

        txtTitle.setText(title);
        txtBody.setText(body);

        Glide.with(this)
                .load(image)
                .into(imgArticle);

        Button btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(v -> finish());
    }
}
