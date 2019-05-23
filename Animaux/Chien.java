package Animaux;


/**
 * Un chien est un animal.
 *
 * @author Marc Rouillet
 * @version 1.0
 */
public class Chien extends Animal
{
    
    public Chien( String nom)
    {
      super(nom);
    }
    
    public void parler()
    {
        System.out.println("Wouaf!");
    }    
}
