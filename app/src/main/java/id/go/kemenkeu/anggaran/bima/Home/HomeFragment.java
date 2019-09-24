package id.go.kemenkeu.anggaran.bima.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.timqi.sectorprogressview.ColorfulRingProgressView;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;
import id.go.kemenkeu.anggaran.bima.SessionManager;

public class HomeFragment extends Fragment {

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getNumberInstance(localeID);

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("BiMA");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        double rp_real = 111000000;
        double rp_pagu = 157000000;
        double prosen  = (rp_real/rp_pagu) * 100;

        TextView tIduser = view.findViewById(R.id.txt_iduser);
        TextView tNmuser = view.findViewById(R.id.txt_nmuser);
        TextView tName   = view.findViewById(R.id.txt_name);
        TextView tProsen = view.findViewById(R.id.dash_prosen);
        TextView tPagu   = view.findViewById(R.id.dash_rp_pagu);
        TextView tReal   = view.findViewById(R.id.dash_rp_real);

        ColorfulRingProgressView crpv = (ColorfulRingProgressView) view.findViewById(R.id.spv);
        crpv.setPercent((int) Math.round(prosen));

        if (getArguments() != null) {
            String mIduser = getArguments().getString("sIduser");
            String mNmuser = getArguments().getString("sNmuser");
            String mName   = getArguments().getString("sName");

            tIduser.setText(mIduser);
            tNmuser.setText(mNmuser);
            tName.setText(mName);
            tProsen.setText(String.format("%.2f", prosen));
            tReal.setText(formatRupiah.format(rp_real));
            tPagu.setText(formatRupiah.format(rp_pagu));
        }

        return view;
    }
}
