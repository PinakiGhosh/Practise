import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Practise {

    public static long factorial(int n){
        if(n==1 || n==2){
            return n;
        }else{
            return factorial(n-1)*n;
        }
    }

    public static long digest(long n){
        int z=0;
        while (n>9){
            z=0;
            while (n>0){
                z+=n%10;
                n=n/10;
            }
            n=z;
        }
        return n;
    }

    public static long rotateNumber(long number,int rotateBy)
    {
        String num=number+"";
        rotateBy=rotateBy%num.length();
        int length=num.length();
        StringBuffer sb=new StringBuffer(num);
        //System.out.println(rotateBy);
        for (int i=0;i<rotateBy;i++){
            sb.insert(0,sb.charAt(length-1));
            sb.deleteCharAt(length);
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=Integer.parseInt(sc.nextLine());
        for (int i=0;i<testCases;i++){
            String[] friendsArray=sc.nextLine().split(" ");
            int friendsToDelete=Integer.parseInt(friendsArray[1]);
            String[] popularityArray=sc.nextLine().split(" ");
            int deleteCount=0;
            boolean deleteFlag=true;
            Stack<Integer> stack = new Stack<>();
            for (int j=0;j<popularityArray.length;j++) {
                if (stack.isEmpty()) {
                    stack.push(Integer.parseInt(popularityArray[i]));
                }else {
                    while (deleteFlag &&!stack.isEmpty() && stack.peek()<Integer.parseInt(popularityArray[i])){
                        if(deleteCount<friendsToDelete){
                            stack.pop();
                            deleteCount++;
                        }else{
                            deleteFlag=false;
                            break;
                        }
                    }
                    stack.push(Integer.parseInt(popularityArray[i]));
                }
            }
            String sb="";
            for (int ii=0;ii<stack.size();ii++){
                sb=stack.pop()+" "+sb;
            }
            System.out.println(sb);
        }

    }
}
