package com.csipsimple.wizards.impl;

import java.util.HashMap;

import com.csipsimple.api.SipConfigManager;
import com.csipsimple.api.SipProfile;
import com.csipsimple.api.SipUri;
import com.csipsimple.api.SipUri.ParsedSipContactInfos;
import com.csipsimple.utils.PreferencesWrapper;

import android.net.Uri;
import android.preference.EditTextPreference;
import kz.telecom.R;

public class IDPhone extends BaseImplementation {

//	private EditTextPreference accountDisplayName;
	private EditTextPreference accountUserName;
	private EditTextPreference accountPassword;


	private void bindFields() {
		//accountDisplayName = (EditTextPreference) parent.findPreference("display_name");
		accountUserName = (EditTextPreference) parent.findPreference("username");
		accountPassword = (EditTextPreference) parent.findPreference("password");
	}

	public void fillLayout(final SipProfile account) {
		bindFields();

		//accountDisplayName.setText(account.username);

		ParsedSipContactInfos parsedInfo = SipUri
				.parseSipContact(account.acc_id);

		String serverFull = account.reg_uri;
		if (serverFull == null) {
			serverFull = "";
		} else {
			serverFull = serverFull.replaceFirst("sip:", "");
		}
		//accountServer.setText(serverFull);
		//accountCallerId.setText(parsedInfo.displayName);
		accountUserName.setText(parsedInfo.userName);

		accountPassword.setText(account.data);

		//accountUseTcp.setChecked(account.transport == SipProfile.TRANSPORT_TCP);

		if (account.proxies != null && account.proxies.length > 0) {
			//accountProxy.setText(account.proxies[0].replaceFirst("sip:", ""));
		} else {
		//accountProxy.setText("");
		}
	}

	public void updateDescriptions() {
		//setStringFieldSummary("display_name");
		setStringFieldSummary("username");
		setPasswordFieldSummary("password");
		//setStringFieldSummary("proxy");
	}

	private static HashMap<String, Integer> SUMMARIES = new HashMap<String, Integer>() {

		private static final long serialVersionUID = 3588502754086317232L;

		{
			//put("display_name", R.string.w_common_display_name_desc);
			put("username", R.string.w_advanced_username_desc);
			put("password", R.string.w_advanced_password_desc);
		}
	};

	@Override
	public String getDefaultFieldSummary(String fieldName) {
		Integer res = SUMMARIES.get(fieldName);
		if (res != null) {
			return parent.getString(res);
		}
		return "";
	}

	public boolean canSave() {
		boolean isValid = true;

		//isValid &= checkField(accountDisplayName, isEmpty(accountDisplayName));
		isValid &= checkField(accountUserName, isEmpty(accountUserName));
		isValid &= checkField(accountPassword, isEmpty(accountPassword));

		return isValid;
	}

	public SipProfile buildAccount(SipProfile account) {
		//accountServer.setText("sip.telecom.kz");
		//accountCallerId.setText(accountUserName.getText());
		
		account.display_name = "iDPhone";
		//String[] serverParts = accountServer.getText().split(":");
		account.acc_id = accountUserName.getText().trim() + " <sip:"
				+ Uri.encode(accountUserName.getText().trim()) + "@"
				+ "sip.telecom.kz" + ">";

		account.reg_uri = "sip:sip.telecom.kz";

		account.realm = "*";
		account.username = getText(accountUserName).trim();
		account.data = getText(accountPassword);
		account.scheme = SipProfile.CRED_SCHEME_DIGEST;
		account.datatype = SipProfile.CRED_DATA_PLAIN_PASSWD;

		/*account.transport = accountUseTcp.isChecked() ? SipProfile.TRANSPORT_TCP
				: SipProfile.TRANSPORT_AUTO;

		if (!isEmpty(accountProxy)) {
			account.proxies = new String[] { "sip:"
					+ accountProxy.getText().trim() };
		} else {
			account.proxies = null;
		}*/
		return account;
	}

	@Override
	public int getBasePreferenceResource() {
		return R.xml.w_simple_preferences;
	}
	
	public void setDefaultParams(PreferencesWrapper prefs) {
		super.setDefaultParams(prefs);
		
		//prefs.setPreferenceBooleanValue(SipConfigManager.ECHO_CANCELLATION, true);
		//prefs.setPreferenceBooleanValue(SipConfigManager.ENABLE_TLS, true);
		//prefs.setPreferenceBooleanValue(SipConfigManager.ENABLE_STUN, false);
		//prefs.setPreferenceBooleanValue(SipConfigManager.ENABLE_ICE, false);
		
		//wb
		prefs.setCodecPriority("PCMA/8000/1", SipConfigManager.CODEC_WB,"245");
        prefs.setCodecPriority("G729/8000/1", SipConfigManager.CODEC_WB,"244");
        prefs.setCodecPriority("GSM/8000/1", SipConfigManager.CODEC_WB, "0");
        prefs.setCodecPriority("iLBC/8000/1", SipConfigManager.CODEC_WB,"0");
        prefs.setCodecPriority("PCMU/8000/1", SipConfigManager.CODEC_WB,"0");
        prefs.setCodecPriority("G722/16000/1", SipConfigManager.CODEC_WB,"0");
        prefs.setCodecPriority("speex/16000/1", SipConfigManager.CODEC_WB,"0");
        prefs.setCodecPriority("speex/8000/1", SipConfigManager.CODEC_WB,"0");
        prefs.setCodecPriority("speex/32000/1", SipConfigManager.CODEC_WB,"0");
        
        //nb codecs
        prefs.setCodecPriority("G729/8000/1", SipConfigManager.CODEC_NB,"245");
        prefs.setCodecPriority("PCMA/8000/1", SipConfigManager.CODEC_NB,"244");
        prefs.setCodecPriority("PCMU/8000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("iLBC/8000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("GSM/8000/1", SipConfigManager.CODEC_NB, "0");
        prefs.setCodecPriority("speex/8000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("G722/16000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("speex/16000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("speex/32000/1", SipConfigManager.CODEC_NB,"0");
        prefs.setCodecPriority("AMR/8000/1", SipConfigManager.CODEC_NB,"0");
	}
	@Override
	public boolean needRestart() {
		return false;
	}

}
