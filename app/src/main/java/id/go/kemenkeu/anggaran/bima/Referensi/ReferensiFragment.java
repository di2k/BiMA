package id.go.kemenkeu.anggaran.bima.Referensi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;

public class ReferensiFragment extends Fragment {

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Referensi");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_referensi, container, false);
    }
}
