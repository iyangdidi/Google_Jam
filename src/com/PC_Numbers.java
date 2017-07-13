package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;;

public class PC_Numbers {
	public void handler() throws IOException{
		Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\iyang\\Desktop\\Google\\PC_Numbers\\C-small-practice.in")));
		FileWriter out = new FileWriter("C:\\Users\\iyang\\Desktop\\Google\\PC_Numbers\\C-small-practice.out");
				
		BigDecimal t = new BigDecimal(5);
		BigDecimal tt = sqrt(t).add(new BigDecimal(3));
		
		int T = sc.nextInt();		
		for(int i=1; i<=T; i++) {
			int n = sc.nextInt();
			BigDecimal res = tt.pow(n);
			out.write("Case #"+i+": "+get3bit(res)+"\n");
		}	
		
		sc.close();
		out.flush();
		out.close();
	}
	public String get3bit(BigDecimal num) {
		String t = num.toString();
		int tt = t.indexOf('.');
		//String[] tt = t.split(".");
		String res = "";
		if(tt-0==1) {
			res = res+"00"+t.substring(0, tt);
		}
		if(tt-0==2) {
			res = res+"0"+t.substring(0, tt);
		}else {
			res = t.substring(tt-3, tt);
		}
		return res;
	}
	public static BigDecimal sqrt(BigDecimal num) {
		if(num.compareTo(BigDecimal.ZERO) < 0) {
		return BigDecimal.ZERO;
		}
		BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
		while(x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0);
		return x;
		}
	private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
		return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
		}
	//大数开方	
	public BigDecimal myBigNumSqrt(BigDecimal xx)
	{
		BigDecimal x=xx;
		BigDecimal n1=BigDecimal.ONE;
		BigDecimal ans=BigDecimal.ZERO;
		//int i=1;
		while((n1.multiply(n1).subtract(x)).abs().compareTo(BigDecimal.valueOf(0.001))==1)
		{
			//System.out.println(i+"..."+n1);
			//i++;
			BigDecimal s1=x.divide(n1,2000,BigDecimal.ROUND_HALF_UP);
			BigDecimal s2=n1.add(s1);
			n1=s2.divide(BigDecimal.valueOf(2),2000,BigDecimal.ROUND_HALF_UP);

		}
		ans=n1;
		//System.out.println(ans);
		BigDecimal rt =new BigDecimal(ans.toString().split("\\.")[0]);
		return rt;
	}	
	public static void main(String[] args) {
		PC_Numbers m = new PC_Numbers();
		try {			
			m.handler();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
