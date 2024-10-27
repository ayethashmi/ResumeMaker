package com.mintdevspro.resumemaker;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class CvViewerActivity extends AppCompatActivity {
    ImageView iv;
    Integer pageNumber = 0;
    PDFView pdfView;

    
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cv_viewer);


        String stringExtra = getIntent().getStringExtra("cvpath");
        Log.d("ggggg", "filedata" + stringExtra);
        this.pdfView = (PDFView) findViewById(R.id.pdfView1);
        File file = new File(stringExtra);
        try {
            Log.d("ffff", "fff" + stringExtra);
            this.pdfView.fromFile(file).swipeHorizontal(false).defaultPage(this.pageNumber.intValue()).enableSwipe(true).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
