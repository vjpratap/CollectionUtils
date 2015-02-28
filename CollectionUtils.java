import java.util.*;

interface ListMapper<E,K>{
	public K mapper(E element);
}

interface ListFilter<E>{
	public boolean filter(E element);
}

interface ListReducer<E,K>{
	public K reduce(K previous, E current);
}



class CollectionUtilsForInteger implements ListMapper<Integer,Integer>, ListFilter<Integer>, ListReducer<Integer, Integer>{
	public Integer mapper(Integer element){
		return element*5;
	}

	public boolean filter(Integer element){
		return element > 5;
	}

	public Integer reduce(Integer previous, Integer current){
		return previous + current;
	}
}

class CollectionUtilsForString implements ListMapper<String,String>, ListFilter<String>, ListReducer<String, String>{
	public String mapper(String element){
		return element.toUpperCase();
	}

	public boolean filter (String element){
		return element.length() == 5;
	}

	public String reduce (String previous, String current){
		return previous + current + " ";
	}
}

class CollectionUtilsForIntegerToString implements ListMapper<Integer, String>, ListReducer<Integer, String>{
	public String mapper (Integer element){
		return "hello number " + element; 
	}

	public String reduce (String previous, Integer current){
		return previous + current;
	}
}

public class CollectionUtils{
	public static<E,K> List<K> map(List<E> list, ListMapper<E,K> listMapper){
		List<K> result = new ArrayList<K>();
		for(E element: list){
			result.add(listMapper.mapper(element));
		}
		return result;
	}

	public static<E> List<E> filter(List<E> list, ListFilter<E> listFilter){
		List<E> result = new ArrayList<E>();
		for(E element: list){
			if(listFilter.filter(element))
				result.add(element);
		}
		return result;
	}

	public static<E,K> K reduce(List<E> list, ListReducer<E,K> listReduce, K previous){
		List<E> result = new ArrayList<E>();
		// previous = list.get(0);
		for (E current : list) {
			previous = listReduce.reduce(previous, current);
		}
		return previous;
	}
}



