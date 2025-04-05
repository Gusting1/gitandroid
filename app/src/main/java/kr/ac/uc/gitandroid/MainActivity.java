package kr.ac.uc.gitandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnPlus, btnMinus, btnMultiply, btnEqual, btnCancel, btnAllClear;

    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operation = "";
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 등호 버튼 클릭 리스너'
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    secondNumber = Double.parseDouble(tvDisplay.getText().toString());
                    double result = 0;

                    switch (operation) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                    }

                    // 정수인 경우 소수점 제거 (예: 5.0 -> 5)
                    if (result == (long) result) {
                        tvDisplay.setText(String.valueOf((long) result));
                    } else {
                        tvDisplay.setText(String.valueOf(result));
                    }

                    isNewInput = true;
                } catch (NumberFormatException e) {
                    tvDisplay.setText("Error");
                    isNewInput = true;
                }
            }
        });
    }
}