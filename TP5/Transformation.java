package TP5;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;



/**
 *La classe Transformation permet de factoriser le code dommun aux classes filles Translation, Rotation et Echelle.
 *Les fonctions communes à ses transformations sont principalement l'empilement et le dépilement de matrices
 * @author Alexis Heloir
 * @version 20/03/2019
 */
public abstract class Transformation extends Noeud
{
    /**
    * Constructeur de la classe Transformation
    */
    public Transformation(Noeud _parent)
    {
        super(_parent);
    }
    
    public void afficher()
    {
        //On empile la matrice courante
        GL11.glPushMatrix();
        
        //On exécute la transformation de la classe.
        //Même si on ne sait pas encore de quelle transformation il s'agit
        
        
        //On dessine le contenu de tous les élements de cette classe 
        //Plus le contenu des noeuds enfants 
        //Il s'agit de parcourir le contenu du Vecteur contenant les enfants
        //Et d'appeler la méthode afficher() pour chaque enfant référencé dans le vecteur        
        for (int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }
        
        //On dépile la matrice courante
        GL11.glPopMatrix();
    }    
}
