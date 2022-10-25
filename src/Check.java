public class Check {
    public String cc11 = "-0123456789A";
    public String cc12 = "-0123456789AB";
    public String cc13 = "-0123456789ABC";
    public String cc14 = "-0123456789ABCD";
    public String cc15 = "-0123456789ABCDE";
    public String cc16 = "-0123456789ABCDEF";

    public boolean doCheck(String num, int cc){
        for(int i = 0; i < num.length(); i++){
            String temp = Character.toString(num.charAt(i));
            switch(cc){
                case 11:
                    if(cc11.contains(temp)) return true;
                    break;
                case 12:
                    if(cc12.contains(temp)) return true;
                    break;
                case 13:
                    if(cc13.contains(temp)) return true;
                    break;
                case 14:
                    if(cc14.contains(temp)) return true;
                    break;
                case 15:
                    if(cc15.contains(temp)) return true;
                    break;
                case 16:
                    if(cc16.contains(temp)) return true;
                    break;
            }
        }
        return false;
    }

    public int[] addToArray(int[] arr, String num){
        int j = num.length() - 1;
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(Number.ifMinus) {
                if (j == 0) break;
            }
            else {
                if(j < 0) break;
            }


            if( ((int)num.charAt(j)  >= 65 && (int)num.charAt(j)  <= 70) ){
                switch((int)num.charAt(j) ){
                    case 65:
                        arr[i] = 10;
                        break;
                    case 66:
                        arr[i] = 11;
                        break;
                    case 67:
                        arr[i] = 12;
                        break;
                    case 68:
                        arr[i] = 13;
                        break;
                    case 69:
                        arr[i] = 14;
                        break;
                    case 70:
                        arr[i] = 15;
                        break;
                }
            }
            else
                arr[i] = Integer.parseInt(String.valueOf(num.charAt(j)));
            j--;
        }
        return arr;
    }
}
