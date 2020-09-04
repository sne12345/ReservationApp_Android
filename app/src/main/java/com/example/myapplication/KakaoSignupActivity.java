package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.ErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.helper.log.Logger;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;

import java.util.ArrayList;
import java.util.List;


public class KakaoSignupActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestMe();
    }

    protected void requestMe() { //유저의 정보를 받아오는 함수

        List<String> keys = new ArrayList<>();
        keys.add("properties.nickname");
        keys.add("kakao_account.email");
        keys.add("kakao_account.phone_number");

        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg=" + errorResult;
                Logger.d(message);

                ErrorCode result = ErrorCode.valueOf(errorResult.getErrorCode());
                if (result == ErrorCode.CLIENT_ERROR_CODE) {
                    finish();
                } else {
                    redirectLoginActivity();
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onSuccess(MeV2Response response) {
                Logger.d("user id : " + response.getId());
                Logger.d("email: " + response.getKakaoAccount().getEmail());
                Logger.d("phone_number: " + response.getKakaoAccount().getPhoneNumber());
                redirectMainActivity();
            }

        });
    }

    private void redirectMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, Frag4.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}
