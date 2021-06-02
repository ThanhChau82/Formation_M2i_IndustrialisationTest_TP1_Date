package edu.m2i.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.m2i.validators.ValidateDate;

public class TestValidateDate {
	private ValidateDate validateDate;
	
	@Before
	public void init() {
		validateDate = new ValidateDate();
	}
	
	/**
	 * Test Annee valide (1000 <= annee <= 3000)
	 */
	@Test
	public void testVerifierAnneOK() {
		assertTrue(validateDate.verifierAnnee(2000));
	}
	
	/**
	 * Test Annee non valide
	 */
	@Test
	public void testVerifierAnneKOInferior() {
		assertFalse(validateDate.verifierAnnee(999));
	}
	
	/**
	 * Test Annee non valide
	 */
	@Test
	public void testVerifierAnneKOSuperior() {
		assertFalse(validateDate.verifierAnnee(3001));
	}
	
	/**
	 * Test mois valide (1<= mois <=12)
	 */
	@Test
	public void testVerifierMoisOK() {
		assertTrue(validateDate.verifierMois(3));
	}
	
	/**
	 * Test mois non valide
	 */
	@Test
	public void testVerifierMoisKOInferior() {
		assertFalse(validateDate.verifierMois(0));
	}
	
	/**
	 * Test mois non valide
	 */
	@Test
	public void testVerifierMoisKOsuperior() {
		assertFalse(validateDate.verifierMois(13));
	}
	
	/**
	 * Test jour 31 valide (1=< jour <= 31)
	 */
	@Test
	public void testVerifierJour31OK() {
		assertTrue(validateDate.verifierJour31(15));
	}
	
	/**
	 * Test jour 31 non valide
	 */
	@Test
	public void testVerifierJour31KOInferior() {
		assertFalse(validateDate.verifierJour31(0));
	}
	
	/**
	 * Test jour 31 non valide
	 */
	@Test
	public void testVerifierJour31KOSuperior() {
		assertFalse(validateDate.verifierJour31(32));
	}
	
	/**
	 * Test jour 31 valide (1=< jour <= 30)
	 */
	@Test
	public void testVerifierJour30OK() {
		assertTrue(validateDate.verifierJour30(15));
	}
	
	/**
	 * Test jour 30 non valide
	 */
	@Test
	public void testVerifierJour30KOInferior() {
		assertFalse(validateDate.verifierJour30(0));
	}
	
	/**
	 * Test jour 30 non valide
	 */
	@Test
	public void testVerifierJour30KOSuperior() {
		assertFalse(validateDate.verifierJour30(31));
	}
	
	/**
	 * Test annee bixestille
	 */
	@Test
	public void testVerifierJour29OK() {
		assertTrue(validateDate.verifierJour29(2004, 15));
	}
	
	@Test
	public void testVerifierJour29KOInferior() {
		assertFalse(validateDate.verifierJour29(2004, 0));
	}
	
	@Test
	public void testVerifierJour29KOSuperior() {
		assertFalse(validateDate.verifierJour29(2004, 30));
	}
	
	@Test
	public void testVerifierJour28OK() {
		assertTrue(validateDate.verifierJour29(2003, 15));
	}
	
	@Test
	public void testVerifierJour28KOInferior() {
		assertFalse(validateDate.verifierJour29(2003, 0));
	}
	
	@Test
	public void testVerifierJour28KOSuperior() {
		assertFalse(validateDate.verifierJour29(2003, 29));
	}
	
	@Test
	public void testVerifierDateMois31JoursOK() {
		assertTrue(validateDate.verifierJour(2003, 1, 31));
	}
	
	@Test
	public void testVerifierDateMois31JoursKO() {
		assertTrue(validateDate.verifierJour(2003, 1, 30));
	}
	
	@Test
	public void testVerifierDateMois30JoursOK() {
		assertTrue(validateDate.verifierJour(2003, 4, 30));
	}
	
	@Test
	public void testVerifierDateMois30JoursKO() {
		assertFalse(validateDate.verifierJour(2003, 4, 31));
	}

	@Test
	public void testVerifierDateMoisFevrierOK() {
		assertTrue(validateDate.verifierJour(2003, 2, 28));
	}
	
	@Test
	public void testVerifierDateMoisFevrierKO() {
		assertFalse(validateDate.verifierJour(2003, 2, 29));
	}
}
