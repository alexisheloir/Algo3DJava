package Animaux;


/**
 * Chaque animal dans ce magasin est un animal. 
 *
 * @author Marc Rouillet
 * @version 1.0
 */
public abstract class Animal implements Comptoir
{
    private String nom;
    private double prix;
    
    public Animal(String nom)
    {        
        this.nom = nom;
    }
    
    public double getPrix()
    {
        return prix;
    }
    
    public void setPrix(double animalPrix)
    {
        prix = animalPrix ;
    }
        
    public abstract void parler();
    
    public void bouger()
    {
        System.out.println("Bouge...");
    }
    
    public String getNom()
    {
        return nom;
    }
}
