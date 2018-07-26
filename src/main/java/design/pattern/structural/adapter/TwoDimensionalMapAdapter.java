package design.pattern.structural.adapter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** * Implementation of Adapter pattern in Java. The java.util.Map has no way to 
 * * automatically load a two dimensional array of objects into a Map as key-value 
 * * pairs. This Java program creates an adapter class that does this. 
 * */
public class TwoDimensionalMapAdapter {

    public static void main(String[] args) {
        Integer[][] squares = { { 2, 4 }, { 3, 9 }, { 4, 16 } };
        MapAdapter adapter = new MapAdapter(squares);
        System.out.println("adapter map contains : " + adapter);

    }

}

/* * This class is an adapter which allows to create a Map by providing a two 
 * * dimensional array of keys and values. It extends AbstractMap class so that it 
 * * become a Map and can be passed around where a Map is needed. All other method 
 * * is implemented in AbstractMap except the adapter functionality which is 
 * * implemented in constructor of this class. 
 */
class MapAdapter extends AbstractMap {
    private Map map;

    public MapAdapter(Object[][] array) {
        super();
        map = new HashMap();
        for (Object[] mapping : array) {
            map.put(mapping[0], mapping[1]);
        }
    }

    @Override
    public Set entrySet() {
        return map.entrySet();
    }
}
