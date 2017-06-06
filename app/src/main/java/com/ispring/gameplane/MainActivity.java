package com.ispring.gameplane;

import android.app.Activity;
import android.text.TextUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements Button.OnClickListener {
    private EditText username = null;
    private EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if(TextUtils.isEmpty(username.getText())){
            //设置提示
            Toast toast=Toast.makeText(getApplicationContext(), "Username is empty.", Toast.LENGTH_SHORT);
            toast.show();
            return;
            }
        if(TextUtils.isEmpty(password.getText())){
            Toast toast=Toast.makeText(getApplicationContext(), "Password is empty.", Toast.LENGTH_SHORT);
            toast.show();
            return;
            }
        if(viewId == R.id.btnGame && username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")){
            startGame();
        }
        else {
            Toast toast=Toast.makeText(getApplicationContext(), "Incorrect username or password.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }

    public void startGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}