package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "job_id")
	private String jobId;

	@Column(name = "e_salary")
	private int eSalary;

	@Column(name = "hire_date")
	private Date hireDate;

	@Column(name = "dept_id")
	private String deptId;

	@Column(name = "phn_num")
	private String phnNum;

	@Column(name = "add_info")
	private String addInfo;

	public Employee() {
	}
	public Employee(String firstName, String lastName, String emailId, String jobId,int eSalary, Date hireDate, String deptId, String phnNum, String addInfo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.jobId = jobId;
		this.eSalary = eSalary;
		this.hireDate = hireDate;
		this.deptId = deptId;
		this.phnNum = phnNum;
		this.addInfo = addInfo;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {this.jobId = jobId; }

	public int getESalary() {return eSalary; }
	public void setESalary(int eSalary) {this.eSalary = eSalary; }

	public Date getHireDate(){ return hireDate; }
	public void setHireDate(Date hireDate){this.hireDate=hireDate; }

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {this.deptId = deptId; }

	public String getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(String phnNum) {this.phnNum = phnNum; }

	public String getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(String addInfo) {this.addInfo = addInfo; }

}
