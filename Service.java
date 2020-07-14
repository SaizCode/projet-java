interface IService{

    public void affiche();
}


public class Service implements IService {

    private static int compt = 0;
    private int id = 0;
    private String libelle;

    private final static int  TAB = 200;

    private Service[] services;

    private Employe[] employes;


    public Service(String libelle){
        
        Service.compt += 1;
        this.id = Service.compt;
        this.libelle = String.valueOf(Service.compt);
    }

    public void affiche(){

        System.out.println("id service :" + this.id);
        System.out.println("libelle service:" + this.libelle);
    }

    public boolean quitter(){

        return true;
    }

    public void AjouterService(Service service){

        if (this.id <= TAB) {

            services[TAB - 1] = service;

        } else {

            System.out.println("Pas plus de " + TAB + " services");
        }
        
       

    }

    public void listerServices(){

        for(Service service : services){
            
            service.affiche();
        }
    }

    public void AjouterEmploye(Employe emp){

        if (this.id <= TAB) {

            employes[TAB - 1] = emp;

        } else {
            
            System.out.println("Pas plus de " + TAB + " empleyes");
        }
        
        employes[TAB - 1] = emp;

    }

    public void listerEmployes(){

        for(Employe e : employes){
            
            e.affiche();
        }
    }


    public void listerJournalier(){

        for(Employe e : employes){
            
            if(e instanceof Journalier){

                e.affiche();
            }
        }
    }

    public void listerEmbauche(){

        for(Employe e : employes){
            
            if(e instanceof Embauche){

                e.affiche();
            }
        }
    }


}

abstract class Employe implements IService{

    private static int compt = 0;
    protected int id;
    protected String nomComplet;

    public Employe(String nomComplet){

        Employe.compt += 1;
        this.id = Employe.compt;
        this.nomComplet = nomComplet;
    }
    
    public void affiche(){

        System.out.println("id employe :" + this.id);
        System.out.println("nom employe:" + this.nomComplet);
    }

    abstract public boolean isEmbauche();
    abstract public boolean isJournalier();

}

class Embauche extends Employe{

    protected double salaire;
    private String dateEmb = "";

    public Embauche(String nomComplet, double salaire, String dateEmb){

        super(nomComplet);
        this.salaire = salaire;
        this.dateEmb = dateEmb;
    }

    public boolean isEmbauche(){

        return true;
    }

    public boolean isJournalier(){
        
        return false;
    }

    public void affiche(){

        System.out.println("id employe :" + this.id);
        System.out.println("Nom employe:" + this.nomComplet);
        System.out.println("Salaire employe:" + this.salaire);
        System.out.println("date embauche:" + this.dateEmb);
    }

}

class Journalier extends Employe{

    private int duree = 2;
    private int forfait;

    public Journalier(String nomComplet, int duree, int forfait) {
        
        super(nomComplet);
        this.duree = duree;
        this.forfait = forfait;

    }

    public boolean isJournalier(){

        return true;
    }

    public boolean isEmbauche(){
        
        return false;
    }

    public void affiche(){
        System.out.println("id employe :" + this.id);
        System.out.println("Nom employe:" + this.nomComplet);
        System.out.println("Salaire employe:" + this.duree);
        System.out.println("date embauche:" + this.forfait);
    }


}


