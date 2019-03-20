package TP5;
import java.util.Vector;


/**
 * La classe noeud est une classe abstraite en amont de la hiérarchie de classe de notre graph de scene. 
 * Sa fonction principale est de porter la structure d'un arbre du graph de scène.
 * Un noeud peut avoir plusieurs enfants et a un seul parent.
 * Seul le noeud d'origine n'a pas de parent.
 *
 * @author Alexis Heloir
 * @version 20/03/2019
 */
public abstract class Noeud
{
    //Un noeud peut avoir plusieurs enfants
    Vector<Noeud> m_enfants;
    
    //Un oeud a un seul parent
    Noeud m_parent;    
    
    
    /**
     * Le constructeur par défaut de la classe Noeud
     */
    public Noeud(Noeud _parent)
    {
        m_parent = _parent;
        _parent.ajouterEnfant(this); //Le parent l'ajoute à sa liste d'enfants
    }
    
    /**
     * Ajoute le Noeud _enfant passé en paramètre à la liste d'enfant en attribut.
     * @param _enfant le noeud enfant à rajouter à la liste d'enfant m_enfants.
     */
    public void ajouterEnfant(Noeud _enfant)
    {
        m_enfants.add(_enfant);
    }
    
    /**
     * Méthode abstraite en charge d'appeler les instruction openGL
     * permettant d'afficher le noeud (même si on ne sait pas encore ce qu'il représente)
     */
    public abstract void afficher();    
}
