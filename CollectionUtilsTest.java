import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionUtilsTest{

	@Test
	public void test_that_function_map_works_as_map_for_int(){
		List<Integer> list = new ArrayList<Integer>();
		ListMapper<Integer> listMapper = new CollectionUtilsForInteger();
		for (int i = 0;i < 5;i++) {
			list.add(i);
		}
		List<Integer> increaseBy5 = CollectionUtils.map(list, listMapper);
		assertEquals((Integer)0,increaseBy5.get(0));
		assertEquals((Integer)5,increaseBy5.get(1));
		assertEquals((Integer)10,increaseBy5.get(2));
		assertEquals((Integer)20,increaseBy5.get(4));
		assertEquals(5, increaseBy5.size());
	}

	@Test 
	public void test_that_function_map_works_as_map_for_string(){
		List<String> list = new ArrayList<String>();
		ListMapper<String> listMapper = new CollectionUtilsForString();
		list.add("vijay");
		list.add("pratap");
		list.add("singh");
		List<String> convertToupperCase = CollectionUtils.map(list, listMapper);
		assertEquals("VIJAY", convertToupperCase.get(0));
		assertEquals("PRATAP",convertToupperCase.get(1));
		assertEquals("SINGH",convertToupperCase.get(2));
		assertEquals(3, convertToupperCase.size());
	}

	@Test
	public void test_that_function_filter_works_for_integer(){
		List<Integer> list = new ArrayList<Integer>();
		ListFilter listFilter = new CollectionUtilsForInteger();
		list.add(6);
		list.add(9);
		list.add(0);
		list.add(5);
		List<Integer> filteredList = CollectionUtils.filter(list,listFilter);
		assertEquals((Integer)6,filteredList.get(0));
		assertEquals((Integer)9,filteredList.get(1));
		assertEquals(2,filteredList.size());
	}
}