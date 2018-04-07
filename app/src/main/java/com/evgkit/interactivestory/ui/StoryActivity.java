package com.evgkit.interactivestory.ui;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.evgkit.interactivestory.R;
import com.evgkit.interactivestory.model.Page;
import com.evgkit.interactivestory.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
    private ImageView imageStory;
    private TextView textStory;
    private Button buttonChoice1;
    private Button buttonChoice2;

    private Story story;
    private String playerName;
    private Stack<Integer> pageStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = this.getIntent();
        playerName = intent.getStringExtra(getString(R.string.key_name));

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {
        pageStack.push(pageNumber);
        final Page page = story.getPage(pageNumber);
        buildImageAndText(page);
        buildButtons(page);
    }

    @Override
    public void onBackPressed() {
        if (0 == pageStack.peek()) {
            pageStack.removeAllElements();
            super.onBackPressed();
        } else {
            pageStack.pop();
            loadPage(pageStack.pop());
        }
    }

    private void buildImageAndText(Page page) {
        imageStory = findViewById(R.id.imageStory);
        imageStory.setImageDrawable(ContextCompat.getDrawable(this, page.getImageId()));

        textStory = findViewById(R.id.textStory);
        textStory.setText(
                String.format(
                        getString(page.getTextId()),
                        playerName
                )
        );
    }

    private void buildButtons(final Page page) {
        buttonChoice1 = findViewById(R.id.buttonChoice1);
        buttonChoice2 = findViewById(R.id.buttonChoice2);

        if (page.isFinalPage()) {
            buttonChoice1.setVisibility(View.INVISIBLE);

            buttonChoice2.setText(R.string.play_again_button_text);
            buttonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(0);
                }
            });
        } else {
            buttonChoice1.setVisibility(View.VISIBLE);
            buttonChoice1.setText(page.getChoices().get(0).getTextId());
            buttonChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(page.getChoices().get(0).getNextPageId());
                }
            });

            buttonChoice2.setVisibility(View.VISIBLE);
            buttonChoice2.setText(page.getChoices().get(1).getTextId());
            buttonChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(page.getChoices().get(1).getNextPageId());
                }
            });
        }
    }
}
