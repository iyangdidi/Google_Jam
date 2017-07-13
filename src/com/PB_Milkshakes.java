package com;

import java.io.*;
import java.util.*;

public class PB_Milkshakes {
	
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\iyang\\Desktop\\Google\\PB_Milkshakes\\B-small-practice.in")));
		FileWriter out = new FileWriter("C:\\Users\\iyang\\Desktop\\Google\\PB_Milkshakes\\B-small-practice.out");
		int c = sc.nextInt();//case numer
		int n = sc.nextInt();//flavor
		int m = sc.nextInt();//customer		
		for(int k=0; k<c; k++) {
			//for each case
			//build the matrix
			int[][] table = new int[m+1][n+1];
			for(int i=1; i<=m; i++) {
				int n_pair = sc.nextInt();
				table[i][0] = n_pair;
				for(int j=1; j<=n_pair; j++) {
					int p1 = sc.nextInt();
					int p2 = sc.nextInt()+1;//to make 0~1 to 1~2, for matrix init is 0
					table[i][p1] = p2;
				}
			}
			//handle the matrix
			//case of table[i][0]==1
			while(true) {
				int flag = 0;
				for(int i=0; i<=m; i++) {					
					if(table[i][0]==1) {
						flag = 1;
						for(int j=1; j<=n; j++) {
							if(table[0][j]==-1) {
								out.write("Case #"+k+":"+"IMPOSSIBLE");
							}
							if(table[i][j]!=0) {
								int tmp = table[i][j];
								for(int t=1; t<=m; t++) {
									if(table[t][j]==tmp) {
										table[i][0]=-1;//customer was santisfied
									}else if(table[t][j]>0) {
										table[i][0]--; 
									}								
								}
								table[0][j] = tmp;//set the milkshake
								break;
							}
						}
					}
				}
				if(flag==0) {break;}
			}
			//output
			out.write("Case #"+k+":"+"");
		}
		sc.close();
		out.flush();
		out.close();
	}
	
	public static void main(String[] args) {
		PB_Milkshakes m = new PB_Milkshakes();
		try {			
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
