import java.util.Arrays;

public class Subtraction {
    Addition addition = new Addition();
    public int[] first;
    public int[] second;

    public void  DoSubtraction(int[] firstArr, int [] secondArr){
        first = Arrays.copyOf(firstArr, firstArr.length);
        second = Arrays.copyOf(secondArr, secondArr.length);

        if(first[0] == 0 & second[0] == 0){
            second[0] = 1;
            addition.DoAddition(first, second);
        }
        else if(first[0] == 1 & second[0] == 1){
            second[0] = 0;
            addition.DoAddition(first, second);
        }
        else if(first[0] == 0 & second[0] == 1){
            second[0] = 0;
            addition.DoAddition(first, second);
        }
        else if(first[0] == 1 & second[0] == 0){
            second[0] = 1;
            addition.DoAddition(first, second);
        }
    }
}
