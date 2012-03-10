package com.csipsimple.wizards;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.csipsimple.api.SipProfile;
import com.csipsimple.utils.CustomDistribution;
import com.csipsimple.wizards.impl.A1;
import com.csipsimple.wizards.impl.AbcVoip;
import com.csipsimple.wizards.impl.Advanced;
import com.csipsimple.wizards.impl.Amivox;
import com.csipsimple.wizards.impl.BGTel;
import com.csipsimple.wizards.impl.BTone;
import com.csipsimple.wizards.impl.Balses;
import com.csipsimple.wizards.impl.Basic;
import com.csipsimple.wizards.impl.Beeztel;
import com.csipsimple.wizards.impl.BelCentrale;
import com.csipsimple.wizards.impl.Betamax;
import com.csipsimple.wizards.impl.Blueface;
import com.csipsimple.wizards.impl.BroadVoice;
import com.csipsimple.wizards.impl.Broadsoft;
import com.csipsimple.wizards.impl.Callcentric;
import com.csipsimple.wizards.impl.CamundaNet;
import com.csipsimple.wizards.impl.Cellip;
import com.csipsimple.wizards.impl.Cotas;
import com.csipsimple.wizards.impl.DeltaThree;
import com.csipsimple.wizards.impl.DvcNg;
import com.csipsimple.wizards.impl.EasyBell;
import com.csipsimple.wizards.impl.Ekiga;
import com.csipsimple.wizards.impl.EuroTelefon;
import com.csipsimple.wizards.impl.Eutelia;
import com.csipsimple.wizards.impl.Expert;
import com.csipsimple.wizards.impl.FastVoip;
import com.csipsimple.wizards.impl.Fayn;
import com.csipsimple.wizards.impl.Freeconet;
import com.csipsimple.wizards.impl.FreephoneLineCa;
import com.csipsimple.wizards.impl.Freephonie;
import com.csipsimple.wizards.impl.Globtelecom;
import com.csipsimple.wizards.impl.Gradwell;
import com.csipsimple.wizards.impl.Haloo;
import com.csipsimple.wizards.impl.HalooCentrala;
import com.csipsimple.wizards.impl.IDPhone;
import com.csipsimple.wizards.impl.IPComms;
import com.csipsimple.wizards.impl.IPshka;
import com.csipsimple.wizards.impl.ITTelenet;
import com.csipsimple.wizards.impl.IiNet;
import com.csipsimple.wizards.impl.Innotel;
import com.csipsimple.wizards.impl.Interphone365;
import com.csipsimple.wizards.impl.Ip2Mobile;
import com.csipsimple.wizards.impl.IpTel;
import com.csipsimple.wizards.impl.Ippi;
import com.csipsimple.wizards.impl.Keyyo;
import com.csipsimple.wizards.impl.Local;
import com.csipsimple.wizards.impl.Localphone;
import com.csipsimple.wizards.impl.Mondotalk;
import com.csipsimple.wizards.impl.Netelip;
import com.csipsimple.wizards.impl.NeufTalk;
import com.csipsimple.wizards.impl.Nymgo;
import com.csipsimple.wizards.impl.OXO810;
import com.csipsimple.wizards.impl.Odorik;
import com.csipsimple.wizards.impl.OnSip;
import com.csipsimple.wizards.impl.Optimus;
import com.csipsimple.wizards.impl.Orbtalk;
import com.csipsimple.wizards.impl.Ovh;
import com.csipsimple.wizards.impl.Pbxes;
import com.csipsimple.wizards.impl.Pennytel;
import com.csipsimple.wizards.impl.Pfingo;
import com.csipsimple.wizards.impl.Phonzo;
import com.csipsimple.wizards.impl.PlanetPhone;
import com.csipsimple.wizards.impl.Pozitel;
import com.csipsimple.wizards.impl.Rapidvox;
import com.csipsimple.wizards.impl.Sapo;
import com.csipsimple.wizards.impl.Sbohempevnalinko;
import com.csipsimple.wizards.impl.Scarlet;
import com.csipsimple.wizards.impl.Sip2Sip;
import com.csipsimple.wizards.impl.SipCel;
import com.csipsimple.wizards.impl.SipSorcery;
import com.csipsimple.wizards.impl.SipWise;
import com.csipsimple.wizards.impl.Sipgate;
import com.csipsimple.wizards.impl.Sipkom;
import com.csipsimple.wizards.impl.Sipnet;
import com.csipsimple.wizards.impl.SiptelPt;
import com.csipsimple.wizards.impl.Smarto;
import com.csipsimple.wizards.impl.Sonetel;
import com.csipsimple.wizards.impl.Speakezi;
import com.csipsimple.wizards.impl.Tanstagi;
import com.csipsimple.wizards.impl.Telsome;
import com.csipsimple.wizards.impl.Tlenofon;
import com.csipsimple.wizards.impl.UkrTelecom;
import com.csipsimple.wizards.impl.VPhone;
import com.csipsimple.wizards.impl.Vanbergsystems;
import com.csipsimple.wizards.impl.Viva;
import com.csipsimple.wizards.impl.VoipBel;
import com.csipsimple.wizards.impl.VoipMS;
import com.csipsimple.wizards.impl.VoipTel;
import com.csipsimple.wizards.impl.Vono;
import com.csipsimple.wizards.impl.WiMobile;
import com.csipsimple.wizards.impl.Zadarma;
import com.csipsimple.wizards.impl.ZonPt;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import kz.telecom.R;

