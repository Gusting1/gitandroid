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

        // TextView 초기화


        // 숫자 버튼 초기화


        // 연산자 버튼 초기화


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


        // 연산자 버튼에 리스너 적용


        // 등호 버튼 클릭 리스너


        // C 버튼 (현재 입력 취소)


        // AC 버튼 (모든 계산 취소)

    }
}