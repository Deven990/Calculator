package com.example.calculator;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText curIn;

    String CalcIn2,CalcIn3;
    Expression expression;
    boolean deg,inv,adv_option,lang_flag;
    String[] splitText = new String[3];
    int cursorPos;

    private final Function[] myFunctions = {
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
            new Function("asin") {
                public double apply(double... args) {
                    return Math.toDegrees(Math.asin(args[0]));
                }
            },
            new Function("acos") {
                public double apply(double... args) {
                    return Math.toDegrees(Math.acos(args[0]));
                }
            },
            new Function("atan") {
                public double apply(double... args) {
                    return Math.toDegrees(Math.atan(args[0]));
                }
            },
    };

    Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
        @Override
        public double apply(double... args) {
            final int arg = (int) args[0];
            if ((double) arg != args[0]) {
                throw new IllegalArgumentException("Operand for factorial has to be an integer");
            }
            if (arg < 0) {
                throw new IllegalArgumentException("The operand of the factorial can not be less than zero");
            }
            double result = 1;
            for (int i = 1; i <= arg; i++) {
                result *= i;
            }
            return result;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout Advance_Layout = findViewById(R.id.Advance_Function_Layout);

        final Button add = findViewById(R.id.ButtonAdd);
        final Button sub = findViewById(R.id.ButtonSub);
        final Button mul = findViewById(R.id.ButtonMul);
        final Button div = findViewById(R.id.ButtonDiv);
        final Button pwr = findViewById(R.id.pwr);
        final Button pi = findViewById(R.id.pi);
        final Button sin = findViewById(R.id.sine);
        final Button cos = findViewById(R.id.cosine);
        final Button tan = findViewById(R.id.tan);
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
        final Button delete = findViewById(R.id.delete);
        final Button buttondec = findViewById(R.id.Buttondec);
        final Button buttonbracC = findViewById(R.id.ButtonbracC);
        final Button buttonbracO = findViewById(R.id.ButtonbracO);
        final ToggleButton deg_rad = findViewById(R.id.toggle_deg_rad);
        final Button log = findViewById(R.id.buttonlog);
        final Button e = findViewById(R.id.buttonexp);
        final Button sqrt = findViewById(R.id.buttonsqrt);
        final Button result = findViewById(R.id.result);
        final Button fact = findViewById(R.id.fact);
        final ToggleButton invert = findViewById(R.id.invert_button);
        final Button ac = findViewById(R.id.ac);
        curIn = findViewById(R.id.curIn);

        curIn.setShowSoftInputOnFocus(false);
        curIn.setText("");

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curIn.setText("");
            }
        });

        invert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                inv = isChecked;
                if(inv){
                    sin.setText(R.string.sin_inv);
                    cos.setText(R.string.cos_inv);
                    tan.setText(R.string.tan_inv);
                    log.setText(R.string.exp);
                }
                else{
                    sin.setText(R.string.sine);
                    cos.setText(R.string.cosine);
                    tan.setText(R.string.tan);
                    log.setText(R.string.logb);
                }
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._0) + splitText[1]);
                curIn.setSelection(cursorPos + 1);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._1) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._2) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._3) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._4) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._5) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._6) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._7) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._8) + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + getText(R.string._9) + splitText[1]);
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
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "π" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inv) {
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "sin(" + splitText[1]);
                    curIn.setSelection(cursorPos + 4);
                }
                else{
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "asin(" + splitText[1]);
                    curIn.setSelection(cursorPos + 5);
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inv) {
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "cos(" + splitText[1]);
                    curIn.setSelection(cursorPos + 4);
                }
                else{
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "acos(" + splitText[1]);
                    curIn.setSelection(cursorPos + 5);
                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inv) {
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "tan(" + splitText[1]);
                    curIn.setSelection(cursorPos + 4);
                }
                else{
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "atan(" + splitText[1]);
                    curIn.setSelection(cursorPos + 5);
                }
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inv) {
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "log" + splitText[1]);
                    curIn.setSelection(cursorPos + 3);
                }
                else{
                    splitText = splitStrings(curIn.getText());
                    curIn.setText(splitText[0] + "e" + splitText[1]);
                    curIn.setSelection(cursorPos + 1);
                }
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
        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "!" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
            }
        });
        deg_rad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                deg = isChecked;
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                CalcIn3 = curIn.getText().toString();
                CalcIn2 ="";
                lang_flag = false;
                for(int i=0;i<CalcIn3.length();i++){
                    switch(CalcIn3.charAt(i)){
                        case '०': CalcIn2 += "0"; lang_flag = true; break;
                        case '१': CalcIn2 += "1"; lang_flag = true; break;
                        case '२': CalcIn2 += "2"; lang_flag = true; break;
                        case '३': CalcIn2 += "3"; lang_flag = true; break;
                        case '४': CalcIn2 += "4"; lang_flag = true; break;
                        case '५': CalcIn2 += "5"; lang_flag = true; break;
                        case '६': CalcIn2 += "6"; lang_flag = true; break;
                        case '७': CalcIn2 += "7"; lang_flag = true; break;
                        case '८': CalcIn2 += "8"; lang_flag = true; break;
                        case '९': CalcIn2 += "9"; lang_flag = true; break;
                        default : CalcIn2 += String.valueOf(CalcIn3.charAt(i)); break;
                    }
                }
                try {
                    if (deg)
                        expression = new ExpressionBuilder(CalcIn2).operator(factorial).functions(myFunctions).build();
                    else
                        expression = new ExpressionBuilder(CalcIn2).operator(factorial).build();
                    String ans = String.format("%.5f",expression.evaluate());
                    String answer="";
                    while(true) {
                        if (ans.endsWith("0") && !ans.endsWith(".0"))
                            ans = ans.substring(0,ans.length()-1);
                        else
                            break;
                    }
                    if(getText(R.string._0).equals("०")) {
                        for (int i = 0; i < ans.length(); i++) {
                            switch (ans.charAt(i)) {
                                case '0':
                                    answer += getText(R.string._0);
                                    break;
                                case '1':
                                    answer += getText(R.string._1);
                                    break;
                                case '2':
                                    answer += getText(R.string._2);
                                    break;
                                case '3':
                                    answer += getText(R.string._3);
                                    break;
                                case '4':
                                    answer += getText(R.string._4);
                                    break;
                                case '5':
                                    answer += getText(R.string._5);
                                    break;
                                case '6':
                                    answer += getText(R.string._6);
                                    break;
                                case '7':
                                    answer += getText(R.string._7);
                                    break;
                                case '8':
                                    answer += getText(R.string._8);
                                    break;
                                case '9':
                                    answer += getText(R.string._9);
                                    break;
                                default:
                                    answer += String.valueOf(ans.charAt(i));
                                    break;
                            }
                        }
                    }
                    else
                        answer = ans;
                    curIn.setText(answer);
                } catch (Exception e) {
                }
                curIn.setSelection(curIn.length());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
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

        delete.setOnLongClickListener(new View.OnLongClickListener() {
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