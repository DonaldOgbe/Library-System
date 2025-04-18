package org.deodev.LibrarySystem.util;

import org.deodev.LibrarySystem.model.Member;
import org.deodev.LibrarySystem.validation.CollectionValidator;
import org.deodev.LibrarySystem.validation.InputValidator;
import java.util.Comparator;

public class RequestTimeQueue extends BaseQueue {
    public RequestTimeQueue() {
        super(Comparator
                .comparing(Member::getRequestTime));
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
