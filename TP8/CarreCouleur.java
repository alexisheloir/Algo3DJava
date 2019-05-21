package TP8;

import TP6.*;

import TP4.Vecteur3D;
import java.util.Vector;

import org.lwjgl.opengl.GL11;


/**
 * Write a description of class carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarreCouleur extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;
    Vector<Vecteur3D> m_tableauDeVecteurs;
    
    int m_DisplayListIndex;
    
    /**
     * Constructor for objects of class carré
     */
    public CarreCouleur(Noeud _parent)
    {
        super(_parent);
        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);
        
        for (int i=-25; i<=25; i+=2){
            for (int j=-25; j<=25; j+=2){
                Vecteur3D vecTranslationCube = new Vecteur3D(i,j,0.0f);
                Translation translationCube = new Translation(m_transformationBase,vecTranslationCube);
                CubeCouleur premierCube = new CubeCouleur(translationCube);
            }
        }

        m_DisplayListIndex = GL11.glGenLists(1);
        GL11.glNewList(m_DisplayListIndex, GL11.GL_COMPILE);
        m_transformationBase.affiche();
        GL11.glEndList();
        
        // // maintenant, on construit nos quatre cubes;
        // Vecteur3D vecTranslationCube1 = new Vecteur3D(-2.0f,-2.0f,0.0f);
        // Translation translationCube1 = new Translation(m_transformationBase,vecTranslationCube1);
        // CubeTexture premierCube = new CubeTexture(translationCube1);
        
        // Vecteur3D vecTranslationCube2 = new Vecteur3D(-2.0f,2.0f,0.0f);
        // Translation translationCube2 = new Translation(m_transformationBase,vecTranslationCube2);
        // CubeTexture secondCube = new CubeTexture(translationCube2);

        // Vecteur3D vecTranslationCube3 = new Vecteur3D(2.0f,2.0f,0.0f);
        // Translation translationCube3 = new Translation(m_transformationBase,vecTranslationCube3);
        // CubeTexture troisièmeCube = new CubeTexture(translationCube3);

        // Vecteur3D vecTranslationCube4 = new Vecteur3D(2.0f,-2.0f,0.0f);
        // Translation translationCube4 = new Translation(m_transformationBase,vecTranslationCube4);
        // CubeTexture quatrièmeCube = new CubeTexture(translationCube4);
                
    }

    /**
     * La méthode dessine dessine les quatre carrés que nous avons in
     * instancié dans le constructeur
     *
     */
    public void dessine()
    {
        // ici il faut dessiner quelquechose. Le quelque chose en question est intancié 
        // dans le construteur de la classe carré 
        //m_transformationBase.affiche();
        GL11.glCallList(m_DisplayListIndex);
    }   
    
}
