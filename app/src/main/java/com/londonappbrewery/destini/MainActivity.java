package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyText;
    Button buttonTop;
    Button buttonBottom;
    int mTopAnswerIndex = R.string.T1_Ans1;
    int mBottomAnswerIndex = R.string.T1_Ans2;

    Map<Integer, Integer> storyFlows = new HashMap<Integer, Integer>();
    Map<Integer, int[]> storyAnswers = new HashMap<Integer, int[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the story flow and answer here
        storyFlows.put(R.string.T1_Ans1, R.string.T3_Story);
        storyFlows.put(R.string.T1_Ans2, R.string.T2_Story);
        storyFlows.put(R.string.T2_Ans1, R.string.T3_Story);
        storyFlows.put(R.string.T2_Ans2, R.string.T4_End);
        storyFlows.put(R.string.T3_Ans1, R.string.T5_End);
        storyFlows.put(R.string.T3_Ans2, R.string.T6_End);

        storyAnswers.put(R.string.T1_Story, new int[] { R.string.T1_Ans1, R.string.T1_Ans2});
        storyAnswers.put(R.string.T2_Story, new int[] { R.string.T2_Ans1, R.string.T2_Ans2});
        storyAnswers.put(R.string.T3_Story, new int[] { R.string.T3_Ans1, R.string.T3_Ans2});

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = (TextView)findViewById(R.id.storyTextView);
        buttonTop = (Button)findViewById(R.id.buttonTop);
        buttonBottom = (Button)findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(mTopAnswerIndex);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStory(mBottomAnswerIndex);
            }
        });

        storyText.setText(R.string.T1_Story);
        buttonTop.setText(mTopAnswerIndex);
        buttonBottom.setText(mBottomAnswerIndex);
    }

    private void UpdateStory(int answer){
        int storyIndex = storyFlows.get(answer);
        storyText.setText(storyIndex);

        int[] answers = storyAnswers.get(storyIndex);
        if(answers != null) {
            //show the answers to top and bottom button
            mTopAnswerIndex = answers[0];
            mBottomAnswerIndex = answers[1];

            buttonTop.setText(mTopAnswerIndex);
            buttonBottom.setText(mBottomAnswerIndex);
        }
        else {
            //the end of story
            buttonTop.setVisibility(View.GONE);
            buttonBottom.setVisibility(View.GONE);
        }
    }
}
