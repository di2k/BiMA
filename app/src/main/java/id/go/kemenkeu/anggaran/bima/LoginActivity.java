package id.go.kemenkeu.anggaran.bima;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText userid, password;
    private Button btn_login;
    private ProgressBar loading;
    private static String URL_LOGIN ="https://api.sistem.online/Android_BiMA/login.php";
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        TextView textAlert = findViewById(R.id.txt_lupaPassword);
        loading = findViewById(R.id.loading);
        userid = findViewById(R.id.userid);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mUserid = userid.getText().toString().trim();
                String mPassword = password.getText().toString().trim();

                if (!mUserid.isEmpty() && !mPassword.isEmpty()) {
                    Login(mUserid, mPassword);
                } else {
                    Toast.makeText(LoginActivity.this, "User ID dan Password Harus diisi", Toast.LENGTH_SHORT).show();
                }

            }
        });

        textAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(LoginActivity.this);
            }
        });

    }

    private void Login(final String userid, final String password) {
        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String iduser = object.getString("iduser").trim();
                                    String nmuser = object.getString("nmuser").trim();
                                    String fullname = object.getString("fullname").trim();
                                    String nip = object.getString("nip").trim();
                                    String jabatan = object.getString("jabatan").trim();
                                    String idusergroup = object.getString("idusergroup").trim();
                                    String kddept = object.getString("kddept").trim();
                                    String kdunit = object.getString("kdunit").trim();
                                    String kdsatker = object.getString("kdsatker").trim();
                                    String kdlokasi = object.getString("kdlokasi").trim();
                                    String nohp = object.getString("nohp").trim();
                                    String email = object.getString("email").trim();
                                    String profilpic = object.getString("profilpic").trim();
                                    String tte_nik = object.getString("tte_nik").trim();
                                    String tte_nama = object.getString("tte_nama").trim();
                                    String stslogin = object.getString("stslogin").trim();

                                    sessionManager.createSession(iduser, nmuser, fullname, nip, jabatan, idusergroup, kddept, kdunit, kdsatker, kdlokasi, nohp, email, profilpic, tte_nik, tte_nama, stslogin);

                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("iduser", iduser);
                                    intent.putExtra("nmuser", nmuser);
                                    intent.putExtra("fullname", fullname);
                                    startActivity(intent);
                                    loading.setVisibility(View.GONE);
                                }

                            } else {
                                Toast.makeText(LoginActivity.this, "User ID dan Password tidak terdaftar", Toast.LENGTH_LONG).show();
                                loading.setVisibility(View.GONE);
                                btn_login.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "Error : User ID dan Password tidak terdaftar", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this, "Error : "+ error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("iduser", userid);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showAlertDialog(Context c) {
        final EditText textEmail = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Lupa Password")
                .setMessage("Masukkan alamat email yang terdaftar pada Satu Anggaran")
                .setView(textEmail)
                .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(textEmail.getText());
                        Toast.makeText(getApplicationContext(), "Permintaan Lupa Password telah dikirim melalui "+task, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Batal", null)
                .create();
        dialog.show();
    }

}
