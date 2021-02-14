package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

public class MainActivity extends AppCompatActivity {

    private EditText curIn;

    String CalcIn2;
    Expression expression;
    boolean deg,inv;
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
        curIn = findViewById(R.id.curIn);

        curIn.setShowSoftInputOnFocus(false);
        curIn.setText("");

        invert.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                inv = isChecked;
                if(inv){
                    sin.setText(R.string.sin_inv);
                    cos.setText(R.string.cos_inv);
                    tan.setText(R.string.tan_inv);
                }
                else{
                    sin.setText(R.string.sine);
                    cos.setText(R.string.cosine);
                    tan.setText(R.string.tan);
                }
            }
        });

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
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "log" + splitText[1]);
                curIn.setSelection(cursorPos + 3);
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                splitText = splitStrings(curIn.getText());
                curIn.setText(splitText[0] + "e" + splitText[1]);
                curIn.setSelection(cursorPos + 1);
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
                CalcIn2 = curIn.getText().toString();
                try {
                    if (deg)
                        expression = new ExpressionBuilder(CalcIn2).operator(factorial).functions(myFunctions).build();
                    else
                        expression = new ExpressionBuilder(CalcIn2).operator(factorial).build();
                    String ans = String.format("%.5f",expression.evaluate());
                    while(true) {
                        if (ans.endsWith("0") && !ans.endsWith(".0"))
                            ans = ans.substring(0,ans.length()-1);
                        else
                            break;
                    }
                    curIn.setText(ans);
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