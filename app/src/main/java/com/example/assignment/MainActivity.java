package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.assignment.dashboard.DashboardActivity;
import com.example.assignment.models.PostMobileNumberRequest;
import com.example.assignment.models.SendOtp;
import com.example.assignment.models.VerifyOtp;
import com.example.assignment.network.NetworkApi;
import com.example.assignment.network.RetrofitHelper;
import com.example.assignment.utils.AppPreferences;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etPhoneNumber)
    EditText ePhoneNumber;
    @BindView(R.id.etOtp)
    EditText eOtp;
    @BindView(R.id.bSendOtp)
    TextView bSendOtp;
    @BindView(R.id.bLogin)
    TextView btLogin;
    @BindView(R.id.textview_mobileno)
    TextView tvMobileNo;
    @BindView(R.id.numberlayout)
    ConstraintLayout llNumber;
    @BindView(R.id.otplayout)
    ConstraintLayout llOtp;
    @BindView(R.id.timer)
    TextView tvTimer;
    @BindView(R.id.progressBar)
    ProgressBar loader;

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppPreferences.getAccessToken(MainActivity.this) == null) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            ePhoneNumber.setText("9876543212");
        } else {
            startActivity(new Intent(MainActivity.this, DashboardActivity.class));
            finish();
        }
    }


    @OnClick({R.id.bSendOtp, R.id.bLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bSendOtp:
                if (ePhoneNumber.length() < 10) {
                    Toast.makeText(this, getString(R.string.please_enter_mobileno), Toast.LENGTH_SHORT).show();
                } else {
                    sendOtp("+91" + ePhoneNumber.getText().toString());
                }
                break;
            case R.id.bLogin:
                if (eOtp.length() < 4) {
                    Toast.makeText(this, getString(R.string.please_enter_otp), Toast.LENGTH_SHORT).show();
                } else {
                    VerifyOtp("+91" + ePhoneNumber.getText().toString(), eOtp.getText().toString());
                }
                break;
        }
    }

    private void sendOtp(String etphoneno) {
        if (isNetworkAvailable()) {
            loader.setVisibility(View.VISIBLE);
            bSendOtp.setEnabled(false);
            PostMobileNumberRequest request = new PostMobileNumberRequest();
            request.setNumber(etphoneno);
            NetworkApi service = RetrofitHelper.getInstance().getclient();
            Call<SendOtp> call = service.postSendOtp(request);
            call.enqueue(new Callback<SendOtp>() {
                @Override
                public void onResponse(Call<SendOtp> call, Response<SendOtp> response) {
                    loader.setVisibility(View.GONE);
                    bSendOtp.setEnabled(true);
                    if (response.code() == 200 & response.body().getStatus() != null && response.body().getStatus()) {
                        tvMobileNo.setText(etphoneno);
                        llNumber.setVisibility(View.GONE);
                        llOtp.setVisibility(View.VISIBLE);
                        funTimer();
                    } else {
                        loader.setVisibility(View.GONE);
                        Toast.makeText(MainActivity.this, getString(R.string.something_wrong), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SendOtp> call, Throwable t) {
                    t.printStackTrace();
                    loader.setVisibility(View.GONE);
                    bSendOtp.setEnabled(true);
                    Toast.makeText(MainActivity.this, getString(R.string.something_wrong), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, getString(R.string.no_network), Toast.LENGTH_SHORT).show();
        }
    }

    private void VerifyOtp(String etphoneno, String otp) {
        loader.setVisibility(View.VISIBLE);
        btLogin.setEnabled(false);
        PostMobileNumberRequest request = new PostMobileNumberRequest();
        request.setNumber(etphoneno);
        request.setOtp(otp);
        NetworkApi service = RetrofitHelper.getInstance().getclient();
        Call<VerifyOtp> call = service.postVerifyOtp(request);
        call.enqueue(new Callback<VerifyOtp>() {
            @Override
            public void onResponse(Call<VerifyOtp> call, Response<VerifyOtp> response) {
                loader.setVisibility(View.GONE);
                btLogin.setEnabled(true);
                if (response.code() == 200 && response.body().getToken() != null) {
                    String accesstoken = response.body().getToken();
                    AppPreferences.setAccessToken(MainActivity.this, accesstoken);
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.invalid_otp), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VerifyOtp> call, Throwable t) {
                t.printStackTrace();
                loader.setVisibility(View.GONE);
                btLogin.setEnabled(true);
                Toast.makeText(MainActivity.this, getString(R.string.something_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Check all connectivities whether available or not
    public boolean isNetworkAvailable() {
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void funTimer() {
        timer = new CountDownTimer(60000, 1000) {
            public void onTick(long millis) {
                // Used for formatting digit to be in 2 digits only
                String formattedTime = String.format(
                        "%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millis) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millis) % 60);
                if (timer != null) {
                    tvTimer.setText(formattedTime);
                }
            }

            public void onFinish() {
                tvTimer.setText(getString(R.string.timeout));
                llOtp.setVisibility(View.GONE);
                llNumber.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        if (llOtp.getVisibility() == View.VISIBLE) {
            llOtp.setVisibility(View.GONE);
            llNumber.setVisibility(View.VISIBLE);
            if (timer != null) {
                timer.cancel();
            }
            return;
        }
        super.onBackPressed();
    }
}