package com.rohan.user.sharedpreferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
EditText text1,text2;
    Button click,get;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    SharedPreferences mypref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(EditText)findViewById(R.id.text1);
        text2 = (EditText) findViewById(R.id.text2);
        click = (Button)findViewById(R.id.click);
        get = (Button) findViewById(R.id.get);
        mypref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1= text1.getText().toString();
                String str2 = text2.getText().toString();
                SharedPreferences.Editor editor = mypref.edit();

                editor.putString(Name, str1);

                editor.putString(Email, str2);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks", Toast.LENGTH_LONG).show();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, ?> myData = mypref.getAll();
                Object prefObj;
                Object prefValue = null;

                for (String key : myData.keySet()) {

                    prefValue = mypref.getString(key,"Data");

//                    if (prefObj instanceof String) prefValue = mypref.getString(key, "STRING_ERROR");
//                    if (prefObj instanceof Integer) prefValue = mypref.getInt(key, "INT_ERROR");
//                    // ...
//                    if (prefObj instanceof Set) prefValue = mypref.getStringSet(key, "SET_ERROR");

                    Log.i(String.format("Shared Preference : %s - %s", mypref, key),
                            String.valueOf(prefValue));
                }
            }
        });
    }
}
