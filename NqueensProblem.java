//from GEEKS FOR GEEKS

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> answer=new ArrayList<>();
        
        ArrayList<Integer> temp= new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        
        check(0,n,board,temp,answer);
        return answer;
    }
    public static void check(int row,int n,boolean[][] chess,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans){
        
        //if are able to put queen in the last row then it is a 1 solution.
        if(row==n){
            ans.add(new ArrayList<>(temp));//q1 output is 2413 //temp storing this
            return;
        }
        //
        for(int col=0;col<n;col++){
            if(safe(chess,row,col,n)){
            chess[row][col]=true;
            temp.add(col+1);//output of column 
            check(row+1,n,chess,temp,ans);
            chess[row][col]=false;
            temp.remove(temp.size()-1);
            }
        }
    }
    static boolean safe(boolean[][] chess,int row,int col,int n){
        //check for diagonal //row and col can be less than zero
        
        //leftdiagonal
        int rowtemp=row;
        int coltemp=col;
        while(rowtemp>=0 && coltemp>=0){
            if (chess[rowtemp][coltemp]==true)
            return false;
            rowtemp--;coltemp--;
        }
        //right diagonal
        rowtemp=row;
        coltemp=col;
        while(rowtemp>=0 && coltemp<n){
            if (chess[rowtemp][coltemp]==true)
            return false;
            rowtemp--;coltemp++;
            
        }
        coltemp=col;
        //check for column//i will remain same
        while(coltemp>=0){
            if (chess[row][coltemp]==true)
            return false;
            coltemp--;
        }
        
        //checking row

        rowtemp=row;
        coltemp=col;
        
        while(rowtemp>=0){
              if(chess[rowtemp][coltemp]==true)
                return false;
            rowtemp--;
        }
        return true;
    }
}
