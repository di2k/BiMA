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
    public static final String NAME = "NAME";



    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String iduser, String nmuser, String name) {
        editor.putBoolean(LOGIN, true);
        editor.putString(IDUSER, iduser);
        editor.putString(NMUSER, nmuser);
        editor.putString(NAME, name);
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
        user.put(NAME, sharedPreferences.getString(NAME, null));

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
