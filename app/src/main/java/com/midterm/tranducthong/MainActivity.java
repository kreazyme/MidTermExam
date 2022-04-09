package com.midterm.tranducthong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.annotation.SuppressLint;
//import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;
    private APIService apiService;
    private CyclerAdapter adapter;
    private ArrayList<ApiModel> lsmodel = new ArrayList<>();
    RecyclerView rcv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new CyclerAdapter(this, lsmodel);
        rcv = findViewById(R.id.rcv);
        rcv.setAdapter(adapter);
        apiService = new APIService();
        apiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<ApiModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<ApiModel> dogBreedsList) {
//                        Log.d("DEBUG1","Sucess");
//                        lsmodel.clear();
//                        lsmodel.addAll(dogBreedsList);
//                        lsmodel = dogBreedsList;
//                        adapter.notifyDataSetChanged();
                        for (ApiModel dog:dogBreedsList){
                            lsmodel.add(dog);
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
//                        Log.d("DEBUG1","Fail"+e.getMessage());
                        System.out.println(e.getMessage());
                    }
                });
        rcv.setLayoutManager(new GridLayoutManager(this,1));

        rcv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@androidx.annotation.NonNull RecyclerView rv, @androidx.annotation.NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@androidx.annotation.NonNull RecyclerView rv, @androidx.annotation.NonNull MotionEvent e) {
                System.out.println("Click je");
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

    }
}