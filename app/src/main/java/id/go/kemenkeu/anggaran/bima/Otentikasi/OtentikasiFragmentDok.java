package id.go.kemenkeu.anggaran.bima.Otentikasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.go.kemenkeu.anggaran.bima.R;

public class OtentikasiFragmentDok extends Fragment {

    private List<OtentikasiModel> lstDok;

    public OtentikasiFragmentDok() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_otentikasi_dok, container, false);

//        RecyclerView myrecycleviewDok = view.findViewById(R.id.tte_recycleview);
//        OtentikasiRVAdapter otentikasiRVAdapter = new OtentikasiRVAdapter(getContext(), lstDok);
//        myrecycleviewDok.setLayoutManager(new LinearLayoutManager(getActivity()));
//        myrecycleviewDok.setAdapter(otentikasiRVAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstDok = new ArrayList<>();
        lstDok.add(new OtentikasiModel("# 007", "ID Revisi: 2019.630931.003", "Surat Usulan Revisi.pdf","Dok. Pengajuan usulan revisi pergeseran jenis belanja\n" +
                "dalam ranger penghematan.", R.drawable.file_pdf));
        lstDok.add(new OtentikasiModel("# 008", "eOffice", "ST Penelaahan Revisi.pdf", "ST Penugasan dalam rangka penelaahan revisi. ", R.drawable.file_pdf));
        lstDok.add(new OtentikasiModel("# 009", "eOffice", "ST Konser.pdf", "ST Penugasan dalam rangka . ", R.drawable.file_pdf));
    }
}
