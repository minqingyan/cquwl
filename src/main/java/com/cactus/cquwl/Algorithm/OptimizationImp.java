package com.cactus.cquwl.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cactus.cquwl.pojo.CarSource;

public class OptimizationImp implements IOptimization{
	
	// 定义一个全局变量
	private static List<Set<Integer>> groups = new ArrayList<>();
	// 求最优组合
	// 步骤如下
	// 1. 先求出每个车辆能装目标货物多少件 count  
	// 2. 形成一个数组，并排好序, 从大到小的排序   , 其中 用Map 进行存储<count, List<CarSource>> , count 是箱子个数
	// 3. 根据给定的算法求出所有组合方式   , 根据count 求出CarSource ，当一个count对应的是多个CarSource的时候，默认是取第一个
	// 4. 将三种的结果List<List<CarSource>>的方式输出=；
	
	@Override
	public List<List<CarSource>> getOptimizationGroup(Map<Integer, List<CarSource>> maps, int target) {
		// TODO Auto-generated method stub
		// 先提炼出Integer
		// 然后在计算组合
		// 组合的存储方式用
		
		int[] a = new int[maps.size()];
		Set keySet = maps.keySet();
		int i = 0;
		for(Object keyName : keySet){
			a[i] = (int) keyName;
			i++;
		}
		Arrays.sort(a);
		print(a, a.length-1, target);
		//　得出所有组合方式
		// 开始调整输出方式
		List<List<CarSource>> list = new ArrayList<>();
		List<CarSource> cars = null;
		for(Set set : groups){
			cars = new ArrayList<>();
			Iterator it = set.iterator();
			while(it.hasNext()){
				cars.add(maps.get(it.next()).get(0));
			}
			list.add(cars);
		}
		return list;
	}
	
	public static void print(int[] a,int s, int target){
		
		int index[] = new int[6];
		int now = 0;
		boolean flag = false;
		for(int i = s; i >= 0; i--){
			if(now+a[i] > target)
				continue;
				
			if(!flag) {
				s = i;
				flag = true;
			}
			now += a[i];
			++index[i];
			
			if(now == target) {
				// 取出对应的 a 的Integer存储下来
				Set<Integer> set = new HashSet<Integer>();
				for(int l = 0; l < 6; l++){
					System.out.print(index[l]+",");
					if(index[l] == 1)
						set.add(a[l]);
				}
				groups.add(set);
				System.out.println();
				if(s == 0)
					break;
				else
					print(a,s-1,target);
			}
		}
	}
}
