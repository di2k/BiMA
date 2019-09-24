package id.go.kemenkeu.anggaran.bima.Revisi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;

public class RevisiFragment extends Fragment {

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Revisi");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_revisi, container, false);

        TextView idUser = view.findViewById(R.id.txt_iduser);
        TextView nmUser = view.findViewById(R.id.txt_nmuser);
        TextView name   = view.findViewById(R.id.txt_name);


        if (getArguments() != null) {
            String mIduser = getArguments().getString("sIduser");
            String mNmuser = getArguments().getString("sNmuser");
            String mName   = getArguments().getString("sName");

            idUser.setText(mIduser);
            nmUser.setText(mNmuser);
            name.setText(mName);
        }

        return view;
    }
}
