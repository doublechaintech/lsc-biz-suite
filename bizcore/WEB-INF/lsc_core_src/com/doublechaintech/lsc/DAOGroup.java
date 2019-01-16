package com.doublechaintech.lsc;

import java.util.HashMap;
import java.util.Map;

import com.doublechaintech.lsc.platform.Platform;
import com.doublechaintech.lsc.platform.PlatformDAO;
import com.doublechaintech.lsc.platform.PlatformTokens;
import com.doublechaintech.lsc.transactiontype.TransactionType;
import com.doublechaintech.lsc.transactiontype.TransactionTypeDAO;
import com.doublechaintech.lsc.transactiontype.TransactionTypeTokens;
import com.doublechaintech.lsc.merchanttype.MerchantType;
import com.doublechaintech.lsc.merchanttype.MerchantTypeDAO;
import com.doublechaintech.lsc.merchanttype.MerchantTypeTokens;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatus;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusDAO;
import com.doublechaintech.lsc.transporttaskstatus.TransportTaskStatusTokens;
import com.doublechaintech.lsc.location.Location;
import com.doublechaintech.lsc.location.LocationDAO;
import com.doublechaintech.lsc.location.LocationTokens;
import com.doublechaintech.lsc.merchant.Merchant;
import com.doublechaintech.lsc.merchant.MerchantDAO;
import com.doublechaintech.lsc.merchant.MerchantTokens;
import com.doublechaintech.lsc.transportproject.TransportProject;
import com.doublechaintech.lsc.transportproject.TransportProjectDAO;
import com.doublechaintech.lsc.transportproject.TransportProjectTokens;
import com.doublechaintech.lsc.transportitem.TransportItem;
import com.doublechaintech.lsc.transportitem.TransportItemDAO;
import com.doublechaintech.lsc.transportitem.TransportItemTokens;
import com.doublechaintech.lsc.transporttask.TransportTask;
import com.doublechaintech.lsc.transporttask.TransportTaskDAO;
import com.doublechaintech.lsc.transporttask.TransportTaskTokens;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.lsc.transporttasktrack.TransportTaskTrackTokens;
import com.doublechaintech.lsc.merchantaccount.MerchantAccount;
import com.doublechaintech.lsc.merchantaccount.MerchantAccountDAO;
import com.doublechaintech.lsc.merchantaccount.MerchantAccountTokens;
import com.doublechaintech.lsc.transaction.Transaction;
import com.doublechaintech.lsc.transaction.TransactionDAO;
import com.doublechaintech.lsc.transaction.TransactionTokens;
import com.doublechaintech.lsc.userdomain.UserDomain;
import com.doublechaintech.lsc.userdomain.UserDomainDAO;
import com.doublechaintech.lsc.userdomain.UserDomainTokens;
import com.doublechaintech.lsc.userwhitelist.UserWhiteList;
import com.doublechaintech.lsc.userwhitelist.UserWhiteListDAO;
import com.doublechaintech.lsc.userwhitelist.UserWhiteListTokens;
import com.doublechaintech.lsc.secuser.SecUser;
import com.doublechaintech.lsc.secuser.SecUserDAO;
import com.doublechaintech.lsc.secuser.SecUserTokens;
import com.doublechaintech.lsc.secuserblocking.SecUserBlocking;
import com.doublechaintech.lsc.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.lsc.secuserblocking.SecUserBlockingTokens;
import com.doublechaintech.lsc.userapp.UserApp;
import com.doublechaintech.lsc.userapp.UserAppDAO;
import com.doublechaintech.lsc.userapp.UserAppTokens;
import com.doublechaintech.lsc.listaccess.ListAccess;
import com.doublechaintech.lsc.listaccess.ListAccessDAO;
import com.doublechaintech.lsc.listaccess.ListAccessTokens;
import com.doublechaintech.lsc.objectaccess.ObjectAccess;
import com.doublechaintech.lsc.objectaccess.ObjectAccessDAO;
import com.doublechaintech.lsc.objectaccess.ObjectAccessTokens;
import com.doublechaintech.lsc.loginhistory.LoginHistory;
import com.doublechaintech.lsc.loginhistory.LoginHistoryDAO;
import com.doublechaintech.lsc.loginhistory.LoginHistoryTokens;
import com.doublechaintech.lsc.genericform.GenericForm;
import com.doublechaintech.lsc.genericform.GenericFormDAO;
import com.doublechaintech.lsc.genericform.GenericFormTokens;
import com.doublechaintech.lsc.formmessage.FormMessage;
import com.doublechaintech.lsc.formmessage.FormMessageDAO;
import com.doublechaintech.lsc.formmessage.FormMessageTokens;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessage;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.lsc.formfieldmessage.FormFieldMessageTokens;
import com.doublechaintech.lsc.formfield.FormField;
import com.doublechaintech.lsc.formfield.FormFieldDAO;
import com.doublechaintech.lsc.formfield.FormFieldTokens;
import com.doublechaintech.lsc.formaction.FormAction;
import com.doublechaintech.lsc.formaction.FormActionDAO;
import com.doublechaintech.lsc.formaction.FormActionTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected TransactionTypeDAO transactionTypeDAO;

	protected MerchantTypeDAO merchantTypeDAO;

	protected TransportTaskStatusDAO transportTaskStatusDAO;

	protected LocationDAO locationDAO;

	protected MerchantDAO merchantDAO;

	protected TransportProjectDAO transportProjectDAO;

	protected TransportItemDAO transportItemDAO;

	protected TransportTaskDAO transportTaskDAO;

	protected TransportTaskTrackDAO transportTaskTrackDAO;

	protected MerchantAccountDAO merchantAccountDAO;

	protected TransactionDAO transactionDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected SecUserBlockingDAO secUserBlockingDAO;

	protected UserAppDAO userAppDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public TransactionTypeDAO getTransactionTypeDAO(){
		return this.transactionTypeDAO;
	}
	public void setTransactionTypeDAO(TransactionTypeDAO dao){
		this.transactionTypeDAO = dao;
	}


	public MerchantTypeDAO getMerchantTypeDAO(){
		return this.merchantTypeDAO;
	}
	public void setMerchantTypeDAO(MerchantTypeDAO dao){
		this.merchantTypeDAO = dao;
	}


	public TransportTaskStatusDAO getTransportTaskStatusDAO(){
		return this.transportTaskStatusDAO;
	}
	public void setTransportTaskStatusDAO(TransportTaskStatusDAO dao){
		this.transportTaskStatusDAO = dao;
	}


	public LocationDAO getLocationDAO(){
		return this.locationDAO;
	}
	public void setLocationDAO(LocationDAO dao){
		this.locationDAO = dao;
	}


	public MerchantDAO getMerchantDAO(){
		return this.merchantDAO;
	}
	public void setMerchantDAO(MerchantDAO dao){
		this.merchantDAO = dao;
	}


	public TransportProjectDAO getTransportProjectDAO(){
		return this.transportProjectDAO;
	}
	public void setTransportProjectDAO(TransportProjectDAO dao){
		this.transportProjectDAO = dao;
	}


	public TransportItemDAO getTransportItemDAO(){
		return this.transportItemDAO;
	}
	public void setTransportItemDAO(TransportItemDAO dao){
		this.transportItemDAO = dao;
	}


	public TransportTaskDAO getTransportTaskDAO(){
		return this.transportTaskDAO;
	}
	public void setTransportTaskDAO(TransportTaskDAO dao){
		this.transportTaskDAO = dao;
	}


	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
		return this.transportTaskTrackDAO;
	}
	public void setTransportTaskTrackDAO(TransportTaskTrackDAO dao){
		this.transportTaskTrackDAO = dao;
	}


	public MerchantAccountDAO getMerchantAccountDAO(){
		return this.merchantAccountDAO;
	}
	public void setMerchantAccountDAO(MerchantAccountDAO dao){
		this.merchantAccountDAO = dao;
	}


	public TransactionDAO getTransactionDAO(){
		return this.transactionDAO;
	}
	public void setTransactionDAO(TransactionDAO dao){
		this.transactionDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public SecUserBlockingDAO getSecUserBlockingDAO(){
		return this.secUserBlockingDAO;
	}
	public void setSecUserBlockingDAO(SecUserBlockingDAO dao){
		this.secUserBlockingDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("TransactionType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransactionTypeDAO().load(id, TransactionTypeTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionTypeDAO().present((TransactionType)data, tokens);
			}
		});

		internalLoaderMap.put("MerchantType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMerchantTypeDAO().load(id, MerchantTypeTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantTypeDAO().present((MerchantType)data, tokens);
			}
		});

		internalLoaderMap.put("TransportTaskStatus", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTaskStatusDAO().load(id, TransportTaskStatusTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskStatusDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskStatusDAO().present((TransportTaskStatus)data, tokens);
			}
		});

		internalLoaderMap.put("Location", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLocationDAO().load(id, LocationTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLocationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLocationDAO().present((Location)data, tokens);
			}
		});

		internalLoaderMap.put("Merchant", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMerchantDAO().load(id, MerchantTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantDAO().present((Merchant)data, tokens);
			}
		});

		internalLoaderMap.put("TransportProject", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportProjectDAO().load(id, TransportProjectTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportProjectDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportProjectDAO().present((TransportProject)data, tokens);
			}
		});

		internalLoaderMap.put("TransportItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportItemDAO().load(id, TransportItemTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportItemDAO().present((TransportItem)data, tokens);
			}
		});

		internalLoaderMap.put("TransportTask", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTaskDAO().load(id, TransportTaskTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskDAO().present((TransportTask)data, tokens);
			}
		});

		internalLoaderMap.put("TransportTaskTrack", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().load(id, TransportTaskTrackTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().present((TransportTaskTrack)data, tokens);
			}
		});

		internalLoaderMap.put("MerchantAccount", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMerchantAccountDAO().load(id, MerchantAccountTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantAccountDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMerchantAccountDAO().present((MerchantAccount)data, tokens);
			}
		});

		internalLoaderMap.put("Transaction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransactionDAO().load(id, TransactionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransactionDAO().present((Transaction)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("SecUserBlocking", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, SecUserBlockingTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserBlockingDAO().present((SecUserBlocking)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}

