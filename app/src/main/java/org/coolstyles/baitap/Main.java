package org.coolstyles.baitap;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.coolstyles.baitap.Constants;

public class Main extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGUI();
    }

    private void initGUI() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClick();
            }
        });
    }

    public void onLoginButtonClick() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(Main.this, "Vui lòng nhập Email và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.equals(Constants.VALID_EMAIL) && password.equals(Constants.VALID_PASSWORD)) {
            Intent myIntent = new Intent(Main.this, Home.class);
            myIntent.putExtra(Constants.PRODUCT_ID, 1);
            startActivity(myIntent);

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(btnLogin.getWindowToken(), 0);
        } else {
            Toast.makeText(Main.this, "Nhập sai Email hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }
}