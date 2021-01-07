package unsw.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import unsw.fruit.Apple;
import unsw.fruit.Fruit;
import unsw.fruit.Orange;

class ArrayListSetTest {

    @Test
    void testBasics() {
        Set<String> set = new ArrayListSet<>();
        set.add("Hello");
        set.add("World");
        assertTrue(set.contains("Hello"));
        assertTrue(set.contains("World"));

        set.remove("Hello");
        assertFalse(set.contains("Hello"));
        assertTrue(set.contains("World"));
    }

    @Test
    void testSubsetOf() {
        Set<Fruit> fruit = new ArrayListSet<>();
        fruit.add(new Apple("Gala"));
        fruit.add(new Apple("Fuji"));
        fruit.add(new Orange("Navel"));

        Set<Apple> apples = new ArrayListSet<>();
        apples.add(new Apple("Gala"));
        apples.add(new Apple("Fuji"));

        assertTrue(apples.subsetOf(fruit));
        assertFalse(fruit.subsetOf(apples));

        fruit.remove(new Apple("Fuji"));

        assertFalse(apples.subsetOf(fruit));
    }

    @Test
    void testIterator() {
        Set<Fruit> fruit = new ArrayListSet<>();
        fruit.add(new Apple("Gala"));
        fruit.add(new Apple("Fuji"));
        fruit.add(new Orange("Navel"));

        Iterator<Fruit> iterator = fruit.iterator();
        
        assertTrue(iterator.next().equals(new Apple("Gala")));
        assertTrue(iterator.next().equals(new Apple("Fuji")));
        assertTrue(iterator.next().equals(new Orange("Navel")));
    }

    @Test
    void testUnion() {
        Set<Fruit> fruit = new ArrayListSet<>();
        fruit.add(new Apple("Gala"));
        fruit.add(new Apple("Fuji"));
        fruit.add(new Orange("Navel"));

        Set<Fruit> fruit2 = new ArrayListSet<>();
        fruit2.add(new Apple("Gala"));
        fruit2.add(new Apple("Fuji2"));
        fruit2.add(new Orange("Navel2"));

        Set<Fruit> unionFruit = fruit.union(fruit2);
        assertTrue(fruit.subsetOf(unionFruit));
        assertTrue(fruit2.subsetOf(unionFruit));
        
        Iterator<Fruit> fruitIter = fruit.iterator();
        Iterator<Fruit> fruit2Iter = fruit2.iterator();

        while (fruitIter.hasNext()) {
            assertTrue(unionFruit.contains(fruitIter.next()));
        }

        while (fruit2Iter.hasNext()) {
            assertTrue(unionFruit.contains(fruit2Iter.next()));
        }
        
    }
    @Test
	void testIntersection() {
        Set<Fruit> fruit = new ArrayListSet<>();
        fruit.add(new Apple("Gala"));
        fruit.add(new Apple("Fuji"));
        fruit.add(new Orange("Navel"));

        Set<Fruit> fruit2 = new ArrayListSet<>();
        fruit2.add(new Apple("Gala"));
        fruit2.add(new Apple("Fuji2"));
        fruit2.add(new Orange("Navel2"));

        Set<Fruit> interFruit = fruit.intersection(fruit2);
        assertTrue(interFruit.contains(new Apple("Gala")));
        assertFalse(interFruit.contains(new Orange("Navel")));
    }

    @Test
	void testEquals() {
		Set<Fruit> fruit = new ArrayListSet<>();
		fruit.add(new Apple("Gala"));
		fruit.add(new Apple("Fuji"));

		Set<Apple> apples = new ArrayListSet<>();
		apples.add(new Apple("Gala"));
		apples.add(new Apple("Fuji"));

		assertTrue(apples.subsetOf(fruit));
		assertTrue(fruit.subsetOf(apples));
		assertTrue(fruit.equals(apples));
		assertTrue(apples.equals(fruit));
		fruit.add(new Orange("Mandarin"));
		assertFalse(fruit.equals(apples));
		assertFalse(apples.equals(fruit));
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		assertFalse(fruit.equals(numbers));
		Set<Fruit> onlyOranges = new ArrayListSet<>();
		onlyOranges.add(new Orange("Navel"));
		onlyOranges.add(new Orange("Navel1"));
		onlyOranges.add(new Orange("Navel2"));
		Set<Orange> oranges = new ArrayListSet<>();
		oranges.add(new Orange("Navel"));
		oranges.add(new Orange("Navel1"));
		oranges.add(new Orange("Navel2"));
		assertTrue(oranges.equals(onlyOranges));
		assertTrue(onlyOranges.equals(oranges));
		oranges.add(new Orange("Ree"));
		assertFalse(oranges.equals(onlyOranges));
		assertFalse(onlyOranges.equals(oranges));
	}
}
