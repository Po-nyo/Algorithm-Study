import java.util.ArrayList;

public class news {
    public static void main(String[] args){
        String str1="E=M*C^2";
        String str2="e=m*c^2";

        String STR1 = str1.toUpperCase();
        String STR2 = str2.toUpperCase();

        news a = new news();

        ArrayList Str1=a.Convert(STR1);
        ArrayList Str2=a.Convert(STR2);


        int Inter=a.InterPoint(Str1,Str2);

        int Union =a.UnionPoint(Str1,Str2);
        int answer = (int)((double)Inter/Union* 65536);

        if(Inter == 0 && Union == 0)
            answer = 65536;

    }

    private ArrayList Convert(String STR){
        String[] ConvertSTR=STR.split("");
        ArrayList Two = new ArrayList();
        for(int i=0;i<ConvertSTR.length-1;i++){
            if(ConvertSTR[i].matches("[A-Za-z]*") &&ConvertSTR[i+1].matches("[A-Za-z]*")){
                Two.add(ConvertSTR[i]+ConvertSTR[i+1]);
            }
        }
        return Two;
    }

    private int UnionPoint(ArrayList S1,ArrayList S2){
        int count = 0;

        for(Object i : S1)
            count++;
        for(Object i : S2)
            count++;

        return count;
    }

    private int InterPoint(ArrayList S1, ArrayList S2){
        int count = 0;
        for(Object i : S1){
            if(S2.contains(i)){
                S2.remove(S2.indexOf(i));
                count++;
            }
        }
        return count;
    }
}
