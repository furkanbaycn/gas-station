package com.example.furkanbaycan.gasstation;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;

    public void showProgressDialog(){
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage(getString(R.string.loading));
        }
        mProgressDialog.show();
    }
    public void hideProgressDialog(){
        if (mProgressDialog!=null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    public String trToEn(String kelime){
        kelime = kelime.toLowerCase();
        char[] tmp = new char[kelime.length()];
        for( int i=0; i<kelime.length(); i++ ) {
            char c = kelime.charAt(i);
            switch( c ) {
                case 'ş': tmp[i] = 's'; break;
                case 'ç': tmp[i] = 'c'; break;
                case 'ö': tmp[i] = 'o'; break;
                case 'ü': tmp[i] = 'u'; break;
                case 'ı': tmp[i] = 'i'; break;
                case 'ğ': tmp[i] = 'g'; break;
                default: tmp[i] = c; break;
            }
        }
        kelime = new String(tmp);
        return kelime;
    }

}
