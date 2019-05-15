package android.learning.trace.android_learning_trace.view.activity.JSON;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Part34JSONParseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part34_jsonparse);
    }

    public void ParseJSONClick(View view) {
        ArrayList<User> users = jsonReader();
        System.out.println(users);
    }


    /**
     * Use Json reader to parse json.
     *
     * @return
     */
    private ArrayList<User> jsonReader() {
        InputStream jsonFile = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            jsonFile = getResources().openRawResource(R.raw.jsonfile);
            int len = jsonFile.available();
            byte[] buffer = new byte[len];
            jsonFile.read(buffer, 0, len);
            String strJSON = new String(buffer);
            JsonReader jr = new JsonReader(new StringReader(strJSON));

            jr.beginObject();
            if (jr.hasNext()) {
                if ("user".equalsIgnoreCase(jr.nextName())) {
                    jr.beginArray();
                    while (jr.hasNext()) {
                        //Begin to parse the object.
                        jr.beginObject();
                        User user = new User();
                        while (jr.hasNext()) {
                            String key = jr.nextName();
                            if ("firstName".equalsIgnoreCase(key)) {
                                user.setFirstName(jr.nextString());
                            } else if ("lastName".equalsIgnoreCase(key)) {
                                user.setLastName(jr.nextString());
                            }
                        }
                        jr.endObject();
                        users.add(user);
                    }
                }


            }

            jr.endArray();
            jr.endObject();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (jsonFile != null) {
                try {
                    jsonFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return users;
    }

    private String createJSON(ArrayList<User> users) {

        JSONArray jsonArray = new JSONArray();
        JSONObject finalResult = new JSONObject();
        for (User user : users) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("firstName", user.getFirstName());
                jsonObject.put("lastName", user.getLastName());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        try {
            finalResult.put("user", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return finalResult.toString();


    }

    public void CreateJSONClick(View view) {

        ArrayList<User> users = jsonReader();
        String userJSON = createJSON(users);
        System.out.println(userJSON);
    }

    //Use GSON parse JSON.
    public void ParseJSONWithGSONClick(View view) {
        Gson gson = new Gson();
        InputStream in = null;
        ArrayList<User> userArrayList = null;

        try {
            in = getResources().openRawResource(R.raw.gsonfile);
            int len = in.available();
            byte[] buffer = new byte[len];
            in.read(buffer, 0, len);
            Type type = new TypeToken<ArrayList<User>>() {
            }.getType();
            userArrayList = gson.fromJson(new String(buffer), type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userArrayList != null) {
            for (User user : userArrayList) {
                System.out.println(user);
            }
        }


    }


    public void CreateJSONWithGSONClick(View view) {

        ArrayList<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setLastName("Haha1");
        u1.setFirstName("Baba1");
        User u2 = new User();
        u2.setLastName("Haha2");
        u2.setFirstName("Baba2");
        users.add(u1);
        users.add(u2);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();
        String json = gson.toJson(users, type);
        System.out.println(json);
    }
}
