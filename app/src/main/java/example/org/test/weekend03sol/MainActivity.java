package example.org.test.weekend03sol;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        Frg01.OnFragmentInteractionListener, Frg02.OnFragmentInteractionListener,
        Frg03.OnFragmentInteractionListener{

    Frg01 frg01;
    Frg02 frg02;
    Frg03 frg03;
    FragmentManager fragmentManager;
    public static final String DYNAMIC_FRG_01 = "dynamic_frg01";
    public static final String DYNAMIC_FRG_02 = "dynamic_frg02";
    public static final String DYNAMIC_FRG_03 = "dynamic_frg03";
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        //viewPager.setAdapter(fragmentManager);
        EmployeeDatabaseHelper databaseHelper = new EmployeeDatabaseHelper(this);
        frg01 = Frg01.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frg01, Frg01.newInstance())
                .addToBackStack(DYNAMIC_FRG_01)
                .commit();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frg02, Frg02.newInstance())
                .addToBackStack(DYNAMIC_FRG_02)
                .commit();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frg03, Frg03.newInstance())
                .addToBackStack(DYNAMIC_FRG_03)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
