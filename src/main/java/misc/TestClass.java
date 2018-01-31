package main.java.misc;

import java.util.Scanner;

/**
 * Created by pinaki on 24/1/18.
 */

class TestClass {


    public static int incrementX(int x,int size,int[] arr){
        while (true){
            x=x+1;
            if(x<size){
                if (arr[x]!=-1){
                    return x;
                }
            }else{
                x=0;
                if (arr[x]!=-1){
                    return x;
                }
            }
        }

    }

    public static void main(String args[] ) throws Exception {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        int x=s.nextInt();
        int countOfAlive =n;
        int[] status=new int[n];
        int peopleToKill;
        boolean printed=false;
        int count=0;
        x=x-1;
        while (countOfAlive>0){
            count++;
            if(count==10){
                break;
            }
            peopleToKill=x%k;
            System.out.println("X "+x+ " People to kill "+peopleToKill+ "Count of alive "+countOfAlive);
            //break;
            if(peopleToKill>countOfAlive){
                System.out.println(x);
                printed=true;
                break;
            }else if(peopleToKill==0){
                incrementX(x,n,status);
                continue;
            }else {
                x=incrementX(x,n,status);
                while (peopleToKill>0){
                    if(status[x]!=-1){
                        status[x]=-1;
                        peopleToKill--;
                        countOfAlive--;
                    }
                    x=incrementX(x,n,status);
                }
            }
        }
        if(!printed){
            System.out.println(x);
        }
    }

}
