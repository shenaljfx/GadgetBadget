package model;

public class Req {
	int reqId;
	int resId;
	String reqType;
	String reqNote;
	
	public Req() {
		
		}
	
	public Req(int reqId, int resId, String reqType, String reqNote) {
		this.reqId = reqId;
		this.resId = resId;
		this.reqType = reqType;
		this.reqNote = reqNote;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	
	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqNote() {
		return reqNote;
	}

	public void setReqNote(String reqNote) {
		this.reqNote = reqNote;
	}
	
}
