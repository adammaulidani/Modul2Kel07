package com.example.notebook.modul2kel07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editUserActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private User usermodel;
    private EditText etUsernameRegister1, etPasswordLama, etPasswordBaru;
    private Button btEdit;
    private String username1, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        initview();
        bacadata();
    }

    private void bacadata() {
        btEdit.setOnClickListener(V ->
                initDataHandler()
        );
    }

    private void initview() {
        etUsernameRegister1 = findViewById(R.id.etUsernameRegister1);
        etPasswordLama = findViewById(R.id.etPasswordLama);
        etPasswordBaru = findViewById(R.id.etPasswordBaru);
        btEdit = findViewById(R.id.btnEdit);
    }

    private void initUser() {
        username1 = etUsernameRegister1.getText().toString();
        password1 = etPasswordLama.getText().toString();
        password2 = etPasswordBaru.getText().toString();

        usermodel = new User();
        usermodel.setPassword(password2);
        usermodel.setUsername(username1);
    }

    private void initDataHandler() {
        initUser();

        databaseHandler = new DatabaseHandler(this);
        databaseHandler.updateMahasiswa(usermodel);
        User model = databaseHandler.getMahasiswa(1);
        Log.e("record", model.getUsername().toString());
        Intent admin = new Intent(editUserActivity.this, LoginActivity.class);
        startActivity(admin);
        finish();
    }
}