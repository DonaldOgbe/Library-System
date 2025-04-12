package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HierarchyQueue extends BaseQueue {

    public HierarchyQueue() {
        super(Comparator
                .comparing((Member m) -> m.getRole().getPriority())
                .thenComparing((Member::getRequestTime)));
    }

    @Override
    public void addToQueue(Member member) {
        priorityQueue.add(member);
    }

    @Override
    public Member peekNext() {
        return priorityQueue.peek();
    }

    @Override
    public Member getHighestInQueue() {
        return priorityQueue.poll();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}
