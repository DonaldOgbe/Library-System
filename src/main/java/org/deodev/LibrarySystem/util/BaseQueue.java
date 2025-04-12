package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;

import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class BaseQueue {
    protected PriorityQueue<Member> priorityQueue;

    public BaseQueue(Comparator<Member> comparator) {
        this.priorityQueue = new PriorityQueue<>(comparator);
    }

    public abstract void addToQueue(Member member);

    public abstract Member peekNext();

    public abstract Member getHighestInQueue();

    public abstract int size();
}
