package ru.mti.edu.collection;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionRunner {

	public static void main(String[] args) {
//		List<Integer> integerList = new ArrayList<Integer>(2);
		List<Integer> integerList = new LinkedList<Integer>();
		
//		((List) integerList).add("ыеко");
		integerList.add(100);
		integerList.add(200);
		integerList.add(300);
		
		for (Integer i : integerList){
			System.out.println(i);
		}
		
		System.out.println("Maximun : " +  integerList.stream().max(
				(a, b) -> { return a-b; }
		).get());
		
		System.out.println("---");
//		Iterator<Integer> iter = integerList.iterator();
//		while(iter.hasNext()) {
		for (Iterator<Integer> iter = integerList.iterator(); iter.hasNext();) {
			Integer i = iter.next();
			System.out.println(i);
			if (i > 100) {
				iter.remove();
			}
		}
		
		System.out.println("" + integerList);
		Object o = 100 + "";
		System.out.println(integerList.contains(o));
		
		System.out.println("---");
		Set<String> color = new HashSet<>();
		color.add("red");
		color.add("yellow");
		color.add("green");
		color.add("green");
		color.add(null);
		System.out.println(color);
		
		Map<Integer, String> phoneDictionary = new LinkedHashMap<>();
		phoneDictionary.put(945, "Moscow");
		phoneDictionary.put(846, "Samara");
		phoneDictionary.put(812, "Saint-Petersburg");
		phoneDictionary.put(null, "Kazan");
		phoneDictionary.put(123, null);
		phoneDictionary.put(234, null);
		phoneDictionary.put(234, "Ekaterinburg");
		
		System.out.println("---");
		int key = 123;
		String city = phoneDictionary.get(key);
//		if (city != null) {
		if (phoneDictionary.containsKey(key)) {
			System.out.println(city);
		}
		
		for (Entry<Integer, String> entry : phoneDictionary.entrySet()) {
			System.out.println(MessageFormat.format("Key : {0}, value : {1}", entry.getKey(), entry.getValue()));
		}
	}
}
