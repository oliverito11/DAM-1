/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suma;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;
/**
 *
 * @author mañana
 */
@RunWith(Parameterized.class)
public class SumaTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sumar method, of class Suma.
     */
    
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {10, 40, 50}, {10, 10, 20}
        });
    }
    
    private int valorA, valorB, esperado;
    
    public SumaTest(int valorA, int valorB, int esperado){
       this.valorA = valorA;
       this.valorB = valorB;
       this.esperado = esperado;
    }
    
    @Test
    public void testSumar() {
        System.out.println("sumar");
        Suma instance = new Suma(valorA, valorB);
        int result = instance.sumar();
        assertEquals(esperado, result);
    }

    /**
     * Test of restar method, of class Suma.
     */
    @Test
    public void testRestar() {
        System.out.println("restar");
        Suma instance = new Suma(10, 50);
        int expResult = 40;
        int result = instance.restar();
        assertEquals(expResult, result);
    }
    
}
