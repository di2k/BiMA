package id.go.kemenkeu.anggaran.bima.Slider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import id.go.kemenkeu.anggaran.bima.Profile.ProfileFragment;
import id.go.kemenkeu.anggaran.bima.R;
import id.go.kemenkeu.anggaran.bima.Referensi.ReferensiFragment;
import id.go.kemenkeu.anggaran.bima.SlideActivity;
import id.go.kemenkeu.anggaran.bima.SplashActivity;

public class SliderPagerAdapter extends PagerAdapter {

    private Context slideContext;
    private List<Slide> slideList;

    public SliderPagerAdapter(Context slideContext, List<Slide> slideList) {
        this.slideContext = slideContext;
        this.slideList = slideList;
    }


    @Override
    public int getCount() {
        return slideList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final LayoutInflater inflater = (LayoutInflater) slideContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View viewSlide = inflater.inflate(R.layout.slider_item, null);
        ImageView slideImg = viewSlide.findViewById(R.id.slider_image);
        slideImg.setImageResource(slideList.get(position).getImage());


        slideImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getApbn = null;
                switch (position) {
                    case 0:
                        getApbn = "r20";
                        break;
                    case 1:
                        getApbn = "a19";
                        break;
                    case 2:
                        getApbn = "r19";
                        break;
                }

                Intent intent = new Intent(slideContext, SlideActivity.class);
                intent.putExtra("getApbn", getApbn );
                slideContext.startActivity(intent);

            }
        });

//        slideImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment selectedFragment = null;
//                Log.i("TAG", "Position : " + position);
//
//                switch (position) {
//                    case 0:
//                        selectedFragment = new ProfileFragment();
//                        break;
//                    case 1:
//                        selectedFragment = new ReferensiFragment();
//                        break;
//                    case 2:
//                        selectedFragment = new ReferensiFragment();
//                        break;
//                }
//
//                FragmentManager manager = ((AppCompatActivity)slideContext).getSupportFragmentManager();
//                FragmentTransaction transaction = manager.beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.replace(R.id.fragment_container, selectedFragment);
//                transaction.commit();
//            }
//        });

        container.addView(viewSlide, 0);
        return viewSlide;

    }
}
