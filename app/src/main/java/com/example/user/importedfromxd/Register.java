package com.example.user.importedfromxd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.Typeface;


public class Register extends AppCompatActivity {

    TextView textViewPlease,textViewAgree;
    Typeface monacoFont,specifyfont,lettergothicfont,prestigeElite;
    EditText editText;
    Button buttonTest;
    int i=1;
    boolean agreement=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        monacoFont= Typeface.createFromAsset(this.getAssets(),"fonts/Monaco.ttf");
        specifyfont= Typeface.createFromAsset(this.getAssets(),"fonts/SpecifyPERSONAL-NormMedium.ttf");
        lettergothicfont= Typeface.createFromAsset(this.getAssets(),"fonts/lettergothicstd.otf");
        prestigeElite= Typeface.createFromAsset(this.getAssets(),"fonts/prestigeelitebold.ttf");
        textViewPlease=(TextView)findViewById(R.id.textViewPlease);
        textViewAgree=(TextView)findViewById(R.id.textViewAgree);
        editText = (EditText) findViewById(R.id.editText);
        buttonTest = (Button) findViewById(R.id.buttonTest);

        textViewPlease.setTypeface(specifyfont);
        textViewAgree.setTypeface(specifyfont);

        textViewPlease.setTypeface(null, Typeface.BOLD);

        String text = "I agree to Tamuku's Terms of Service and Privacy Policy.";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan foreColor = new ForegroundColorSpan(Color.rgb(0,150,136));
        ForegroundColorSpan foreColor2 = new ForegroundColorSpan(Color.rgb(0,150,136));

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //can make changes here
                Toast.makeText( getBaseContext() , "Terms of Service!", Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this,"Terms of Service!",Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                //can make changes here
                Toast.makeText(Register.this,"Privacy Policy!",Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this,"Privacy Policy!",Toast.LENGTH_SHORT).show();
            }
        };

        ss.setSpan(clickableSpan1, 20,36,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(clickableSpan2, 41,55,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        ss.setSpan(foreColor,20,36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(foreColor2,41,55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textViewAgree.setText(ss);
        textViewAgree.setMovementMethod(LinkMovementMethod.getInstance());

        editText.setGravity(Gravity.CENTER);
        editText.setTypeface(null, Typeface.BOLD);
    }

    public void onClickNext(View view){
        if (agreement==false){
            Toast.makeText(Register.this,"You must agree to Tamuku's Terms of Service and Privacy Policy to continue ",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Register.this, "Next", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickCancel(View view){
        Toast.makeText(Register.this,"Cancel",Toast.LENGTH_SHORT).show();
    }
    public void changeMe(View view){
        if (view==buttonTest){
            i++;
            if (i%2==0){
                buttonTest.setBackgroundResource(R.drawable.checked3);
                agreement=true;
            }
            else{
                buttonTest.setBackgroundResource(R.drawable.unchecked);
                agreement=false;
            }
        }
    }

}
