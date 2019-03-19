package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * La classe lumière ponctuelle représente une source de lumière ponctuelle.
 * Elle est définie par un point dans l'espace à partir duquel vont irradier
 * les rayons émis par cette source ponctuelle.
 * @author Alexis Heloir
 * @version 19/03/2019
 */
public class LumierePonctuelle extends Lumiere
{
    // tableau de float représentant l'origine de la source lumineuse (appelé m_position)
    //La quatrième valeur du tableau vaut 1 : cela signifie que ce tableau de réels sera interprété en tant que paramètre de lumière
    //ponctuelle lors de la phase d'initialisation.
    private float[] m_position = {0.0f, 0.0f, 0.0f, 1.0f};

    /**
     * Constructeur de la classe LumierePonctuelle, il prend quatre arguments
     * @param _vecteurAmbiant composante ambiante de la lumière
     * @param _vecteurDiffus composante diffus de la lumière
     * @param _vecteurSpeculaire composante speculaire de la lumière
     * @param _position vectur donnant la direction des rayons émis.
     */
    public LumierePonctuelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _position)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_position[0] = _position.getX();
        m_position[1] = _position.getY();
        m_position[2] = _position.getZ();
        m_position[3] = 1.0f;      
    }
    
    /**
     * Constructeur sans paramètre pour la classe
     */
    public LumierePonctuelle()
    {
        m_position[0] = 0.0f;
        m_position[1] = 0.0f;
        m_position[2] = 0.0f;
        m_position[3] = 0.0f;
    }
    
    /**
     * On initialise la valeur du vecteur de position pour cette instance de classe 
     * de lumière ponctuelle après avoir appelé la méthode d'initialisation de la 
     * classe parente     */
     
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffPosition = BufferUtils.createFloatBuffer(4).put(m_position);
        buffPosition.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffPosition);        
    }
    
}
