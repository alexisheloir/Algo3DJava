package TP_Minecraft;

import TP4.Vecteur3D;

import TP6.*;
import TP7.*;
/**
 * Une rotation dont l'angle de rotation est dynamique.
 * la valur de rotation déclarée dans la classe parente (m_angle)
 * est appliquée toutes les m_intervalleEnMS millisecondes.
 * Cette classe repose sur le singleton Horloge pour gérer sa temporalité
 *
 * @author Alexis Heloir
 * @version 2019/03/26
 */
public class AnimeCiseauG extends Rotation
{

    private int m_intervalleEnMS; // m_angle est appliqué toutes les m_intervalleEnMS sillisecondes
    private Horloge_ciseau m_horloge; // singleton utilisé pour récupérer le temps passé entre deux appels à transforme()
    private float m_angleInitial; // utilisé pour sauvegarder la valeur angulaire initiale à appliquer
    private float m_rotationAngle; // Angle de rotation pendant l'animation
    
    /**
     * Le constructeur appelle celui de la classe parente avec un paramètre en plus : l'intevalle en 
     * millisecondes lors duquel l'angle m_angleInitial sera appliqué
     * @param _intervalleEmMS l'intervalle pendant lequel l'angle m_angleInitial sera appliqué
     */
    public AnimeCiseauG(Noeud _parent, Vecteur3D _axe, float _angle, float _rotationAngle, int _intervalleEnMS)
    {
        super(_parent, _axe, _angle);
        m_intervalleEnMS = _intervalleEnMS;
        m_horloge = Horloge_ciseau.getInstance();
        m_angleInitial = m_angle;
        m_rotationAngle = _rotationAngle;
    }

    /**
     * Cette classe met à jour l'angle m_angle à partir de sa valeur initiale et du temps 
     * écoulé depuis le dernier tick d'horloge. Elle appelle ensuite la transformation de 
     * la classe parente
     */
    public void transforme(){
        long iterateur = System.currentTimeMillis();
        m_angle += -Math.cos(Math.toRadians(iterateur))*m_rotationAngle;
        System.out.println("i : " + Math.cos(Math.toRadians(iterateur))*10);
        System.out.println("m_angle : " + m_angle);

        super.transforme();
    }
    
}