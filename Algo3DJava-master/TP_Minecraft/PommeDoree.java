package TP_Minecraft;

import TP4.*;
import TP8.*;
import TP6.*;

/**
 * Cette classe permet de créer des pommes dorees.
 *
 * @author CASTEL Brandon
 * @version 28/03/19
 */
public class PommeDoree extends Objet
{
    Transformation m_transformationBase;
    Translation[][] MatrixTranslation = new Translation[17][12];
    Rotation[][] MatrixRotation = new Rotation[17][12];
    /**
     * Constructor for objects of class PomeDoree
     */
    public PommeDoree(Noeud _parent)
    {
        super(_parent);
        
        // On déclare un tableau binaire pour savoir où seront afficher les cubes.
        int[][] MatrixBinaire = 
        {{ 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
         { 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
         { 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
         { 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
         { 0, 0, 0, 0, 2, 2, 5, 2, 0, 0, 0, 0},
         { 0, 0, 2, 2, 3, 5, 5, 4, 2, 2, 0, 0},
         { 0, 2, 3, 3, 3, 3, 4, 3, 4, 4, 2, 0},
         { 0, 2, 3, 1, 1, 3, 3, 3, 3, 4, 2, 0},
         { 2, 3, 1, 1, 3, 3, 3, 3, 3, 4, 4, 2},
         { 2, 3, 1, 1, 3, 3, 3, 3, 3, 4, 4, 2},
         { 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 2},
         { 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 2},
         { 0, 2, 4, 3, 3, 3, 3, 4, 4, 4, 2, 0},
         { 0, 2, 4, 4, 4, 4, 4, 4, 4, 4, 2, 0},
         { 0, 0, 2, 4, 4, 2, 2, 4, 4, 2, 0, 0},
         { 0, 0, 0, 2, 2, 0, 0, 2, 2, 0, 0, 0},
         { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        
        // On instancie une transformation de base et quatre carrés qui seront déclarés
        // comme enfants (graphe de scène) de cette transformation.
        Vecteur3D transformationBase = new Vecteur3D(0.0f, 0.0f, 0.0f);
        m_transformationBase = new Translation(_parent, transformationBase);
        
        
        
        //On crée un tableau de translation avec i le numéro de ligne et j le numéro de colonne
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 17; j++) { 
                MatrixTranslation[j][i] = new Translation(_parent, new Vecteur3D((j*2)-25,(i*2)-11,-75.0f));
                MatrixRotation[j][i] = new Rotation(_parent, new Vecteur3D(0.0f, 38.0f, 0.0f), 1.0f);
                //Blanc
                if (MatrixBinaire[j][i] == 1)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(1.0f, 1.0f,1.0f));
                }
                
                //Noir
                 else if (MatrixBinaire[j][i] == 2)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.2f, 0.2f, 0.2f));
                }
                
                //Jaune
                else if (MatrixBinaire[j][i] == 3)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(1.0f, 1.0f,0f));
                }
                
                else if (MatrixBinaire[j][i] == 4)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.9f, 0.75f, 0f));
                }
                
                //Marron
                else if (MatrixBinaire[j][i] == 5)
                {
                    new CubeCouleur(MatrixTranslation[j][i], new Vecteur3D(0.71f, 0.47f, 0.13f));
                }                
            }
        }
        
        System.out.println(MatrixTranslation); 
    }
    
    public void dessine()
    {
        m_transformationBase.affiche();
    }

    
}
