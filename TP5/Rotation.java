package TP5;

import TP4.Vecteur3D;
import org.lwjgl.opengl.GL11;


/**
 * Write a description of class Rotate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rotation extends Transformation
{
    //Ce vecteur stocke les coordonnées de rotate
    private Vecteur3D m_axe;
    private float m_angle;
    
    /**
     * Constructeur par défaut de la classe Rotation
     * @param _parent le noeud déclaré comme parent de l'instance courante (this)
     * @param _coordonnees les coordonnées de la rotation à appliquer
     * @param _angle l'angle de la rotation
     */
    public Rotation(Noeud _parent, Vecteur3D _axe, float _angle)
    {
        super(_parent);
        m_angle = _angle;
        m_axe = _axe;
    }
    
    /**
     * Implémentation de la méthode transforme sur la classe Rotation. Rotatef est une fonction qui prend en entrée l'angle et les trois 
     * coordonnées du Vecteur3D axe
     */
    public void transforme()
    {
        GL11.glRotatef(m_angle, m_axe.getX(), m_axe.getY(), m_axe.getZ());
    }
}
