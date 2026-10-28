package com.mavis.demo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int BG = Color.parseColor("#0B1020");
    private static final int CARD = Color.parseColor("#161E33");
    private static final int ACCENT = Color.parseColor("#5B8CFF");
    private static final int TEXT = Color.parseColor("#E8ECF4");
    private static final int MUTED = Color.parseColor("#8A94AD");

    private int taps = 0;
    private TextView counter;

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private GradientDrawable card(int color, int radiusDp) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(radiusDp));
        return d;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(BG);
        root.setPadding(dp(24), dp(40), dp(24), dp(24));

        TextView title = new TextView(this);
        title.setText("Mavis Demo");
        title.setTextColor(TEXT);
        title.setTextSize(30);
        title.setTypeface(title.getTypeface(), android.graphics.Typeface.BOLD);
        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Собрано в облаке GitHub Actions.\nТы поставил это приложение с телефона.");
        subtitle.setTextColor(MUTED);
        subtitle.setTextSize(15);
        subtitle.setPadding(0, dp(8), 0, dp(24));
        root.addView(subtitle);

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setBackground(card(CARD, 20));
        box.setPadding(dp(20), dp(20), dp(20), dp(20));
        root.addView(box);

        counter = new TextView(this);
        counter.setText("Нажатий: 0");
        counter.setTextColor(TEXT);
        counter.setTextSize(20);
        counter.setTypeface(counter.getTypeface(), android.graphics.Typeface.BOLD);
        box.addView(counter);

        TextView hint = new TextView(this);
        hint.setText("Каждый тап считается в твоём приложении, на твоём телефоне.");
        hint.setTextColor(MUTED);
        hint.setTextSize(13);
        hint.setPadding(0, dp(6), 0, dp(18));
        box.addView(hint);

        Button button = new Button(this);
        button.setText("Нажми меня");
        button.setTextColor(Color.WHITE);
        button.setTextSize(16);
        button.setAllCaps(false);
        button.setBackground(card(ACCENT, 16));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taps++;
                counter.setText("Нажатий: " + taps);
                Toast.makeText(MainActivity.this, "Работает. Нажатий: " + taps, Toast.LENGTH_SHORT).show();
            }
        });
        box.addView(button);

        TextView footer = new TextView(this);
        footer.setText("v0.1.0 · сборка: GitHub Actions · APK: release");
        footer.setTextColor(MUTED);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, dp(28), 0, 0);
        root.addView(footer);

        setContentView(root);
    }
}
