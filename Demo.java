package java8;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		
		List<Object> tempList= new ArrayList<Object>();
		/**
		 * Adding values to list... For Demo purpose..
		 */
		for(int i=0;i<500;i++)
			tempList.add(i);
		
		ParallelProcessListElements process = new ParallelProcessListElements();
		final int numberofthreads = 5;
		Object obj = new Demo();
		Method method=null;
		
		try{ method=Demo.class.getMethod("printList", List.class);}catch(Exception e) {}
		/**
		 * Method Call...
		 */
		process.processList(numberofthreads,tempList,obj,method);
	}
	
	public void printList(List<Integer>list) {
		/**
		 * Business logic to process the list...
		 */
		list.forEach(item->{
			try{Thread.sleep(1000);}catch(Exception e) {}
			System.out.println(item);
			});
	}
}
