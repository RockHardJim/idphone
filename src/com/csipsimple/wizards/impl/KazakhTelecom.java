package com.csipsimple.wizards.impl;

import com.csipsimple.api.SipProfile;

import android.text.InputType;

import kz.telecom.R;

public class KazakhTelecom extends SimpleImplementation {

	@Override
	protected String getDomain() {
		// TODO Auto-generated method stub
		return "sip.telecom.kz";
	}

	@Override
	protected String getDefaultName() {
		// TODO Auto-generated method stub
		return "ID Phone";
	}
	
	@Override
	public void fillLayout(final SipProfile account) {
		super.fillLayout(account);
		
		accountUsername.setTitle(R.string.w_common_phone_number);
		accountUsername.setDialogTitle(R.string.w_common_phone_number);
		accountUsername.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
		
	}
	
	@Override
	public String getDefaultFieldSummary(String fieldName) {
		if(fieldName.equals(USER_NAME)) {
			return parent.getString(R.string.w_common_phone_number_desc);
		}
		return super.getDefaultFieldSummary(fieldName);
	}
	
	public SipProfile buildAccount(SipProfile account) {
		account = super.buildAccount(account);
		account.proxies = null;
		account.transport = SipProfile.TRANSPORT_UDP;
		return account;
	}
}
