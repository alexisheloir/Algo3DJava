package TP6;

import TP4.*;

/**
 * Write a description of class CubeCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CubeCreator
{
    public CubeCreator(Noeud _parent, float x, float y, float z){
        Vecteur3D vecteur = new Vecteur3D(x,y,z);
        Translation translationCube = new Translation(_parent, vecteur);
        CubeTexture cube = new CubeTexture(translationCube);
    }
}
