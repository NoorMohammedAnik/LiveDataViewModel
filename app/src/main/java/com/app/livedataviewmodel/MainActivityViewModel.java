package com.app.livedataviewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData <String> myRandomNumber;
    String TAG= this.getClass().getSimpleName();

    public MutableLiveData <String> getMyRandomNumber()
    {
        if (myRandomNumber==null)
        {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Random random=new Random();
        myRandomNumber.postValue("Number: "+(random.nextInt(100-1)));

        Log.d(TAG,"Create random number");
    }


    @Override
    protected void onCleared() {
        super.onCleared();

        Log.d(TAG,"OnCleared: ViewModel Destroy");
    }

}
