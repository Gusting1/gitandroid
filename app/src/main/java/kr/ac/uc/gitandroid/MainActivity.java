package kr.ac.uc.gitandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // TextView 초기화
        tvDisplay = findViewById(R.id.tvDisplay);
        tvDisplay.setText("0");

        // 숫자 버튼 초기화
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        // 연산자 버튼 초기화
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEqual = findViewById(R.id.btnEqual);
        btnCancel = findViewById(R.id.btnCancel);
        btnAllClear = findViewById(R.id.btnAllClear);
        // 숫자 버튼 클릭 리스너 설정
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String digit = button.getText().toString();

                if (isNewInput) {
                    tvDisplay.setText(digit);
                    isNewInput = false;
                } else {
                    String currentText = tvDisplay.getText().toString();
                    if (currentText.equals("0")) {
                        tvDisplay.setText(digit);
                    } else {
                        tvDisplay.setText(currentText + digit);
                    }
                }
            }
        };

        // 숫자 버튼에 리스너 적용
        btn0.setOnClickListener(numberClickListener);
        btn1.setOnClickListener(numberClickListener);
        btn2.setOnClickListener(numberClickListener);
        btn3.setOnClickListener(numberClickListener);
        btn4.setOnClickListener(numberClickListener);
        btn5.setOnClickListener(numberClickListener);
        btn6.setOnClickListener(numberClickListener);
        btn7.setOnClickListener(numberClickListener);
        btn8.setOnClickListener(numberClickListener);
        btn9.setOnClickListener(numberClickListener);

        // 연산자 버튼 클릭 리스너 설정
        View.OnClickListener operatorClickListener = new View.OnClickListener() {
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
        };


        // 연산자 버튼에 리스너 적용
        btnPlus.setOnClickListener(operatorClickListener);
        btnMinus.setOnClickListener(operatorClickListener);
        btnMultiply.setOnClickListener(operatorClickListener);


        // 등호 버튼 클릭 리스너
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


        // C 버튼 (현재 입력 취소)
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("0");
                isNewInput = true;
            }
        });

        // AC 버튼 (모든 계산 취소)
        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText("0");
                firstNumber = 0;
                secondNumber = 0;
                operation = "";
                isNewInput = true;
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}