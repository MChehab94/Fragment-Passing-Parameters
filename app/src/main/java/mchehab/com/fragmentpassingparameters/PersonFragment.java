package mchehab.com.fragmentpassingparameters;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;

public class PersonFragment extends Fragment {

    private Person person;

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextAge;

    public void setPerson(Person person){
        this.person = person;
    }

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextAge = view.findViewById(R.id.editTextAge);

        initParameters();

        editTextFirstName.setText(person.getFirstName());
        editTextLastName.setText(person.getLastName());
        editTextAge.setText(person.getAge() + "");

        return view;
    }

    private void initParameters(){
        Bundle bundle = getArguments();
        if(bundle != null){
            person = new Gson().fromJson(bundle.getString("person"), Person.class);
        }
    }
}