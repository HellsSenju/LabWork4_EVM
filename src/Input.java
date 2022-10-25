import java.util.Scanner;

public class Input {
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();
    Number number = new Number();
    public static int cc;
    public int[] firstArr;
    public int[] secondArr;

    public boolean fMinus = false;
    public boolean sMinus = false;

    public void doInput(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("CC: 2 - 16: -->");
            try {
                int polycc = scan.nextInt();
                if(polycc >= 2 && polycc <= 16){
                    cc = polycc;
                    break;
                }
                System.out.println("Error");
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        firstArr = number.inputNumber("first");
        if(firstArr[0] == 1) fMinus = true;
        secondArr = number.inputNumber("second");
        if(secondArr[0] == 1) sMinus = true;
    }

    public void Operation(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Division(/), Multiplication(*), Addition(+), Subtraction(-) -->");
            String operation = scan.nextLine();
            if(operation.equals("+")){
                addition.DoAddition(firstArr, secondArr);
                addition.Print();
                break;
            }
            if(operation.equals("-")){
                subtraction.DoSubtraction(firstArr, secondArr);
                subtraction.addition.Print();
                break;
            }
            if(operation.equals("*")){

                multiplication.dpMultiplication(firstArr, secondArr);
                break;
            }
            if(operation.equals("/")){
                division.DoDivision(firstArr, secondArr);
                break;
            }
            System.out.println();
            System.out.println("Error! Try again");
        }
    }
}
