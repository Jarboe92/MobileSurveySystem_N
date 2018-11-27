package com.example.yewang.mobilesurveysystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Group-project";
    private static final int LOG_IN_REQUEST = 0;
    private FirebaseDatabase database;
    private String user;
    private Button login;
    private Button qrScan;
    private Button viewSurveys;
    private Button createSurvey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.log_in_button);
        qrScan = findViewById(R.id.scan_qr_button);
        viewSurveys = findViewById(R.id.view_survey_button);
        createSurvey = findViewById(R.id.create_survey_button);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i(TAG, "LAUNCHING LOG_IN_REQUEST");
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, LOG_IN_REQUEST);
            }
        });

        qrScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        viewSurveys.setVisibility(View.INVISIBLE);
        viewSurveys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        createSurvey.setVisibility(View.INVISIBLE);
        createSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SurveryWizard.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOG_IN_REQUEST) {
            if (resultCode == RESULT_OK) {
                user = data.getStringExtra("user");
                viewSurveys.setVisibility(View.VISIBLE);
                createSurvey.setVisibility(View.VISIBLE);
            }
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
}
