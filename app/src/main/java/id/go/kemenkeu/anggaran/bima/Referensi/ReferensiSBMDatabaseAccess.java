package id.go.kemenkeu.anggaran.bima.Referensi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ReferensiSBMDatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static ReferensiSBMDatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private ReferensiSBMDatabaseAccess(Context context) {
        this.openHelper = new ReferensiSBMDatabase(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static ReferensiSBMDatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new ReferensiSBMDatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getSBM() {
        List<String> list = new ArrayList<>();
        String[] xx = {"001"};
        Cursor cursor = database.rawQuery("SELECT nmsbu FROM t_sbu WHERE substr(kdsbu,-3) = ?", xx);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("datadb",list.toString());
        return list;
    }
}
