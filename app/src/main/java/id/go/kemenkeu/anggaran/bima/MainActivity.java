package id.go.kemenkeu.anggaran.bima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

import id.go.kemenkeu.anggaran.bima.Home.HomeFragment;
import id.go.kemenkeu.anggaran.bima.Diskusi.DiskusiFragment;
import id.go.kemenkeu.anggaran.bima.Otentikasi.OtentikasiFragment;
import id.go.kemenkeu.anggaran.bima.Profile.ProfileFragment;
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
        String mIduser      = user.get(sessionManager.IDUSER);
        String mNmuser      = user.get(sessionManager.NMUSER);
        String mFullname    = user.get(sessionManager.FULLNAME);
        String mNip         = user.get(sessionManager.NIP);
        String mJabatan     = user.get(sessionManager.JABATAN);
        String mIdusergroup = user.get(sessionManager.IDUSERGROUP);
        String mKddept      = user.get(sessionManager.KDDEPT);
        String mKdunit      = user.get(sessionManager.KDUNIT);
        String mKdsatker    = user.get(sessionManager.KDSATKER);
        String mKdlokasi    = user.get(sessionManager.KDLOKASI);
        String mNohp        = user.get(sessionManager.NOHP);
        String mEmail       = user.get(sessionManager.EMAIL);
        String mProfilpic   = user.get(sessionManager.PROFILPIC);
        String mTte_nik     = user.get(sessionManager.TTE_NIK);
        String mTte_nama    = user.get(sessionManager.TTE_NAMA);
        String mStslogin    = user.get(sessionManager.STSLOGIN);

        data.putString("sIduser", mIduser);
        data.putString("sNmuser", mNmuser);
        data.putString("sFullname", mFullname);
        data.putString("sNip", mNip);
        data.putString("sJabatan", mJabatan);
        data.putString("sIdusergroup", mIdusergroup);
        data.putString("sKddept", mKddept);
        data.putString("sKdunit", mKdunit);
        data.putString("sKdsatker", mKdsatker);
        data.putString("sKdlokasi", mKdlokasi);
        data.putString("sNohp", mNohp);
        data.putString("sEmail", mEmail);
        data.putString("sProfilpic", mProfilpic);
        data.putString("sTte_nik", mTte_nik);
        data.putString("sTte_nama", mTte_nama);
        data.putString("sStslogin", mStslogin);

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
                        case R.id.nav_diskusi:
                            selectedFragment = new DiskusiFragment();
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
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.replace(R.id.fragment_container, selectedFragment);
                    transaction.commit();
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
                Fragment profileFragment = new ProfileFragment();
                profileFragment.setArguments(data);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profileFragment).commit();
                return true;
            case R.id.nav_logout:
                sessionManager.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
