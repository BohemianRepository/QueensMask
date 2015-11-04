package com.queensmask.bohemianrepository.queensmask;

import android.content.Context;
import android.test.mock.MockContext;
import android.widget.EditText;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestMasks extends TestCase {

    class MyClass{
        public String getString(){
            return null;
        }
    };

    @Mock
    MyClass cpf = Mockito.mock(MyClass.class);

    @Test
    public void shoul_return_a_CPF_mask(){

        String CPF = "03221874197";
        when(cpf.getString()).thenReturn("CPF");


        String expected = "032.218.741-97";

        assertEquals(expected, CPF);
    }

}
