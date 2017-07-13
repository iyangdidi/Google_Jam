package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.math.*;;

public class PC_Numbers {
	public void handler() throws IOException {
		Scanner sc = new Scanner(new BufferedReader(
				new FileReader("C:\\Users\\iyang\\Desktop\\Google\\PC_Numbers\\C-small-practice.in")));
		FileWriter out = new FileWriter("C:\\Users\\iyang\\Desktop\\Google\\PC_Numbers\\C-small-practice.out");

		BigDecimal t = new BigDecimal(5);
		BigDecimal tt = sqrt(t).add(new BigDecimal(3));

		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			BigDecimal res = tt.pow(n);
			out.write("Case #" + i + ": " + get3bit(res) + "\n");
		}

		sc.close();
		out.flush();
		out.close();
	}

	public String get3bit(BigDecimal num) {
		String t = num.toString();
		int tt = t.indexOf('.');
		// String[] tt = t.split(".");
		System.out.println(tt);
		String res = "";
		if (tt - 0 == 1) {
			res = res + "00" + t.substring(0, tt);
		}
		if (tt - 0 == 2) {
			res = res + "0" + t.substring(0, tt);
		} else {
			res = t.substring(tt - 3, tt);
		}
		return res;
	}

	// 大数开方
	public static BigDecimal sqrt(BigDecimal num) {
		if (num.compareTo(BigDecimal.ZERO) < 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
		BigDecimal ttt=x;
		while (x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0) {
			BigDecimal t = sqrtIteration(ttt, num);
			t = t.abs();
			int tt = t.compareTo(new BigDecimal("0.0000000000000000000001"));
			ttt = x;
		}
			
		return x;
	}

	private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
		BigDecimal t = x.add(n.divide(x, MathContext.DECIMAL128));
		t = t.divide(new BigDecimal("2"), MathContext.DECIMAL128);
		return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
	}

	public static void main(String[] args) {
		PC_Numbers m = new PC_Numbers();
		try {
			m.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
