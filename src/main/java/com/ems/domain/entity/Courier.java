package com.ems.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 快递员信息构建
 *
 * @author dyf
 */
@Table(name="courier")
public class Courier implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 快递员ID */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;

	/** 快递员姓名 */
    @Column(name = "name")
	private String name;

	/** 手机号码 */
    @Column(name = "tel")
	private String tel;

	/** 密码 */
    @Column(name = "password")
	private String password;

	/** 派送区 */
    @Column(name = "region")
	private String region;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
