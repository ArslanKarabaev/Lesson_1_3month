package com.example.lesson_1_3month;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private Button btn_send;
    private EditText et_email;
    private EditText et_letter;
    private EditText et_theme;
    private final int openGmail = 283;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener(){
    btn_send.setOnClickListener(view -> {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{et_email.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, et_theme.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, et_letter.getText().toString());
        startActivity(intent);
    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == openGmail && resultCode == RESULT_OK && data != null){

        }
    }

    private void initView(){
        btn_send = findViewById(R.id.btn_send);
        et_email = findViewById(R.id.et_email);
        et_letter = findViewById(R.id.et_letter);
        et_theme = findViewById(R.id.et_theme);
    }
}
