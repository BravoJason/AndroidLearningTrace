package android.learning.trace.android_learning_trace.view.activity.XML;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Part33XMLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part33_xml);
    }

    //Use PULL to parse the XML.
    public void parseXMLPULLClick(View view) {

        ArrayList<Person> personArrayList = parser();

        for (Person person : personArrayList) {
            System.out.println(person);
        }


    }

    private ArrayList<Person> parser() {

        ArrayList<Person> personArrayList = new ArrayList<>();
        Person p = null;

        //Create a PULL parese.
        XmlPullParser pullParser = Xml.newPullParser();
        InputStream in = getResources().openRawResource(R.raw.file);
        try {
            //Set the parse input stream.
            pullParser.setInput(in, "UTF-8");
            //Get current event type.
            int eventType = pullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        String tag = pullParser.getName();
                        if (tag.equals("person")) {
                            p = new Person();
                            p.setId(
                                    Integer.parseInt(
                                            pullParser.getAttributeValue(
                                                    null,
                                                    "personid")));
                        } else if (tag.equalsIgnoreCase("name")) {

                            if (p != null) {
                                p.setName(pullParser.nextText());
                            }
                        } else if (tag.equalsIgnoreCase("age")) {
                            if (p != null) {
                                p.setAge(Integer.parseInt(pullParser.nextText()));
                            }
                        } else if (tag.equalsIgnoreCase("gender")) {
                            if (p != null) {
                                p.setGender(pullParser.nextText());
                            }
                        } else if (tag.equalsIgnoreCase("tel")) {
                            if (p != null) {
                                p.setTel(pullParser.nextText());
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (pullParser.getName().equalsIgnoreCase("person")) {
                            personArrayList.add(p);
                        }
                        break;
                }
                eventType = pullParser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personArrayList;


    }
}
