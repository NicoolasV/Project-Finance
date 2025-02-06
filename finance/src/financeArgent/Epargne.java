package financeArgent;	
import java.util.Date;   

public class Epargne {
	 
	String nomCompte;
	Date ouvertureCompte;
	float solde;
	float taux;
	Integer plafond;
	float interetPrevisionnel;
	
	//constructor with 6 parameters
	public Epargne(String nomCompte,Date ouvertureCompte, float solde, float taux, Integer plafond, float interetPrevisionnel) {
		super();
		this.nomCompte = nomCompte;
		this.ouvertureCompte = ouvertureCompte;
		this.solde = solde;
		this.taux = taux;
		this.plafond = plafond;
		this.interetPrevisionnel = interetPrevisionnel;
	}

	@Override						//display in line all objects from class Epargne
	public String toString() {
		return "Objects from classe Epargne are: [nomCompte=" + nomCompte + ", ouvertureCompte=" + ouvertureCompte + ", solde=" + solde + ", taux=" + taux + ", plafond=" + plafond + ", interetPrevisionnel=" + interetPrevisionnel +"]";
	}
}
