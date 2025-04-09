package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HierarchyQueue {
    private Comparator<Member> memberComparator = Comparator
            .comparing((Member m) -> m.getRole().getPriority())
            .thenComparing((Member::getRequestTime));

    private PriorityQueue<Member> priorityQueue = new PriorityQueue<>(memberComparator
    );

    public void addToQueue(Member member) {
        priorityQueue.add(member);
    }

    public Member peekNext() {
        return priorityQueue.peek();
    }
}
