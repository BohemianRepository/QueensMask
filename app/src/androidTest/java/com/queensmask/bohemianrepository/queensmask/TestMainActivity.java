package com.queensmask.bohemianrepository.queensmask;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.EditText;

import com.queensmask.bohemianrepository.queensmask.Utils.QueensMask;

import org.junit.Test;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */
public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {


    private MainActivity mainActivity;

    private EditText cpf;

    public TestMainActivity(){
        super(MainActivity.class);
    }

    public TestMainActivity(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mainActivity = getActivity();

    }

    @Test
    public void test_should_return_a_masked_CPF(){

        String CPF = "03221874197";
        cpf = (EditText) mainActivity.findViewById(R.id.edit_text_cpf);

        cpf.addTextChangedListener(QueensMask.insert("###.###.###-##", cpf));

        cpf.setText(CPF);

        String result = cpf.getText().toString();
        assertEquals("032.218.741-97", result);
    }
}
