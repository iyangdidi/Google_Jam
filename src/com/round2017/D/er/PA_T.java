package com.round2017.D.er;

import java.io.*;
import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class PA_T {
	int N;
	int Ts;
	int Tf;
	int[][] bus;
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\in.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\out.out");
		
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
			count = 0;
			if(solve(1, 0)) {
				out.write("Case #"+k+": "+count+"\n");
			}else {
				out.write("Case #"+k+": IMPOSSIBLE\n");
			}
					
		}				
		sc.close();
		out.flush();
		out.close();
	}
	int count;
	boolean solve(int city, int cur_t){		
		
		if(cur_t>12) {
			return false;
		}
		
		if(city==N-1) {
			return true;			
		}
		
		//signtseeing
		int bus_t;
		if((cur_t+Ts)<=bus[city][1]) {
			bus_t = bus[city][1];
		}else {
			bus_t = getBusTime(city, cur_t+Ts);
		}		
		if(solve(city+1,cur_t+Ts+bus[city][3])) {
			count++;
			return true;
		}else {
			//not signtseeing
			if(cur_t<=bus[city][1]) {
				bus_t = bus[city][1];
			}else {
				bus_t = getBusTime(city, cur_t);
			}			
			return solve(city+1,cur_t+bus[city][3]);
		}
	}
	
	int getBusTime(int city, int cur_t) {
		int k = (cur_t-bus[city][1]+1)/bus[city][2];
		int bus_t = bus[city][1]+k*bus[city][2];
		return bus_t;
	}

	
	public static void main(String[] args) {
		PA_T m = new PA_T();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
