package cs246.fencing_tournament;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainScreen extends AppCompatActivity {

    public void viewContestants(View v) {

    }

    public void startPool(View v) {

    }

    public void startBracket(View v) {

    }

    public void setContestants(View v) {
        Intent action = new Intent(MainScreen.this, EnterContestant.class);
        startActivity(action);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
}