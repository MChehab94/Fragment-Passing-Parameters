package mchehab.com.fragmentpassingparameters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private PersonFragment parametersFragment = new PersonFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            Person person = new Person("First Name", "Last Name", 22);
            Bundle bundle = new Bundle();
            bundle.putString("person", new Gson().toJson(person));
            parametersFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.frameLayout, parametersFragment)
                    .commit();
        }
    }
}