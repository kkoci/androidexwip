package com.shairlook.shairlook_v1;

/**
 * Created by kristian on 26/04/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterMember extends Activity implements OnItemSelectedListener{
    //DbAdapter dbAdapter;
    EditText txtName;
    EditText txtPassword;
    EditText txtPasswordConf;
    EditText txtEmail;
    EditText txtEmailConf;
    EditText txtSchool;
    Button btnJoin;
    Activity currentActivity;

    private String[] state= {"USB","Stanford","Harvard","UCV","USM","Tor vergata", "La Sapienza"};
    Spinner spinner_school;

    /**public void onFinish(){
        Intent intent = new Intent(RegisterMember.this, LoginActivity.class);
        startActivity(intent);
    }**/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_register);
        System.out.println(state.length);
        spinner_school = (Spinner) findViewById(R.id.spinner_school);
        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, state);
        adapter_state
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_school.setAdapter(adapter_state);
        spinner_school.setOnItemSelectedListener(this);
        currentActivity=this;
        txtName = (EditText) findViewById(R.id.et_user);
        txtPassword = (EditText) findViewById(R.id.et_pw_reg);
        txtPasswordConf = (EditText) findViewById(R.id.et_pw_conf);
        txtEmail = (EditText) findViewById(R.id.et_email_reg);
        txtEmailConf = (EditText) findViewById(R.id.et_email_conf);
        btnJoin = (Button) findViewById(R.id.btn_join);

        /**dbAdapter = new DbAdapter(this);
         dbAdapter.open();**/

        btnJoin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(txtName.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(txtPassword.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(txtPasswordConf.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(txtEmail.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(txtEmailConf.getWindowToken(), 0);
                //imm.hideSoftInputFromWindow(txtSchool.getWindowToken(), 0);
                //imm.hideSoftInputFromWindow(spinner_school.getWindowToken(), 0);

                String name = txtName.getText().toString();
                String password = txtPassword.getText().toString();
                String passwordconf = txtPasswordConf.getText().toString();
                String email = txtEmail.getText().toString();
                String emailconf = txtEmailConf.getText().toString();
                String school = spinner_school.getSelectedItem().toString();
                //long i = EndpointsAsyncTaskInsert(name, password, email, school);
                if ((txtName.length() == 0) || (txtEmail.length() == 0) || (txtPassword.length() == 0)) {
                    Toast.makeText(RegisterMember.this, "You need to provide values for Name, Email and Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Toast.makeText(RegisterMember.this, "You have successfully registered",Toast.LENGTH_LONG).show();
                else {
                    if (!passwordconf.equals(password)) {
                        Toast.makeText(getApplicationContext(), "Password Does Not Matches", Toast.LENGTH_LONG).show();
                    }
                    if (!emailconf.equals(email)) {
                        Toast.makeText(getApplicationContext(), "Email Does Not Matches", Toast.LENGTH_LONG).show();
                    }

                }
                //Go ahead and perform the transaction
                /**String[] params = {name,email,password,school};
                new EndpointsAsyncTaskInsert((OnTaskFinishListener) currentActivity).execute(params);**/
                try{  Intent k = new Intent(RegisterMember.this, LoginActivity.class);
                    startActivity(k);
                }catch(Exception e){

                }
                /**new EndpointsAsyncTaskInsert(LoginMember.this) {
                 protected void onPostExecute(User result) {
                 super.onPostExecute(result);
                 // Do something with result
                 Intent intent = new Intent(LoginMember.this, WelcomeScreen.class);
                 startActivity(intent);
                 }
                 }.execute(params);**/

            }


            /**catch (SQLException e) {
             Toast.makeText(RegisterMember.this, "Some problem occurred",
             Toast.LENGTH_LONG).show();

             }**/

        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        spinner_school.setSelection(position);
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    /**public void insertUser(View v) {
        new EndpointsAsyncTaskInsert(this).execute();
    }**/
}


