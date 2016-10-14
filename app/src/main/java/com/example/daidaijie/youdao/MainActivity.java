package com.example.daidaijie.youdao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.wordsEditText)
    EditText wordsEditText;
    @Bind(R.id.startButton)
    Button startButton;
    @Bind(R.id.transTextView)
    TextView transTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.startButton)
    public void onClick() {
        startTrans();
    }

    private void startTrans() {
        String baseUrl = "http://fanyi.youdao.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        TransService transService = retrofit.create(TransService.class);

        transService.getTrans(URLEncoder.encode(wordsEditText.getText().toString()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TransResult>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "翻译完成", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        transTextView.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(TransResult transResult) {
                        transTextView.setText(transResult.toString());
                    }
                });

    }
}
