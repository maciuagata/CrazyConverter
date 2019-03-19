package lt.vtvpmc.ems.zp182.crazyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import java.text.DecimalFormat;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private TextView numberField;
    private Button convertId;
    private Button resetId;
    private TextView kilometre0;
    private TextView centimetre0;
    private TextView mile0;
    private TextView yard0;
    private TextView foot0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField = (TextView) findViewById(R.id.numberField);
        convertId = (Button) findViewById(R.id.convertId);
        resetId = (Button) findViewById(R.id.resetId);
        kilometre0 = (TextView) findViewById(R.id.kilometre0);
        centimetre0 = (TextView) findViewById(R.id.centimetre0);
        mile0 = (TextView) findViewById(R.id.mile0);
        yard0 = (TextView) findViewById(R.id.yard0);
        foot0 = (TextView) findViewById(R.id.foot0);


        convertId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double userInputValue;

                try {
                    userInputValue = Double.parseDouble(numberField.getText().toString());
                } catch (Exception ex) {
                    userInputValue = 0;
                    Context context = getApplicationContext();
                    CharSequence text = "Įvesk skaičių!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if (userInputValue > 0) {

                    DecimalFormat df = new DecimalFormat("##.##");

                    kilometre0.setText(String.valueOf(df.format(userInputValue / 100000)));
                    centimetre0.setText(String.valueOf(df.format(userInputValue)));
                    mile0.setText(String.valueOf(df.format(userInputValue / 160934.4)));
                    yard0.setText(String.valueOf(df.format(userInputValue / 91.44)));
                    foot0.setText(String.valueOf(df.format(userInputValue / 30.48)));

                }

            }
        });

        resetId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberField.setText(null);

                kilometre0.setText(R.string.kilometre0);
                centimetre0.setText(R.string.kilometre0);
                mile0.setText(R.string.kilometre0);
                yard0.setText(R.string.kilometre0);
                foot0.setText(R.string.kilometre0);
            }
        });

    }
}
