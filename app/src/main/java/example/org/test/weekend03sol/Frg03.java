package example.org.test.weekend03sol;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Frg03 extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    EditText etEmployeeName;
    EditText etEmployeeBirth;
    EditText etEmployeeWage;
    EditText etEmployeeHire;
    EditText etEmployeeImage;
    Button btnFindAnEmployee;
    Button btnUpdateAnEmployee;
    Button btnDeleteAnEmployee;
    EmployeeDatabaseHelper employeeDatabaseHelper;

    public Frg03() {
        // Required empty public constructor
    }


    public static Frg03 newInstance() {
        Frg03 fragment = new Frg03();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frg03, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etEmployeeName = view.findViewById(R.id.etEmployeeName);
        etEmployeeBirth = view.findViewById(R.id.etEmployeeBirth);
        etEmployeeHire = view.findViewById(R.id.etEmployeeHire);
        etEmployeeWage = view.findViewById(R.id.etEmployeeWage);
        etEmployeeImage = view.findViewById(R.id.etEmployeeImage);
        btnFindAnEmployee = view.findViewById(R.id.btnFindAnEmployee);
        btnUpdateAnEmployee = view.findViewById(R.id.btnUpdateAnEmployee);
        btnDeleteAnEmployee = view.findViewById(R.id.btnDeleteAnEmployee);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        String name = etEmployeeName.getText().toString();
        String birth = etEmployeeBirth.getText().toString();
        String wage = etEmployeeWage.getText().toString();
        String hire = etEmployeeHire.getText().toString();
        String image = etEmployeeImage.getText().toString();
        switch(v.getId()){
            case R.id.btnFindAnEmployee:
                if(name != null){
                    Employee employee = new Employee(name, birth, wage, hire, image);
                    employeeDatabaseHelper.getEmployeeById(getId());
                }
                break;
            case R.id.btnUpdateAnEmployee:
                if(name!=null){
                    Employee employee = new Employee(name, birth, wage, hire, image);
                    employeeDatabaseHelper.updateEmployeeInDatabase(employee);
                }
                break;
            case R.id.btnDeleteAnEmployee:
                if(name!= null){
                    Employee employee = new Employee(name, birth, wage, hire, image);
                    String nameArr[] = {name};
                    employeeDatabaseHelper.deleteFromDatabaseById(nameArr);
                }
        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
