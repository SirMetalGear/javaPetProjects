package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        int temp;
        int sqrt = 1;

        if(number <= 1)
        {
            throw new IllegalNumberException();
        }
        else
        {
            while(sqrt * sqrt <= number)
                sqrt++;

            for (int i=2; i<=sqrt; i++) {
                temp = number % i;
                if (temp == 0) {
                    return (false);
                }
            }
        }
        return (true);
    }

    public int digitsSum(int number) {
        int sum = 0;
        while(number != 0){
            sum += (number % 10);
            number/=10;
        }
        return (sum);
    }


}
