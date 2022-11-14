package com.cognixia.progresstracker.entities;

import java.util.Objects;

public class Watchlist {

    private int watchlistid;
    private int userid;
    private int showid;
    private Progress progressid;

    public Watchlist() {

    }

    public Watchlist(int watchlistid, int userid, int showid, int progressid) {
        this.watchlistid = watchlistid;
        this.userid = userid;
        this.showid = showid;
        switch(progressid) {
        case 1:
        	this.progressid = Progress.NOT_STARTED;
        	break;
        case 2:
        	this.progressid = Progress.IN_PROGRESS;
        	break;
        case 3:
        	this.progressid = Progress.COMPLETED;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watchlist watchlist = (Watchlist) o;
        return watchlistid == watchlist.watchlistid && userid == watchlist.userid && showid == watchlist.showid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchlistid, userid, showid);
    }

    public int getWatchlistid() {
        return watchlistid;
    }

    public void setWatchlistid(int watchlistid) {
        this.watchlistid = watchlistid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public Progress getProgressid() {
        return progressid;
    }
    
    public int getProgressAsInt() {
    	return this.progressid.idValue();
    }

    public void setProgressid(Progress progressid) {
        this.progressid = progressid;
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "watchlistid=" + watchlistid +
                ", userid=" + userid +
                ", showid=" + showid +
                ", progressid=" + progressid.idValue() + 
                '}';
    }
}
