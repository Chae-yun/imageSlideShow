package kr.hs.emirim.ycy6685.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlip;
    EditText editTime;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butStart=(Button)findViewById(R.id.but_start);//참조 변수로 선언, 버튼은 지역 변수도 괜찮아, 뷰로 반환되므로 버튼으로 형변환
        Button butStop=(Button)findViewById(R.id.but_stop);
        viewFlip=(ViewFlipper) findViewById(R.id.view_flip);
        editTime=(EditText)findViewById(R.id.edit_time);
        butStart.setOnClickListener(this);
        butStop.setOnClickListener(this);

    }

    public void onClick(View v) { //v는 이벤트가 발생된 객체의 참조값을 가지고 있음 이걸로 무슨 버튼인지 알아냄 id 비교해서

        switch(v.getId()) {
            case R.id.but_start:
                time=(int)(Double.parseDouble(editTime.getText().toString())*1000);
                viewFlip.setFlipInterval(time);
                viewFlip.startFlipping();
                break;
            case R.id.but_stop:
                viewFlip.stopFlipping();
                break;
        }

    }
}
