package cs246.fencing_tournament.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs246.fencing_tournament.R;
import cs246.fencing_tournament.data.ContestantData;
import cs246.fencing_tournament.data.MatchData;

public class Match_Driver extends AppCompatActivity {

    private List<ContestantData> contestants;
    private boolean canUpdate = true;
    private ContestantData p1;
    private ContestantData p2;
    private MatchData thisMatch;
    public static final String TAG = "MatchDriver";

    // These two are needed, in order to pass the match back to the pool screen.
    private int poolNum, matchNum;

    public void callMatch(View v) {
        Intent action = new Intent(Match_Driver.this, MatchScreen.class);

        action.putParcelableArrayListExtra("ContestantsArray",(ArrayList<ContestantData>)contestants);
        startActivity(action);
        finish();
    }

    public void vic1(View v){
        CheckBox p2Vic = (CheckBox) findViewById(R.id.p2Vic);
        if (canUpdate){
            thisMatch.setVicId(thisMatch.getId1());
        }
        p2Vic.setChecked(false);
    }

    public void vic2(View v){
        CheckBox p1Vic = (CheckBox) findViewById(R.id.p1Vic);
        if (canUpdate){
            thisMatch.setVicId(thisMatch.getId2());
        }
        p1Vic.setChecked(false);
    }

    public void update(View v) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("ContestantsArray",
                (ArrayList<ContestantData>) contestants);
        intent.putExtra("Match", thisMatch);
        intent.putExtra("PoolNum", poolNum);
        intent.putExtra("MatchNum", matchNum);

        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match__driver);

        contestants = getIntent().getParcelableArrayListExtra("ContestantsArray");
        thisMatch = getIntent().getParcelableExtra("Match");
        poolNum = getIntent().getIntExtra("PoolNum", -1);
        matchNum = getIntent().getIntExtra("MatchNum", -1);

        if (poolNum == -1)  Log.e(TAG, "Pool Num didn't get passed.");
        else Log.e(TAG, "POOL_NUM: " + poolNum);
        if (matchNum == -1) Log.e(TAG, "Match Num didn't get passed.");
        else Log.e(TAG, "MATCH_NUM: " + matchNum);

        if (thisMatch == null) {
            thisMatch = new MatchData(1,2);
            canUpdate = false;
        }
        if (contestants == null) {
            canUpdate = false;
        }

        Log.e(TAG, "P1 SCORE = " + thisMatch.getP1Score());
        Log.e(TAG, "P2 SCORE = " + thisMatch.getP2Score());

        if (canUpdate){
            p1 = ContestantData.findById(contestants,thisMatch.getId1());
            TextView name = (TextView) findViewById(R.id.p1Name);
            name.setText(p1.getName());
            p2 = ContestantData.findById(contestants,thisMatch.getId2());
            name = (TextView) findViewById(R.id.p2Name);
            name.setText(p2.getName());
        }

    }
}