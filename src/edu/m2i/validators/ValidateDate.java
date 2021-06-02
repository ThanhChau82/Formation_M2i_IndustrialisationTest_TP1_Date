package edu.m2i.validators;

import java.util.ArrayList;
import java.util.List;

import edu.m2i.entites.Date;

public class ValidateDate {
	private final List<Integer> MOIS_31_JOURS = createMois31Jours();
	
	public List<Integer> createMois31Jours() {
		List<Integer> mois = new ArrayList();
		mois.add(1);
		mois.add(3);
		mois.add(5);
		mois.add(7);
		mois.add(8);
		mois.add(10);
		mois.add(12);
		return mois;
	}
	
	public boolean verifierDate(Date date) {
		int annee = date.getAnnee();
		int mois = date.getMois();
		int jour = date.getJour();
		
		boolean isAnneeOK = verifierAnnee(annee);
		boolean isMoisOK = verifierMois(mois);
		boolean isJourOK = verifierJour(annee, mois, jour);
		
		return isAnneeOK && isMoisOK && isJourOK;
	}
	
	public boolean verifierAnnee(int annee) {
		return annee >= 1000 && annee <= 3000;
	}
	
	/**
	 * La date est valide si (mois[1-12])
	 * @param mois
	 * @return
	 */
	public boolean verifierMois(int mois) {
		return (mois >= 1 && mois <= 12);
	}	

	public boolean verifierJour(int annee, int mois, int jour) {
		if (MOIS_31_JOURS.contains(mois)) {
			return verifierJour31(jour);
		} else if (mois == 2) {
			return verifierJour29(annee, jour);
		} else {
			return verifierJour30(jour);
		}

	}
	
	public boolean verifierJour31(int jour) {
		return jour >= 1 && jour <= 31;
	}

	public boolean verifierJour29(int annee, int jour) {
		if (annee%4 == 0 && annee%100 != 0) {
			return jour >= 1 && jour <= 29;
		} else {
			return jour >=1 && jour <= 28;
		}
	}

	public boolean verifierJour30(int jour) {
		return jour >= 1 && jour <= 30;
	}

	
}
