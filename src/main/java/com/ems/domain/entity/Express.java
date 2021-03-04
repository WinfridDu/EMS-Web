package com.ems.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 快递信息构建
 *
 * @author dyf
 */
@Table(name="express")
public class Express implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 快递ID */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;

	/** 收件人电话 */
    @Column(name = "rec_tel")
	private String recTel;

	/** 收件人姓名 */
    @Column(name = "rec_name")
	private String recName;

	/** 发件人电话 */
    @Column(name = "send_tel")
	private String sendTel;

	/** 收件地址 */
    @Column(name = "address")
	private String address;

	/** 快递员id */
    @Column(name = "courier_tel")
	private String courierTel;

	/** 0未分配1已分配 */
    @Column(name = "status")
	private Boolean status;

	@Column(name = "courier_num")
	private String courierNum;

	@Column(name = "send_time")
	private Date sendTime;

	@Column(name = "qr_code")
	private String qrCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecTel() {
		return recTel;
	}

	public void setRecTel(String recTel) {
		this.recTel = recTel;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public String getSendTel() {
		return sendTel;
	}

	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourierTel() {
		return courierTel;
	}

	public void setCourierTel(String courierTel) {
		this.courierTel = courierTel;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
}
