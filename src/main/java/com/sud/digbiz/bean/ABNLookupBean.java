/**
 * 
 */
package com.sud.digbiz.bean;

import java.io.Serializable;

/**
 * @author Sudhir_Korde
 *
 */
public class ABNLookupBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Abn = null;
	private String abnStatus = null;
	private String addressDate = null;
	private String addressPostCode = null;
	private String addressState = null;
	private String businessName = null;
	private String entityName = null;
	private String entityTypeCode = null;
	private String entityTypeName = null;
	private String exceptionMessage = null;
	private String acn = null;

	public ABNLookupBean() {

	}

	public String getAbnStatus() {
		return abnStatus;
	}

	public void setAbnStatus(String abnStatus) {
		this.abnStatus = abnStatus;
	}

	public String getAddressDate() {
		return addressDate;
	}

	public void setAddressDate(String addressDate) {
		this.addressDate = addressDate;
	}

	public String getAddressPostCode() {
		return addressPostCode;
	}

	public void setAddressPostCode(String addressPostCode) {
		this.addressPostCode = addressPostCode;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityTypeCode() {
		return entityTypeCode;
	}

	public void setEntityTypeCode(String entityTypeCode) {
		this.entityTypeCode = entityTypeCode;
	}

	public String getEntityTypeName() {
		return entityTypeName;
	}

	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getAcn() {
		return acn;
	}

	public void setAcn(String acn) {
		this.acn = acn;
	}

	public String getAbn() {
		return Abn;
	}

	public void setAbn(String abn) {
		Abn = abn;
	}

}
