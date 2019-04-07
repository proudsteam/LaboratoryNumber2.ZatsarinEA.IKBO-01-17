package android.example.laboratorynumber2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //RecyclerView recyclerView;
    ArrayList<Civilisation> arrayList;
    ListView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecycler);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerAdapter adapter = new RecyclerAdapter(arrayList,MainActivity.this);
        ListAdapter adapter = new ListAdapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(adapter);
        String jsonFile = loadJSONFromAsset();
        String helptext;
        try {
            JSONArray jsonArray = new JSONArray(jsonFile);
            Log.d("Zheka", "" +jsonArray.length());
            for (int i=1; i < jsonArray.length(); i++)
            {
                Log.d("Zheka","Iteration " + i);
                JSONObject jsonObject = new JSONObject();
                Log.d("Zheka","FLAG0");
                jsonObject = jsonArray.getJSONObject(i);
                Log.d("Zheka","FLAG0.1");
                Log.d("Zheka", "" + jsonObject.has("flags"));
                Log.d("Zheka",jsonObject.getString("name"));
                if ((jsonObject.has("flags")))
                    helptext = "no description";
                else helptext = jsonObject.getString("helptext");
                Log.d("Zheka","FLAG0.2");
                Log.d("Zheka", " flag1");
                arrayList.add(new Civilisation(jsonObject.getString("name"),helptext,jsonObject.getString("graphic")));
                Log.d("Zheka","flag2");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,ViewPageActivity1.class);
                intent.putExtra("iterator",i);
                startActivity(intent);

            }
        });
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("myJSON.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}


class Civilisation {
  private  String name;
  private  String description;
  private  String Image = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";

    public Civilisation(String name, String description, String image) {
        this.name = name;
        this.description = description;
        Image += image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
