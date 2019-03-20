package TP5;


/**
 * Write a description of class Objet here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Objet extends Noeud
{
    public Objet(Noeud _parent)
    {
        super(_parent);
    }

    public abstract void dessiner();   
    
    public void afficher()
    {
        /*
         *Ici on dessine l'objet, même si on ne sais pas comment le dessiner. 
         */
        dessiner();
        
        /*
         * Ici on dessine le contenu de tous les éléments de cette classe, plus le contenu des noeuds enfants.
         * Il s'agit de parcourir le contenu du Vecteur contenant les enfants et d'appeler la méthode afficher()
         * pour chaque enfant référencé dans le vecteur
         */
        for (int i=0; i<m_enfants.size(); i++)
        {
            m_enfants.get(i).afficher();
        }
    }
}
