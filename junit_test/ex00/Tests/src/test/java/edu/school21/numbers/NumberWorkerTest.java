package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;


public class NumberWorkerTest {


    @ParameterizedTest
    @ValueSource(ints = { 13, 19, 17 })
    public void isPrimeForPrimes(int cand)
    {
        boolean res;
        NumberWorker nw = new NumberWorker();
        Assertions.assertTrue(nw.isPrime(cand));
    }

    @ParameterizedTest
    @ValueSource(ints = { 12, 15, 16 })
    public void isPrimeForNotPrimes(int cand)
    {
        boolean res;
        NumberWorker nw = new NumberWorker();
        Assertions.assertFalse(nw.isPrime(cand));
    }


    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 1 })
    public  void isPrimeForIncorrectNumbers(int cand)
    {
        NumberWorker nw = new NumberWorker();
        Assertions.assertThrows(IllegalNumberException.class,  ()->{nw.isPrime(cand);});


    }

    @ParameterizedTest
    @CsvFileSource (resources = {"/data.csv"}, delimiter = ',', numLinesToSkip = 1)
    public void digitSumCheck(int num, int res)
    {
        NumberWorker nw = new NumberWorker();
//        System.out.println(num + " " + res);
        Assertions.assertEquals(res, nw.digitsSum(num));
    }




}
