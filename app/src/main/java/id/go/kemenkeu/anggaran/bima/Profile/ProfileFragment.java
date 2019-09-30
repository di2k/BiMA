package id.go.kemenkeu.anggaran.bima.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.R;

public class ProfileFragment extends Fragment {


    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("Profile");
//        show back button
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView iLogo  = view.findViewById(R.id.pro_logo);
        TextView tIduser = view.findViewById(R.id.pro_iduser);
        TextView tNmuser = view.findViewById(R.id.pro_nmuser);
        TextView tFullname = view.findViewById(R.id.pro_fullname);
        TextView tJabatan  = view.findViewById(R.id.pro_jabatan);
        TextView tNohp   = view.findViewById(R.id.pro_nohp);
        TextView tEmail  = view.findViewById(R.id.pro_email);
        TextView tTte_nama = view.findViewById(R.id.pro_tte_nama);
        TextView tTte_nik  = view.findViewById(R.id.pro_tte_nik);
        LinearLayout lBsre = view.findViewById(R.id.layout_bsre);

        if (getArguments() != null) {
            String mIduser   = getArguments().getString("sIduser");
            String mNmuser   = getArguments().getString("sNmuser");
            String mFullname = getArguments().getString("sFullname");
            String mJabatan  = getArguments().getString("sJabatan");
            String mNohp     = getArguments().getString("sNohp");
            String mEmail    = getArguments().getString("sEmail");
            String mTte_nama = getArguments().getString("sTte_nama");
            String mTte_nik  = getArguments().getString("sTte_nik");
            String mProfilpic = getArguments().getString("sProfilpic");

            Glide.with(this).load("https://api.sistem.online/logo/"+mProfilpic).into(iLogo);
            tIduser.setText(mIduser);
            tNmuser.setText(mNmuser);
            tFullname.setText(mFullname);
            tJabatan.setText(mJabatan);
            tNohp.setText(mNohp);
            tEmail.setText(mEmail);
            tTte_nama.setText(mTte_nama);
            tTte_nik.setText(mTte_nik);

            if (mTte_nik == "") {lBsre.setVisibility(View.GONE);}


        }

        return view;
    }

}
