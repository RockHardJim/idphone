/**
 * Copyright (C) 2010-2012 Regis Montoya (aka r3gis - www.r3gis.fr)
 * This file is part of CSipSimple.
 *
 *  CSipSimple is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  If you own a pjsip commercial license you can also redistribute it
 *  and/or modify it under the terms of the GNU Lesser General Public License
 *  as an android library.
 *
 *  CSipSimple is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CSipSimple.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.csipsimple.wizards.impl;

import com.csipsimple.api.SipConfigManager;
import com.csipsimple.api.SipProfile;
import com.csipsimple.utils.PreferencesWrapper;

import android.text.InputType;


public class VoipTel extends SimpleImplementation {
	

	@Override
	protected String getDomain() {
		return "voip.voiptel.ie";
	}
	
	@Override
	protected String getDefaultName() {
		return "Voiptel Mobile";
	}
	
	@Override
	protected boolean canTcp() {
		return false;
	}
	
	@Override
	public void fillLayout(SipProfile account) {
		super.fillLayout(account);

		accountUsername.getEditText().setInputType(InputType.TYPE_CLASS_PHONE);
	}
	
	@Override
	public void setDefaultParams(PreferencesWrapper prefs) {
		super.setDefaultParams(prefs);

		prefs.setCodecPriority("g729/8000/1", SipConfigManager.CODEC_NB, "240");
		prefs.setCodecPriority("g729/8000/1", SipConfigManager.CODEC_WB, "240");
	}
	
	@Override
	public boolean needRestart() {
		return true;
	}
}
