package com.shairlook.shairlook_v1;

/**
 * Created by kristian on 12/04/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MemberActivity extends Activity {
    Button btnLogin;
    Button btnRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        //txtUserName = (EditText) findViewById(R.id.et_email);
        //txtPassword = (EditText) findViewById(R.id.et_school);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_reg);

        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View a) {

                Intent i = new Intent(MemberActivity.this, LoginActivity.class);
                startActivity(i);

                } //catch (Exception e) {
                        //Toast.makeText(MemberActivity.this, "Some problem occurred",
                                //Toast.LENGTH_LONG).show();

                    //}

                });


        btnRegister.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

        Intent b = new Intent(MemberActivity.this, RegisterMember.class);
        startActivity(b);

        } //catch (Exception e) {
            //Toast.makeText(MemberActivity.this, "Some problem occurred",
            //Toast.LENGTH_LONG).show();

            //}

    });
}}

