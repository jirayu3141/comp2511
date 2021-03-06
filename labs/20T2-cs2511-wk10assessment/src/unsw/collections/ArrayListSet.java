/**
 *
 */
package unsw.collections;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of Set that uses an ArrayList to store the elements.
 *
 * @invariant All e in elements occur only once
 *
 * @author Jirayu Sirivorawong
 *
 */
public class ArrayListSet<E> implements Set<E> {

    private ArrayList<E> elements;

    public ArrayListSet() {
        elements = new ArrayList<>();
    }

    @Override
    public void add(E e) {
        if(!elements.contains(e)) {
            elements.add(e);
        }
    }

    @Override
    public void remove(E e) {
        elements.remove(e);
    }

    @Override
    public boolean contains(Object e) {
        return elements.contains(e);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean subsetOf(Set<?> other) {
        for (E x: elements) {
            if(!other.contains(x)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return this.elements.iterator();
    }

    @Override
    public Set<E> union(Set<? extends E> other) {
        ArrayListSet<E> union = new ArrayListSet<>();
		for (E e : this.elements) {
			union.add(e);
		}
		for (E e : other) {
			if (!union.contains(e)) {
				union.add(e);
			}
		}
		return union;
    }

    @Override
    public Set<E> intersection(Set<? extends E> other) {
        ArrayListSet<E> intersect = new ArrayListSet<>();
		for (E e : this.elements) {
			if (other.contains(e)) {
				intersect.add(e);
			}
		}
		return intersect;
    }

    /**
     * For this method, it should be possible to compare all other possible sets
     * for equality with this set. For example, if an ArrayListSet<Fruit> and a
     * LinkedListSet<Fruit> both contain the same elements they are equal.
     * Similarly, if a Set<Apple> contains the same elements as a Set<Fruit>
     * they are also equal.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Set) {
			if (((Set<?>) other).size() != this.elements.size()) {
				return false;
			}
			for (E e : this.elements) {
				if (!((Set<?>) other).contains(e)) {
					return false;
				}
			}
			return true;
		}
		return false;
    }

}
