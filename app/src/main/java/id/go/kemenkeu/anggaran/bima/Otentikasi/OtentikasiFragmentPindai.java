package id.go.kemenkeu.anggaran.bima.Otentikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import id.go.kemenkeu.anggaran.bima.R;

public class OtentikasiFragmentPindai extends Fragment {

    public OtentikasiFragmentPindai() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_otentikasi_pindai, container, false);

        return view;
    }
}
