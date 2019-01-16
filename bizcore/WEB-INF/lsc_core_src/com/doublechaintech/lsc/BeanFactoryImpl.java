
package com.doublechaintech.lsc;
import java.util.Map;

import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.transactiontype.TransactionType;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.transaction.Transaction;
import com.doublechaintech.lsc.userdomain.UserDomain;
import com.doublechaintech.lsc.userwhitelist.UserWhiteList;
import com.doublechaintech.lsc.secuser.SecUser;
import com.doublechaintech.lsc.secuserblocking.SecUserBlocking;
import com.doublechaintech.lsc.userapp.UserApp;
import com.doublechaintech.lsc.listaccess.ListAccess;
import com.doublechaintech.lsc.objectaccess.ObjectAccess;
import com.doublechaintech.lsc.loginhistory.LoginHistory;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formaction.FormAction;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public TransactionType createTransactionType(Map<String,Object> options){
		return new TransactionType();
	}


	public MerchantType createMerchantType(Map<String,Object> options){
		return new MerchantType();
	}


	public TransportTaskStatus createTransportTaskStatus(Map<String,Object> options){
		return new TransportTaskStatus();
	}


	public Location createLocation(Map<String,Object> options){
		return new Location();
	}


	public Merchant createMerchant(Map<String,Object> options){
		return new Merchant();
	}


	public TransportProject createTransportProject(Map<String,Object> options){
		return new TransportProject();
	}


	public TransportItem createTransportItem(Map<String,Object> options){
		return new TransportItem();
	}


	public TransportTask createTransportTask(Map<String,Object> options){
		return new TransportTask();
	}


	public TransportTaskTrack createTransportTaskTrack(Map<String,Object> options){
		return new TransportTaskTrack();
	}


	public MerchantAccount createMerchantAccount(Map<String,Object> options){
		return new MerchantAccount();
	}


	public Transaction createTransaction(Map<String,Object> options){
		return new Transaction();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}





}










