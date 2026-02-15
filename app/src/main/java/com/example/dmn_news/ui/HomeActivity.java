package com.example.dmn_news.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loadData();
    }

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;

    private void loadData(){
        String url = "https://jsonplaceholder.typicode.com/posts";

        StringRequest request = new StringRequest(Request.Method.GET, url ,
                response -> {
                    List<Article> articles = GsonHelper.parseJson(response);
                    adapter = new ArticleAdapter(articles);
                    recyclerView.setAdapter(adapter);
                },
                error -> {
                    Toast.makeText(this, "Connection Error !", Toast.LENGTH_SHORT).show();
                }
                );
        VolleyHelper.getInstance(this).addToRequestQueue(request);
    }

}