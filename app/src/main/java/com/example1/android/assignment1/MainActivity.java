package com.example1.android.assignment1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
   RangeBar rangeBar;
   TextView minimumYear,maximumYear;
   SwitchCompat Soundswitch,Menswitch,Womenswitch;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rangeBar = (RangeBar)findViewById(R.id.rangebar1);
        minimumYear = (TextView)findViewById(R.id.minyear);
        maximumYear = (TextView)findViewById(R.id.maxyears);
        Soundswitch = (SwitchCompat)findViewById(R.id.soundPressed);
        Menswitch = (SwitchCompat)findViewById(R.id.Menswitch);
        Womenswitch = (SwitchCompat)findViewById(R.id.Womenswitch);


        rangeBar.setSeekPinByValue(66);
        maximumYear.setText("66 years");
        Menswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(!buttonView.isChecked()){
                     if(!Womenswitch.isChecked()){
                         Womenswitch.setChecked(true);
                     }
                 }
            }
        });

        Womenswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!buttonView.isChecked()){
                    if(!Menswitch.isChecked()){
                        Menswitch.setChecked(true);
                    }
                }
            }
        });


        Soundswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

                    LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                    View dialogView = inflater.inflate(R.layout.dialogalert, null);
                    builder1.setView(dialogView);



                    final AlertDialog alert11 = builder1.create();

                  //  alert11.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(150,153,0,77)));

                   alert11.getWindow().getAttributes().verticalMargin = 0.3f;
                  //  alert11.getWindow().getAttributes().alpha = 0.7f;
                    alert11.setCancelable(false);

                    alert11.show();

                    final Handler handler  = new Handler();
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (alert11.isShowing()) {
                                alert11.dismiss();
                            }
                        }
                    };

                    alert11.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            handler.removeCallbacks(runnable);
                        }
                    });

                    handler.postDelayed(runnable, 2000);
                }
            }
        });

        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                   minimumYear.setText(""+leftPinValue+"-");
                   maximumYear.setText(rightPinValue+" years");
            }
        });




    }

    public void go(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.go_alert1,null);
        builder1.setView(dialogView);



        final AlertDialog alert11 = builder1.create();

        //  alert11.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(150,153,0,77)));

        // alert11.getWindow().getAttributes().verticalMargin = 0.3f;
        //  alert11.getWindow().getAttributes().alpha = 0.7f;
        alert11.setCancelable(true);

        alert11.show();

    }




}
