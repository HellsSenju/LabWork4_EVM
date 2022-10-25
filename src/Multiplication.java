public class Multiplication {
    private int[] result;
    private int[] firstArr;
    private int[] secondArr;
    public void dpMultiplication(int[] firstArr, int[] secondArr){
        Addition addition = new Addition();
        addition.result = new int[16];
        result = new int[16];
        this.firstArr = firstArr;
        this.secondArr = secondArr;
        for(int i = secondArr.length - 1; i > 0; i--){
            if(secondArr[i] == 1){
                Rules(i, result);
                addition.DoAddition(addition.result, result);
            }
        }
        if(firstArr[0] == 1 & secondArr[0] == 0) addition.result[0] = 1;
        if(firstArr[0] == 0 & secondArr[0] == 1) addition.result[0] = 1;
        addition.Print();
    }

    private void Rules(int index, int[] arr){
        int j = arr.length - secondArr.length + index;

        for(int i = firstArr.length - 1; i > 0; i--){
            if(firstArr[i] == 0 & secondArr[index] == 0) arr[j] = 0;

            if(firstArr[i] == 1 & secondArr[index] == 0) arr[j] = 0;

            if(firstArr[i] == 0 & secondArr[index] == 1) arr[j] = 0;

            if(firstArr[i] == 1 & secondArr[index] == 1) arr[j] = 1;
            j--;
        }
    }
}
