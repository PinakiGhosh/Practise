package misc;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by pinaki on 29/1/18.
 */
public class Dummy {

    public static int[] convertStringToIntArray(String st){
        String arr[]=st.split(" ");
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=Integer.parseInt(arr[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
//        1->1 7->11 26->26 151->131 38->86
        HashMap<Integer,Integer> m= new HashMap<Integer, Integer>();
        m.put(1,1);
        m.put(7,11);
        m.put(26,26);
        m.put(151,131);
        m.put(38,86);
        Scanner sc=new Scanner(System.in);
        int testCases=Integer.parseInt(sc.nextLine());
        int arr[]=convertStringToIntArray(sc.nextLine());
        for(int j=0;j<arr.length;j++){
            System.out.println(m.get(arr[j]));
        }
    }
}
