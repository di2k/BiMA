package id.go.kemenkeu.anggaran.bima.Referensi;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class ReferensiSBMDatabase extends SQLiteAssetHelper {
    public static final String DB_NAME = "sbm_db.db";
    public static final int DB_VERSION = 1;

    public ReferensiSBMDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
