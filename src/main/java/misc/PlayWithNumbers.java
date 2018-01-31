package main.java.misc;

/**
 * Created by pinaki on 25/1/18.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class PlayWithNumbers {

    class Scan
    {
        private byte[] buf=new byte[1024];    //Buffer of Bytes
        private int index;
        private InputStream in;
        private int total;
        public Scan()
        {
            in=System.in;
        }
        public int scan()throws IOException    //Scan method used to scan buf
        {
            if(total<0)
                throw new InputMismatchException();
            if(index>=total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                    return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int integer=0;
            int n=scan();
            while(isWhiteSpace(n))    //Removing starting whitespaces
                n=scan();
            int neg=1;
            if(n=='-')                //If Negative Sign encounters
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }
        private boolean isWhiteSpace(int n)
        {
            if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
                return true;
            return false;
        }
    }
    class Print
    {
        private final BufferedWriter bw;
        public Print()
        {
            this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object object)throws IOException
        {
            bw.append(""+object);
        }
        public void println(Object object)throws IOException
        {
            print(object);
            bw.append("\n");
        }
        public void close()throws IOException
        {
            bw.close();
        }
    }

    public static int getSubArrayMean(int[] arr, int startIndex,int endIndex){
        long sum=0;
        for (int i=startIndex-1;i<endIndex;i++){
            sum+=arr[i];
        }
        return (int)Math.floor(sum/((endIndex-startIndex)+1));
    }

    public void mainMethod() throws IOException{
        Scan s=new Scan();
        Print p=new Print();

        int size=s.scanInt();
        int testCases=s.scanInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=s.scanInt();
        }
        for (int i=0;i<testCases;i++){
            int m=s.scanInt();
            int n=s.scanInt();
            p.println(getSubArrayMean(arr,m,n));
        }
    }
    public static void main(String args[] ) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCases=Integer.parseInt(br.readLine().split(" ")[1]);
//        String[] inpNums=br.readLine().split(" ");
//        int m,n;
//        String[] inp;
//        for(int i=0;i<testCases;i++){
//            inp=br.readLine().split(" ");
//            m=Integer.parseInt(inp[0]);
//            n=Integer.parseInt(inp[1]);
//            System.out.println(getSubArrayMean(inpNums,m,n));
//        }
            new PlayWithNumbers().mainMethod();
    }
}

