import java.util.*;

interface ListMapper<E,K>{
	public K mapper(E element);
}

interface ListFilter<E>{
	public boolean filter(E element);
}

class CollectionUtilsForInteger implements ListMapper<Integer,Integer>, ListFilter<Integer>{
	public Integer mapper(Integer element){
		return element*5;
	}

	public boolean filter(Integer element){
		return element > 5;
	}
}

class CollectionUtilsForFilterString implements ListFilter<String>{
	public boolean filter (String element){
		return element.length() == 5;
	}
}

class CollectionUtilsForString implements ListMapper<String,String>{
	public String mapper(String element){
		return element.toUpperCase();
	}
}

class CollectionUtilsForIntegerToString implements ListMapper<Integer, String>{
	public String mapper (Integer element){
		return "hello number " + element; 
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
}



