import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

/**
 * @author s0176953
 * 
 */
public class FebonaciiTest {

    HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();

    /**
     * @param args
     */
    public static void main(String[] args) {

        FebonaciiTest test = new FebonaciiTest();
        for (int i = 0; i < 10; i++) {
            System.out.println("Febonaccii: " + test.febonacciCount(i));
        }

    }

    public int febonacciCount(int no) {
        int totalSum = 0;
        if (no < 2)
            return 1;
        
        if (values.get(no) != null) {
            return values.get(no);
        }

        totalSum = febonacciCount(no - 1) + febonacciCount(no - 2);
        System.out.println("total sum:"+totalSum);
        values.put(no, totalSum);

        return totalSum;
    }
       

}
