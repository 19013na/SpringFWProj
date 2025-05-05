package mylab.customer.vo;

import java.util.Date;

public class CustomerVO {
	private int id;
	private String email;
	private String name;
	private int age;
	private Date entry_date;
	
	public CustomerVO() {
	}
	
	
	public CustomerVO(int id, String email, String name, int age, Date entry_date) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.entry_date = entry_date;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}
