package java8;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains method processList.
 * This method splits the list into given number of sublists and add to thread.
 * Each thread process parallel.
 * Function Argument numberofthreads - number of threads to process.
 * Function Argument tempList - the base list of type Object.
 * Function Argument obj- Object from which this method is called,  Function Argument method 
 * 						  should be defined inside obj.
 * Function Argument method - Method in which business logic is written to process the list.
 * 
 * @author jithin
 * @see Demo.java
 * @version 1
 *
 */
public class ParallelProcessListElements {
	public void processList (int numberofthreads,List<Object>tempList, 
			Object obj, Method method){
		
				final int sizeofList=tempList.size();
				final int sizeofsublist = sizeofList/numberofthreads;
				List<Thread> threadlist = new ArrayList<Thread>();
				
				for(int i=0;i<numberofthreads;i++) {
					int firstindex = i*sizeofsublist;
					int lastindex = i*sizeofsublist+sizeofsublist;
					if(i==numberofthreads-1)
						lastindex=sizeofList;
					
					List<Object> subList=tempList.subList(firstindex,lastindex );
					
					Thread th = new Thread(()->{
								try{method.invoke(obj, subList);}catch(Exception e) {e.printStackTrace();}
							});
					
					threadlist.add(th);
				}
				
				threadlist.forEach(th->{th.start();try{Thread.sleep(10);}catch(Exception e) {}});
	}

}
