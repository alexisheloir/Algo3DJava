package TP3;


/**
 * Cette classe représente un vecteur à deux dimensions.
 * Elle est surtout utilisée pour définir les coordonnées
 * (u,v) de texture.
 * @author (Brandon Castel)
 * @version (0.0.0.1 alpha)
 */
public class Vecteur2D
{
    // instance variables - replace the example below with your own
    private float m_u=0.0f, m_v=0.0f; // m : variable membre

    /**
     * Constructeur par défaut initialise les deux
     * composants du vecteur à zéro.
     */
    public Vecteur2D()
    {
        // Initialisation des attributs à l'appel du construction
        m_u = 0.0f;
        m_v = 0.0f;
    }
    
    /**
     * Ce constructeur prend deux paramètres :
     * les valeurs qui seront assignées aux composantes
     * m_u et m_v de l'instance de Vecteur2D
     * 
     * @param _u la valeur de la composante u du vecteur
     * @param _v la valeur de la composante v du vecteur
     */
    
    public Vecteur2D(float _u, float _v)
    {
        m_u = _u;
        m_v = _v;
    }

    /**
     * Cette méthode ajoute au vecteur courant le
     * vecteur passé en paramètre. Les composantes du
     * vecteur passé en paramètre sont ajoutées aux
     * composantes du vecteur représenté par l'instance courante.
     * 
     * @param _vec vecteur à ajouter à cette instance
     */
    
    public void add(Vecteur2D _vec)
    {
        m_u += _vec.getU();
        m_v += _vec.getV();
    }
    
    /**
     * Accesseur pour la composante u
     * @return la valeur de la composante u
     */
    
    public float getU()
    {
        return m_u;
    }
    
    /**
     * Accesseur pour la composante v
     * @return la valeur de la composante v
     */
    
    public float getV()
    {
        return m_v;
    }
    
    /**
     * mutateur pour la composante u
     * @param _u la valeur de la composante u
     */
    public void setU(float _u)
    {
        this.m_u = _u;
    }
    
    /**
     * mutateur pour la composante v
     * @param _u la valeur de la composante v
     */
    public void setV(float _v)
    {
        this.m_v = _v;
    }
    
    /**
     * Cette méthode retourne la norme du vecteur, c'est à
     * dire la racine carrée de la somme des carrés des deux
     * composantes du vecteur
  
     * @return    La norme du vecteur
     */
    public float getMagnitude()
    {
       /*
        * La méthode <b>sqrt</b> du package Math retourne un
        * double : on la transtype en float.
        */
       return(float)Math.sqrt(m_u*m_u + m_v*m_v);
    }
}
