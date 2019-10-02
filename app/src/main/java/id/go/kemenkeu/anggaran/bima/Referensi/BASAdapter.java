package id.go.kemenkeu.anggaran.bima.Referensi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.go.kemenkeu.anggaran.bima.R;

public class BASAdapter extends RecyclerView.Adapter<BASAdapter.ViewHolder> {

    private Context context;
    private List<BASModel> basList;

    public BASAdapter(Context context, List<BASModel> basList) {
        this.context = context;
        this.basList = basList;
    }

    @NonNull
    @Override
    public BASAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerview_referensi_bas, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BASAdapter.ViewHolder holder, int position) {
        BASModel bas = basList.get(position);

        holder.textKode.setText(bas.getKode());
        holder.textUraian.setText(bas.getUraian());
        holder.textDeskripsi.setText(bas.getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return basList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textKode, textUraian, textDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);

            textKode = itemView.findViewById(R.id.kode_bas);
            textUraian = itemView.findViewById(R.id.uraian_bas);
            textDeskripsi = itemView.findViewById(R.id.deskripsi_bas);
        }
    }
}
