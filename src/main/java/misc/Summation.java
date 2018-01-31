package misc;

/**
 * Created by pinaki on 19/1/18.
 */
public class Summation {

    public static String add(String a,String b){
        int sizeA=a.length();
        int sizeB=b.length();
        if(sizeA>sizeB){
            b=padZeroes(b,sizeA-sizeB);
        }else if(sizeB>sizeA){
            a=padZeroes(a,sizeB-sizeA);
        }
        sizeA=a.length();
        sizeB=b.length();
        int c1,c2,sum;
        boolean carry=false;
        StringBuffer finalString=new StringBuffer("");
        for(int i=1;i<=a.length();i++){
            c1=a.charAt(sizeA-i) - '0';
            c2=b.charAt(sizeB-i) - '0';
            sum=c1+c2;
            if(carry){
                sum++;
            }
            if(sum>9){
                carry=true;
                finalString.append(sum%10);
            }else {
                finalString.append(sum);
                carry=false;
            }
        }
        if(carry){
            finalString.append("1");
        }

        return finalString.reverse().toString();
    }

    public static String padZeroes(String a,int count){
        for(int i=0;i<count;i++){
            a="0"+a;
        }
        return a;
    }

    public static void main(String[] args) {
        String a="9999";
        String b="1";
        System.out.println(Summation.add(a,b));
    }
}
