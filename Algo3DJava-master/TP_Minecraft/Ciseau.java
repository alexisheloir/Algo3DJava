package TP_Minecraft;

import TP4.*;
import TP8.*;
import TP6.*;

/**
 * Cette classe permet de créer des ciseaux.
 *
 * @author CASTEL Brandon
 * @version 28/03/19
 */
public class Ciseau extends Objet
{
    Transformation m_transformationBase;
    Translation[][] MatrixTranslation = new Translation[12][12];
    
    /**
     * Constructor for objects of class Ciseau
     */
    public Ciseau(Noeud _parent)
    {
        super(_parent);
        
        // On déclare un tableau binaire pour savoir où seront afficher les cubes.
        int[][] MatrixBinaire = 
        {{ 0, 0, 0, 0, 0, 0, 7, 7, 8, 0, 0, 0},
         { 0, 0, 0, 0, 0, 7, 7, 3, 2, 1, 0, 0},
         { 0, 0, 0, 0, 7, 7, 3, 2, 1, 0, 1, 0},
         { 0, 0, 0, 7, 7, 3, 2, 1, 0, 1, 2, 8},
         { 0, 0, 7, 6, 8, 2, 1, 0, 1, 2, 3, 8},
         { 0, 0, 7, 6, 8, 0, 0, 1, 2, 3, 7, 8},
         { 0, 7, 6, 8, 0, 0, 0, 2, 3, 7, 8, 0},
         { 0, 7, 6, 8, 0, 0, 7, 8, 7, 8, 0, 0},
         { 0, 4, 5, 0, 7, 7, 6, 6, 8, 0, 0, 0},
         { 3, 0, 0, 4, 6, 6, 7, 7, 0, 0, 0, 0},
         { 3, 0, 0, 5, 8, 8, 0, 0, 0, 0, 0, 0},
         { 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        // On instancie une transformation de base et quatre carrés qui seront déclarés
        // comme enfants (graphe de scène) de cette transformation.
        Vecteur3D transformationBase = new Vecteur3D(0.0f, 0.0f, 0.0f);
        m_transformationBase = new Translation(_parent, transformationBase);
        
        //On crée un tableau de translation avec i le numéro de ligne et j le numéro de colonne
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                MatrixTranslation[j][i] = new Translation(_parent, new Vecteur3D((j*2)-11,(i*2)-11,0.0f));
                if (MatrixBinaire[j][i] == 1)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(1.0f, 1.0f,1.0f));
                }
                
                //Gris
                else if (MatrixBinaire[j][i] == 2)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.8f, 0.8f,0.8f));
                }
                
                else if (MatrixBinaire[j][i] == 3)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.6f, 0.6f,0.6f));
                }
                
                else if (MatrixBinaire[j][i] == 4)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.4f, 0.4f,0.4f));
                }
                
                else if (MatrixBinaire[j][i] == 5)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.2f, 0.2f,0.2f));
                }
                
                //Marron
                 else if (MatrixBinaire[j][i] == 6)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.8f, 0.4f,0.12f));
                }
                
                 else if (MatrixBinaire[j][i] == 7)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.6f, 0.33f,0.1f));
                }
                
                 else if (MatrixBinaire[j][i] == 8)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.3f, 0.18f,0.06f));
                }
            }
        }
        
        System.out.println(MatrixTranslation);
        
        //On crée notre ciseau
        // CubeCreator cube0 = new CubeCreator(this, -8.0f, 0.0f, -30.0f);
        // CubeCreator cube1 = new CubeCreator(this, -6.0f, 0.0f, -30.0f);
        // CubeCreator cube2 = new CubeCreator(this, -6.0f, 2.0f, -30.0f);
            
    }
    
    public Ciseau(Noeud _parent, Vecteur3D _axe, float _angle, float _rotationAngle, int _intervalleEnMS ) 
    {
        super(_parent);
        Transformation anime1D = new AnimeCiseauD(_parent, _axe, _angle, _rotationAngle, _intervalleEnMS);
        Transformation anime1G = new AnimeCiseauG(_parent, _axe, _angle, _rotationAngle, _intervalleEnMS);
        CiseauD CiseauD1 = new CiseauD(anime1D);
        CiseauG CiseauG1 = new CiseauG(anime1G);
        
        // On instancie une transformation de base et quatre carrés qui seront déclarés
        // comme enfants (graphe de scène) de cette transformation.
        Vecteur3D transformationBase = new Vecteur3D(0.0f, 0.0f, 0.0f);
        m_transformationBase = new Translation(_parent, transformationBase);
    }
    
    public void dessine()
    {
        m_transformationBase.affiche();
    }
    

}
