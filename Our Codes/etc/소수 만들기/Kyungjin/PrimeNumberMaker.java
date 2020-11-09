package make_prime_number.solution;

import java.util.*;

public class PrimeNumberMaker {

    private int[] nums;
    private boolean[] using;
    private boolean[] isNotPrimeNumber;
    private ArrayList<Integer> primeNumbers;

    public ArrayList<Integer> getPrimeNumberList(int[] nums) {
        this.nums = nums;
        this.using = new boolean[nums.length];
        this.primeNumbers = new ArrayList<>();

        StringBuilder max = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--)
            max.append(nums[i]);

        int maxNumber = Integer.parseInt(max.toString());
        this.isNotPrimeNumber = new boolean[maxNumber + 1];

        construct_isNotPrimeNumber(maxNumber);

        for(int i=1; i<=nums.length; i++)
            makeNumber(new StringBuilder(), 0, i);

        return primeNumbers;
    }

    private void makeNumber(StringBuilder numString, int depth, int n) {
        if(depth == n) {
            int number = Integer.parseInt(numString.toString());
            if(!isNotPrimeNumber[number] && !primeNumbers.contains(number))
                primeNumbers.add(number);
        }
        else {
            for(int i=0; i<nums.length; i++) {
                if(!using[i]) {
                    numString.append(nums[i]);
                    using[i] = true;
                    makeNumber(numString, depth + 1, n);
                    using[i] = false;
                    numString.deleteCharAt(depth);
                }
            }
        }
    }

    private void construct_isNotPrimeNumber(int maxNumber) {
        isNotPrimeNumber[0] = true;
        if(maxNumber < 1)
            return;
        isNotPrimeNumber[1] = true;

        for(int i=2; i<Math.sqrt(maxNumber); i++) {
            if(isNotPrimeNumber[i])
                continue;
            for(int j=2*i; j<=maxNumber; j+=i)
                isNotPrimeNumber[j] = true;
        }
    }
}
