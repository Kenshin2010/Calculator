package vn.manroid.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtResult;
    Button btnClear;
    TextView txtShow;
    private String trai = "";
    private String phai = "";
    private String phepToan = "";

    private boolean chuyen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShow = (TextView)findViewById(R.id.MarqueeText);
        txtShow.setSelected(true);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    public void onActionClick(View view) {
        String tag = view.getTag().toString();
        switch (tag) {
            case "1":
            case "2":
            case "3":
            case "4":
                chuyen = true;
                phepToan = view.getTag().toString();
                break;
            default:
                thucHienPhepBang();
                break;
        }
    }

    private void thucHienPhepBang() {
        Double kqua = null;
        double _trai = Double.parseDouble(trai);
        double _phai = Double.parseDouble(phai);

        switch (phepToan){
            case "1" :
                kqua = _trai + _phai;
                break;
            case "2" :
                kqua = _trai - _phai;
                break;
            case "3" :
                kqua = _trai * _phai;
                break;
            case "4" :
                kqua = _trai / _phai;
                break;
        }
        if (kqua != null){
            txtResult.setText(String.valueOf(kqua));
            trai = String.valueOf(kqua);
            phai = "";
            chuyen = false;

        }else {
            txtResult.setText("Error");
        }

    }

    public void onNumberClick(View view) {
        String number = ((Button) view).getText().toString();
        //Toast.makeText(this, number, Toast.LENGTH_SHORT).show();

        if (!chuyen) {
            trai += number;
            txtResult.setText(trai);
        } else {
            phai += number;
            txtResult.setText(phai);
        }


    }


    //Click for Clear
    @Override
    public void onClick(View v) {

        trai = "";
        phai = "";
        chuyen = false;
        txtResult.setText("");
    }
}
