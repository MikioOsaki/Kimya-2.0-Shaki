package com.example.mikio.kimya_3_0_Yevlakh;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
        Button buttonQRSearch = (Button) findViewById(R.id.buttonQRSearch);
        Button buttonForm = (Button) findViewById(R.id.buttonForm);

        buttonSearch.setOnClickListener(this);
        buttonQRSearch.setOnClickListener(this);
        buttonForm.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSearch:
                Toast.makeText(this, "Implementierung Folgt in Kürze.", Toast.LENGTH_SHORT).show();
                File pdfFile = new File(Environment
                                .getExternalStorageDirectory(), "testpdf.pdf");
                try {
                    if (pdfFile.exists()) {
                        Uri path = Uri.fromFile(pdfFile);
                        Intent objIntent = new Intent(Intent.ACTION_VIEW);
                        objIntent.setDataAndType(path, "application/pdf");
                        objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(objIntent);
                    } else {
                        Toast.makeText(MainActivity.this, "File NotFound",

                                Toast.LENGTH_SHORT).show();
                    }
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this,
                            "No Viewer Application Found", Toast.LENGTH_SHORT)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.buttonQRSearch:
                Toast.makeText(this, "Implementierung Folgt in Kürze.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonForm:
                Intent i = new Intent(this, FormActivity.class);
                startActivity(i);
                finish();
                break;

        }
    }
}
