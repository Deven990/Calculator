package com.example.calculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.widget.SwitchCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class MainActivity extends AppCompatActivity {

    private EditText curIn;

    String CalcIn2;
    Expression expression;
    boolean deg;
    String[] splitText = new String[3];
    int cursorPos;

    private Function[] myFunctions = {
            new Function("sin") {
                public double apply(double... args) {
                    return Math.sin(Math.toRadians(args[0]));
                }
            },
            new Function("cos") {
                public double apply(double... args) {
                    return Math.cos(Math.toRadians(args[0]));
                }
            },
            new Function("tan") {
                public double apply(double... args) {
                    return Math.tan(Math.toRadians(args[0]));
                }
            },
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ConstraintLayout new_layout = findViewById(R.id.constraintLayout);
        SwitchCompat theme = findViewById(R.id.switch_theme);
        final Button add = findViewById(R.id.ButtonAdd);
        final Button sub = findViewById(R.id.ButtonSub);
        final Button mul = findViewById(R.id.ButtonMul);
        final Button div = findViewById(R.id.ButtonDiv);
        final Button pwr = findViewById(R.id.pwr);
        final Button inv = findViewById(R.id.Buttonclr);
        final Button sin = findViewById(R.id.button);
        final Button cos = findViewById(R.id.button2);
        final Button tan = findViewById(R.id.button3);
        final Button button0 = findViewById(R.id.Button0);
        final Button button1 = findViewById(R.id.Button1);
        final Button button2 = findViewById(R.id.Button2);
        final Button button3 = findViewById(R.id.Button3);
        final Button button4 = findViewById(R.id.Button4);
        final Button button5 = findViewById(R.id.Button5);
        final Button button6 = findViewById(R.id.Button6);
        final Button button7 = findViewById(R.id.Button7);
        final Button button8 = findViewById(R.id.Button8);
        final Button button9 = findViewById(R.id.Button9);
        final Button buttonclr = findViewById(R.id.button4);
        final Button buttondec = findViewById(R.id.Buttondec);
        final Button buttonbracC = findViewById(R.id.ButtonbracC);
        final Button buttonbracO = findViewById(R.id.ButtonbracO);
        final ToggleButton clr = findViewById(R.id.buttonclr);
        final Button log = findViewById(R.id.buttonlog);
        final Button e = findViewById(R.id.buttonexp);
        final Button sqrt = findViewById(R.id.buttonsqrt);
        final Button result = findViewById(R.id.result);
        curIn = findViewById(R.id.curIn);

        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    new_layout.setBackgroundColor(Color.parseColor("#ffffff"));
                    button0.setBackgroundColor(Color.parseColor("#ffffff"));
                    button1.setBackgroundColor(Color.parseColor("#ffffff"));
                    button2.setBackgroundColor(Color.parseColor("#ffffff"));
                    button3.setBackgroundColor(Color.parseColor("#ffffff"));
                    button4.setBackgroundColor(Color.parseColor("#ffffff"));
                    button5.setBackgroundColor(Color.parseColor("#ffffff"));
                    button6.setBackgroundColor(Color.parseColor("#ffffff"));
                    button7.setBackgroundColor(Color.parseColor("#ffffff"));
                    button8.setBackgroundColor(Color.parseColor("#ffffff"));
                    button9.setBackgroundColor(Color.parseColor("#ffffff"));
                    buttonclr.setBackgroundColor(Color.parseColor("#ffffff"));
                    buttondec.setBackgroundColor(Color.parseColor("#ffffff"));
                    buttonbracC.setBackgroundColor(Color.parseColor("#ffffff"));
                    buttonbracO.setBackgroundColor(Color.parseColor("#ffffff"));
                    add.setBackgroundColor(Color.parseColor("#ffffff"));
                    sub.setBackgroundColor(Color.parseColor("#ffffff"));
                    div.setBackgroundColor(Color.parseColor("#ffffff"));
                    mul.setBackgroundColor(Color.parseColor("#ffffff"));
                    pwr.setBackgroundColor(Color.parseColor("#ffffff"));
                    inv.setBackgroundColor(Color.parseColor("#ffffff"));
                    sin.setBackgroundColor(Color.parseColor("#ffffff"));
                    cos.setBackgroundColor(Color.parseColor("#ffffff"));
                    tan.setBackgroundColor(Color.parseColor("#ffffff"));
                    log.setBackgroundColor(Color.parseColor("#ffffff"));
                    e.setBackgroundColor(Color.parseColor("#ffffff"));
                    sqrt.setBackgroundColor(Color.parseColor("#ffffff"));
                    result.setBackgroundColor(Color.parseColor("#ffffff"));
                    curIn.setBackgroundColor(Color.parseColor("#ffffff"));
                    clr.setBackgroundColor(Color.parseColor("#ffffff"));
                    button0.setTextColor(Color.parseColor("#111111"));
                    button1.setTextColor(Color.parseColor("#111111"));
                    button2.setTextColor(Color.parseColor("#111111"));
                    button3.setTextColor(Color.parseColor("#111111"));
                    button4.setTextColor(Color.parseColor("#111111"));
                    button5.setTextColor(Color.parseColor("#111111"));
                    button6.setTextColor(Color.parseColor("#111111"));
                    button7.setTextColor(Color.parseColor("#111111"));
                    button8.setTextColor(Color.parseColor("#111111"));
                    button9.setTextColor(Color.parseColor("#111111"));
                    buttonclr.setTextColor(Color.parseColor("#111111"));
                    buttondec.setTextColor(Color.parseColor("#111111"));
                    buttonbracC.setTextColor(Color.parseColor("#111111"));
                    buttonbracO.setTextColor(Color.parseColor("#111111"));
                    add.setTextColor(Color.parseColor("#111111"));
                    sub.setTextColor(Color.parseColor("#111111"));
                    div.setTextColor(Color.parseColor("#111111"));
                    mul.setTextColor(Color.parseColor("#111111"));
                    pwr.setTextColor(Color.parseColor("#111111"));
                    inv.setTextColor(Color.parseColor("#111111"));
                    sin.setTextColor(Color.parseColor("#111111"));
                    cos.setTextColor(Color.parseColor("#111111"));
                    tan.setTextColor(Color.parseColor("#111111"));
                    log.setTextColor(Color.parseColor("#111111"));
                    e.setTextColor(Color.parseColor("#111111"));
                    sqrt.setTextColor(Color.parseColor("#111111"));
                    result.setTextColor(Color.parseColor("#111111"));
                    curIn.setTextColor(Color.parseColor("#111111"));
                    clr.setTextColor(Color.parseColor("#111111"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        button0.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button1.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button2.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button3.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button4.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button5.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button6.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button7.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button8.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        button9.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        buttonclr.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        buttondec.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        buttonbracC.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        buttonbracO.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        add.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        sub.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        div.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        mul.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        pwr.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        inv.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        sin.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        cos.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        tan.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        log.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        e.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        sqrt.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        result.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        curIn.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                        clr.setOutlineSpotShadowColor(Color.parseColor("#ffffff"));
                    }
                    
                }
                else{
                    new_layout.setBackgroundColor(Color.parseColor("#333333"));
                    button0.setBackgroundColor(Color.parseColor("#333333"));
                    button1.setBackgroundColor(Color.parseColor("#333333"));
                    button2.setBackgroundColor(Color.parseColor("#333333"));
                    button3.setBackgroundColor(Color.parseColor("#333333"));
                    button4.setBackgroundColor(Color.parseColor("#333333"));
                    button5.setBackgroundColor(Color.parseColor("#333333"));
                    button6.setBackgroundColor(Color.parseColor("#333333"));
                    button7.setBackgroundColor(Color.parseColor("#333333"));
                    button8.setBackgroundColor(Color.parseColor("#333333"));
                    button9.setBackgroundColor(Color.parseColor("#333333"));
                    buttonclr.setBackgroundColor(Color.parseColor("#333333"));
                    buttondec.setBackgroundColor(Color.parseColor("#333333"));
                    buttonbracC.setBackgroundColor(Color.parseColor("#333333"));
                    buttonbracO.setBackgroundColor(Color.parseColor("#333333"));
                    add.setBackgroundColor(Color.parseColor("#333333"));
                    sub.setBackgroundColor(Color.parseColor("#333333"));
                    div.setBackgroundColor(Color.parseColor("#333333"));
                    mul.setBackgroundColor(Color.parseColor("#333333"));
                    pwr.setBackgroundColor(Color.parseColor("#333333"));
                    inv.setBackgroundColor(Color.parseColor("#333333"));
                    sin.setBackgroundColor(Color.parseColor("#333333"));
                    cos.setBackgroundColor(Color.parseColor("#333333"));
                    tan.setBackgroundColor(Color.parseColor("#333333"));
                    log.setBackgroundColor(Color.parseColor("#333333"));
                    e.setBackgroundColor(Color.parseColor("#333333"));
                    sqrt.setBackgroundColor(Color.parseColor("#333333"));
                    result.setBackgroundColor(Color.parseColor("#333333"));
                    curIn.setBackgroundColor(Color.parseColor("#333333"));
                    clr.setBackgroundColor(Color.parseColor("#333333"));
                    button0.setTextColor(Color.parseColor("#ffffff"));
                    button1.setTextColor(Color.parseColor("#ffffff"));
                    button2.setTextColor(Color.parseColor("#ffffff"));
                    button3.setTextColor(Color.parseColor("#ffffff"));
                    button4.setTextColor(Color.parseColor("#ffffff"));
                    button5.setTextColor(Color.parseColor("#ffffff"));
                    button6.setTextColor(Color.parseColor("#ffffff"));
                    button7.setTextColor(Color.parseColor("#ffffff"));
                    button8.setTextColor(Color.parseColor("#ffffff"));
                    button9.setTextColor(Color.parseColor("#ffffff"));
                    buttonclr.setTextColor(Color.parseColor("#ffffff"));
                    buttondec.setTextColor(Color.parseColor("#ffffff"));
                    buttonbracC.setTextColor(Color.parseColor("#ffffff"));
                    buttonbracO.setTextColor(Color.parseColor("#ffffff"));
                    add.setTextColor(Color.parseColor("#ffffff"));
                    sub.setTextColor(Color.parseColor("#ffffff"));
                    div.setTextColor(Color.parseColor("#ffffff"));
                    mul.setTextColor(Color.parseColor("#ffffff"));
                    pwr.setTextColor(Color.parseColor("#ffffff"));
                    inv.setTextColor(Color.parseColor("#ffffff"));
                    sin.setTextColor(Color.parseColor("#ffffff"));
                    cos.setTextColor(Color.parseColor("#ffffff"));
                    tan.setTextColor(Color.parseColor("#ffffff"));
                    log.setTextColor(Color.parseColor("#ffffff"));
                    e.setTextColor(Color.parseColor("#ffffff"));
                    sqrt.setTextColor(Color.parseColor("#ffffff"));
                    result.setTextColor(Color.parseColor("#ffffff"));
                    curIn.setTextColor(Color.parseColor("#ffffff"));
                    clr.setTextColor(Color.parseColor("#ffffff"));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        button0.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button1.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button2.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button3.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button4.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button5.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button6.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button7.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button8.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        button9.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        buttonclr.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        buttondec.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        buttonbracC.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        buttonbracO.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        add.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        sub.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        div.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        mul.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        pwr.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        inv.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        sin.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        cos.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        tan.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        log.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        e.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        sqrt.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        result.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        curIn.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                        clr.setOutlineSpotShadowColor(Color.parseColor("#333333"));
                    }
                }
            }
        });
        curIn.setShowSoftInputOnFocus(false);
        curIn.setText("");

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "0" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "1" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "2" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "3" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "4" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "5" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "6" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "7" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "8" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "9" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        buttondec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "." + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        buttonbracO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "(" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        buttonbracC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + ")" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "+" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "-" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "/" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "*" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        pwr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "^" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "pi" + splitText[1]);
                curIn.setSelection(cursorPos + 2);
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "sin(" + splitText[1]);
                curIn.setSelection(cursorPos + 4);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "cos(" + splitText[1]);
                curIn.setSelection(cursorPos + 4);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "tan(" + splitText[1]);
                curIn.setSelection(cursorPos + 4);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "log" + splitText[1]);
                curIn.setSelection(cursorPos + 3);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "exp" + splitText[1]);
                curIn.setSelection(cursorPos + 3);
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "sqrt" + splitText[1]);
                curIn.setSelection(cursorPos + 4);
            }
        });

        clr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    deg = true;
                } else
                    deg = false;
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                CalcIn2 = curIn.getText().toString();
                try {
                    if (deg) {
                        expression = new ExpressionBuilder(CalcIn2).functions(myFunctions).build();
                        double value = expression.evaluate();
                        curIn.setText(Double.toString(value));
                    } else {
                        expression = new ExpressionBuilder(CalcIn2).build();
                        double value = expression.evaluate();
                        curIn.setText(Double.toString(value));
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                curIn.setSelection(curIn.length());
            }
        });

        buttonclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcIn2 = curIn.getText().toString();
                try {
                    if (!CalcIn2.isEmpty()) {
                        splitText = splitStrings(curIn.getText());
                        int len = splitText[0].length() - 1;
                        splitText[2] = splitText[0].substring(0, len);
                        CalcIn2 = splitText[2] + splitText[1];
                        cursorPos = splitText[2].length();
                        curIn.setText(CalcIn2);
                        curIn.setSelection(cursorPos);
                    }
                } catch (Exception e) {
                }
            }
        });

        buttonclr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                curIn.setText("");
                curIn.setSelection(curIn.length());
                return false;
            }
        });
    }

    private String[] splitStrings(Editable text) {
        cursorPos = curIn.getSelectionEnd();
        splitText[0] = curIn.getText().subSequence(0, cursorPos).toString();
        splitText[1] = curIn.getText().subSequence(cursorPos, curIn.length()).toString();
        return splitText;
    }

}