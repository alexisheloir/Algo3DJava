package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Une lumière directionnelle représente une source de lumière
 * située à l'infini : tous les rayons émis par cette lumière sont parallèles
 * et leur direction est donnée par un vecteur.
 * @author Alexis Heloir
 * @version 19/03/2019
 */
public class LumiereDirectionelle extends Lumiere
{

    private float[] m_direction = {0.0f,0.0f,0.0f,0.0f};
    
    /**
     * Constructeur de la classe LumiereDirectionnelle, il prend quatre arguments
     * @param _vecteurAmbiant composante ambiante de la lumière
     * @param _vecteurDiffus composante diffus de la lumière
     * @param _vecteurSpeculaire composante speculaire de la lumière
     * @param _direction direction de la lumière. 
     */
    public LumiereDirectionelle(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                             Vecteur3D _vecteurSpeculaire, Vecteur3D _direction)
    {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire);
        m_direction[0] = _direction.getX();
        m_direction[1] = _direction.getY();
        m_direction[2] = _direction.getZ();
        m_direction[3] = 0.0f; //La dernière valeur du tableau du réel représentant la position est
                                // égale à 0 pour indiquer que la lumière est directionnelle (c'est dans la doc
    }
    
    /**
     * Constructeur sans paramètre pour la classe LumièreDirectionelle
     * Il place une lumière directionelle qui simule une lumière d'un bô soleil de zénith. 
     */
    public LumiereDirectionelle()
    {
        m_direction[0] = 0.0f;
        m_direction[1] = 0.0f;
        m_direction[2] = 0.0f;
        m_direction[3] = 0.0f;
    }
    
    /**
     * On initialise la valeur du vecteur de direction pour cette instance de classe 
     * de lumière directionelle après avoir appelé la méthode d'initialisation de la 
     * classe parente
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_direction);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);
        
    }

}
