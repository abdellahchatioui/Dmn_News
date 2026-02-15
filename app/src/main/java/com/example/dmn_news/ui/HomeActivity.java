package com.example.dmn_news.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.dmn_news.R;
import com.example.dmn_news.adapters.ArticleAdapter;
import com.example.dmn_news.helpers.GsonHelper;
import com.example.dmn_news.helpers.VolleyHelper;
import com.example.dmn_news.models.Article;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //grid layout
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        loadData();

    }

    private void loadData() {
        String url = "https://jsonplaceholder.typicode.com/posts";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                response -> {
                    List<Article> articles = GsonHelper.parseJson(response);
                    adapter = new ArticleAdapter(articles);
                    recyclerView.setAdapter(adapter);
                },
                error -> {
                    Toast.makeText(this, "Erreur réseau", Toast.LENGTH_SHORT).show();
                }
        );

        VolleyHelper.getInstance(this).addToRequestQueue(request);
    }

}