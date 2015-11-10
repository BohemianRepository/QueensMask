package com.queensmask.bohemianrepository.queensmask.QueenMask;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.queensmask.bohemianrepository.queensmask.MainActivity;
import com.queensmask.bohemianrepository.queensmask.Utils.EditTextMask;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */
public abstract class QueensMask {

    public static void bind(Activity target) {
        bind(target, target);
    }

    private static void bind(Activity classTarget, Activity source) {

        Set<Field> set = new HashSet<>();
        Class<?> clsName = classTarget.getClass();

       for(Field field : clsName.getDeclaredFields()){
//            if(field.isAnnotationPresent(QueenMask.class)){
//                EditText text = (EditText) field.get(source);
//                EditTextMask.addMask("###.###.###-##", text);
//            }
        }
    }

    /**
     * Created by Ueliton-PC on 08/11/2015.
     */

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface QueenMask {

        String value();
    }

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
