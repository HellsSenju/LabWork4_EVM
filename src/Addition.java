import java.util.Arrays;

public class Addition {
    public int[] result;
    protected int[] plusOne;
    public int[] firstArr;
    public int[] secondArr;

    public void DoAddition(int[] first, int[] second){
        firstArr = Arrays.copyOf(first, first.length);
        secondArr = Arrays.copyOf(second, second.length);

        if(firstArr[0] == 1){
            Inverse(firstArr);
        }
        if(secondArr[0] == 1){
            Inverse(secondArr);
        }

        plusOne = new int[firstArr.length];

        plusOne[plusOne.length - 1] = 1;

        result = Rules(firstArr, secondArr);

        if(result[1] == 1) {
            if(checkNull()) fullInvers(result);
            else Inverse(result);
        }
    }

    private int[] Rules(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length];
        int temp = 0;
        for(int i = arr1.length - 1; i >= 0; i-- ){
            if(arr1[i] == 0  & arr2[i] == 0) // 0+0
            {
                if(temp == 0) arr[i] = 0;
                else arr[i] = 1;
                temp = 0;
            }

            if(arr1[i] == 1  & arr2[i] == 0 | arr1[i] == 0  & arr2[i] == 1) //0 + 1 or 1 + 0
            {
                if(temp == 0) {
                    arr[i] = 1;
                    temp = 0;
                }
                else {
                    arr[i] = 0;
                    temp = 1;
                }
            }

            if(arr1[i] == 1  & arr2[i] == 1) // 1 + 1
            {
                if(temp == 1){
                    arr[i] = 1;
                    temp = 1;
                }
                else{
                    arr[i] = 0;
                    temp = 1;
                }
            }
        }
        if(temp == 1) arr = Rules(arr, plusOne);
        return arr;
    }

    public void Inverse(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }

    private boolean checkNull(){
        for (int i = 1; i < result.length; i++){
            if(result[i] == 0)return false;
        }
        return true;
    }

    private void fullInvers(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
    }

    public void Print(){
        System.out.print("Result:  ");
        for (int j : result) System.out.print(j);
        System.out.println();
    }
}
