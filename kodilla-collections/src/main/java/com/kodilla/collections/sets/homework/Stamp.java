package com.kodilla.collections.sets.homework;

import java.util.Objects;

public class Stamp {
    private String stampName;
    private int stampWidth;
    private int stampHeight;
    private boolean isStamped;

    public Stamp(String stampName, int stampWidth, int stampHeight, boolean isStamped) {
        this.stampName = stampName;
        this.stampWidth = stampWidth;
        this.stampHeight = stampHeight;
        this.isStamped = isStamped;
    }

    public String getStampName() {
        return stampName;
    }

    public int getStampWidth() {
        return stampWidth;
    }

    public int getStampHeight() {
        return stampHeight;
    }

    public boolean isStamped() {
        return isStamped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return stampWidth == stamp.stampWidth && stampHeight == stamp.stampHeight && isStamped == stamp.isStamped && Objects.equals(stampName, stamp.stampName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stampName, stampWidth, stampHeight, isStamped);
    }

    @Override
    public String toString() {
        return "Stamp{" +
                "stampName='" + stampName + '\'' +
                ", stampWidth=" + stampWidth +
                ", stampHeight=" + stampHeight +
                ", isStamped=" + isStamped +
                '}';
    }
}
