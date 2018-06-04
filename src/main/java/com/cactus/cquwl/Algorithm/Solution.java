package com.cactus.cquwl.Algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	/*
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while(sin.hasNext()) {
			int size = sin.nextInt();
			int weight = sin.nextInt();
			int[] w = new int[size];
			int[] nums = new int[size];
			for(int i=0; i<size; i++) {
				w[i] = sin.nextInt();
			}
			for(int i=0; i<size; i++) {
				nums[i] = sin.nextInt();
			}
			
			Solution fama = new Solution (w, nums, weight);
			fama.resovle();
			Stack<int[]> rets = fama.getResult();
			while(!rets.isEmpty()) {
				System.out.print(Arrays.toString(rets.pop()));
			}
		}
		sin.close();
	}
	*/
	private int[] weights;
	private int[] nums;
	private int w;   // 目标货物重量
	private Stack<int[]> rets;
	private int minw;  // 记录最小最近的值
	
	public Solution(int[] weights, int[] nums, int w) {
		assert weights!=null && nums!=null && weights.length == nums.length && w >= 0;
		
		this.nums = Arrays.copyOf(nums, nums.length);
		this.weights = Arrays.copyOf(weights, weights.length);
		this.w = w;
		
		minw = Integer.MAX_VALUE;
		rets = new Stack<int[]>();
	}
	
	public boolean resovle() {
		int[] ans = new int[this.weights.length];
		int[] nans = new int[this.weights.length];
		Arrays.fill(ans, 0);
		Arrays.fill(nans, 0);
		
		if(!find(this.w, 0, ans, nans)){
			rets.push(nans);
			return false;
		}
		return true;
	}
	
	public Stack<int[]> getResult() {
		return rets;
	}
	
	
	private boolean find(int weight, int depth, int[] ans, int[] nans) {
		if(weight==0) {
			rets.push(Arrays.copyOf(ans, ans.length));
			return true;
		}
		
		if(weight<0 || depth >= ans.length) {
			if(Math.abs(weight) < minw && weight < 0) {
				for(int i=0; i<ans.length; i++) nans[i]=ans[i];
				minw = weight;
			}
			return false;
		}
		
		boolean flag = false;
		for(int i=0; i<=nums[depth]; i++) {
			ans[depth] = i;
			if(find(weight-weights[depth]*i, depth+1, ans, nans)) flag=true;
		}
		ans[depth] = 0;

		return flag;
	}
}

