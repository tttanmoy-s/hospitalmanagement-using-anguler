package com.example.hospital.model;

//import com.example.hospital.model.String;
import com.example.hospital.model.doctor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name="patient")

public class patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid;
	@Column(name ="pname")
	private String Pname;
	@Column(name ="page")
	private int page;
	@Column(name ="pgender")
	private String pgender;
	@Column(name ="dateofvisit")
	private String dateofvisit;

	@ManyToOne
	private doctor doctorid ;

	public patient() {
		super();
	}

	public patient(String pname, int page, String pgender, String dateOfVisit, doctor doctorid) {
		super();
		Pname = pname;
		this.page = page;
		this.pgender = pgender;
		this.dateofvisit = dateOfVisit;
		this.doctorid = doctorid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public String getDateOfVisit() {
		return dateofvisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateofvisit = dateOfVisit;
	}

	public doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(doctor doctorid) {
		this.doctorid = doctorid;
	}

}
