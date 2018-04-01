package com.evgkit.interactivestory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = this.getIntent();
        String playerName = intent.getStringExtra(getString(R.string.key_name));
        Toast.makeText(this, playerName, Toast.LENGTH_SHORT).show();
        Log.d(TAG, playerName);
    }
}
