package com.cognixia.progresstracker.entities;

import java.util.Objects;

public class Show {

    private int showid;
    private String showName;

    public Show(int showid, String showName) {
        this.showid = showid;
        this.showName = showName;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showid=" + showid +
                ", showName='" + showName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return showid == show.showid && Objects.equals(showName, show.showName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showid, showName);
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }
}
