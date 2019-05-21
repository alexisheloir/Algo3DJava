package TP8;

import org.lwjgl.opengl.GL11;

import TP6.*;
import TP4.*;

/**
 * Write a description of class CubeTexture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CubeTexture extends CubeTextureFlat
{

    private Materiau m_materiau;
        
    /**
     * Constructor for objects of class CubeTexture
     */
    public CubeTexture(Noeud _parent, String _texturePath, Materiau _materiau)
    {
        super(_parent, _texturePath);        
        m_materiau = _materiau;
    }
    
    /**
     * Constructor for objects of class CubeTexture
     */
    public CubeTexture(Noeud _parent, String _texturePath)
    {
        super(_parent, _texturePath);        
        m_materiau = new Materiau(0.0f,0.0f,0.0f,0.7f,0.7f,0.7f,0.7f,0.6f,0.6f,.25f);
    }
    
    /**
     * Constructor for objects of class CubeTexture
     */
    public CubeTexture(Noeud _parent)
    {
        super(_parent);        
        m_materiau = new Materiau(0.0f,0.0f,0.0f,0.7f,0.7f,0.7f,0.7f,0.6f,0.6f,.25f);
    }
    
    /**
     * Constructor for objects of class CubeTexture
     */
    public CubeTexture(Noeud _parent, Vecteur3D _couleurDiffuse)
    {
        super(_parent);        
        m_materiau = new Materiau(0.0f,0.0f,0.0f,_couleurDiffuse.getX(),_couleurDiffuse.getY(),_couleurDiffuse.getZ(),0.7f,0.6f,0.6f,.25f);
    }
    

    /**
     * Cette m�thode utilise une suite d'instructions OpenGL perettant d'afficher un cube.
     * Vous trouverez ces instructions dans la clase OpenGL en vrac du package TP2.
     */
    public void dessine(){
        
        
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT, m_materiau.getAmbient());
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_DIFFUSE, m_materiau.getDiff());
        GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, m_materiau.getSpec());
        GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS,  m_materiau.getShinisess()*128.0f); 
        super.dessine();
    }

}
