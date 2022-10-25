import java.util.Arrays;

public class Division {

    Subtraction subtraction;
    Addition addition;
    public String res = "";
    public void DoDivision(int[] firstArr, int[] secondArr){
        subtraction = new Subtraction();
        addition = new Addition();

        if(firstArr[0] == 1 & secondArr[0] == 0){
            firstArr[0] = 0;
            res += "-";
        }
        else if(firstArr[0] == 0 & secondArr[0] == 1){
            secondArr[0] = 0;
            res += "-";
        }
        int divisorI = findF(secondArr); //делитель (старший разряд)
        int dividendI = findF(firstArr); // делимое (старший разряд)
        int kol;


        int[] divisor = Arrays.copyOf(secondArr, secondArr.length);
        if(dividendI < divisorI) //  Предварительный сдвиг делителя
        {
            kol = divisorI - dividendI;
            while(kol != 0){
                offset(divisor, 0);
                kol--;
            }
        }
        kol = divisorI - dividendI;
        subtraction.DoSubtraction(firstArr,divisor);
        int[] chastOst = subtraction.addition.result; // частичный остаток
        if(chastOst[0] == 1) res += "0";
        if(chastOst[0] == 0) res += "1";
        if(Compare(chastOst,secondArr) & !ifNol(chastOst)){
            while(kol != 0){
                offset(chastOst, 0);
                if(chastOst[0] == 1) // частичный остаток отриц. => прибавляем к нему делитель
                {
                    addition.DoAddition(chastOst, divisor);
                    chastOst = addition.result; //обновляем частичный остаток
                    if(chastOst[0] == 1) res += "0";
                    if(chastOst[0] == 0) res += "1";
                }
                else // частичный остаток положит. => вычитаем из него делитель
                {
                    subtraction.DoSubtraction(chastOst, divisor);

                    chastOst = subtraction.addition.result; //обновляем частичный остаток
                    if(chastOst[0] == 1) res += "0";
                    if(chastOst[0] == 0) res += "1";
                }

                if(Compare(chastOst, secondArr))break;

                kol--;
            }
        }


        while(res.length() - 1 != kol){
            res += "0";
        }
        chastOst[0] = 0;
        System.out.println("Целая часть: " + res);
        Print(chastOst);
    }

    private void offset(int[] arr, int add){
        for(int i = 2; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = add;
    }

    private boolean Compare(int[] f, int[] s) //first - частичный остаток, second - исходный (несдвинутый) делитель
    {
        subtraction = new Subtraction();
        int[] first = Arrays.copyOf(f, f.length);
        int[] second = Arrays.copyOf(s, s.length);
        first[0] = 0;
        second[0] = 0;
        subtraction.DoSubtraction(first, second);
        if(subtraction.addition.result[0] == 0) return true; //если частичный ост меньше исходного делителя - true
        return false; //если меньше
    }

    private int findF(int[] arr){
        for (int i = 1; i < arr.length; i++){
            if(arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean ifNol(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 1)return false;
        }
        return true;
    }

    public void Print(int[] arr){
        System.out.print("Остаток:  ");
        for (int j : arr) System.out.print(j);
        System.out.println();
    }
}
