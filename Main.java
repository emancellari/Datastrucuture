import java.util.*;
 
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
 
class Main {
static int min(int x, int y, int z)
   {
       if (x <= y && x <= z)
           return x;
       if (y <= x && y <= z)
           return y;
       else
           return z;
   }
   static int editDistDP(String str1, String str2, int m,
                         int n)
   {
       // Create a table to store results of subproblems
       int dp[][] = new int[m + 1][n + 1];
       // Fill d[][] in bottom up manner backtracking
       for (int i = 0; i <= m; i++) {
           for (int j = 0; j <= n; j++) {
               // If first string is empty, only option is
               // to insert all characters of second string
               if (i == 0)
                   dp[i][j] = j; // Min. operations = j
               // If second string is empty, only option is
               // to remove all characters of second string
               else if (j == 0)
                   dp[i][j] = i; // Min. operations = i
               // If last characters are same, ignore last
               // char and recur for remaining string
               else if (str1.charAt(i - 1)
                        == str2.charAt(j - 1))
                   dp[i][j] = dp[i - 1][j - 1];
               // If the last character is different,
               // consider all possibilities and find the
               // minimum
               else
                   dp[i][j] = 1
                               + min(dp[i][j - 1], // Insert
                                    dp[i - 1][j], // Remove
                                    dp[i - 1]
                                      [j - 1]); // Replace
           }
       }
       return dp[m][n];
   }
 
public static void main(String[] args){
   
   
   
     try {
       File myObj = new File("filename.txt");
       File myObj2 = new File("filename2.txt");
       Scanner myReader = new Scanner(myObj);
       Scanner Reader = new Scanner(myObj2);
     while (myReader.hasNextLine()) {
       String data = myReader.nextLine();
       String data2=Reader.nextLine();
       System.out.println(editDistDP(data, data2,data.length(),data2.length()));
     }
     myReader.close();
     Reader.close();
   } catch (FileNotFoundException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
 }
}
