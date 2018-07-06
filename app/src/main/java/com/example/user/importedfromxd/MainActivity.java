package com.example.user.importedfromxd;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Typeface monacoFont,specifyfont,lettergothicfont,prestigeElite;
    TextView textViewMain;
    private DrawerLayout myDrawer;
    private Button buttonBurger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monacoFont= Typeface.createFromAsset(this.getAssets(),"fonts/Monaco.ttf");
        specifyfont= Typeface.createFromAsset(this.getAssets(),"fonts/SpecifyPERSONAL-NormMedium.ttf");
        lettergothicfont= Typeface.createFromAsset(this.getAssets(),"fonts/lettergothicstd.otf");
        prestigeElite= Typeface.createFromAsset(this.getAssets(),"fonts/prestigeelitebold.ttf");

        textViewMain=(TextView)findViewById(R.id.textViewMain);
        //textViewMain.setTypeface(null,Typeface.BOLD);
        /////
        //textViewMain.setTypeface(prestigeElite);
        //textViewMain.setTypeface(textViewMain.getTypeface(), Typeface.BOLD);
        //textViewMain.setTypeface(prestigeElite, Typeface.BOLD);
        //textViewMain.setTypeface(textViewMain.getTypeface(), Typeface.BOLD);
        textViewMain.setTypeface(null,Typeface.BOLD);
        textViewMain.setTypeface(prestigeElite);

        myDrawer= (DrawerLayout) findViewById(R.id.drawer);
        buttonBurger=(Button)findViewById(R.id.buttonBurger);
        myDrawer.bringToFront();
    }

    public void openDrawer(View view){
        myDrawer.openDrawer(Gravity.START);
        Toast.makeText(this,"Open Drawer",Toast.LENGTH_SHORT).show();
    }

    public void openRO(View view) {
        Toast.makeText(this,"Switch Activity!",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    }
