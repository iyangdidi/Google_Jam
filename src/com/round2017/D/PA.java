package com.round2017.D;

import java.io.*;
import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.INACTIVE;

public class PA {
	int N;
	int Ts;
	int Tf;
	int[][] bus;
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\A-large.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\A-large.out");
		
		int T = sc.nextInt();//cases
		for(int k=1; k<=T; k++) {
			N = sc.nextInt();
			Ts = sc.nextInt();
			Tf = sc.nextInt();
			bus = new int[N][3+1];
			for(int i=1; i<=N-1; i++) {
				bus[i][1] = sc.nextInt();
				bus[i][2] = sc.nextInt();
				bus[i][3] = sc.nextInt();
			}
			
			//handle
			solve();
			
			//reconstrcut the result
			boolean flag = false;
			for(int i=N-1; i>=0; i--) {
				if(dp[N-1][i] <= Tf) {
					flag = true;					
					out.write("Case #"+k+": "+i+"\n");					
	                break;
				}
			}
			if(!flag) {
				out.write("Case #"+k+": IMPOSSIBLE\n");
			}
					
		}				
		sc.close();
		out.flush();
		out.close();
	}
	
	int dp[][];
	
	void solve() {
		dp = new int[N][N];
		//init
		for(int i=0; i<=N-1; i++) {
			for(int j=0; j<=N-1; j++) {
				dp[i][j] = Tf+1;
			}
		}
		dp[0][0] = 0;
		
		for(int i=1; i<=N-1; i++) {
			for(int j=0; j<=i; j++) {
				if(j<=i-1) {
					int bus_t = 0;
					if(dp[i-1][j]<=bus[i][1]) {
						bus_t = bus[i][1];
					}else {
						bus_t = getBusTime(i, j);
					}
					dp[i][j] = Math.min(dp[i][j], bus_t+bus[i][3]);
				}
				if(j-1>=0) {
					int bus_t = 0;
					int pre_t = dp[i-1][j-1]+Ts;
					if(pre_t<=bus[i][1]) {
						bus_t = bus[i][1];
					}else {
						bus_t = getBusTimePre(i, j, pre_t);						
					}
					dp[i][j] = Math.min(dp[i][j], bus_t + bus[i][3]);
				}
			}
		}
	}
	
	int getBusTimePre(int i, int j, int pre_t) {
		int bus_t;
		int t = (pre_t-bus[i][1])%bus[i][2];
		if(t>0) {
			bus_t = bus[i][1]+((pre_t-bus[i][1])/bus[i][2]+1)*bus[i][2];
		}else {
			bus_t = pre_t;
		}
		
		return bus_t;
	}
	
	int getBusTime(int i, int j) {
		int bus_t;
		int t = (dp[i-1][j]-bus[i][1])%bus[i][2];
		if(t>0) {
			bus_t = bus[i][1] + ((dp[i - 1][j] - bus[i][1]) / bus[i][2] + 1)*bus[i][2];
		}else {
			bus_t = dp[i - 1][j];
		}
		
		return bus_t;
	}
	
//	
//	int solve(int city, int cur_t){		
//		
//		if(cur_t>Tf) {
//			return -1;
//		}
//		
//		if(city==N) {
//			return 0;			
//		}
//		
//		//signtseeing
//		int a;
//		int bus_t;
//		if((cur_t+Ts)<=bus[city][1]) {
//			bus_t = bus[city][1];
//		}else {
//			bus_t = getBusTime(city, cur_t+Ts);
//		}		
//		a = solve(city+1,bus_t+bus[city][3]);
//		if(a>0) {
//			a++;
//		}
//
//		//not signtseeing
//		int b;
//		if(cur_t<=bus[city][1]) {
//			bus_t = bus[city][1];
//		}else {
//			bus_t = getBusTime(city, cur_t);
//		}			
//		b = solve(city+1,bus_t+bus[city][3]);
//		
//		return a>b ? a:b;
//	}
//	
//	int getBusTime(int city, int cur_t) {
//		int k;
//		if(bus[city][2]==1) {
//			k = cur_t-bus[city][1];
//		}else {
//			k = (cur_t-bus[city][1]+1)/bus[city][2];
//		}
//		
//		int bus_t = bus[city][1]+k*bus[city][2];
//		return bus_t;
//	}

	
	public static void main(String[] args) {
		PA m = new PA();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
