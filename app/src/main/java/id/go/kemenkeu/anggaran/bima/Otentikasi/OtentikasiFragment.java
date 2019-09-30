package id.go.kemenkeu.anggaran.bima.Otentikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;

public class OtentikasiFragment extends Fragment {

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Otentikasi");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private OtentikasiVPAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_otentikasi, container, false);

        TabLayout tabLayout = view.findViewById(R.id.tte_tabLayout);
        ViewPager viewPager = view.findViewById(R.id.tte_viewPager);
        adapter = new OtentikasiVPAdapter(getFragmentManager());

        adapter.AddFragment(new OtentikasiFragmentTtd(), "TTD");
        adapter.AddFragment(new OtentikasiFragmentDok(), "Dokumen");
        adapter.AddFragment(new OtentikasiFragmentPindai(), "Pindai");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
