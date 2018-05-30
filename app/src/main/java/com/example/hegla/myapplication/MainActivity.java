package com.example.hegla.myapplication;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private EditText mEditAmount;
    private EditText mEditPercentage;
    private Button mDone;
    private double tip_res;
    private CoordinatorLayout mSnackBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditAmount=(EditText) findViewById(R.id.totalAmount);
        mEditPercentage=(EditText) findViewById(R.id.tip_percentage);
        mSnackBarLayout =findViewById(R.id.snackbarcontainer);
        mDone=(Button) findViewById(R.id.done);

        mDone.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                        if(mEditAmount.getText().toString().length() <=0){

                            final Snackbar snackbar= Snackbar.make(mSnackBarLayout, "Please enter the amount",
                                    Snackbar.LENGTH_INDEFINITE);

                            TextView tv=(TextView)(snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                            tv.setTextColor(Color.WHITE);

                            ViewGroup group=(ViewGroup) snackbar.getView();
                            group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                            snackbar.setActionTextColor(Color.WHITE);
                            snackbar.setAction("ok", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    snackbar.dismiss();
                                    mEditPercentage.setText("");
                                    mEditAmount.setText("");
                                }
                            });

                            snackbar.show();

                        }

                        else if (mEditPercentage.getText().toString().length() <=0){
                            /**
                            final Snackbar snackbar= Snackbar.make(mSnackBarLayout, "Please enter the tip percentage  ",
                                    Snackbar.LENGTH_INDEFINITE);

                            TextView tv=(TextView)(snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                            tv.setTextColor(Color.WHITE);

                            ViewGroup group=(ViewGroup) snackbar.getView();
                            group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                            snackbar.setActionTextColor(Color.WHITE);
                            snackbar.setAction("ok", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    snackbar.dismiss();
                                    mEditPercentage.setText("");
                                    mEditAmount.setText("");
                                }
                            });

                            snackbar.show();
                             */

                            double amount=Double.parseDouble(mEditAmount.getText().toString());
                            double tip_per=10;
                            tip_res =(amount+tip_per)/100;
                            Log.d(TAG, "onClick() called with: v = [" + tip_res + "]");

                            final Snackbar snackbar= Snackbar.make(mSnackBarLayout,
                                    "Tip is : " + tip_res,
                                    Snackbar.LENGTH_INDEFINITE);

                            TextView tv=(TextView)(snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                            tv.setTextColor(Color.WHITE);

                            ViewGroup group=(ViewGroup) snackbar.getView();
                            group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                            snackbar.setActionTextColor(Color.WHITE);
                            snackbar.setAction("ok", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    snackbar.dismiss();
                                    mEditPercentage.setText("");
                                    mEditAmount.setText("");
                                }
                            });

                            snackbar.show();

                        }

                        else{
                            double amount=Double.parseDouble(mEditAmount.getText().toString());
                            double tip_per=Double.parseDouble(mEditPercentage.getText().toString());
                            tip_res =(amount+tip_per)/100;
                            Log.d(TAG, "onClick() called with: v = [" + tip_res + "]");

                            final Snackbar snackbar= Snackbar.make(mSnackBarLayout,
                                    "Tip is : " + tip_res,
                                    Snackbar.LENGTH_INDEFINITE);

                            TextView tv=(TextView)(snackbar.getView()).findViewById(android.support.design.R.id.snackbar_text);
                            tv.setTextColor(Color.WHITE);

                            ViewGroup group=(ViewGroup) snackbar.getView();
                            group.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                            snackbar.setActionTextColor(Color.WHITE);
                            snackbar.setAction("ok", new View.OnClickListener(){
                                @Override
                                public void onClick(View v){
                                    snackbar.dismiss();
                                    mEditPercentage.setText("");
                                    mEditAmount.setText("");
                                }
                            });

                            snackbar.show();
                        }



            }

        });
    }
}
