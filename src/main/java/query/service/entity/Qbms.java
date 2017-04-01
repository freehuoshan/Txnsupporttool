package query.service.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Qbms implements Serializable{

	private Boolean loadArchiveTable;
	private String mLinkResponseCode;
	private Date mLinkReceivedDate;
	private Timestamp nrtConformedDate;
	
	public Qbms(Boolean loadArchiveTable, String mLinkResponseCode, Date mLinkReceivedDate,
			Timestamp nrtConformedDate) {
		super();
		this.loadArchiveTable = loadArchiveTable;
		this.mLinkResponseCode = mLinkResponseCode;
		this.mLinkReceivedDate = mLinkReceivedDate;
		this.nrtConformedDate = nrtConformedDate;
	}

	public Boolean getLoadArchiveTable() {
		return loadArchiveTable;
	}

	public void setLoadArchiveTable(Boolean loadArchiveTable) {
		this.loadArchiveTable = loadArchiveTable;
	}

	public String getmLinkResponseCode() {
		return mLinkResponseCode;
	}

	public void setmLinkResponseCode(String mLinkResponseCode) {
		this.mLinkResponseCode = mLinkResponseCode;
	}

	public Date getmLinkReceivedDate() {
		return mLinkReceivedDate;
	}

	public void setmLinkReceivedDate(Date mLinkReceivedDate) {
		this.mLinkReceivedDate = mLinkReceivedDate;
	}

	public Timestamp getNrtConformedDate() {
		return nrtConformedDate;
	}

	public void setNrtConformedDate(Timestamp nrtConformedDate) {
		this.nrtConformedDate = nrtConformedDate;
	}

	@Override
	public String toString() {
		return "Qbms [loadArchiveTable=" + loadArchiveTable + ", mLinkResponseCode=" + mLinkResponseCode
				+ ", mLinkReceivedDate=" + mLinkReceivedDate + ", nrtConformedDate=" + nrtConformedDate + "]";
	}
	
	
	
}
