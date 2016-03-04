package com.mac.chris.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    TextView tv;
    Button b;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("MySettings", MODE_PRIVATE);

        edt = (EditText) findViewById(R.id.editText);
        tv = (TextView) findViewById(R.id.savedText);
        tv.setText(settings.getString("SET","not there"));

    }

    public void save (View v) {
        SharedPreferences.Editor editor = settings.edit();
        String text = edt.getText().toString();
        editor.putString("SET", edt.getText().toString());
        editor.commit();
        tv.setText(edt.getText().toString());

        Log.d("Shared Preferences", "Saved Settings");

//        try {
//            int c;
//            FileInputStream fIn = openFileInput("file.txt");
//            StringBuilder temp = new StringBuilder();
//            while ((c = fIn.read()) != -1) {
//                temp.append((char) c);
//            }
//            fIn.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
