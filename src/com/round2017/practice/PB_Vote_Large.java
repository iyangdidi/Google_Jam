package com.round2017.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PB_Vote_Large {
	public void handler() throws IOException{
		String path = PB_Vote_Large.class.getResource("").getPath();
		path = path.substring(1, path.length());
		Scanner sc = new Scanner(new BufferedReader(new FileReader(path+"io//B-small-practice.in")));
		FileWriter out = new FileWriter(path+"io//B-small-practice.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			//TODO
		}
				
		sc.close();
		out.flush();
		out.close();
	}
	double[][] dp = new double[2001][2001];
	int N,M;
	public void initDp() {
		for(int i=0; i<N+1; i++) {
			for(int j=0; j<M+1; j++) {
				dp[i][j] = -1.0;
			}
		}
		dp[0][0] = 1.0;
	}
	public double solve(int n, int m) {
		double res = 0.0;
		
		if(dp[n][m]!=-1.0) {
			return dp[n][m];
		}else {
			if(n>m) {
				if(m==0) {
					dp[n][m] = solve(n-1,m)*(N-n+1);
				}else {}
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		PB_Vote_Large m = new PB_Vote_Large();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

