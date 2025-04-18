package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;
import org.deodev.LibrarySystem.validation.CollectionValidator;
import org.deodev.LibrarySystem.validation.InputValidator;
import java.util.Comparator;

public class HierarchyQueue extends BaseQueue {

    public HierarchyQueue() {
        super(Comparator
                .comparing((Member m) -> m.getRole().getPriority())
                .thenComparing((Member::getRequestTime)));
    }

    @Override
    public void addToQueue(Member member) {
        InputValidator.validateNotNull(member);
        priorityQueue.add(member);
    }

    @Override
    public Member peekNext() {
        CollectionValidator.validateQueueNotEmpty(priorityQueue);
        return priorityQueue.peek();
    }

    @Override
    public Member getHighestInQueue() {
        CollectionValidator.validateQueueNotEmpty(priorityQueue);
        return priorityQueue.poll();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}
