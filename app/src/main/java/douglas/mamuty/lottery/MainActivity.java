package douglas.mamuty.lottery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getLottery(View view){
        TextInputEditText intStart =  findViewById(R.id.intStart);
        TextInputEditText intEnd =  findViewById(R.id.intEnd);

        if (intStart.getText().toString().matches("") || intEnd.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(), "Is necessary enter the interval",Toast.LENGTH_LONG).show();
            return;
        }

        if (Integer.parseInt(String.valueOf(intStart.getText())) >= Integer.parseInt(String.valueOf(intEnd.getText()))){
            Toast.makeText(getApplicationContext(), "Start must be less than End and different!",Toast.LENGTH_LONG).show();
            return;
        }

        TextView results =  findViewById(R.id.results);
        int random = randomWithInterval(Integer.parseInt(String.valueOf(intStart.getText())) ,Integer.parseInt(String.valueOf(intEnd.getText())));
        results.setText(Integer.toString(random));
    }

    public int randomWithInterval(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }
}