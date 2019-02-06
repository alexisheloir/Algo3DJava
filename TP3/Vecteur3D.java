package TP3;

/**
 * Cette classe permet de representer un vecteur a deux dimensions.
 * Elle est surtout utilisee pour definir les coordonnees 
 * (u,v,w) de forme.
 * @author (Marc Rouillet)
 * @version (0.0.0.1 alpha) 
*/
public class Vecteur3D
{
   // instance variables - replace the example below with your own
   float m_u,m_v,m_w;
    
   /**
    * Constructeur par défaut des objets de la classe Vecteur3D
   */
   public Vecteur3D()
   {
    m_u = 0.0f;
    m_v = 0.0f;
    m_w = 0.0f; 
   }
    
    
   /**
    * Constructeur avec paramètre des objets de la classe Vecteur3D
   */
   public Vecteur3D(float _u, float _v, float _w)
   {   
     m_u = _u;
     m_v = _v;
     m_w = _w; 
    }
   
   /**
    * Accesseur de la valeur U
    * Retourne la valeur U
    */
   public float getU()
   {
    return m_u;
   }
    
   
  /**
   * Accesseur de la valeur V
   * Retourne la valeur V
   */
  public float getV()
   {
    return m_v;
   }
    
   /**
    * Accesseur de la valeur W
    * Retourne la valeur W
    */public float getW()
   {
    return m_w;
   }
    
}