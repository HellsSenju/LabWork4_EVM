public class Convertor {
    int finalNumSys = 2;
    public int[] Conver(int[] number){
        int temp = 0, j = number.length - 1;

        //to 10 cc
        for (int k : number) {
            temp = temp + k * (int) Math.pow(Input.cc, j);
            j--;
        }

        int i = number.length - 1;

        while(temp > 0) //to 2 cc
        {
            number[i] = temp % finalNumSys;
            temp /= finalNumSys;
            i--;
        }
        return number;
    }
}
