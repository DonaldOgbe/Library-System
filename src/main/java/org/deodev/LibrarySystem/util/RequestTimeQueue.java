package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RequestTimeQueue extends BaseQueue {
    public RequestTimeQueue() {
        super(Comparator
                .comparing(Member::getRequestTime));
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
