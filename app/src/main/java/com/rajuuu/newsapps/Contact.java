package com.rajuuu.newsapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.adapter.MyListAdapter;
import com.example.item.MyListData;
import com.example.item.Tipsmodel;
import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Context mContext;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayList1;
    private SearchableSpinner spinner;
    MyListData[] myListData;
    List<MyListData> myListData1 = new ArrayList<>();
    List<MyListData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mContext = this;
        AddDataToArrayList();
        new getLatest().execute(Constant.CITY_URL);
        findViews();
        new getreporter().execute(Constant.REPORT_URL);




    }

    private void AddDataToArrayList() {

    }
    private void findViews()
    {
        spinner = (SearchableSpinner) findViewById(R.id.spinner);
        //For set Title to Spinner
        spinner.setTitle("Select City");
        setDataToAdapter(arrayList);
    }
    @SuppressLint("StaticFieldLeak")
    private class getLatest extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showProgress(true);

            arrayList = new ArrayList<>();
            arrayList1 = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... params) {
            return JsonUtils.getJSONString(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
//            showProgress(false);
            if (null == result || result.length() == 0) {
//                lyt_not_found.setVisibility(View.VISIBLE);
            } else {
                try {
                    JSONObject mainJson = new JSONObject(result);
                    JSONArray jsonArray = mainJson.getJSONArray("NEWS_APP");
                    JSONObject objJson;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        objJson = jsonArray.getJSONObject(i);
//                        Tipsmodel objItem = new Tipsmodel(objJson.getString("tips_id"),objJson.getString("tips_name"),objJson.getString("tips_desc"),objJson.getString("tips_image"));
arrayList.add(""+objJson.getString("city_name"));
arrayList1.add(""+objJson.getString("city_id"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                displayData();
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class getreporter extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showProgress(true);
        }

        @Override
        protected String doInBackground(String... params) {
            return JsonUtils.getJSONString(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
//            showProgress(false);
            if (null == result || result.length() == 0) {
//                lyt_not_found.setVisibility(View.VISIBLE);
            } else {
                try {

                    JSONObject mainJson = new JSONObject(result);
                    JSONArray jsonArray = mainJson.getJSONArray("NEWS_APP");
                    JSONObject objJson;
                    list = new ArrayList<>();
                    myListData=new MyListData[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        objJson = jsonArray.getJSONObject(i);
//                        Tipsmodel objItem = new Tipsmodel(objJson.getString("tips_id"),objJson.getString("tips_name"),objJson.getString("tips_desc"),objJson.getString("tips_image"));



                        list.add(new MyListData(""+objJson.getString("reporter_name"),""+objJson.getString("reporter_id"),""+objJson.getString("reporter_mobile"),""+objJson.getString("reporter_city"), R.drawable.ic_baseline_person));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                displayData();

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                MyListAdapter adapter = new MyListAdapter(list,Contact.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Contact.this));
                recyclerView.setAdapter(adapter);
            }
        }
    }



    @SuppressLint("StaticFieldLeak")
    private class getreporterbycity extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            showProgress(true);
        }

        @Override
        protected String doInBackground(String... params) {
            return JsonUtils.getJSONString(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
//            showProgress(false);
            if (null == result || result.length() == 0) {
//                lyt_not_found.setVisibility(View.VISIBLE);
            } else {
                try {

                    JSONObject mainJson = new JSONObject(result);
                    JSONArray jsonArray = mainJson.getJSONArray("NEWS_APP");
                    JSONObject objJson;
                    list = new ArrayList<>();
                    myListData=new MyListData[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        objJson = jsonArray.getJSONObject(i);
//                        Tipsmodel objItem = new Tipsmodel(objJson.getString("tips_id"),objJson.getString("tips_name"),objJson.getString("tips_desc"),objJson.getString("tips_image"));



                        list.add(new MyListData(""+objJson.getString("reporter_name"),""+objJson.getString("reporter_id"),""+objJson.getString("reporter_mobile"),""+objJson.getString("reporter_city"), R.drawable.ic_baseline_person));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                displayData();

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                MyListAdapter adapter = new MyListAdapter(list,Contact.this);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(Contact.this));
                recyclerView.setAdapter(adapter);
            }
        }
    }

    private void setDataToAdapter(ArrayList<String> arrayList)
    {
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, arrayList);
        // Specify layout to be used when list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItemText = parent.getItemAtPosition(position).toString();
        String selectedItemid =arrayList1.get(position).toString();

        Toast.makeText(mContext, " You select >> " + selectedItemText, Toast.LENGTH_SHORT).show();

        new getreporterbycity().execute(Constant.REPORT_URL_CITY+"="+selectedItemid);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}