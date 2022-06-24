package com.devivan.customkeyboard.keyboards;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.devivan.customkeyboard.R;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomKeyboard {

    // KEYBOARD VARIABLES ///////////////////////////////////////////////
    // Context                                                         //
    Context context;                                                   //
    // Dialog                                                          //
    AlertDialog keyboardDialog;                                        //
    View keyboardView;                                                 //
    // TextViews                                                       //
    TextView textView, secondTextView;                                 //
    //                                                                 //
    // Number buttons                                                  //
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0; //
    //                                                                 //
    // Letters buttons                                                 //
    Button btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP; //
    Button btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL, btnÑ; //
    Button btnZ, btnX, btnC, btnV, btnB, btnN, btnM;                   //
    Button btnSpace;                                                   //
    //                                                                 //
    // Action buttons                                                  //
    ImageView btnEnter, btnDelete;                                     //
    //                                                                 //
    // List of numbers & letters                                       //
    ArrayList<Button> btnNumbers, btnLetters;                          //
    /////////////////////////////////////////////////////////////////////

    // Constructor
    public CustomKeyboard(Context context, TextView textView, boolean secondTextView) {
        // Build keyboard
        buildKeyboard(context);

        // Set parameters
        this.context = context;
        this.textView = textView;
        this.secondTextView = secondTextView ? keyboardView.findViewById(R.id.textView) : null;
        ///////////////////////////////////////////////////////////////////////////////////////

        // Revive keyboard
        reviveKeyboard();

        // Resize keys
        resizeKeys();

        // Show keyboard
        show();
    }

    // Build dialog
    @SuppressLint("InflateParams")
    public void buildKeyboard(Context context) {
        // Inflate keyboard view
        keyboardView = ((Activity) context).getLayoutInflater().inflate(R.layout.dialog_keyboard, null);

        // Find keys of keyboard
        findKeysOfKeyboard();

        // Build keyboard dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.Keyboard);
        builder.setView(keyboardView);
        keyboardDialog = builder.create();

        // Set keyboard animation
        keyboardDialog.getWindow().getAttributes().windowAnimations = R.style.KeyboardAnimation;
    }

    // Find keys of keyboard
    private void findKeysOfKeyboard() {
        /////////////
        // Numbers //
        /////////////
        {
            btnNumbers = new ArrayList<>();
            btn1 = keyboardView.findViewById(R.id.btn1);
            btnNumbers.add(btn1);
            btn2 = keyboardView.findViewById(R.id.btn2);
            btnNumbers.add(btn2);
            btn3 = keyboardView.findViewById(R.id.btn3);
            btnNumbers.add(btn3);
            btn4 = keyboardView.findViewById(R.id.btn4);
            btnNumbers.add(btn4);
            btn5 = keyboardView.findViewById(R.id.btn5);
            btnNumbers.add(btn5);
            btn6 = keyboardView.findViewById(R.id.btn6);
            btnNumbers.add(btn6);
            btn7 = keyboardView.findViewById(R.id.btn7);
            btnNumbers.add(btn7);
            btn8 = keyboardView.findViewById(R.id.btn8);
            btnNumbers.add(btn8);
            btn9 = keyboardView.findViewById(R.id.btn9);
            btnNumbers.add(btn9);
            btn0 = keyboardView.findViewById(R.id.btn0);
            btnNumbers.add(btn0);
        }

        /////////////
        // Letters //
        /////////////
        {
            btnLetters = new ArrayList<>();
            btnQ = keyboardView.findViewById(R.id.btnQ);
            btnLetters.add(btnQ);
            btnW = keyboardView.findViewById(R.id.btnW);
            btnLetters.add(btnW);
            btnE = keyboardView.findViewById(R.id.btnE);
            btnLetters.add(btnE);
            btnR = keyboardView.findViewById(R.id.btnR);
            btnLetters.add(btnR);
            btnT = keyboardView.findViewById(R.id.btnT);
            btnLetters.add(btnT);
            btnY = keyboardView.findViewById(R.id.btnY);
            btnLetters.add(btnY);
            btnU = keyboardView.findViewById(R.id.btnU);
            btnLetters.add(btnU);
            btnI = keyboardView.findViewById(R.id.btnI);
            btnLetters.add(btnI);
            btnO = keyboardView.findViewById(R.id.btnO);
            btnLetters.add(btnO);
            btnP = keyboardView.findViewById(R.id.btnP);
            btnLetters.add(btnP);

            btnA = keyboardView.findViewById(R.id.btnA);
            btnLetters.add(btnA);
            btnS = keyboardView.findViewById(R.id.btnS);
            btnLetters.add(btnS);
            btnD = keyboardView.findViewById(R.id.btnD);
            btnLetters.add(btnD);
            btnF = keyboardView.findViewById(R.id.btnF);
            btnLetters.add(btnF);
            btnG = keyboardView.findViewById(R.id.btnG);
            btnLetters.add(btnG);
            btnH = keyboardView.findViewById(R.id.btnH);
            btnLetters.add(btnH);
            btnJ = keyboardView.findViewById(R.id.btnJ);
            btnLetters.add(btnJ);
            btnK = keyboardView.findViewById(R.id.btnK);
            btnLetters.add(btnK);
            btnL = keyboardView.findViewById(R.id.btnL);
            btnLetters.add(btnL);
            btnÑ = keyboardView.findViewById(R.id.btnÑ);
            btnLetters.add(btnÑ);

            btnZ = keyboardView.findViewById(R.id.btnZ);
            btnLetters.add(btnZ);
            btnX = keyboardView.findViewById(R.id.btnX);
            btnLetters.add(btnX);
            btnC = keyboardView.findViewById(R.id.btnC);
            btnLetters.add(btnC);
            btnV = keyboardView.findViewById(R.id.btnV);
            btnLetters.add(btnV);
            btnB = keyboardView.findViewById(R.id.btnB);
            btnLetters.add(btnB);
            btnN = keyboardView.findViewById(R.id.btnN);
            btnLetters.add(btnN);
            btnM = keyboardView.findViewById(R.id.btnM);
            btnLetters.add(btnM);

            btnSpace = keyboardView.findViewById(R.id.btnSpace);
            btnLetters.add(btnSpace);
        }

        ////////////
        // Action //
        ////////////
        btnEnter = keyboardView.findViewById(R.id.btnEnter);
        btnDelete = keyboardView.findViewById(R.id.btnDelete);
        //////////////////////////////////////////////////////
    }

    // Revive keyboard
    private void reviveKeyboard() {
        // Set text on second textView
        if (isNotNull(secondTextView)) secondTextView.setText(textView.getText().toString());
        else keyboardView.findViewById(R.id.textView).setVisibility(View.GONE);

        // Numbers key click event
        for (Button b : btnNumbers) {
            b.setOnClickListener(v -> onKeyClick(b.getText().toString().toLowerCase()));
        }

        // Letters key click event
        for (Button b : btnLetters) {
            b.setOnClickListener(v -> onKeyClick(b.getText().toString().toLowerCase()));
        }

        // On show keyboard
        keyboardDialog.setOnShowListener(dialog -> {
            // Set textView as selected
            textView.setBackgroundResource(R.drawable.box_with_round_selected);
        });

        keyboardDialog.setOnDismissListener(dialog -> {
            // Set textView as deselected
            textView.setBackgroundResource(R.drawable.box_with_round);
        });

        /////////////
        // Actions //
        /////////////
        // Enter
        btnEnter.setOnClickListener(v -> {
            // Dismiss keyboard
            dismiss();
        });

        // Delete
        btnDelete.setOnClickListener(v -> {
            String txt = textView.getText().toString();
            if (len(txt) > 0) {
                textView.setText(txt.substring(0, len(txt) - 1));
                if (isNotNull(secondTextView))
                    secondTextView.setText(textView.getText().toString());
            }
        });

        // Delete all
        btnDelete.setOnLongClickListener(v -> {
            textView.setText("");
            if (isNotNull(secondTextView))
                secondTextView.setText(textView.getText().toString());
            return true;
        });
    }

    // On key click
    private void onKeyClick(String character) {
        // Calculate new text
        String txt = textView.getText().toString();
        if (txt.endsWith(" ") && character.equals("_")) return;
        else txt += (len(textView.getText().toString()) == 0 ? character.toUpperCase() : character.toLowerCase());
        txt = txt.replace("_", " ");
        ////////////////////////////////////////////

        // Set text
        textView.setText(txt);
        if (isNotNull(secondTextView))
            secondTextView.setText(txt);
    }

    // Resize keys
    private void resizeKeys() {
        float hw = getHW(10);
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.addAll(btnNumbers);
        buttons.addAll(btnLetters.stream().filter(b -> b != btnSpace).collect(Collectors.toList()));
        for (Button button : buttons) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) button.getLayoutParams();
            layoutParams.height = (int) hw;
            layoutParams.width = (int) hw;
            button.setLayoutParams(layoutParams);
        }
    }

    ///////////
    // UTILS //
    ///////////
    public int len(String string) {
        return string != null ? string.length() : 0;
    }

    public boolean isNotNull(Object o) {
        return o != null;
    }

    public void show() {
        if (isNotNull(keyboardDialog) && !keyboardDialog.isShowing()) keyboardDialog.show();
    }

    public void dismiss() {
        if (isNotNull(keyboardDialog) && keyboardDialog.isShowing()) keyboardDialog.dismiss();
    }

    private float getHW(int cols) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        float wDp = 11 * 5;

        float _w_ = dpWidth - wDp;

        float w = _w_ / cols;

        w = getPx(w);

        return w;
    }

    private float getPx(float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return dp * density;
    }
}