public class WizardUtils {

	public static class WizardInfo {
		public String label;
		public String id;
		public int icon;
		public int priority = 99;
		public Locale[] countries;
		public boolean isGeneric = false;
		public boolean isWorld = false;
		public Class<?> classObject;

		public WizardInfo(String aId, String aLabel, int aIcon, int aPriority,
				Locale[] aCountries, boolean aIsGeneric, boolean aIsWorld,
				Class<?> aClassObject) {
			id = aId;
			label = aLabel;
			icon = aIcon;
			priority = aPriority;
			countries = aCountries;
			isGeneric = aIsGeneric;
			isWorld = aIsWorld;
			classObject = aClassObject;
		}
	};

	private static boolean initDone = false;

	public static final String LABEL = "LABEL";
	public static final String ICON = "ICON";
	public static final String ID = "ID";
	public static final String LANG_DISPLAY = "DISPLAY";
	public static final String PRIORITY = "PRIORITY";
	public static final String PRIORITY_INT = "PRIORITY_INT";

	public static final String EXPERT_WIZARD_TAG = "EXPERT";
	public static final String LOCAL_WIZARD_TAG = "LOCAL";

	private static HashMap<String, WizardInfo> WIZARDS_DICT;

	private static class WizardPrioComparator implements
			Comparator<Map<String, Object>> {

		@Override
		public int compare(Map<String, Object> infos1,
				Map<String, Object> infos2) {
			if (infos1 != null && infos2 != null) {
				if ((Boolean) infos1.get(PRIORITY_INT)) {
					Integer w1 = (Integer) infos1.get(PRIORITY);
					Integer w2 = (Integer) infos2.get(PRIORITY);
					// Log.d(THIS_FILE, "Compare : "+w1+ " vs "+w2);
					if (w1 > w2) {
						return -1;
					}
					if (w1 < w2) {
						return 1;
					}
				} else {
					String name1 = (String) infos1.get(LABEL);
					String name2 = (String) infos2.get(LABEL);
					return name1.compareToIgnoreCase(name2);
				}
			}
			return 0;
		}
	}

	private static Locale locale(String isoCode) {
		String[] codes = isoCode.split("_");
		if (codes.length == 2) {
			return new Locale(codes[0].toLowerCase(), codes[1].toUpperCase());
		} else if (codes.length == 1) {
			return new Locale(codes[0].toLowerCase());
		}
		Log.e("WizardUtils", "Invalid locale " + isoCode);
		return null;
	}

	/**
	 * Initialize wizards list
	 */
	private static void initWizards() {
		WIZARDS_DICT = new HashMap<String, WizardInfo>();
		WIZARDS_DICT.put("iD Phone", new WizardInfo("iD Phone",
				"iD Phone", R.drawable.ic_wizard_globtelecom, 1,
				new Locale[] {}, true, false,
				IDPhone.class));
		// Generic
		WIZARDS_DICT.put(WizardUtils.EXPERT_WIZARD_TAG, new WizardInfo(
				WizardUtils.EXPERT_WIZARD_TAG, "Expert",
				R.drawable.ic_wizard_expert, 1, new Locale[] {}, true, false,
				Expert.class));
		if (CustomDistribution.distributionWantsOtherProviders()) {
			// World wide


			
			

		} else {
			WizardInfo info = CustomDistribution.getCustomDistributionWizard();
			//WIZARDS_DICT.put(info.id, info);
		}
		initDone = true;
	}

