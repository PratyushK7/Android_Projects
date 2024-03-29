package com.example.testapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender < 5)
                    sGender = getString(R.string.Female);
                else
                    sGender = getString(R.string.Male);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality == 0)
                    sNationality = getString(R.string.sa_citizen);
                else
                    sNationality = getString(R.string.foreign_citizen);

                String Text = getString(R.string.dob) + dob + "\n" +
                        getString(R.string.gender) + sGender + "\n" +
                        getString(R.string.nationality) + sNationality;

                tvResults.setText(Text);
            }
        });
    }


}
