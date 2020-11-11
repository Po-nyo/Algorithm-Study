public class FindTeemo {
    public static void main(String[] args){

        String[] Teemo={"T","E","E","M","O"};
        String[][] Find={{"T","e","e","m","o"}
                        ,{"e","i","x","r","b"}
                        ,{"a","b","c","z","z"}
                        ,{"m","q","r","x","i"}
                        ,{"t","o","o","m","o"}};

        String[][] expansion=new String[Find.length+8][Find[0].length+8];

        for(int i=0;i<expansion.length;i++){
            for(int j=0;j<expansion[0].length;j++){
                expansion[i][j]="x";
                if(i>=5&&i<=expansion.length-5 &&j>=5&&j<=expansion.length-5 ){
                    expansion[i][j]=Find[i-5][j-5];
                }
            }
        }

        FindTeemo a = new FindTeemo();
        a.Find(expansion,Teemo,Find);

        for(int i=0;i<Find.length;i++){
            for(int j=0;j<Find[0].length;j++){
                System.out.print(Find[i][j]);
            }
            System.out.println();
        }
    }

    private String[][] Find(String[][] expansion,String[] Teemo,String[][] Find){
        FindTeemo a = new FindTeemo();
        String[] check;

        for(int i=5;i<expansion.length-5;i++){
            for(int j=5;j<expansion[i].length-5;j++){
                check=check(expansion[i][j],expansion[i-1][j+1],expansion[i-2][j+2],expansion[i-3][j+3],expansion[i-4][j+4]);
                if(edge(Teemo,check)||edge(Teemo,a.reverse(check))){
                    Find[i-5][j-5]="#";
                    Find[i-6][j-4]="#";
                    Find[i-7][j-3]="#";
                    Find[i-8][j-2]="#";
                    Find[i-9][j-1]="#";
                }
                check=check(expansion[i][j],expansion[i+1][j+1],expansion[i+2][j+2],expansion[i+3][j+3],expansion[i+4][j+4]);
                if(edge(Teemo,check)||edge(Teemo,a.reverse(check))){
                    Find[i-5][j-5]="#";
                    Find[i-4][j-4]="#";
                    Find[i-3][j-3]="#";
                    Find[i-2][j-2]="#";
                    Find[i-1][j-1]="#";
                }
                check=check(expansion[i][j],expansion[i+1][j],expansion[i+2][j],expansion[i+3][j],expansion[i+4][j]);
                if(edge(Teemo,check)||edge(Teemo,a.reverse(check))){
                    Find[i-5][j-5]="#";
                    Find[i-4][j-5]="#";
                    Find[i-3][j-5]="#";
                    Find[i-2][j-5]="#";
                    Find[i-1][j-5]="#";
                }
                check=check(expansion[i][j],expansion[i][j+1],expansion[i][j+2],expansion[i][j+3],expansion[i][j+4]);
                if(edge(Teemo,check)||edge(Teemo,a.reverse(check))){
                    Find[i-5][j-5]="#";
                    Find[i-5][j-4]="#";
                    Find[i-5][j-3]="#";
                    Find[i-5][j-2]="#";
                    Find[i-5][j-1]="#";
                }
            }
        }
        return Find;
    }
    private boolean edge(String[] Teemo, String[] check){
        boolean chain = true;
        int count =0;
        for(int i=0;i<5;i++) {
            if (Teemo[i].equalsIgnoreCase(check[i])){
                count++;
                chain = true;
            }

            else{
                if(chain==false)
                    return false;
                chain=false;
            }
        }

        return count>=3;
    }
    private String[] reverse(String[] check){
        String temp=check[4];
        check[4]=check[0];
        check[0]=temp;
        temp=check[3];
        check[3]=check[1];
        check[1]=temp;

        return check;
    }
    private String[] check(String a,String b,String c, String d, String e){
        String[] check=new String[5];
        check[0]=a;
        check[1]=b;
        check[2]=c;
        check[3]=d;
        check[4]=e;
        return check;
    }

}
