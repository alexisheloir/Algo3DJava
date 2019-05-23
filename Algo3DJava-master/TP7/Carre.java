package TP7;

import TP6.*;
import TP4.*;
/**
 * Write a description of class Carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Carre extends Objet
{
    Transformation m_transformationBase;
    
    /**
     * La méthode dessine dessine les quatres carrés que nous avons instancié dans le constructeur
     */
    public Carre(Noeud _parent)
    {
        super(_parent);
        
        // On instancie une trasnformation de base et quatre carrés qui seront déclarés
        // comme enfants (graphe de scène) de cette transformation.
        Vecteur3D transformationBase = new Vecteur3D(0.0f, 0.0f, 0.0f);
        m_transformationBase = new Translation(_parent, transformationBase);
        
        
        //Maintenant on dessine nos cubes
        Vecteur3D vecTranslationCube1 = new Vecteur3D(-2.0f, -2.0f, 0.0f);
        Translation translationCube1 = new Translation(m_transformationBase, vecTranslationCube1);
        CubeTexture premierCube = new CubeTexture(translationCube1);
        
        Vecteur3D vecTranslationCube2 = new Vecteur3D(-2.0f, -2.0f, 0.0f);
        Translation translationCube2 = new Translation(m_transformationBase, vecTranslationCube2);
        CubeTexture deuxiemeCube = new CubeTexture(translationCube2);
        
        Vecteur3D vecTranslationCube3 = new Vecteur3D(-2.0f, -2.0f, 0.0f);
        Translation translationCube3 = new Translation(m_transformationBase, vecTranslationCube3);
        CubeTexture troisiemeCube = new CubeTexture(translationCube3);
        
        Vecteur3D vecTranslationCube4 = new Vecteur3D(-2.0f, -2.0f, 0.0f);
        Translation translationCube4 = new Translation(m_transformationBase, vecTranslationCube4);
        CubeTexture quatriemeCube = new CubeTexture(translationCube4);
        
    }

   public void dessine(){
       //Ici on dessine quelque chose. Le quelque chose en question est instancié dans le constructeur
       //de la classe carré.
       m_transformationBase.affiche();
   }
}
