package day3.exercice4;

public class Employe {
    private int numero;
    private String nom;
    private String adresse;
    private String telephone;
    private double salaire;

    //Constructeurs
    public Employe(int numero,String nom, String adresse, String telephone, double salaire){
        this.numero = numero;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.salaire = salaire;
    }
    public Employe(){

    }
    //méthodes d'accès aux variables d'instance
    public int getNumero(){
        return numero;
    }
    public String getNom(){
        return nom;
    }
    public String getAdresse(){
        return adresse;
    }
    public String getTelephone(){
        return telephone;
    }
    public double getSalaire(){
        return salaire;
    }
    //modifieurs
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setSalaire(double salaire){
        this.salaire = salaire;
    }

    //Autres méthodes
    public void afficher(){
        System.out.println("Numéro : " + numero);
        System.out.println("Nom : " + nom);
        System.out.println("Adresse : " + adresse);
        System.out.println("Téléphone : " + telephone);
        System.out.println("Salaire : " + salaire);
    }

}
