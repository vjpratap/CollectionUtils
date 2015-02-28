import java.util.*;

class ListMapper{
	public int multiplyby5(int number){
		return number*5;
	}
}


public class CollectionUtils{
	public static List<Integer> map(List<Integer> list, ListMapper listMapper){
		List<Integer> result = new ArrayList<Integer>();
		for(Integer i : list){
			result.add(listMapper.multiplyby5(i));
		}
		return result;
	}
}