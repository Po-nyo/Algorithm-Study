public class BinaryConvert {
    public static void main(String[] args){
        String s = "1";

        BinaryConvert a = new BinaryConvert();

        int repeat =1;
        int zero = s.length() - a.Count(s);

        if(s.equals("1")){
            zero = 0;
            repeat=0;
        }

        while (!a.Convert(a.Count(s)).equals("1")) {
            repeat++;
            System.out.println(s = a.Convert(a.Count(s)));
            zero += s.length()-a.Count(s);
        }

        System.out.println(repeat+", "+zero);
    }
    private int Count(String s){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                count++;
        }
        return count;
    }

    private String Convert(int count){
        String s = "";

        while(count>=2){
            s=count%2+s;
            count /= 2;
        }

        return count+s;
    }
}
