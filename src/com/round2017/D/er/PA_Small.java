package com.round2017.D.er;

import java.io.*;
import java.util.*;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.INACTIVE;

public class PA_Small {
	int N;
	int Ts;
	int Tf;
	int[][] bus;
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\A_in.in")));
		FileWriter out = new FileWriter("D:\\e-workspace\\Google\\src\\com\\round2017\\D\\io\\A_out.out");
		
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
			int count = solve(1, 0);
			if(count>=0) {
				out.write("Case #"+k+": "+count+"\n");
			}else {
				out.write("Case #"+k+": IMPOSSIBLE\n");
			}
					
		}				
		sc.close();
		out.flush();
		out.close();
	}
	
	int solve(int city, int cur_t){		
		
		if(cur_t>Tf) {
			return -1;
		}
		
		if(city==N) {
			return 0;			
		}
		
		//signtseeing
		int a;
		int bus_t;
		if((cur_t+Ts)<=bus[city][1]) {
			bus_t = bus[city][1];
		}else {
			bus_t = getBusTime(city, cur_t+Ts);
		}		
		a = solve(city+1,bus_t+bus[city][3]);
		if(a>0) {
			a++;
		}

		//not signtseeing
		int b;
		if(cur_t<=bus[city][1]) {
			bus_t = bus[city][1];
		}else {
			bus_t = getBusTime(city, cur_t);
		}			
		b = solve(city+1,bus_t+bus[city][3]);
		
		return a>b ? a:b;
	}
	
	int getBusTime(int city, int cur_t) {
		int k;
		if(bus[city][2]==1) {
			k = cur_t-bus[city][1];
		}else {
			k = (cur_t-bus[city][1]+1)/bus[city][2];
		}
		
		int bus_t = bus[city][1]+k*bus[city][2];
		return bus_t;
	}

	
	public static void main(String[] args) {
		PA_Small m = new PA_Small();
		try {
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
