package lists3;

import lists3.Iterators.Iterator;


public class Operations {
	
	public static LinkedList insertIntoListBeforeIndex(int beforeIndex, LinkedList fromList, LinkedList toList) {
		LinkedList temp = new LinkedList();
		Iterator it = toList.iterator();
		int index = 0;
		
		for(it.first(); index < beforeIndex; it.next(), index++){
			temp.add(it.current());
		}
		Iterator it2 = fromList.iterator();
		for(it2.first(); !it2.isDone(); it2.next()){
			temp.add(it2.current());
		}
		for( ; index < toList.size(); index++){
			temp.add(toList.get(index));
		}
		return temp;
	}
	
	
	public static LinkedList insertIntoListBeforeValue(Object beforeValue, LinkedList fromList, LinkedList toList) {
		LinkedList temp = new LinkedList();
		if(beforeValue instanceof String){
			Iterator it = toList.iterator();
			int index = 0;
			
			String val = (String) beforeValue;
			for(it.first(); !val.equals((String)it.current()); it.next(), index++){
				temp.add(it.current());
			}
			
			Iterator it2 = fromList.iterator();
			for(it2.first(); !it2.isDone(); it2.next()){
				temp.add(it2.current());
			}
			for( ; index < toList.size(); index++){
				temp.add(toList.get(index));
			}
		}
		return temp;
	}

	
	public static LinkedList concatLists(LinkedList fromList, LinkedList toList) {
		return insertIntoListBeforeIndex(toList.size(), fromList, toList);
	}
}
