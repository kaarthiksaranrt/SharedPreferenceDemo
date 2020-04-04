package com.example.dwis.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.edit1);
        age=(EditText)findViewById(R.id.edit2);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp=getSharedPreferences("MySharedPref",MODE_PRIVATE);

        SharedPreferences.Editor edit=sp.edit();

        edit.putString("name",name.getText().toString());
        edit.putInt("age",Integer.parseInt(age.getText().toString()));

        edit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp2=getSharedPreferences("MySharedPref",MODE_PRIVATE);
        String s1=sp2.getString("name","");
        int a=sp2.getInt("age",0);
        name.setText(s1);
        age.setText(String.valueOf(a));
    }
}
