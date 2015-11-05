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

    public static String getMaskWhitSuffix(String mask, String string) {

        String unmaskedString = unmask(string);
        return maskUnmaskedString(mask, unmaskedString, true);
    }

    public static String getMaskWhitOutSuffix(String mask, String string) {

        String unmaskedString = unmask(string);
        return maskUnmaskedString(mask, unmaskedString, false);
    }

    private static String maskUnmaskedString(String mask, String unmaskedString, boolean whitSuffix) {

        char[] unmaskedArray = unmaskedString.toCharArray();
        int numberOfMaskCaracters = getNumberOfMaskCaracters(mask);

        StringBuilder maskedString = new StringBuilder("");

        int maskIndex = 0;
        int i = 0;
        while (i < unmaskedArray.length && i < numberOfMaskCaracters) {
            if (maskIndex != '#'){
                maskIndex = walkOverMask(maskIndex, mask, maskedString);
            }
            maskIndex++;
            maskedString.append(unmaskedArray[i++]);
        }

        if(whitSuffix && hasMaskSuffix(mask, maskIndex)){
            walkOverMask(maskIndex, mask, maskedString);
        }

        return maskedString.toString();
    }

    private static int getNumberOfMaskCaracters(String mask) {
        return unmask(mask).length();
    }

    private static int walkOverMask(int maskIndex, String mask, StringBuilder maskedString) {
        int j = maskIndex;
        while( j < mask.length() && mask.charAt(j) != '#' ) {
            maskedString.append(mask.charAt(j++));
        }
        return j;
    }

    private static boolean hasMaskSuffix(String mask, int maskIndex) {

        return mask.length() > maskIndex;
    }
}
