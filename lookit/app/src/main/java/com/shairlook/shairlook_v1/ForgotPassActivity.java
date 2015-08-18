package com.shairlook.shairlook_v1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

/**
 * Created by kristian on 03/05/2015.
 */
public class ForgotPassActivity extends Activity {

    //DbAdapter dbAdapter;
    EditText et_email_forgot;
    Button btn_forgot;
    String emailAdd, beginning, name, stupidAction, hatefulAct, out;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);
        initializeVars();
        btn_forgot.setOnClickListener((View.OnClickListener) this);

        et_email_forgot = (EditText) findViewById(R.id.et_email_forgot);
        btn_forgot = (Button) findViewById(R.id.btn_forgot);

        /**dbAdapter = new DbAdapter(this);
        dbAdapter.open();**/

        /**btn_forgot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et_email_forgot.getWindowToken(), 0);
                String email = et_email_forgot.getText().toString();
                if (email.length() > 0 ) {
                    try {

                        if (dbAdapter.Forgot(email)) {
                            //Toast.makeText(MemberActivity.this,
                            //"Successfully Logged In", Toast.LENGTH_LONG)
                            //.show();
                            Intent i = new Intent(ForgotPassActivity.this, send_email.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(ForgotPassActivity.this,
                                    "Invalid email",
                                    Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(ForgotPassActivity.this, "Some problem occurred",
                                Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(ForgotPassActivity.this,
                            "Email field is empty", Toast.LENGTH_LONG).show();
                }
            }

        });**/
    }
    private void initializeVars() {
        // TODO Auto-generated method stub
        et_email_forgot = (EditText) findViewById(R.id.et_email_forgot);
        btn_forgot = (Button) findViewById(R.id.btn_forgot);
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub

        convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated();
        String emailaddress[] = { emailAdd };
        String message = "Well hello ";
                /**+ name
                + " I just wanted to say "
                + beginning
                + ".  Not only that but I hate when you "
                + stupidAction
                + ", that just really makes me crazy.  I just want to make you "
                + hatefulAct
                + ".  Welp, thats all I wanted to chit-chatter about, oh and"
                + out
                + ".  Oh also if you get bored you should check out www.mybringback.com"
                + '\n' + "PS. I think I love you...   :(";**/

    }

    private void convertEditTextVarsIntoStringsAndYesThisIsAMethodWeCreated() {
        // TODO Auto-generated method stub
        emailAdd = et_email_forgot.getText().toString();
        //out = outro.getText().toString();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

