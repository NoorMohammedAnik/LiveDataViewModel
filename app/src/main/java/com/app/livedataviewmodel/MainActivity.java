package com.app.livedataviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtNumber;
    Button btnChange;

    String TAG= this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber=findViewById(R.id.txt_number);
        btnChange=findViewById(R.id.btn_change);


        //ViewModel Initialization
        MainActivityViewModel viewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData <String> myRandomNumber=viewModel.getMyRandomNumber();


        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtNumber.setText(s);
                Log.i(TAG, "UI updated");
            }
        });



        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.createNumber();
            }
        });

    }
}