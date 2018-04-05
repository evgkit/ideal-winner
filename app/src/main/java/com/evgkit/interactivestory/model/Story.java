package com.evgkit.interactivestory.model;


import com.evgkit.interactivestory.R;

import java.util.Arrays;

public class Story {
    private static final int NUMBER_OF_PAGES = 7;

    private Page[] pages = new Page[NUMBER_OF_PAGES];

    public Story() {
        pages[0] = new Page(
                0,
                R.drawable.page0,
                R.string.page0,
                Arrays.asList(
                        new Choice(R.string.page0_choice1, 3),
                        new Choice(R.string.page0_choice2, 4)
                )
        );

        pages[1] = new Page(
                1,
                R.drawable.page1,
                R.string.page1,
                Arrays.asList(
                        new Choice(R.string.page1_choice1, 3),
                        new Choice(R.string.page1_choice2, 4)
                )
        );

        pages[2] = new Page(
                2,
                R.drawable.page2,
                R.string.page2,
                Arrays.asList(
                        new Choice(R.string.page2_choice1, 4),
                        new Choice(R.string.page2_choice2, 6)
                )
        );

        pages[3] = new Page(
                3,
                R.drawable.page3,
                R.string.page3,
                Arrays.asList(
                        new Choice(R.string.page3_choice1, 4),
                        new Choice(R.string.page3_choice2, 5)
                )
        );

        pages[4] = new Page(
                4,
                R.drawable.page4,
                R.string.page4,
                Arrays.asList(
                        new Choice(R.string.page4_choice1, 5),
                        new Choice(R.string.page4_choice2, 6)
                )
        );

        pages[5] = new Page(
                5,
                R.drawable.page5,
                R.string.page5
        );

        pages[6] = new Page(
                6,
                R.drawable.page6,
                R.string.page6
        );
    }

    public Page getPage(int pageNumber) {
        if (pageNumber < 0 || NUMBER_OF_PAGES <= pageNumber ) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }
}
