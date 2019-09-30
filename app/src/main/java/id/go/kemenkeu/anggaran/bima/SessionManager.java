package id.go.kemenkeu.anggaran.bima;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String IDUSER = "IDUSER";
    public static final String NMUSER = "NMUSER";
    public static final String FULLNAME = "FULLNAME";
    public static final String NIP = "NIP";
    public static final String JABATAN = "JABATAN";
    public static final String IDUSERGROUP = "IDUSERGROUP";
    public static final String KDDEPT = "KDDEPT";
    public static final String KDUNIT = "KDUNIT";
    public static final String KDSATKER = "KDSATKER";
    public static final String KDLOKASI = "KDLOKASI";
    public static final String NOHP = "NOHP";
    public static final String EMAIL = "EMAIL";
    public static final String PROFILPIC = "PROFILPIC";
    public static final String TTE_NIK = "TTE_NIK";
    public static final String TTE_NAMA = "TTE_NAMA";
    public static final String STSLOGIN = "STSLOGIN";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String iduser, String nmuser, String fullname, String nip, String jabatan, String idusergroup, String kddept, String kdunit, String kdsatker, String kdlokasi, String nohp, String email, String profilpic, String tte_nik, String tte_nama, String stslogin) {
        editor.putBoolean(LOGIN, true);
        editor.putString(IDUSER, iduser);
        editor.putString(NMUSER, nmuser);
        editor.putString(FULLNAME, fullname);
        editor.putString(NIP, nip);
        editor.putString(JABATAN, jabatan);
        editor.putString(IDUSERGROUP, idusergroup);
        editor.putString(KDDEPT, kddept);
        editor.putString(KDUNIT, kdunit);
        editor.putString(KDSATKER, kdsatker);
        editor.putString(KDLOKASI, kdlokasi);
        editor.putString(NOHP, nohp);
        editor.putString(EMAIL, email);
        editor.putString(PROFILPIC, profilpic);
        editor.putString(TTE_NIK, tte_nik);
        editor.putString(TTE_NAMA, tte_nama);
        editor.putString(STSLOGIN, stslogin);
        editor.apply();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(IDUSER, sharedPreferences.getString(IDUSER, null));
        user.put(NMUSER, sharedPreferences.getString(NMUSER, null));
        user.put(FULLNAME, sharedPreferences.getString(FULLNAME, null));
        user.put(NIP, sharedPreferences.getString(NIP, null));
        user.put(JABATAN, sharedPreferences.getString(JABATAN, null));
        user.put(IDUSERGROUP, sharedPreferences.getString(IDUSERGROUP, null));
        user.put(KDDEPT, sharedPreferences.getString(KDDEPT, null));
        user.put(KDUNIT, sharedPreferences.getString(KDUNIT, null));
        user.put(KDSATKER, sharedPreferences.getString(KDSATKER, null));
        user.put(KDLOKASI, sharedPreferences.getString(KDLOKASI, null));
        user.put(NOHP, sharedPreferences.getString(NOHP, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(PROFILPIC, sharedPreferences.getString(PROFILPIC, null));
        user.put(TTE_NIK, sharedPreferences.getString(TTE_NIK, null));
        user.put(TTE_NAMA, sharedPreferences.getString(TTE_NAMA, null));
        user.put(STSLOGIN, sharedPreferences.getString(STSLOGIN, null));

        return user;
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        ((MainActivity) context).finish();
    }
}
