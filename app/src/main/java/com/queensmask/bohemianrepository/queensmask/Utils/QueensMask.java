package com.queensmask.bohemianrepository.queensmask.Utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */
public abstract class QueensMask {

    public static final String CPF = "###.###.###-##";
    public static final String PHONE = "(##) ####-####";
    public static final String CNPJ = "##.###.###/####-##";

    public static String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "").replaceAll("[ ]", "");
    }

    public static String getMask(String mask, String string) {

        String unmaskedString = unmask(string);
        return maskUnmaskedString(mask, unmaskedString);
    }

    private static String maskUnmaskedString(String mask, String unmaskedString) {

        char[] unmaskedArray = unmaskedString.toCharArray();

        StringBuilder maskedString = new StringBuilder("");

        int maskIndex = 0;
        int i = 0;
        while (i < unmaskedArray.length) {
            if (maskIndex != '#'){
                maskIndex = walkOverMask(maskIndex, mask, maskedString);
            }
            maskIndex++;
            maskedString.append(unmaskedArray[i++]);
        }

        if(hasMaskSuffix(mask, maskIndex)){
            walkOverMask(maskIndex, mask, maskedString);
        }

        return maskedString.toString();
    }

    private static int walkOverMask(int maskIndex, String mask, StringBuilder maskedString) {
        int j = maskIndex;
        while( mask.charAt(j) != '#' ) {
            maskedString.append(mask.charAt(j++));
        }
        return j;
    }

    private static boolean hasMaskSuffix(String mask, int maskIndex) {

        return mask.length() > maskIndex;
    }
}
