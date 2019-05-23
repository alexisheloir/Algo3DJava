package Animaux;


/**
 * Voici la super menagerie
 *
 * @author  Marc Rouillet
 * @version 1.0
 */
public class Menagerie
{
    public Menagerie()
    {
    }
    
    private void presentoir(Animal Animal)
    {
        System.out.println("Nom:" + Animal.getNom() + " Prix: " + Animal.getPrix());
        Animal.parler();
        Animal.bouger();
        System.out.println();        
    }
    
    public void test1()
    {
        Chien chien = new Chien("Pattaron");
        presentoir(chien);
        
        Chat chat = new Chat("Mousty");
        presentoir(chat);
        
        Poisson poisson = new Poisson("Goup");
        presentoir(poisson);
    }
    
    public void test2()
    {
        Chien chien = new Chien("Pattaron");
        chien.setPrix(150);
        presentoir(chien);
        
        Chat chat = new Chat("Mousty");
        chat.setPrix(100);
        presentoir(chat);
        
        Poisson poisson = new Poisson("Goup");
        poisson.setPrix(75);
        presentoir(poisson);
    }
}
