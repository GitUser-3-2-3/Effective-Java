package item_18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

// inappropriate use of inheritance!
@SuppressWarnings("unused")
public class FaultyInstrumentedSet<E> extends HashSet<E> {

    // the number of attempted element insertions.
    private int addCount = 0;

    public FaultyInstrumentedSet() {
    }

    public FaultyInstrumentedSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        FaultyInstrumentedSet<String> set = new FaultyInstrumentedSet<>();
        set.addAll(List.of("snap", "cackle", "pop"));

        // returns the wrong result!
        System.out.println(set.getAddCount());
    }
}







