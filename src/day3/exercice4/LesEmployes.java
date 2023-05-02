package day3.exercice4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
public class LesEmployes {
    private BufferedReader bfr;

    //Constructeurs
    public LesEmployes(){
        bfr=null;
    }
    public LesEmployes(String nomFichier){
        try{
            //Création d'un flux pour le fichier texte
            //le nom du fichier est passé en argument
            FileReader in = new FileReader(nomFichier);
            bfr= new BufferedReader(in);
        }catch (IOException e){
            System.out.println("Pb entrée sortie :" + e.getMessage());
        }
    }

    // Transforme une chaine en un objet de type Employe
    //format de la chaine : 1*BARBE*Rue des Vignes Paris*0123546789*10000
    public Employe fabriqueEmploye(String chaine){
        Employe emp=null;
        StringTokenizer st = new StringTokenizer(chaine, "*");
        if(st.countTokens()==5){
            int code = Integer.parseInt(st.nextToken());
            String nom = st.nextToken();
            String adresse= st.nextToken();
            String telephone = st.nextToken();
            double salaire= Double.parseDouble(st.nextToken());
            emp = new Employe(code,nom,adresse,telephone,salaire);
        }
        return emp;
    }
    //Transformer le fichier en une collection d'employés
    public List<Employe> fabriqueVecteur(){
        String chaine;
        Employe emp;
        List<Employe> employes = new Vector<Employe>();
        try{
            do{
                chaine = bfr.readLine();
                if(chaine!=null){
                    emp=fabriqueEmploye(chaine);
                    employes.add(emp);
                }
            }while(chaine!=null);
        }catch(IOException e){
            System.out.println("Problème de lecture : " +e.getMessage());
        }
        return employes;
    }
    //Transforme le fichier en une chaine de caractères formée de plusieurs lignes
    public String fabriqueChaine(){
        StringBuffer chainebf=new StringBuffer();
        String chaine;
        try{
            do{
                chaine= bfr.readLine() ;
                if(chaine!=null){
                    chainebf.append(chaine +"\n");
                }
            }while(chaine!=null);
        }catch(IOException e){
            System.out.println("Problème de lecture : " +e.getMessage());

        }
        return chainebf.toString();
    }

}
