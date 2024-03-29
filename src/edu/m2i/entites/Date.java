package edu.m2i.entites;

public class Date {
	private int jour;
	private int mois;
	private int annee;
	
	public Date() {
		super();
	}
	public Date(int jour, int mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	@Override
	public String toString() {
		return "Date [jour=" + jour + ", mois=" + mois + ", annee=" + annee + "]";
	}	
}
