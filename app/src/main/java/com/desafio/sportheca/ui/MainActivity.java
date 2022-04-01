package com.desafio.sportheca.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.desafio.sportheca.data.ResponseApi;
import com.desafio.sportheca.databinding.ActivityMainBinding;
import com.desafio.sportheca.domain.Jogador;
import com.desafio.sportheca.domain.ResponseObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ResponseApi responseApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        setupHttpClient();
        dataFromApi();
        setupResponseApiRefresh();

    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sportsmatch.com.br/teste/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        responseApi = retrofit.create(ResponseApi.class);
    }

    private void dataFromApi() {
        binding.swipeResponseApi.setRefreshing(true);
        responseApi.getResponseObject().enqueue(new Callback<ResponseObject>() {
            @Override
            public void onResponse(@NonNull Call<ResponseObject> call, @NonNull Response<ResponseObject> response) {
                if (response.isSuccessful()) {
                    ResponseObject responseApi = response.body();

                    showValues(responseApi);
                } else {
                    //showErrorMessage();
                }

                binding.swipeResponseApi.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
                //showErrorMessage();
                binding.swipeResponseApi.setRefreshing(false);
            }
        });
    }

    private void showValues(ResponseObject responseApi) {
        Jogador player = responseApi.getObject().get(0).getPlayer();

        Glide.with(getBaseContext()).load(player.getImg()).circleCrop().into(binding.userImage);

        binding.nameUserTextView.setText(player.getName());
        binding.countryUserTextView.setText(player.getCountry());
        binding.positionUserTextView.setText(player.getPos());
        binding.percentageUserTextView.setText(player.getPercentage());

        binding.cupsWonTextView.setText("" + player.getBarras().getCopas_do_Mundo_Vencidas().getPla());
        binding.cupsWonProgressBar.setProgress(player.getBarras().getCopas_do_Mundo_Vencidas().getPla());
        binding.cupsWonProgressBar.setMax(player.getBarras().getCopas_do_Mundo_Vencidas().getMax());

        binding.cupsPlayedTextView.setText("" + player.getBarras().getCopas_do_Mundo_Disputadas().getPla());
        binding.cupsPlayedProgressBar.setProgress(player.getBarras().getCopas_do_Mundo_Disputadas().getPla());
        binding.cupsPlayedProgressBar.setMax(player.getBarras().getCopas_do_Mundo_Disputadas().getMax());

        binding.posCupsPlayedTextView.setText("" + player.getBarras().getCopas_do_Mundo_Disputadas().getPos());
        binding.posCupsWonTextView.setText("" + player.getBarras().getCopas_do_Mundo_Vencidas().getPos());

    }

    private void setupResponseApiRefresh() {
        binding.swipeResponseApi.setOnRefreshListener(this::dataFromApi);
    }


}