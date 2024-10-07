package com.form.advancedformvalidationapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPhone, editTextPassword, editTextConfirmPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Powiązanie widoków z kodem
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Obsługa kliknięcia przycisku
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    // Walidacja formularza
    private void validateForm() {
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            showToast("Proszę wprowadzić imię");
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            showToast("Proszę wprowadzić nazwisko");
            return;
        }

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Proszę wprowadzić poprawny adres e-mail");
            return;
        }

        if (TextUtils.isEmpty(phone) || phone.length() < 9) {
            showToast("Proszę wprowadzić poprawny numer telefonu (co najmniej 9 cyfr)");
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            showToast("Hasło musi mieć co najmniej 6 znaków");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showToast("Hasła się nie zgadzają");
            return;
        }

        showToast("Formularz przesłany poprawnie");
    }

    // Funkcja pomocnicza do wyświetlania komunikatów Toast
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}