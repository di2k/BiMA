package id.go.kemenkeu.anggaran.bima.Home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.timqi.sectorprogressview.ColorfulRingProgressView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import id.go.kemenkeu.anggaran.bima.Diskusi.DiskusiFragment;
import id.go.kemenkeu.anggaran.bima.MainActivity;
import id.go.kemenkeu.anggaran.bima.Otentikasi.OtentikasiFragment;
import id.go.kemenkeu.anggaran.bima.R;
import id.go.kemenkeu.anggaran.bima.Slider.Slide;
import id.go.kemenkeu.anggaran.bima.Slider.SliderPagerAdapter;

public class HomeFragment extends Fragment {

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getNumberInstance(localeID);

    public float rp_real, rp_pagu, prosen  = 0;
    int nChat, nNotif, nDoc  = 0;

    private List<Slide> lstSlides;
    private ViewPager sliderPager;
    private ProgressBar loading;
    private LinearLayout chart;

    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("BiMA");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);


        sliderPager = view.findViewById(R.id.slider_pager);
        loading = view.findViewById(R.id.loading);
        chart = view.findViewById(R.id.dash_chart);

        chart.setVisibility(view.GONE);
        loading.setVisibility(View.VISIBLE);

        ImageView iLogo  = view.findViewById(R.id.img_logo);
        TextView tIduser = view.findViewById(R.id.txt_iduser);
        TextView tNmuser = view.findViewById(R.id.txt_nmuser);
        TextView tName   = view.findViewById(R.id.txt_name);

        if (getArguments() != null) {
            String mIduser   = getArguments().getString("sIduser");
            String mNmuser   = getArguments().getString("sNmuser");
            String mFullname = getArguments().getString("sFullname");
            String mProfilpic = getArguments().getString("sProfilpic");

            tIduser.setText(mIduser);
            tNmuser.setText(mNmuser);
            tName.setText(mFullname);
            Glide.with(this).load("https://api.sistem.online/logo/"+mProfilpic).into(iLogo);
        }

        String URL_DASH = "https://api.sistem.online/Rest/bima/dash?iduser="+getArguments().getString("sIduser");

        final TabLayout indicator = view.findViewById(R.id.indicator);

        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.sl_rapbn2020));
        lstSlides.add(new Slide(R.drawable.sl_apbn2019));
        lstSlides.add(new Slide(R.drawable.sl_rapbn2019));

        SliderPagerAdapter adapter = new SliderPagerAdapter(getContext(), lstSlides);
        sliderPager.setAdapter(adapter);

        indicator.setupWithViewPager(sliderPager, true);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DASH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Log.e("TAG", response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            JSONArray jsonArray = jsonObject.getJSONArray("message");
                            if (status.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    rp_pagu = (float) object.getDouble("rp_pagu");
                                    rp_real = (float) object.getDouble("rp_real");
                                    nChat  = object.getInt("n_chat");
                                    nNotif  = object.getInt("n_notif");
                                    nDoc  = object.getInt("n_dok");

                                    refreshChart();
                                    refreshNotif();

                                    loading.setVisibility(View.GONE);
                                    chart.setVisibility(View.VISIBLE);
                                }

                            } else {
                                Log.e("Error", "onResponse: Error" );
                            }
                        } catch (JSONException e) {
                            Log.e("Error", "onResponse: "+e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(stringRequest);

        return view;
    }

    public void refreshChart() {

        final ColorfulRingProgressView crpv = getActivity().findViewById(R.id.spv);
        final TextView tPagu   = getActivity().findViewById(R.id.dash_rp_pagu);
        final TextView tReal   = getActivity().findViewById(R.id.dash_rp_real);
        final TextView tProsen = getActivity().findViewById(R.id.dash_prosen);

        crpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Graph ", Toast.LENGTH_SHORT).show();
            }
        });

        tReal.setText(formatRupiah.format(rp_real));
        tPagu.setText(formatRupiah.format(rp_pagu));

        float prosen  = (rp_real/rp_pagu) * 100;
        crpv.setPercent((int) Math.round(prosen));
        tProsen.setText(String.format("%.2f", prosen));
    }

    public void refreshNotif() {
        ImageView iChat  = getActivity().findViewById(R.id.dash_ico_chat);
        ImageView iNotif = getActivity().findViewById(R.id.dash_ico_notif);
        ImageView iDoc   = getActivity().findViewById(R.id.dash_ico_doc);
        TextView lChat   = getActivity().findViewById(R.id.dash_lbl_chat);
        TextView lNotif  = getActivity().findViewById(R.id.dash_lbl_notif);
        TextView lDoc    = getActivity().findViewById(R.id.dash_lbl_doc);

        if (nNotif != 0 ) {
            lNotif.setText(Integer.toString(nNotif)+ " Notifikasi");
            lNotif.setTextColor(getResources().getColor(R.color.colorPrimary));
        } else {
            lNotif.setText("0 Notifikasi");
            lNotif.setTextColor(getResources().getColor(R.color.gray));
        }

        iNotif.setColorFilter(getResources().getColor(R.color.colorPrimary));
        iNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new DiskusiFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        if (nChat != 0 ) {
            lChat.setText(Integer.toString(nChat)+ " Percakapan");
            lChat.setTextColor(getResources().getColor(R.color.colorPrimary));
            iChat.setColorFilter(getResources().getColor(R.color.colorPrimary));

            iChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new DiskusiFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

        } else {
            lChat.setText("0 Chat");
            lChat.setTextColor(getResources().getColor(R.color.gray));
            iChat.setColorFilter(getResources().getColor(R.color.gray));
        }

        if (nDoc != 0 ) {
            lDoc.setText(Integer.toString(nDoc)+ " Dokumen");
            lDoc.setTextColor(getResources().getColor(R.color.colorPrimary));
            iDoc.setColorFilter(getResources().getColor(R.color.colorPrimary));

            iDoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new OtentikasiFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

        } else {
            lDoc.setText("0 Dokumen");
            lDoc.setTextColor(getResources().getColor(R.color.gray));
            iDoc.setColorFilter(getResources().getColor(R.color.gray));
        }

    }

}
