package id.go.kemenkeu.anggaran.bima.Revisi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;

public class RevisiFragment extends Fragment {

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Revisi");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_revisi, container, false);

        ImageView iLogo  = view.findViewById(R.id.img_logo);
        TextView idUser = view.findViewById(R.id.txt_iduser);
        TextView nmUser = view.findViewById(R.id.txt_nmuser);
        TextView name   = view.findViewById(R.id.txt_name);


        if (getArguments() != null) {
            String mIduser = getArguments().getString("sIduser");
            String mNmuser = getArguments().getString("sNmuser");
            String mFullname = getArguments().getString("sFullname");
            String mProfilpic = getArguments().getString("sProfilpic");


            idUser.setText(mIduser);
            nmUser.setText(mNmuser);
            name.setText(mFullname);
            Glide.with(this).load("https://api.sistem.online/logo/"+mProfilpic).into(iLogo);

        }

        return view;
    }
}
