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

public class Frg02 extends Fragment implements View.OnClickListener {

    EditText etEmployeeName;
    EditText etEmployeeBirth;
    EditText etEmployeeWage;
    EditText etEmployeeHire;
    EditText etEmployeeImage;
    Button btnInsertEmployee;
    EmployeeDatabaseHelper employeeDatabaseHelper;
    private OnFragmentInteractionListener mListener;

    public Frg02() {

    }


    public static Frg02 newInstance() {
        Frg02 fragment = new Frg02();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frg02, container, false);
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etEmployeeName = view.findViewById(R.id.etEmployeeName);
        etEmployeeBirth = view.findViewById(R.id.etEmployeeBirth);
        etEmployeeHire = view.findViewById(R.id.etEmployeeHire);
        etEmployeeWage = view.findViewById(R.id.etEmployeeWage);
        etEmployeeImage = view.findViewById(R.id.etEmployeeImage);
        btnInsertEmployee = view.findViewById(R.id.btnInsertEmployee);
        btnInsertEmployee.setOnClickListener(this);
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
    Employee employee = new Employee(name, birth, wage, hire, image);
    employeeDatabaseHelper.insertEmployeeIntoDatabse(employee);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
