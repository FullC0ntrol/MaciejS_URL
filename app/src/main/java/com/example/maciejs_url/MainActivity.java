package com.example.maciejs_url;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL_1 = "https://picsum.photos/200/300";
    private static final String IMAGE_URL_2 = "https://picsum.photos/200/301";
    private static final String IMAGE_URL_3 = "https://picsum.photos/200/302";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja elementów UI
        TextView titleTextView = findViewById(R.id.titleTextView);
        EditText urlEditText = findViewById(R.id.urlEditText);
        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        MaterialButton button1 = findViewById(R.id.button1);
        MaterialButton button2 = findViewById(R.id.button2);
        MaterialButton button3 = findViewById(R.id.button3);
        MaterialButton loadUrlButton = findViewById(R.id.loadUrlButton);

        // Odbieranie danych z Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imageUrl = intent.getStringExtra("imageUrl");
        if (title != null) {
            titleTextView.setText(title);
        }

        // Ładowanie obrazka z Intent (jeśli istnieje)
        if (imageUrl != null) {
            if (imageUrl.equals(IMAGE_URL_1) || imageUrl.startsWith("http")) {
                Glide.with(this).load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(imageView1);
            } else if (imageUrl.equals(IMAGE_URL_2)) {
                Glide.with(this).load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(imageView2);
            } else if (imageUrl.equals(IMAGE_URL_3)) {
                Glide.with(this).load(imageUrl)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(imageView3);
            }
        }

        // Obsługa przycisku do ładowania wpisanego URL
        loadUrlButton.setOnClickListener(v -> {
            String customUrl = urlEditText.getText().toString().trim();
            if (!customUrl.isEmpty()) {
                Intent newIntent = new Intent(MainActivity.this, MainActivity.class);
                newIntent.putExtra("title", "Własny obrazek");
                newIntent.putExtra("imageUrl", customUrl);
                newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(newIntent);
            }
        });

        // Obsługa przycisku 1
        button1.setOnClickListener(v -> {
            Intent newIntent = new Intent(MainActivity.this, MainActivity.class);
            newIntent.putExtra("title", "Obrazek 1");
            newIntent.putExtra("imageUrl", IMAGE_URL_1);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
        });

        // Obsługa przycisku 2
        button2.setOnClickListener(v -> {
            Intent newIntent = new Intent(MainActivity.this, MainActivity.class);
            newIntent.putExtra("title", "Obrazek 2");
            newIntent.putExtra("imageUrl", IMAGE_URL_2);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
        });

        // Obsługa przycisku 3
        button3.setOnClickListener(v -> {
            Intent newIntent = new Intent(MainActivity.this, MainActivity.class);
            newIntent.putExtra("title", "Obrazek 3");
            newIntent.putExtra("imageUrl", IMAGE_URL_3);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
        });
    }
}