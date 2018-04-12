package ru.itis;

public class Main {

    public static void main(String[] args) {
	    HashMap<String, Integer> map = new HashMap<>();
	    map.put("Marsel", 24);
	    map.put("Almaz", 19);
	    map.put("Marsel", 20);
	    map.put("Richard", 13);
		System.out.println(map.get("Marsel"));
	}
}
