package com.round2017.A.er;

import java.awt.HeadlessException;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

import javax.jws.WebParam.Mode;

/**
 * 
 * @author iyang
 * 
 * Problem

Mr. Panda has recently fallen in love with a new game called Square Off, in which players compete to find as many different squares as possible on an evenly spaced rectangular grid of dots. To find a square, a player must identify four dots that form the vertices of a square. Each side of the square must have the same length, of course, but it does not matter what that length is, and the square does not necessarily need to be aligned with the axes of the grid. The player earns one point for every different square found in this way. Two squares are different if and only if their sets of four dots are different.

Mr. Panda has just been given a grid with R rows and C columns of dots. How many different squares can he find in this grid? Since the number might be very large, please output the answer modulo 109 + 7 (1000000007).

Input

The first line of the input gives the number of test cases, T. T lines follow. Each line has two integers R and C: the number of dots in each row and column of the grid, respectively.
Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of different squares can be found in the grid.
Limits

1 ≤ T ≤ 100.
Small dataset

2 ≤ R ≤ 1000.
2 ≤ C ≤ 1000.
Large dataset

2 ≤ R ≤ 109.
2 ≤ C ≤ 109.
Sample


Input 
4
2 4
3 4
4 4
1000 500

Output
Case #1: 3
Case #2: 10
Case #3: 20
Case #4: 624937395


 *
 */

public class PA_Square_Counting {
	BigInteger mode = new BigInteger("1000000007");
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\A-small-practice.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\A\\io\\A-small-practice.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int min = R>C?C:R;
			BigInteger sum = new BigInteger("0");
			//因为就算是斜的，其实也可以被一个“正”的正方形包围，每个“正”的正方向，其边上的点可以重新连接形成新的正方形 
			//所以通过长度为len的正方向来确定个数
			//long up = 0;
			for(int len=1; len<=min; len++) {
				BigInteger tmp = new BigInteger((R-len)*(C-len)*len+"");
				//up = up+tmp/mode;
				sum = sum.add(tmp);
			}
			
			out.write("Case #"+k+": "+sum.mod(mode)+"\n");
		}
				
		sc.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		PA_Square_Counting m = new PA_Square_Counting();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
