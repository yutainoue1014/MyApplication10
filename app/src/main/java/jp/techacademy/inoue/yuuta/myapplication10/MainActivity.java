package jp.techacademy.inoue.yuuta.myapplication10;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            mTextView.setText(mEditText.getText().toString());
        } else if (v.getId() == R.id.button2) {
            showAlertDialog();
        } else if (v.getId() == R.id.button3) {
            showTimePickerDialog();
        }
    }

    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("タイトル");
        alertDialogBuilder.setMessage("メッセージ");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNeutralButton("中立",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "中立ボタン");
                    }
                });

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "否定ボタン");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if ((hourOfDay >= 2) && (hourOfDay < 10)) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("おはよう");
                        }
                        else if ((hourOfDay >= 10) && (hourOfDay < 18)) {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんにちわ");
                        }else {
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("こんばんわ");
                        }

                    }
                },
                12, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}