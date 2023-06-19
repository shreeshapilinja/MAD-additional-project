package com.example.project8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
    }
    public void parsexml(View view){
        try{
            InputStream is=getAssets().open("city.xml");
            DocumentBuilderFactory documentfact=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuil=documentfact.newDocumentBuilder();
            Document docu=documentBuil.parse(is);
            StringBuilder stringbuild=new StringBuilder();
            stringbuild.append("XML DATA");
            stringbuild.append("\n...........\n");
            NodeList nodeList=docu.getElementsByTagName("place");
            for(int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    stringbuild.append("\n city name :").append(getvalue("city",element));
                    stringbuild.append("\n latitude :").append(getvalue("lat",element));
                    stringbuild.append("\n longitude :").append(getvalue("long",element));
                    stringbuild.append("\n temperature :").append(getvalue("temp",element));
                    stringbuild.append("\n humidity :").append(getvalue("hum",element));
                    stringbuild.append("\n .........\n");
                }
            }
            tv1.setText(stringbuild.toString());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    public void parsejson(View view){
        String json;
        StringBuilder stringbuild=new StringBuilder();
        try{
            InputStream is =getAssets().open("city.json");
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            json=new String(buffer, StandardCharsets.UTF_8);
            JSONArray jsonarry=new JSONArray(json);
            stringbuild.append("JSON DATA");
            stringbuild.append("\n..........\n");
            for(int i=0;i<jsonarry.length();i++){
                JSONObject jsonObject=jsonarry.getJSONObject(i);
                stringbuild.append("\n city name : " ).append(jsonObject.getString("city"));
                stringbuild.append("\n latitude : ").append(jsonObject.getString("lat"));
                stringbuild.append("\n longitude : ").append(jsonObject.getString("long"));
                stringbuild.append("\n temperature : ").append(jsonObject.getString("temp"));
                stringbuild.append("\n humidity : ").append(jsonObject.getString("hum"));
                stringbuild.append("\n..........\n");
            }
            tv2.setText(stringbuild.toString());
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
    }
    private String getvalue(String tag,Element element){
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}