import java.util.Arrays;
import java.util.Scanner;

public class Number {
    Convertor convertor = new Convertor();
    Check check = new Check();

    public int[] numArr;
    public static boolean ifMinus;

    public int[] inputNumber(String nomer){
        Scanner scan = new Scanner(System.in);
        String numStr;

        while(true){
            System.out.print(nomer +  " number -->");

            if(Input.cc < 11) //cc без букв
            {
                try{
                    int num = scan.nextInt(); //считываем
                    numStr = String.valueOf(Math.abs(num)); //преобразуем в строку
                    numArr = new int[8];

                    Arrays.fill(numArr, 0); //зполняем всее нулями
                    int j = numStr.length() - 1;
                    for(int i = numArr.length - 1; i >= 0; i--) //добавляем цифры числа
                    {
                        if(j < 0) break;
                        numArr[i] = Integer.parseInt(String.valueOf(numStr.charAt(j)));
                        j--;
                    }
                    numArr = convertor.Conver(numArr); //переводим в 2 сс

                    if(num < 0)//отрицательное или положительное
                    {
                        numArr[0] = 1;
                    }

                    break;
                }catch (Exception ex){
                    System.out.println();
                    System.out.println(ex.getMessage());
                    System.out.println("Try again");
                }
            }

            else //сс с буквами
            {
                try{
                    numStr = scan.nextLine(); //считываем строку
                    numStr = numStr.toUpperCase(); //делаем буквы большими

                    ifMinus = String.valueOf(numStr.charAt(0)).equals("-"); //отрицательное или положительное

                    if(check.doCheck(numStr, Input.cc)) //если все символы в  строке правильные
                    {
                        numArr = new int[8];
                        Arrays.fill(numArr, 0); //зполняем всее нулями
                        numArr = check.addToArray(numArr, numStr); //добавляем цифры числа
                        numArr = convertor.Conver(numArr); //переводим в 2 сс

                        if(ifMinus)//отрицательное или положительное
                        {
                            numArr[0] = 1;
                        }

                        break;
                    }
                    System.out.println("Error");
                }catch (Exception ex){
                    System.out.println();
                    System.out.println(ex.getMessage());
                    System.out.println("Try again");
                }
            }
        }
        return numArr;
    }
}
