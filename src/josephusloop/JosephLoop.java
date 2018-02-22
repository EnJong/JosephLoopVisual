package josephusloop;

import java.util.ArrayList;
import java.util.List;

public class JosephLoop {
	int result;
	int totalNumber;
	int intervalNumber = 2;

	public JosephLoop(int inputNumber1, int inputNumber2) {
		super();
		this.totalNumber = inputNumber1;
		this.intervalNumber = inputNumber2;
	}
	public int yuesefu(int n,int m){
        if(n == 1){
        	return 0; //这里返回下标,从0开始，只有一个元素就是剩余的元素0
        }
        else{
        	return (yuesefu(n-1,m) + m) % n; //我们传入的n是总共多少个数
        }
	}
	public int josephLoop() {
		for (int i = 2; i <= totalNumber; i++) {
	        result = (result + intervalNumber) % i;
		}
		return result;
	}

	public int[] joseph(int totalNum, int countNum) {  
		 // 初始化人数  
		 List<Integer> start = new ArrayList<Integer>();  
		 int [] result = new int [totalNum];
		 for (int i = 1; i <= totalNum; i++) {  
			 start.add(i);  
		 } 
		 //从第K个开始计数  
		 int k = 0;  
		 for (int i =0; start.size() > 0; i++) {  
		     k = k + countNum;  
		     //第m人的索引位置  
		     k = k % (start.size()) - 1;  
		     // 判断是否到队尾  
		     if (k < 0) {  
		    	 result[i] = start.get(start.size()-1);
//		         System.out.println("最后一个：" + start.get(start.size()-1));  
		    	 start.remove(start.size() - 1);  
		    	 k = 0;  
	         } else {  
	        	 result[i] = start.get(k);
//	              System.out.println(start.get(k));  
	             start.remove(k);  
	         } 
		  }
//		  for(int i:result) {
//			  System.out.print(i);
//		  }
		  return result;
	 }  
	
	 public static void main(String[] args){
		JosephLoop josephLoopTest = new JosephLoop(40,3);
		josephLoopTest.joseph(4, 2);
	}
}
