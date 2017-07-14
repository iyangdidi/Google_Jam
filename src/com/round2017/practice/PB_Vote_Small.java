package com.round2017.practice;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * 
 * @author iyang
 * 
 * Problem

A and B are the only two candidates competing in a certain election. We know from polls that exactly N voters support A, and exactly M voters support B. We also know that N is greater than M, so A will win.

Voters will show up at the polling place one at a time, in an order chosen uniformly at random from all possible (N + M)! orders. After each voter casts their vote, the polling place worker will update the results and note which candidate (if any) is winning so far. (If the votes are tied, neither candidate is considered to be winning.)

What is the probability that A stays in the lead the entire time -- that is, that A will always be winning after every vote?

Input

The input starts with one line containing one integer T, which is the number of test cases. Each test case consists of one line with two integers N and M: the numbers of voters supporting A and B, respectively.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the probability that A will always be winning after every vote.

y will be considered correct if y is within an absolute or relative error of 10-6 of the correct answer. See the FAQ for an explanation of what that means, and what formats of real numbers we accept.

Limits

1 �� T �� 100.
Small dataset

0 �� M < N �� 10.
Large dataset

0 �� M < N �� 2000.
Sample


Input 

2
2 1
1 0


Output
Case #1: 0.33333333
Case #2: 1.00000000

In sample case #1, there are 3 voters. Two of them support A -- we will call them A1 and A2 -- and one of them supports B. They can come to vote in six possible orders: A1 A2 B, A2 A1 B, A1 B A2, A2 B A1, B A1 A2, B A2 A1. Only the first two of those orders guarantee that Candidate A is winning after every vote. (For example, if the order is A1 B A2, then Candidate A is winning after the first vote but tied after the second vote.) So the answer is 2/6 = 0.333333...

In sample case #2, there is only 1 voter, and that voter supports A. There is only one possible order of arrival, and A will be winning after the one and only vote.
 *
 */

//Correct
public class PB_Vote_Small {
	
	public void handler() throws IOException{
		String path = PB_Vote_Small.class.getResource("").getPath();
		path = path.substring(1, path.length());
		Scanner sc = new Scanner(new BufferedReader(new FileReader(path+"B-small-practice.in")));
		FileWriter out = new FileWriter(path+"B-small-practice.out");
		
		//read data
		int T = sc.nextInt();
		for(int k=1; k<=T; k++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			BigInteger[][] ma = new BigInteger[N+1][M+1];
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=M; j++) {
					ma[i][j] = new BigInteger("0");
				}
			}
			ma[0][0] = new BigInteger("1");
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=M; j++) {
					if(i>j) {
						if(j==0) {
							ma[i][j] = ma[i-1][j].multiply(new BigInteger((N-i+1)+""));
						}else {
							if(ma[i-1][j].equals(new BigInteger("0"))) {
								ma[i][j] = ma[i][j-1].multiply(new BigInteger((M-j+1)+""));
							}else {
								ma[i][j] = ma[i-1][j].multiply(new BigInteger((N-i+1)+"")).add(ma[i][j-1].multiply(new BigInteger((M-j+1)+"")));
							}
						}
					}
				}
			}
			
			BigDecimal allc  = allCases(N+M);
			BigDecimal cases = new BigDecimal(ma[N][M]);
			BigDecimal res = cases.divide(allc,8,RoundingMode.HALF_UP);
			
			out.write("Case #"+k+": "+res.toString()+"\n");
			
//			BigInteger sum = new BigInteger("0");
//			for(int i=0; i<=N; i++) {
//				for(int j=0; j<=M; j++) {
//					if(i>j) {
//						if(j>0) {
//							BigInteger tmp = new BigInteger(""+(N-i+1)*(M-j+1));
//							sum = sum.add(tmp);
//						}else {
//							sum = sum.add(new BigInteger(""+(N-i+1)));
//						}						
//					}
//				}
//			}			
		}
		
		
		sc.close();
		out.flush();
		out.close();
	}
	
	public BigDecimal allCases(int num) {
		BigDecimal t = new BigDecimal(""+1);
		for(int i=1; i<=num; i++) {
			t = t.multiply(new BigDecimal(""+i));
		}
		
		return t;
	}
	
	public static void main(String[] args) {
		PB_Vote_Small m = new PB_Vote_Small();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
