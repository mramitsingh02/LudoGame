package com.ludo.entities;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Participants implements Collection<Participant> {

    private final List<Participant> participantQueue;
    private final int capacity;
    private int currentParticipantsIndex;

    public Participants(int capacity) {
        this.capacity = capacity;
        this.participantQueue = new ArrayList<>(this.capacity);
        this.currentParticipantsIndex = 0;
    }
    @Override
    public int size() {
        return participantQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return participantQueue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        Participant participant = (Participant) o;
        return participantQueue.contains(participant);
    }

    @Override
    public Iterator iterator() {
        return participantQueue.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }



    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Remove operation not supported.");
    }

    @Override
    public boolean addAll(Collection c) {
        return participantQueue.addAll(c);
    }

    @Override
    public void clear() {
        participantQueue.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Remove operation not supported.");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Remove operation not supported.");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Remove operation not supported.");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Remove operation not supported.");
    }

    public Optional<Participant> nextParticipant() {
        if(isEmpty())
        {
            return Optional.empty();
        }

        int index = currentParticipantsIndex % size() ;
        currentParticipantsIndex ++;
        return Optional.of(participantQueue.get(index));
    }
    @Override
    public void forEach(Consumer<? super Participant> action) {
        Collection.super.forEach(action);
    }



    @Override
    public boolean add(Participant participant) {
        participant.setId(this.size());
        return participantQueue.add(participant);
    }


    @Override
    public boolean removeIf(Predicate<? super Participant> filter) {
        return Collection.super.removeIf(filter);
    }



    @Override
    public Spliterator<Participant> spliterator() {
        return Collection.super.spliterator();
    }

    @Override
    public Stream<Participant> stream() {
        return Collection.super.stream();
    }

    @Override
    public Stream<Participant> parallelStream() {
        return Collection.super.parallelStream();
    }
}
