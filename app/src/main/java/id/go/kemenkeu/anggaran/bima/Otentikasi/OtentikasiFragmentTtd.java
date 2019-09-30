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

public class OtentikasiFragmentTtd extends Fragment {

    private List<OtentikasiModel> lstTtd;

    public OtentikasiFragmentTtd() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_otentikasi_ttd, container, false);

        RecyclerView myrecycleviewTtd = view.findViewById(R.id.tte_recycleview);
        OtentikasiRVAdapter otentikasiRVAdapter = new OtentikasiRVAdapter(getContext(), lstTtd);
        myrecycleviewTtd.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleviewTtd.setAdapter(otentikasiRVAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstTtd = new ArrayList<>();
        lstTtd.add(new OtentikasiModel("# 007", "ID Revisi: 2019.630931.003", "Surat Usulan Revisi.pdf","Dok. Pengajuan usulan revisi pergeseran jenis belanja\n" +
                "dalam ranger penghematan.", R.drawable.file_pdf));
        lstTtd.add(new OtentikasiModel("# 008", "eOffice", "ST Penelaahan Revisi.pdf", "ST Penugasan dalam rangka penelaahan revisi. ", R.drawable.file_pdf));
    }
}
