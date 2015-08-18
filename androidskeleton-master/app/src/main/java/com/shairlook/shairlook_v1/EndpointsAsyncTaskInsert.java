package com.shairlook.shairlook_v1;

import android.os.AsyncTask;
import android.util.Log;

/**import com.appspot.shairlook1.userEndpoint.UserEndpoint;
import com.appspot.shairlook1.userEndpoint.model.User;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
**/
import java.io.IOException;

/**
 * Created by kristian on 04/07/2015.
 */

/**public class EndpointsAsyncTaskInsert extends AsyncTask<String, Void, User> implements GoogleClientRequestInitializer {
    private static UserEndpoint myApiService = null;
    //private Context context;
    private OnTaskFinishListener listener;**/
    /**EndpointsAsyncTaskInsert(Context context) {
        this.context = context;
    }**/

    /**public EndpointsAsyncTaskInsert(OnTaskFinishListener listener){
        this.listener = listener;
    }
    @Override
    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        // put it here no in MyClass
        abstractGoogleClientRequest.setDisableGZipContent(true);
    }

// class MyClass{} // you don't need it


    @Override
    protected User doInBackground(String... params) {
        User response = null;
        if (myApiService == null) { // Only do this once
            UserEndpoint.Builder builder = new UserEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
// options for running against local devappserver
// - 10.0.2.2 is localhost's IP address in Android emulator
// - turn off compression when running against local devappserver
                    .setRootUrl("https://shairlook1.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(this);
// end options for devappserver

            myApiService = builder.build();
        }

        try {
            User users = new User();
            users.setEmail(params[0]);
            users.setPassword(params[1]);
            users.setName(params[2]);
            response = myApiService.insertUser(users).execute();
        } catch (Exception e) {
            Log.d("Could not Add User", e.getMessage(), e);
        }
        return response;
    }
    //@Override
    protected void onPostExecute(User user){
        //super.onPostExecute(users);
        super.onPostExecute(user);

        if (user != null) {  // error**

            // Do JSON Parsing

        }else{

            //Show Warning

        }
        listener.onFinish();
    }

}**/





