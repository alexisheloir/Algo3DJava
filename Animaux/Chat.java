package Animaux;


/**
 * Un chat est un animal.
 *
 * @author Marc Rouillet
 * @version 1.0
 */
public class Chat extends Animal
{
    public Chat(String nom)
    {
        super(nom);
    }
    
    public void parler()
    {
        System.out.println("Miaou!");
    }
    
    
}
