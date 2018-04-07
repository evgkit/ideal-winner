package com.evgkit.interactivestory.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evgkit.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerName = String.valueOf(nameInput.getText());
                startStory(playerName);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameInput.setText("");
    }

    private void startStory(String playerName) {
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), playerName);
        startActivity(intent);
    }
}
