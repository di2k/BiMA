package id.go.kemenkeu.anggaran.bima.Referensi;

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

public class ReferensiFragment extends Fragment {

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Referensi");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private ReferensiVPAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_referensi, container, false);

        TabLayout tabLayout = view.findViewById(R.id.ref_tabLayout);
        ViewPager viewPager = view.findViewById(R.id.ref_viewPager);
        adapter = new ReferensiVPAdapter(getFragmentManager());

        adapter.AddFragment(new ReferensiFragmentSBM(), "SBM");
        adapter.AddFragment(new ReferensiFragmentBAS(), "BAS");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
