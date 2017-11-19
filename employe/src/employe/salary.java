/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

/**
 *
 * @author DELL
 */
public class salary{
	public static void main(String[] args) {
		Personnel p = new Personnel();
		p.ajouterEmploye(new Vendeur("TOTO", "Business", 45, "1995", 30000));
		p.ajouterEmploye(new Representant("PAUL", "Vendtout", 25, "2001", 20000));
		p.ajouterEmploye(new Technicien("JEAN", "Bosseur", 28, "1998", 1000));
		p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
		p.ajouterEmploye(new TechnARisque("FRANK", "Flippe", 28, "2000", 1000));
		p.ajouterEmploye(new ManutARisque("MARK", "Abordage", 30, "2001", 45));

		p.afficherSalaires();
		System.out.println("Le salaire moyen dans l'entreprise est de "
				+ p.salaireMoyen() + " francs.");

	}

}
 
    

