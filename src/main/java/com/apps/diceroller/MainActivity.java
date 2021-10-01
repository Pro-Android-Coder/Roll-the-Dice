package com.apps.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationView = findViewById(R.id.dice);
        textView = findViewById(R.id.number);
        button = findViewById(R.id.roll);

        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                hideDice();
                int r = (int) (Math.random()*(6 - 1 + 1)) + 1;
                String s = String.valueOf(r);
                textView.setText(s);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void rollDice(View view) {
        showDice();
        animationView.playAnimation();
    }

    private void showDice() {
        animationView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        button.setEnabled(false);
    }

    private void hideDice() {
        animationView.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);
        button.setEnabled(true);
    }
}