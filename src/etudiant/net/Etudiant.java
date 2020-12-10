package etudiant.net;

/**
 * @author Eya Zaoui, RT2-1
 * Etudiant entity class matching the database entity.
 *
 */

public class Etudiant {
	
	private final int id;
	private final String nom;
	private final String dateDeNaissance;
	private final String nationalite;
	private final String email;
	private final String adresse;
	
	public Etudiant(int id, String nom, String dateDeNaissance, String nationalite, String email, 
			String adresse) {
		this.id = id;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.nationalite = nationalite;
		this.email = email;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getAge() {
		return dateDeNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public String getEmail() {
		return email;
	}

	public String getAdresse() {
		return adresse;
	}

	

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", date de naissance=" + dateDeNaissance + 
				", nationalite=" + nationalite + ", email=" + email + ", adresse=" + adresse+"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	

}