	private static Map<String, Object> wizardInfoToMap(WizardInfo infos,
			boolean usePriorityInt) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(LABEL, infos.label);
		map.put(ID, infos.id);
		map.put(ICON, infos.icon);
		map.put(PRIORITY, infos.priority);
		map.put(PRIORITY_INT, usePriorityInt);
		return map;
	}

	// Ok, what could have be done is declaring an interface but not able with
	// static fields
	// I'll later check whether this is more interesting to declare an interface
	// or an info class
	// used to declare wizards
	public static WizardInfo getWizardClassInfos(Class<?> wizard) {
		Method method;
		try {
			method = wizard.getMethod("getWizardInfo", (Class[]) null);
			return (WizardInfo) method.invoke(null, (Object[]) null);
		} catch (Exception e) {
			// Generic catch : we are not interested in more details
			e.printStackTrace();
		}
		return null;
	}

	public static HashMap<String, WizardInfo> getWizardsList() {
		if (!initDone) {
			initWizards();
		}
		return WIZARDS_DICT;
	}

	public static WizardInfo getWizardClass(String wizardId) {
		if (!initDone) {
			initWizards();
		}
		return WIZARDS_DICT.get(wizardId);
	}

	public static int getWizardIconRes(String wizardId) {
		// Update account image
		WizardInfo wizard_infos = WizardUtils.getWizardClass(wizardId);
		if (wizard_infos != null) {
			if (!wizard_infos.isGeneric) {
				return wizard_infos.icon;
			}
		}
		return R.drawable.ic_launcher_phone;
	}

	public static Bitmap getWizardBitmap(Context ctxt, SipProfile account) {
		if (account.icon == null) {
			Resources r = ctxt.getResources();
			BitmapDrawable bd = ((BitmapDrawable) r.getDrawable(WizardUtils
					.getWizardIconRes(account.wizard)));
			account.icon = bd.getBitmap();
		}
		return account.icon;
	}

	public static ArrayList<HashMap<String, String>> getWizardsGroups(
			Context context) {
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> m;

		// Local
		m = new HashMap<String, String>();

		// m.put("lang", Locale.getDefault().getCountry());
		m.put(LANG_DISPLAY, Locale.getDefault().getDisplayCountry());
		//result.add(m);

		// Generic
		m = new HashMap<String, String>();
		// m.put("lang", "generic");
		m.put(LANG_DISPLAY, context.getString(R.string.generic_wizards_text));
		result.add(m);

		if (CustomDistribution.distributionWantsOtherProviders()) {
			// World
			m = new HashMap<String, String>();
			// m.put("lang", "world");
			m.put(LANG_DISPLAY,
					context.getString(R.string.world_wide_providers_text));
			//result.add(m);

			// Others
			m = new HashMap<String, String>();
			// m.put("lang", "others");
			m.put(LANG_DISPLAY,
					context.getString(R.string.other_country_providers_text));
			//result.add(m);
		}

		return result;
	}

	public static ArrayList<ArrayList<Map<String, Object>>> getWizardsGroupedList() {
		ArrayList<Map<String, Object>> locale_list = new ArrayList<Map<String, Object>>();
		ArrayList<Map<String, Object>> generic_list = new ArrayList<Map<String, Object>>();
		ArrayList<Map<String, Object>> world_list = new ArrayList<Map<String, Object>>();
		ArrayList<Map<String, Object>> others_list = new ArrayList<Map<String, Object>>();

		Set<Entry<String, WizardInfo>> wizards = getWizardsList().entrySet();
		for (Entry<String, WizardInfo> wizard : wizards) {
			boolean found = false;

			for (Locale country : wizard.getValue().countries) {
				if (country != null) {
					if (country.getCountry().equals(
							Locale.getDefault().getCountry())) {
						found = true;
						locale_list
								.add(wizardInfoToMap(wizard.getValue(), true));
						break;
					} else if (country.getCountry().equalsIgnoreCase("")) {
						if (country.getLanguage().equals(
								Locale.getDefault().getLanguage())) {
							found = true;
							locale_list.add(wizardInfoToMap(wizard.getValue(),
									true));
							break;
						}
					}
				}
			}
			if (!found) {
				if (wizard.getValue().isGeneric) {
					generic_list.add(wizardInfoToMap(wizard.getValue(), true));
					found = true;
				} else if (wizard.getValue().isWorld) {
					world_list.add(wizardInfoToMap(wizard.getValue(), false));
					found = true;
				}
			}
			if (!found) {
				others_list.add(wizardInfoToMap(wizard.getValue(), false));
			}
		}

		WizardPrioComparator comparator = new WizardPrioComparator();
		Collections.sort(locale_list, comparator);
		Collections.sort(generic_list, comparator);
		Collections.sort(world_list, comparator);
		Collections.sort(others_list, comparator);

		ArrayList<ArrayList<Map<String, Object>>> result = new ArrayList<ArrayList<Map<String, Object>>>();
		//result.add(locale_list);
		result.add(generic_list);
		//result.add(world_list);
		//result.add(others_list);
		return result;
	}

}
