package day3.exercice3;


public class Contact {
    private String prenom;
    private String nom;
    private String email;

    public Contact(String prenom, String nom, String email) {
        this.prenom =prenom;
        this.nom=nom;
        this.email=email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString() {
        return prenom + " " + nom + " " + email;
    }

}
