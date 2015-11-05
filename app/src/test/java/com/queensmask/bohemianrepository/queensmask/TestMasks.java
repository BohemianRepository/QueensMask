package com.queensmask.bohemianrepository.queensmask;

import com.queensmask.bohemianrepository.queensmask.Utils.QueensMask;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Ueliton-PC on 03/11/2015.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestMasks extends TestCase {


    @Test
    public void should_return_a_unmasked_cpf(){

        String maskedCPF = "652.672.478-71";

        String result = QueensMask.unmask(maskedCPF);
        String expectedUnmaskedCPF = "65267247871";

        assertEquals(expectedUnmaskedCPF, result);
    }

    @Test
    public void shoul_return_a_CPF_mask(){

        String CPF = "65267247871";

        String result = QueensMask.getMaskWhitOutSuffix(QueensMask.CPF, CPF);

        String expected = "652.672.478-71";

        assertEquals(expected, result);
    }

    @Test
    public void should_return_a_partial_masked_CPF(){

        String CPF = "6526";

        String result = QueensMask.getMaskWhitOutSuffix(QueensMask.CPF, CPF);

        String expected = "652.6";

        assertEquals(expected, result);
    }

    @Test
    public void should_return_a_masked_phone_number(){

        String phone = "6799321323";

        String result = QueensMask.getMaskWhitOutSuffix(QueensMask.PHONE, phone);

        String expected = "(67) 9932-1323";

        assertEquals(expected, result);
    }

    @Test
    public void sould_return_a_partial_phone_number_mask(){
        String phone = "67";

        String result = QueensMask.getMaskWhitOutSuffix(QueensMask.PHONE, phone);

        String expected = "(67";

        assertEquals(expected, result);
    }

    @Test
    public void should_return_a_masked_CNPJ(){

        String CNPJ = "24900500000148";

        String result = QueensMask.getMaskWhitOutSuffix(QueensMask.CNPJ, CNPJ);

        String expected = "24.900.500/0001-48";

        assertEquals(expected, result);
    }

    @Test
    public void should_return_a_custom_masked_string_whit_suffix(){

        String CNPJ = "11";

        String result = QueensMask.getMaskWhitSuffix("...#/#...", CNPJ);

        String expected = "...1/1...";

        assertEquals(expected, result);
    }

}
