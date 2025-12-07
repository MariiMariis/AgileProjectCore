package com.agile.domain.vo;

import java.util.Objects;

public final class StoryPoint {

    private final int value;

    public StoryPoint(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Story Points não podem ser negativos.");
        }
        if (value > 100) {
            throw new IllegalArgumentException("Story Points excessivos. Quebre a tarefa.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public StoryPoint add(StoryPoint other) {
        return new StoryPoint(this.value + other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoryPoint that = (StoryPoint) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}