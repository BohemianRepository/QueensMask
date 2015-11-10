package com.queensmask.bohemianrepository.queensmask.Utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.queensmask.bohemianrepository.queensmask.QueenMask.QueensMask;

/**
 * Created by Ueliton-PC on 04/11/2015.
 */
public abstract class EditTextMask {


    public static void addMask(String mask, EditText editText) {
        editText.addTextChangedListener(getMaskedTextWatcher(mask, editText));
    }

    public static TextWatcher getMaskedTextWatcher(final String mask, final EditText ediTxt) {
        return new TextWatcher() {

            boolean wasMasked;

            public void onTextChanged(CharSequence string, int start, int before,
                                      int count) {

                if (wasMasked) {
                    wasMasked = false;
                    return;
                }

                String maskedString = QueensMask.getMaskWhitOutSuffix(mask, string.toString());

                wasMasked = true;
                ediTxt.setText(maskedString);
                ediTxt.setSelection(maskedString.length());
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        };
    }
}
