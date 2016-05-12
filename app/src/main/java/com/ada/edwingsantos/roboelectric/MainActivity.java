package com.ada.edwingsantos.roboelectric;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class MainActivity extends AppCompatActivity {

    Button downloadBtn;
    TextView nameView;
    EditText editTextURL;

//    @BindView(R.id.btn_download)Button downloadBtn;
//    @BindView(R.id.edit_text_download)EditText editTextURL;
//    @BindView(R.id.text_view)TextView nameView;
//    @BindView(R.id.imageView)ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadBtn = (Button) findViewById(R.id.btn_download);
        nameView = (TextView) findViewById(R.id.text_view);
        editTextURL = (EditText) findViewById(R.id.edit_text_download);

        //ButterKnife.bind(this);
    }

    public void download(){

    }

    public void disableControls(){
        downloadBtn.setEnabled(false);
        editTextURL.setEnabled(false);

    }


    //download image
    public void downloadImage(View view) {
        Toast.makeText(this, R.string.roboelectric_rocks, Toast.LENGTH_LONG).show();
        disableControls();
    }

    public void downloadFinished(byte[] result){

        Intent resultAct = new Intent(this, ResultActivity.class);
        resultAct.putExtra("RESULT", result);
        startActivity(resultAct);
    }
}
