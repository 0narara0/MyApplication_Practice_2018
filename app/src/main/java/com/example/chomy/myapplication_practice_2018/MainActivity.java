package com.example.chomy.myapplication_practice_2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;

    public static final int QUANTITY_MIN = 0;
    public static final int QUANTITY_MAX = 10;
    public static final int COFFEE_PRICE = 3000;

    private Button mMinusButton;
    private Button mPlusButton;
    private Button mOrderButton;
    private TextView mQuantityTextView;
    private TextView mResultTextView;

    //수량
    private int mQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //초기화
        init();

        //레이아웃 표시
        setContentView(R.layout.activity_coffee);

        //레이아웃에서 특정 id를 인스터스 변수와 연결
        mMinusButton = (Button)findViewById(R.id.minus_button);
        mPlusButton = (Button)findViewById(R.id.plus_button);
        mOrderButton = (Button) findViewById(R.id.order_button);
        mQuantityTextView = (TextView)findViewById(R.id.quantity_text);
        mResultTextView = (TextView)findViewById(R.id.result_text);

        //무명클래스
        mMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuantity --;
                if(mQuantity< QUANTITY_MIN){
                    mQuantity=QUANTITY_MIN;
                }

                displayResult();

                /*//debug
                Log.d(TAG,"마이너스 버튼 클릭");
                Log.v(TAG,"일반로그"); //verbose
                Log.e(TAG,"에러로그"); //error
                Log.i(TAG,"정보로그"); //information
                Log.w(TAG,"경고로그"); //warning

                //토스트 메세지
                Toast.makeText(MainActivity.this, "메세지",Toast.LENGTH_SHORT).show();*/
            }
        });

        mPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuantity ++;
                if(mQuantity > QUANTITY_MAX){
                    mQuantity = QUANTITY_MAX;
                }

                displayResult();
            }
        });

        mOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mResultTextView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 중복되는 것 method로 뺀 것 (find Action이용)
    private void displayResult() {

        mQuantityTextView.setText("" +mQuantity); //""+mQuantity 해서 문자열로 변경
        String result = "가격 : " + (COFFEE_PRICE * mQuantity +"원\n감사합니다");
        mResultTextView.setText(result);
    }

    //find Action 이용
    private void init() {
        mQuantity = 0; //원래는 생성자에서 초기화
    }
}

