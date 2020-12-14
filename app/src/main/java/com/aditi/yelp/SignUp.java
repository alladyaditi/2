package com.aditi.yelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SignUp  extends AppCompatActivity {
    EditText username, password, email, confirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username  = findViewById(R.id.user_name);
        email     = findViewById(R.id.email);
        password  = findViewById(R.id.password);
        confirm   = findViewById(R.id.confirm_password);
    }


    /**
     *
     * @param view
     */
    public void signUp(View view){
        // sign the user into firebase firestore..

        /*String googleKey = "AIzaSyDSr2lN0Rw8xQRgl-bQE8dIIXRqsMhIRAE";
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
*/
    }
}
