/**
 * 
 */
package com.yahoo.twshopping.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2013 Google Code Jam Qualification Round {at} Yahoo! Sophia team
 * @author kentsay
 * @version 1.0
 */
public class TicTacToe {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/case/large.in");
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            char table[][] = new char [4][4];
            int testCase = Integer.parseInt(br.readLine());
            for(int i=0; i<testCase; i++) {
                for (int j = 0; j<4; j++) {
                    String line = br.readLine();
                    for (int k=0; k<4; k++) table[j][k] = line.charAt(k);
                }
                
                //possible results
                String winner = "";
                String[] ans = new String[10];
                ans[0] = Character.toString(table[0][0]) + Character.toString(table[0][1]) + Character.toString(table[0][2])+ Character.toString(table[0][3]);
                ans[1] = Character.toString(table[1][0]) + Character.toString(table[1][1]) + Character.toString(table[1][2])+ Character.toString(table[1][3]);
                ans[2] = Character.toString(table[2][0]) + Character.toString(table[2][1]) + Character.toString(table[2][2])+ Character.toString(table[2][3]);
                ans[3] = Character.toString(table[3][0]) + Character.toString(table[3][1]) + Character.toString(table[3][2])+ Character.toString(table[3][3]);
                ans[4] = Character.toString(table[0][0]) + Character.toString(table[1][0]) + Character.toString(table[2][0])+ Character.toString(table[3][0]);
                ans[5] = Character.toString(table[0][1]) + Character.toString(table[1][1]) + Character.toString(table[2][1])+ Character.toString(table[3][1]);
                ans[6] = Character.toString(table[0][2]) + Character.toString(table[1][2]) + Character.toString(table[2][2])+ Character.toString(table[3][2]);
                ans[7] = Character.toString(table[0][3]) + Character.toString(table[1][3]) + Character.toString(table[2][3])+ Character.toString(table[3][3]);
                ans[8] = Character.toString(table[0][0]) + Character.toString(table[1][1]) + Character.toString(table[2][2])+ Character.toString(table[3][3]);
                ans[9] = Character.toString(table[3][0]) + Character.toString(table[2][1]) + Character.toString(table[1][2])+ Character.toString(table[0][3]);
                
                for (int z=0; z<ans.length; z++)
                    winner = JudgeStatus(ans[z], winner);
                
                System.out.println("Case #" + (i+1) +": "+ winner);
                br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Cannot find test case");
        }
    }
    
    public static String JudgeStatus(String ans, String result) {
        if (ans.equals("TOOO") || ans.equals("OTOO") || ans.equals("OOTO") || ans.equals("OOOT") || 
            ans.equals("TXXX") || ans.equals("XTXX") || ans.equals("XXTX") || ans.equals("XXXT") || 
            ans.equals("OOOO") || ans.equals("XXXX")) {
            if (ans.charAt(0) != 'T') result = ans.charAt(0) +" won";
            else result = ans.charAt(1) + " won";
        }
        else { 
            if (ans.contains(String.valueOf('.')) && !result.equals("X won") && !result.equals("O won")) {
                result = "Game has not completed";
            }
            else if (result == "" && !ans.contains(String.valueOf('.'))) {
                result = "Draw";
            }
        } 
        return result;
    }
}
