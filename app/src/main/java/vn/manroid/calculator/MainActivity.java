package vn.manroid.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //show text
    TextView txtShow;

    //=========================================//

    //For Caculator

    private TextView txtResult;
    private Button btnClear, btnDau;
    private View view;
    private String trai = "";
    private String phai = "";
    private String phepToan = "";
    private boolean chuyen = false;


    //thay doi dau

    private boolean dauAmDuong = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //show text
        txtShow = (TextView) findViewById(R.id.MarqueeText);
        txtShow.setSelected(true);

        //=================================================//

        btnClear = (Button) findViewById(R.id.btnClear);
        btnDau = (Button) findViewById(R.id.btn_dau);

        txtResult = (TextView) findViewById(R.id.txtResult);
        btnClear.setOnClickListener(this);

        btnDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dauAmDuong = true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnClear) {
            trai = "";
            phai = "";
            txtResult.setText("");
            chuyen = false;
        } else {
            Toast.makeText(this, "-", Toast.LENGTH_SHORT).show();
        }
    }


    public void onActionClick(View view) {

        String tag = view.getTag().toString();
        switch (tag) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "6":
                chuyen = true;
                phepToan = view.getTag().toString();
                break;
            default:
                thucHienPhepBang();
        }


    }


    private void thucHienPhepBang() {
        Double kqua = null;
        Double _trai = Double.parseDouble(trai);
        Double _phai = Double.parseDouble(phai);

        switch (phepToan) {
            case "1":
                kqua = _trai + _phai;
                break;
            case "2":
                kqua = _trai - _phai;
                break;
            case "3":
                kqua = _trai * _phai;
                break;
            case "4":
                kqua = _trai / _phai;
                break;
            case "6":
                kqua = Math.exp(1.0 / _phai * Math.log(_trai));
                break;
            default:
               finish();
        }
        if (phepToan != null) {
            txtResult.setText(String.valueOf(kqua));
            trai = String.valueOf(kqua);
            phai = "";
            chuyen = false;
        } else {
            txtResult.setText("Error");
        }

    }

    public void onNumberClick(View view) {
        String number = ((Button) view).getText().toString();
        String tagDau = ((Button) view).getText().toString();
        //Toast.makeText(this, number, Toast.LENGTH_SHORT).show();

        if (!chuyen) {
            if (dauAmDuong) {
                trai += number;
                txtResult.setText("-" + trai);
                trai = "-" + trai;
                dauAmDuong = false;
            } else {
                trai += number;
                txtResult.setText(trai);
            }
        } else {
            if (dauAmDuong) {
                phai += number;
                txtResult.setText("-" + phai);
                phai = "-" + phai;
                dauAmDuong = false;
            } else {
                phai += number;
                txtResult.setText(phai);
            }
        }
    }


}
