package kr.ac.uc.gitandroid;

import android.os.Bundle;
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


        // 숫자 버튼에 리스너 적용


        // 연산자 버튼 클릭 리스너 설정


        // 연산자 버튼에 리스너 적용


        // 등호 버튼 클릭 리스너

        // C 버튼 (현재 입력 취소)


        // AC 버튼 (모든 계산 취소)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}