package com.queensmask.bohemianrepository.queensmask;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.queensmask.bohemianrepository.queensmask.Utils.EditTextMask;
import com.queensmask.bohemianrepository.queensmask.Utils.QueensMask;

import org.junit.Test;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */
public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {



    public TestMainActivity(){
        super(MainActivity.class);
    }

    public TestMainActivity(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void test_should_return_a_masked_CPF(){

        String CPF = "03221874197";
        EditText cpf = (EditText) getActivity().findViewById(R.id.edit_text);

        EditTextMask.addMask(QueensMask.CPF, cpf);
        cpf.setText(CPF);

        String result = cpf.getText().toString();
        assertEquals("032.218.741-97", result);
    }
}
