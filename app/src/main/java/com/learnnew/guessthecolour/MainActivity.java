package com.learnnew.guessthecolour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    private boolean delete = false;
    int CODE_SIZE=0;
    EditText myEditText;
    LinearLayout l_layout,ll;
    int cnt=0;
    String ans="COLOUR";
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int temp;
    LinearLayout.LayoutParams mparam;
    Button btn_hint;
    String check_ans="";
    Random rnd = new Random();
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


         img = (ImageView) findViewById(R.id.imgRandom);
        //editText=findViewById(R.id.et1);

        ll = (LinearLayout) findViewById(R.id.ll);
        l_layout = (LinearLayout) findViewById(R.id.linearlayout);
        mparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btn_hint= findViewById(R.id.btn_hint);


        temp=rnd.nextInt(4);
        String str = "img_" + temp;
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );


        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t10);
        t11 = findViewById(R.id.t11);
        t12 = findViewById(R.id.t12);
        t13 = findViewById(R.id.t13);
        t14 = findViewById(R.id.t14);

        t1.setTag(1);
        t2.setTag(2);
        t3.setTag(3);
        t4.setTag(4);
        t5.setTag(5);
        t6.setTag(6);
        t7.setTag(7);
        t8.setTag(8);
        t9.setTag(9);
        t10.setTag(10);
        t11.setTag(11);
        t12.setTag(12);
        t13.setTag(13);
        t14.setTag(14);


        setImageBlock(temp);

        randomLetters();

        createEditText();


        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAns=" ";
                ArrayList letters = new ArrayList();
                for(int i=0;i<ans.length();i++)
                {
                    letters.add(ans.charAt(i));
                }
                Collections.shuffle(letters);
                for(int i=0;i<ans.length();i++) {
                    sAns += letters.get(i)+"    ";
                }
                Toast.makeText(getApplicationContext(),sAns,Toast.LENGTH_SHORT).show();
            }
        });


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValuetoAnswer(t1.getText().toString(), (Integer) t1.getTag());
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValuetoAnswer(t2.getText().toString(),(Integer) t2.getTag());
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t3.getText().toString(),(Integer) t3.getTag());
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t4.getText().toString(),(Integer) t4.getTag());
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t5.getText().toString(),(Integer) t5.getTag());
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t6.getText().toString(),(Integer) t6.getTag());
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t7.getText().toString(),(Integer) t7.getTag());
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t8.getText().toString(),(Integer) t8.getTag());
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t9.getText().toString(),(Integer) t9.getTag());
            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t10.getText().toString(),(Integer) t10.getTag());
            }
        });

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t11.getText().toString(),(Integer) t11.getTag());
            }
        });
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t12.getText().toString(),(Integer) t12.getTag());
            }
        });
        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t13.getText().toString(),(Integer) t13.getTag());
            }
        });
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setValuetoAnswer(t14.getText().toString(),(Integer) t14.getTag());
            }
        });

    }

    private void createEditText() {

        for (int i =0;i<cnt;i++) {

            myEditText = new EditText(getApplicationContext());
            myEditText.setLayoutParams(mparam);
            myEditText.setTextSize(20);
            myEditText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            myEditText.setTag(i);
            myEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(1)});
            myEditText.setFocusableInTouchMode(false);
            l_layout.addView(myEditText);
        }

        for(int i=0;i<cnt-1;i++)
        {

            EditText editText = (EditText) l_layout.findViewWithTag(i);
            EditText editText2 = (EditText) l_layout.findViewWithTag(i+1);

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int count, int after) {

                    if (editText.length() == 1) {
                        editText2.requestFocus();
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                    editText2.requestFocus();
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                    // TODO Auto-generated method stub
                    editText.requestFocus();
                }

            });


        }

    }

    private void setImageBlock(int temp) {

        switch(temp){
            case 0:
                cnt = 4;
                ans = "PINK";
                CODE_SIZE = cnt;
                break;
            case 1:
                cnt = 3;
                ans = "RED";
                CODE_SIZE = cnt;
                break;
            case 2:
                cnt = 4;
                ans="BLUE";
                CODE_SIZE = cnt;
                break;
            case 3:
                cnt = 5;
                ans="GREEN";
                CODE_SIZE = cnt;
                break;
            case 4:
                cnt = 6;
                ans="ORANGE";
                CODE_SIZE = cnt;
                break;

        }
    }

    private void randomLetters() {

        for(int k=1;k<15;k++) {
            Random randomAlpha = new Random();
            char randomChar2 = alphabet.charAt(randomAlpha.nextInt(alphabet.length()));
            int cc=0;

            for(int m=0;m<ans.length();m++)
            {
                if(randomChar2!=ans.charAt(m)){
                    cc=cc+1;
                }
            }

            if(cc==ans.length()) {
                TextView textView = (TextView) ll.findViewWithTag(k);
                textView.setText(String.valueOf(randomChar2));
            }

        }

        ArrayList numbers = new ArrayList();
        for(int i=0;i<14;i++)
        {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);

        for(int k=0;k<ans.length();k++) {

            TextView textView = (TextView) ll.findViewWithTag(numbers.get(k));
            System.out.println("=="+textView.getText().toString());
            String x = textView.getText().toString();
            textView.setText(String.valueOf(ans.charAt(k)));


        }

    }


    private void setValuetoAnswer(String s,int t) {

        EditText editText;
        TextView textV = ll.findViewWithTag(t);
        for(int i=0;i<cnt;i++) {
            editText = (EditText) l_layout.findViewWithTag(i);
            if (editText.length() == 0) {
                editText.setText(s);
                textV.setVisibility(View.INVISIBLE);
                check_ans+=s;
                break;
            }

        }

        System.out.println("checkans"+check_ans);

        //check answer completed or not
        if(check_ans.equals(ans)&&check_ans.length()==ans.length())
        {
            Toast.makeText(getApplicationContext(),"Answer Correct",Toast.LENGTH_SHORT).show();
            deleteEditText();
            gotoNextQuestion();
        }
        else if(!check_ans.equals(ans)&&check_ans.length()==ans.length()){
            Toast.makeText(getApplicationContext(),"Answer Wrong",Toast.LENGTH_SHORT).show();
            resetEditText();
        }

    }

    private void deleteEditText() {

        EditText editText;
        TextView textV;//= ll.findViewWithTag(t);
        check_ans="";
        for (int i = 0; i < cnt; i++) {
            editText = (EditText) l_layout.findViewWithTag(i);
            editText.setText("");
            l_layout.removeView(editText);

        }
        for(int i=1;i<15;i++)

        {
            textV=ll.findViewWithTag(i);
            textV.setVisibility(View.VISIBLE);
        }
    }

    private void gotoNextQuestion() {

        temp=rnd.nextInt(4);
        String str = "img_" + temp;
        img.setImageDrawable
                (
                        getResources().getDrawable(getResourceID(str, "drawable",
                                getApplicationContext()))
                );

        setImageBlock(temp);

        randomLetters();

        createEditText();
    }

    private void resetEditText() {

        EditText editText;
        TextView textV;
        check_ans="";
        for (int i = 0; i < cnt; i++) {
            editText = (EditText) l_layout.findViewWithTag(i);
            editText.setText("");


        }
        for(int i=1;i<15;i++)

        {
            textV=ll.findViewWithTag(i);
            textV.setVisibility(View.VISIBLE);
        }
    }

    protected final static int getResourceID(final String resName, final String resType, final Context ctx)
    {
        final int ResourceID =
                ctx.getResources().getIdentifier(resName, resType,
                        ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }


}