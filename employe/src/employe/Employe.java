/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

/* **********************************************************************
 *  La classe Employe
 * **********************************************************************/
abstract class Employe {
	private String nom;
	private String prenom;
	private int age;
	private String date;
	
        
        
        public static void main(String[] args){}
	
	public Employe(String prenom, String nom, int age, String date) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.date = date;
	}

	public abstract double  calculerSalaire();

	public String getTitre()
		{
			return "L'employe " ;
		}
	
	public String getNom() {
		return getTitre() + prenom + " " + nom;
	}
}

/* **********************************************************************
 *  La classe Commercial (regroupe Vendeur et ReprÃ©sentant)
 * **********************************************************************/
abstract class Commercial extends Employe {
	private double chiffreAffaire;

	public Commercial(String prenom, String nom, int age, String date,
			   double chiffreAffaire) {
		super(prenom, nom, age, date);
		this.chiffreAffaire = chiffreAffaire;
	}

	public double getChiffreAffaire()
		{
			return chiffreAffaire;
		}
	
}

/* **********************************************************************
 *  La classe Vendeur
 * **********************************************************************/
class Vendeur extends Commercial {
	private final static double POURCENT_VENDEUR = 0.2;
	private final static int BONUS_VENDEUR = 100;
	public Vendeur(String prenom, String nom, int age, String date,
			double chiffreAffaire) {
		super(prenom, nom, age, date, chiffreAffaire);
	}

	public double calculerSalaire() {
		return (POURCENT_VENDEUR * getChiffreAffaire()) + BONUS_VENDEUR;
	}

	public String getTitre()
		{
			return "Le vendeur ";
		}

}

/* **********************************************************************
 *  La classe ReprÃ©sentant
 * **********************************************************************/
class Representant extends Commercial {
    private final static double POURCENT_REPRESENTANT = 0.2;
	private final static int BONUS_REPRESENTANT = 200;
	public Representant(String prenom, String nom, int age, String date, double chiffreAffaire) {
		super(prenom, nom, age, date, chiffreAffaire);
	}

	public double calculerSalaire() {
		return (POURCENT_REPRESENTANT * getChiffreAffaire()) + BONUS_REPRESENTANT;
	}

	public String getTitre()
		{
			return "Le representant ";
		}
}

/* **********************************************************************
 *  La classe Technicien (Production)
 * **********************************************************************/
class Technicien extends Employe {
	private final static double FACTEUR_UNITE = 5.0;
	

	private int unites;

	public Technicien(String prenom, String nom, int age, String date, int unites) {
		super(prenom, nom, age, date);
		this.unites = unites;
	}

	public double calculerSalaire() {
		return FACTEUR_UNITE * unites;
	}

	public String getTitre()
		{
			return "Le technicien ";
		}
}

/* **********************************************************************
 *  La classe Manutentionnaire
 * **********************************************************************/
class Manutentionnaire extends Employe {
	private final static double SALAIRE_HORAIRE = 65.0;
	private int heures;

	public Manutentionnaire(String prenom, String nom, int age, String date,
					 int heures) {
		super(prenom, nom, age, date);
		this.heures = heures;
	}

	public double calculerSalaire() {
		return SALAIRE_HORAIRE * heures;
	}

	public String getTitre()
		{
			return "Le manut. " ;
		}
}

/* **********************************************************************
 *  L'interface d'employe Ã  risque
 * **********************************************************************/
interface ARisque {
	int PRIME = 25000;
}

/* **********************************************************************
 *  Une premiÃ¨re sous-classe d'employe Ã  risque
 * **********************************************************************/
class TechnARisque extends Technicien implements ARisque {

	public TechnARisque(String prenom, String nom, int age, String date, int unites) {
		super(prenom, nom, age, date, unites);
	}

	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
}

/* **********************************************************************
 *  Une autre sous-classe d'employe Ã  risque
 * **********************************************************************/
class ManutARisque extends Manutentionnaire implements ARisque {
	
	public ManutARisque(String prenom, String nom, int age, String date, int heures) {
		super(prenom, nom, age, date, heures);
	}

	public double calculerSalaire() {
		return super.calculerSalaire() + PRIME;
	}
}

/* **********************************************************************
 *  La classe Personnel
 * **********************************************************************/
class Personnel {
	private Employe[] staff;
	private int nbreEmploye;
	private final static int MAXEMPLOYE = 200;

	public Personnel() {
		staff = new Employe[MAXEMPLOYE];
		nbreEmploye = 0;
	}

	public void ajouterEmploye(Employe e) {
		++nbreEmploye;
		if (nbreEmploye <= MAXEMPLOYE) {
			staff[nbreEmploye - 1] = e;
		} else {
			System.out.println("Pas plus de " + MAXEMPLOYE + " employe");
		}
	}

	public double salaireMoyen() {
		double somme = 0.0;
		for (int i = 0; i < nbreEmploye; i++) {
			somme += staff[i].calculerSalaire();
		}
		return somme / nbreEmploye;
	}

	public void afficherSalaires() {
		for (int i = 0; i < nbreEmploye; i++) {
			System.out.println(staff[i].getNom() + " gagne "
					+ staff[i].calculerSalaire() + " francs.");
		}
	}
}





	



