package com.nervenet.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final int BG = Color.rgb(8, 8, 10);
    private final int RED = Color.rgb(235, 35, 45);
    private final int WHITE = Color.rgb(240, 240, 240);
    private final int MUTED = Color.rgb(145, 145, 150);

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        showHome();
    }

    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView v = new TextView(this);
        v.setText(value);
        v.setTextSize(size);
        v.setTextColor(color);
        v.setGravity(Gravity.CENTER);
        if (bold) v.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return v;
    }

    private LinearLayout column() {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setGravity(Gravity.CENTER_HORIZONTAL);
        box.setPadding(dp(22), dp(24), dp(22), dp(24));
        box.setBackgroundColor(BG);
        return box;
    }

    private void showHome() {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);

        LinearLayout root = column();
        root.setGravity(Gravity.CENTER);

        TextView title = text("NERVE.NET", 34, RED, true);
        title.setLetterSpacing(0.08f);
        root.addView(title, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(58)));

        TextView subtitle = text("PRIVATE NETWORK", 13, MUTED, false);
        subtitle.setLetterSpacing(0.18f);
        LinearLayout.LayoutParams subParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(36));
        subParams.bottomMargin = dp(28);
        root.addView(subtitle, subParams);

        View line = new View(this);
        line.setBackgroundColor(RED);
        root.addView(line, new LinearLayout.LayoutParams(dp(170), dp(2)));

        TextView welcome = text("WELCOME TO NERVE", 17, WHITE, true);
        LinearLayout.LayoutParams welcomeParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(70));
        root.addView(welcome, welcomeParams);

        Button enter = button("ENTER NETWORK");
        root.addView(enter, buttonParams());
        enter.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                showDashboard();
            }
        });

        TextView footer = text("NERVE.NET  |  OFFLINE EDITION", 10, MUTED, false);
        LinearLayout.LayoutParams footerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(60));
        root.addView(footer, footerParams);

        scroll.addView(root);
        setContentView(scroll);
    }

    private void showDashboard() {
        ScrollView scroll = new ScrollView(this);
        LinearLayout root = column();
        root.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);

        TextView title = text("NERVE.NET", 30, RED, true);
        root.addView(title, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(70)));

        TextView sub = text("NETWORK DASHBOARD", 13, MUTED, false);
        root.addView(sub, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(42)));

        addNotice(root, "MEMBERS");
        addNotice(root, "MESSAGES");
        addNotice(root, "SETTINGS");

        Button back = button("BACK");
        root.addView(back, buttonParams());
        back.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { showHome(); }
        });

        scroll.addView(root);
        setContentView(scroll);
    }

    private void addNotice(LinearLayout root, String label) {
        Button b = button(label);
        root.addView(b, buttonParams());
        b.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        label + " - NOT CONFIGURED YET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private Button button(String label) {
        Button b = new Button(this);
        b.setText(label);
        b.setTextColor(WHITE);
        b.setTextSize(14);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        b.setAllCaps(false);
        b.setBackgroundColor(RED);
        return b;
    }

    private LinearLayout.LayoutParams buttonParams() {
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, dp(52));
        p.topMargin = dp(10);
        p.bottomMargin = dp(10);
        return p;
    }
}
