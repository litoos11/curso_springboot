package com.litoos11.oracle.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	//@Temporal(value= TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "detail")
	private String detail;

	@Column(name = "username")
	private String username;

	@Column(name = "url")
	private String url;

	
	public Log(Date fecha, String detail, String username, String url) {
		super();
		this.fecha = fecha;
		this.detail = detail;
		this.username = username;
		this.url = url;
	}

	public Log() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
