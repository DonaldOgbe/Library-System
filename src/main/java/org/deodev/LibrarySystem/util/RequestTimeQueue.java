package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RequestTimeQueue extends BaseQueue {
    private final Comparator<Member> memberComparator = Comparator
            .comparing(Member::getRequestTime);

    private PriorityQueue<Member> priorityQueue = new PriorityQueue<>(memberComparator
    );

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
