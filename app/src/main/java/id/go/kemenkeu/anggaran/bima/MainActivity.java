package id.go.kemenkeu.anggaran.bima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

import id.go.kemenkeu.anggaran.bima.Home.HomeFragment;
import id.go.kemenkeu.anggaran.bima.Konsultasi.KonsultasiFragment;
import id.go.kemenkeu.anggaran.bima.Otentikasi.OtentikasiFragment;
import id.go.kemenkeu.anggaran.bima.Referensi.ReferensiFragment;
import id.go.kemenkeu.anggaran.bima.Revisi.RevisiFragment;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;
    Bundle data = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mIduser = user.get(sessionManager.IDUSER);
        String mNmuser = user.get(sessionManager.NMUSER);
        String mName   = user.get(sessionManager.NAME);

        data.putString("sIduser", mIduser);
        data.putString("sNmuser", mNmuser);
        data.putString("sName", mName);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.nav_home);

//        first selected fragment
        Fragment homeFragment = new HomeFragment();
        homeFragment.setArguments(data);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_revisi:
                            selectedFragment = new RevisiFragment();
                            break;
                        case R.id.nav_konsultasi:
                            selectedFragment = new KonsultasiFragment();
                            break;
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_otentikasi:
                            selectedFragment = new OtentikasiFragment();
                            break;
                        case R.id.nav_referensi:
                            selectedFragment = new ReferensiFragment();
                            break;
                    }

                    selectedFragment.setArguments(data);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }
            };

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.up_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                Toast toast = Toast.makeText(this, "Under Construction", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0,0);
                toast.show();
                return true;
            case R.id.nav_logout:
                sessionManager.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
