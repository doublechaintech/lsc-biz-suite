package com.doublechaintech.lsc;


import com.doublechaintech.lsc.platform.PlatformManager;

import com.doublechaintech.lsc.transactiontype.TransactionTypeManager;

import com.doublechaintech.lsc.merchanttype.MerchantTypeManager;

import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusManager;

import com.doublechaintech.lsc.location.LocationManager;

import com.doublechaintech.lsc.merchant.MerchantManager;

import com.doublechaintech.lsc.transportproject.TransportProjectManager;

import com.doublechaintech.lsc.transportitem.TransportItemManager;

import com.doublechaintech.lsc.transporttask.TransportTaskManager;

import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrackManager;

import com.doublechaintech.lsc.merchantaccount.MerchantAccountManager;

import com.doublechaintech.lsc.transaction.TransactionManager;

import com.doublechaintech.lsc.userdomain.UserDomainManager;

import com.doublechaintech.lsc.userwhitelist.UserWhiteListManager;

import com.doublechaintech.lsc.secuser.SecUserManager;

import com.doublechaintech.lsc.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.lsc.userapp.UserAppManager;

import com.doublechaintech.lsc.listaccess.ListAccessManager;

import com.doublechaintech.lsc.objectaccess.ObjectAccessManager;

import com.doublechaintech.lsc.loginhistory.LoginHistoryManager;

import com.doublechaintech.lsc.genericform.GenericFormManager;

import com.doublechaintech.lsc.formmessage.FormMessageManager;

import com.doublechaintech.lsc.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.lsc.formfield.FormFieldManager;

import com.doublechaintech.lsc.formaction.FormActionManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected TransactionTypeManager transactionTypeManager;

	protected MerchantTypeManager merchantTypeManager;

	protected TransportTaskStatusManager transportTaskStatusManager;

	protected LocationManager locationManager;

	protected MerchantManager merchantManager;

	protected TransportProjectManager transportProjectManager;

	protected TransportItemManager transportItemManager;

	protected TransportTaskManager transportTaskManager;

	protected TransportTaskTrackManager transportTaskTrackManager;

	protected MerchantAccountManager merchantAccountManager;

	protected TransactionManager transactionManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public TransactionTypeManager getTransactionTypeManager(){
		return this.transactionTypeManager;
	}
	public void setTransactionTypeManager(TransactionTypeManager manager){
		this.transactionTypeManager = manager;
	}


	public MerchantTypeManager getMerchantTypeManager(){
		return this.merchantTypeManager;
	}
	public void setMerchantTypeManager(MerchantTypeManager manager){
		this.merchantTypeManager = manager;
	}


	public TransportTaskStatusManager getTransportTaskStatusManager(){
		return this.transportTaskStatusManager;
	}
	public void setTransportTaskStatusManager(TransportTaskStatusManager manager){
		this.transportTaskStatusManager = manager;
	}


	public LocationManager getLocationManager(){
		return this.locationManager;
	}
	public void setLocationManager(LocationManager manager){
		this.locationManager = manager;
	}


	public MerchantManager getMerchantManager(){
		return this.merchantManager;
	}
	public void setMerchantManager(MerchantManager manager){
		this.merchantManager = manager;
	}


	public TransportProjectManager getTransportProjectManager(){
		return this.transportProjectManager;
	}
	public void setTransportProjectManager(TransportProjectManager manager){
		this.transportProjectManager = manager;
	}


	public TransportItemManager getTransportItemManager(){
		return this.transportItemManager;
	}
	public void setTransportItemManager(TransportItemManager manager){
		this.transportItemManager = manager;
	}


	public TransportTaskManager getTransportTaskManager(){
		return this.transportTaskManager;
	}
	public void setTransportTaskManager(TransportTaskManager manager){
		this.transportTaskManager = manager;
	}


	public TransportTaskTrackManager getTransportTaskTrackManager(){
		return this.transportTaskTrackManager;
	}
	public void setTransportTaskTrackManager(TransportTaskTrackManager manager){
		this.transportTaskTrackManager = manager;
	}


	public MerchantAccountManager getMerchantAccountManager(){
		return this.merchantAccountManager;
	}
	public void setMerchantAccountManager(MerchantAccountManager manager){
		this.merchantAccountManager = manager;
	}


	public TransactionManager getTransactionManager(){
		return this.transactionManager;
	}
	public void setTransactionManager(TransactionManager manager){
		this.transactionManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


}









