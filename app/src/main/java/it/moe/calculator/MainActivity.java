package it.moe.calculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import it.moe.calculator.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();

    }

    private void initListeners() {
    }

    public void onNumberClick(View view) {
        Button btn = (Button) view;
        Log.d("MOE" , btn.getText().toString());

        if (binding.etCalculator.getText().toString().equals("0"))
            binding.etCalculator.setText(btn.getText().toString());
        else binding.etCalculator.append(btn.getText().toString());

    }

    public void onOperatorClicked(View view) {
        int operator = view.getId();
        if (operator == R.id.btAdd){
          this.operator = "+" ;
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        }else if(operator == R.id.btSub){
            this.operator = "-";
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btMul) {
            this.operator = "*";
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btDiv) {
            this.operator = "/";
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);

        } else if (operator == R.id.btClear) {
            this.operator = "C";
            binding.tvOperation.setText(binding.etCalculator.getText().toString());
            binding.etCalculator.setText("0");
            binding.tvOperator.setText(this.operator);


        }else if (operator == R.id.btEqu) {
            int first = Integer.parseInt(binding.tvOperation.getText().toString());
            int second = Integer.parseInt(binding.etCalculator.getText().toString());
            Calculate(first,second);
            binding.tvOperation.setText("0");
            binding.tvOperator.setText("");
        }


    }


    private void Calculate(int first,int second){
        int result = 0;
     if (this.operator.equals("+")){
      result = first + second;
     } else if (this.operator.equals("-")) {
       result = first - second;
     }else if (this.operator.equals("*")){
         result = first * second;
     } else if (this.operator.equals("/")) {
         result = first / second;
     }
     binding.etCalculator.setText(String.valueOf(result));
    }


    public void clear(View view) {
        binding.etCalculator.setText("0");
    }
}