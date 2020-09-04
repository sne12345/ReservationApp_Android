package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.Session;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private static final int APP_REQUEST_CODE = 7117;
    private ProgressDialog pDialog;


//    @BindView(R.id.frag4_relative1_2)
//    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴바 설정하기
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // 하단바 설정하기
        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.category:
                        setFrag(1);
                        break;
                    case R.id.message:
                        setFrag(2);
                        break;
                    case R.id.mypage:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        setFrag(0); // 첫 프레그먼트 화면을 무엇으로 지정해 줄 것인지

        getList a = new getList();
        a.execute();
    }

    // 프래그먼트 교체가 일어나는 실행문
    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch(n){
            case 0:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
        }
    }


    class getList extends AsyncTask<Void, String, Void> {
        String LoadData;
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("검색중입니다..");
            pDialog.setCancelable(false);
            pDialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... param) {
            // TODO Auto-generated method stub

            try {
                HttpParams httpParameters = new BasicHttpParams();
                HttpProtocolParams.setVersion(httpParameters, HttpVersion.HTTP_1_1);

                HttpClient client = new DefaultHttpClient(httpParameters);

                HttpConnectionParams.setConnectionTimeout(httpParameters, 7000);
                HttpConnectionParams.setSoTimeout(httpParameters, 7000);
                HttpConnectionParams.setTcpNoDelay(httpParameters, true);

                // 주소
                String postURL = "http://115.136.103.86:8081/myapp/DBConnection";

                HttpPost post = new HttpPost(postURL);
                ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

//                params.add(new BasicNameValuePair("ProjectID", PID));
//                params.add(new BasicNameValuePair("Itemleft", IL));
//                params.add(new BasicNameValuePair("Itemright", IR));

                UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                post.setEntity(ent);

                long startTime = System.currentTimeMillis();

                HttpResponse responsePOST = client.execute(post);

                long elapsedTime = System.currentTimeMillis() - startTime;
                Log.v("debugging", elapsedTime + " ");

                HttpEntity resEntity = responsePOST.getEntity();
                if (resEntity != null) {
                    LoadData = EntityUtils.toString(resEntity, HTTP.UTF_8);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            pDialog.dismiss();

        }
    }
}