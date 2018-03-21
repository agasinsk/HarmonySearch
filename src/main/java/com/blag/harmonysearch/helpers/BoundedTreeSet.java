package com.blag.harmonysearch.helpers;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class BoundedTreeSet<E> extends TreeSet<E> {

    private final int capacity;

    public BoundedTreeSet(final int capacity) {
        super();
        this.capacity = capacity;
    }

    public BoundedTreeSet(final int capacity, final Collection<? extends E> c) {
        super(c);
        this.capacity = capacity;
    }

    public BoundedTreeSet(final int capacity, final Comparator<? super E> comparator) {
        super(comparator);
        this.capacity = capacity;
    }

    public BoundedTreeSet(final int capacity, final SortedSet<E> s) {
        super(s);
        this.capacity = capacity;
    }

    @Override
    public boolean add(final E e) {
        if (size() >= capacity) {
            return false;
        }

        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (size() + c.size() >= capacity) {
            return false;
        }

        return super.addAll(c);
    }
}