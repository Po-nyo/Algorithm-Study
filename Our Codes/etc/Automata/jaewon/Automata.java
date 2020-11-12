
public class Automata {
    public static void main(String[] args){
        String num1 = "00001";
        String num2 = "000";
        String num3 = "101";

        Automata a = new Automata();

        System.out.println(a.Confirm(num1));
        System.out.println(a.Confirm(num2));
        System.out.println(a.Confirm(num3));

    }

    private String Binary(int length,int num){
        String Binary="";
        int count =1;
        while(num>1){
            count++;
            Binary = num%2+Binary;
            num /= 2;
        }
        Binary = num+Binary;

        length-=count;

        for(int i=0;i<length;i++){
            Binary ="0"+Binary;
        }

        return Binary;
    }


    private String Convert(String num2){
        String[] NUM2=num2.split("");
        String[] result=new String[NUM2.length];

        for(int i=0;i<NUM2.length;i++) {
            result[i]=NUM2[i];
            if (i == 0) {
                if (!NUM2[NUM2.length - 1].equals(NUM2[i + 1])) {
                    if (NUM2[i].equals("0"))
                        result[i] = "1";
                    else
                        result[i] = "0";
                }
            } else if (i == NUM2.length - 1){
                if (!NUM2[i - 1].equals(NUM2[0])) {
                    if (NUM2[i].equals("0"))
                        result[i] = "1";
                    else
                        result[i] = "0";
                }
            } else {
                if (!NUM2[i - 1].equals(NUM2[i + 1])) {
                    if (NUM2[i].equals("0"))
                        result[i] = "1";
                    else
                        result[i] = "0";
                }
            }
        }

        String s = "";

        for(int i=0;i<result.length;i++)
            s += result[i];

        return s;
    }


    private String Confirm(String num){
        int circuit = (int)Math.pow(2,num.length());
        String s="";
        int count=0;
        for(int i=0;i<=circuit;i++){
            if(num.equals(Convert(Binary(num.length(),i)))){
                s = Convert(Binary(num.length(),i));
                count++;
            }
        }

        if(count == 0)
            s = "zero";

        else if(count>=2)
            s =  "multiple";

        return s;
    }
}
