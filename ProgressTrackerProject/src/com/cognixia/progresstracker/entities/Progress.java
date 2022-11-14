package com.cognixia.progresstracker.entities;

public enum Progress {
	NOT_STARTED(1),
	IN_PROGRESS(2),
	COMPLETED(3);
	
	private int progressid;
	
	private Progress(int id) {
		this.progressid = id;
	}
	
	public int idValue() {
		return progressid;
	}
	
	public static Progress idName(int idCode) {
		switch(idCode) {
		case 1:
    		return Progress.NOT_STARTED;
    	case 2:
    		return Progress.IN_PROGRESS;
    	default:
    		return Progress.COMPLETED;
		}
	}
}
