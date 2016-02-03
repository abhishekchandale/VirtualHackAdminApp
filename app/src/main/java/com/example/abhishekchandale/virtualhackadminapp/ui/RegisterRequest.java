package com.example.abhishekchandale.virtualhackadminapp.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.abhishek.chandale.myapplication.backend.complaintApi.ComplaintApi;
import com.example.abhishek.chandale.myapplication.backend.complaintApi.model.Complaint;
import com.example.abhishekchandale.virtualhackadminapp.R;
import com.example.abhishekchandale.virtualhackadminapp.adapter.ComplaintAdapter;
import com.example.abhishekchandale.virtualhackadminapp.database.DbAccess;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhi on 17-01-2016.
 */
public class RegisterRequest extends AppCompatActivity {

    private ListView listView;
    private String message, date;
    private DbAccess dbAccess;
    private Cursor cursor;
    private String compMessage[], comDate[], name[];
    private ComplaintAdapter complaintAdapter;
    private byte[][] blobArray;

    private double lat, longitude;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbAccess = new DbAccess(this);
        setContentView(R.layout.previous_comp_activity);
        listView = (ListView) findViewById(R.id.listView);
        new RegisterRequestApi(this).execute();
    }

    public void PopulateData() {

        try {
            cursor = dbAccess.getComplaint();

            compMessage = new String[cursor.getCount()];
            comDate = new String[cursor.getCount()];
            name = new String[cursor.getCount()];
            blobArray = new byte[cursor.getCount()][];
            if (cursor.moveToNext()) {
                for (int i = 0; i < cursor.getCount(); i++) {
                    compMessage[i] = cursor.getString(cursor.getColumnIndex("complaintMessage"));
                    comDate[i] = cursor.getString(cursor.getColumnIndex("datetime"));
                    name[i] = cursor.getString(cursor.getColumnIndex("name"));
                    blobArray[i] = cursor.getBlob(cursor.getColumnIndex("image"));
                    cursor.moveToNext();
                }

            } else {

                Toast.makeText(getApplicationContext(), "databse not created...", Toast.LENGTH_LONG).show();
            }
            complaintAdapter = new ComplaintAdapter(this, compMessage, comDate, name, blobArray);
            listView.setAdapter(complaintAdapter);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void showMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("lat", lat);
        intent.putExtra("long", longitude);
        startActivity(intent);
    }

    class RegisterRequestApi extends AsyncTask<Void, Void, List<Complaint>> {
        private ComplaintApi myApiService = null;
        private Context context;
        private ProgressDialog progressDialog;

        RegisterRequestApi(Context context) {
            this.context = context;
            progressDialog = new ProgressDialog(this.context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Loading");
            progressDialog.show();
        }

        @Override
        protected List<Complaint> doInBackground(Void... params) {
            if (myApiService == null) {  // Only do this once
                ComplaintApi.Builder builder = new ComplaintApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("https://virtualhack-1193.appspot.com/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }

            try {
                return myApiService.listComplaint().execute().getItems();
            } catch (Exception e) {
                return Collections.EMPTY_LIST;
            }
        }

        @Override
        protected void onPostExecute(List<Complaint> result) {
            dbAccess.clearComplaints();

            for (Complaint q : result) {
                progressDialog.dismiss();
                // Toast.makeText(getApplicationContext(), q.getImage(), Toast.LENGTH_SHORT).show();
                lat = q.getLat();
                longitude = q.getLon();
                Log.e("coordinate-" ,+lat+""+longitude);
                dbAccess.addComplaint(q.getComplaintMessage(), Base64.decode(q.getImage(), 0), q.getName(), q.getEmail(), q.getDate(), q.getLat(), q.getLon(), q.getComplaintAddress());
            }

            PopulateData();
        }
    }
}
