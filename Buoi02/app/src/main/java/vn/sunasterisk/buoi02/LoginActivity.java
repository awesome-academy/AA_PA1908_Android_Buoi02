package vn.sunasterisk.buoi02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener {
    private Button buttonLogin;
    private TextView textSignUp;
    private EditText textUsername;
    private EditText textPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_login);

        initView();
        registerListener();
        /*findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });*/
    }

    private void registerListener() {
        buttonLogin.setOnClickListener(this);
        textSignUp.setOnClickListener(this);

        /*buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        LoginActivity.this,
                        "Login success!",
                        Toast.LENGTH_LONG
                )
                        .show();
                //login(v);
            }
        });*/
    }

    private void initView() {
        buttonLogin = findViewById(R.id.button_login);
        textSignUp = findViewById(R.id.text_sign_up);
        textUsername = findViewById(R.id.text_username_input);
        textPassword = findViewById(R.id.text_password_input);
    }

    /*public void login(View view) {
        Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                //Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();
                login();
                break;
            case R.id.text_sign_up:
                Toast.makeText(
                        this,
                        "Sign Up success!",
                        Toast.LENGTH_SHORT
                ).show();
                break;
            default:
                break;
        }
    }

    private void login() {
        String username = textUsername.getText().toString();
        String password = textPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                    this,
                    "username and password is not empty!",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (username.equals("nguyen.minh.tuan") && password.equals("123456")) {
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            openMainActivity();
        } else {
            Toast.makeText(this, "Login Failure!", Toast.LENGTH_SHORT).show();
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
