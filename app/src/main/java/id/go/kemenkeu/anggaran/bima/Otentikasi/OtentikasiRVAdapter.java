package id.go.kemenkeu.anggaran.bima.Otentikasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.go.kemenkeu.anggaran.bima.R;

public class OtentikasiRVAdapter extends RecyclerView.Adapter<OtentikasiRVAdapter.MyViewHolder> {

    Context context;
    List<OtentikasiModel> mData;

    public OtentikasiRVAdapter(Context context, List<OtentikasiModel> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.fragment_otentikasi_ttd_item,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_id.setText(mData.get(position).getId());
        holder.tv_iddok.setText(mData.get(position).getIdDok());
        holder.tv_nmdok.setText(mData.get(position).getNmDok());
        holder.tv_desc.setText(mData.get(position).getDesc());
        holder.logo_file.setImageResource(mData.get(position).getLogoFile());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_id;
        private TextView tv_iddok;
        private TextView tv_nmdok;
        private TextView tv_desc;
        private ImageView logo_file;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id     = itemView.findViewById(R.id.tte_ttd_id);
            tv_iddok  = itemView.findViewById(R.id.tte_ttd_iddok);
            tv_nmdok  = itemView.findViewById(R.id.tte_ttd_nmdok);
            tv_desc   = itemView.findViewById(R.id.tte_ttd_desc);
            logo_file = itemView.findViewById(R.id.tte_ttd_logoFile);
        }
    }
}
