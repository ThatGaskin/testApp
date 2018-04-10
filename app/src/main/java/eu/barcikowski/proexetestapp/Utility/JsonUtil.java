package eu.barcikowski.proexetestapp.Utility;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import eu.barcikowski.proexetestapp.model.Item;

public class JsonUtil {


    @NotNull
    public List<Item> loadURLData(@NotNull String URL, @Nullable final Context applicationContext) {
        final List<Item> items = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("items");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jObject = array.getJSONObject(i);
                                Item item = new Item(jObject.getString("name"), jObject.getString("image"));
                                items.add(item);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(applicationContext, "Error with getting the data", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(applicationContext, "Error with getting the data" , Toast.LENGTH_LONG).show();
            }
        });
        return items;
    }
}

