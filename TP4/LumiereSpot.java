package TP4;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;


/**
 * La classe spot représente une lumière ponctuelle qui
 * diffuse un faisceau de lumière selon une direction
 * et un angle de diffusion (GL_SPOT_CUTOFF). Un troisième paramètre
 * (GL_SPOT_EXPONENT) détermine l'atténuation de l'intensité lumineuse
 * lorsque la direction des rayons s'écarte de la direction principale
 * (GL_SPOT_DIRECTION)
 *
 * @author Alexis Heloir
 * @version 19/03/2019
 */
public class LumiereSpot extends LumierePonctuelle
{
    //La direction principale de la lumière spot (tableau de réels, dimension 1)
    float[] m_spotDirection = {0.0f, 0.0f, -1.0f};
    
    //L'angle de diffusion de la lumière spot
    //(réel compris entre 0 (distribution uniforme) et 128 (focus maximal) )
    float m_spotCutoff = 0.0f;
    
    //L'atténuation par rapport à la direction principale
    //(réel entre 0 et 90 => Cône de lumière ou 180 => Distribution uniforme)
    float m_spotExponent = 90.0f;    

    /**
     * Constructeur de la classe LumiereSpot
     * @param _vecteurAmbiant composante ambiante de la lumière
     * @param _vecteurDiffus composante diffus de la lumière
     * @param _vecteurSpeculaire composante speculaire de la lumière
     * @param _position vectur donnant la direction des rayons émis
     * @param _spotDirection donnant la direction principale de la lumière
     * @param _spotCutoff donnant l'angle de la diffusion de la lumière
     * @param _spotExponent donnant l'atténuation par rapport à la direction principale
     */
    public LumiereSpot(Vecteur3D _vecteurAmbiant, Vecteur3D _vecteurDiffus, 
                       Vecteur3D _vecteurSpeculaire, Vecteur3D _position, Vecteur3D _spotDirection, float _spotCutoff, float _spotExponent)
                       {
        super(_vecteurAmbiant, _vecteurDiffus, _vecteurSpeculaire, _position);
        m_spotDirection[0] = _spotDirection.getX();
        m_spotDirection[1] = _spotDirection.getY();
        m_spotDirection[3] = -1.0f;
        
        m_spotCutoff = _spotCutoff;
        
        m_spotExponent = _spotExponent;       
        
    }

    /**
     * Constructeur sans paramètre de la classe LumiereSpot
     */
    public LumiereSpot()
    {
        m_spotDirection[0] = 0.0f;
        m_spotDirection[1] = 0.0f;
        m_spotDirection[3] = -1.0f;
        
        m_spotCutoff = 0.0f;
        
        m_spotExponent = 90.0f;    
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void initialise()
    {
        super.initialise();
        
        FloatBuffer buffDirection = BufferUtils.createFloatBuffer(4).put(m_spotDirection);
        buffDirection.position(0);

        GL11.glLight(m_currentLight, GL11.GL_AMBIENT, buffDirection);        
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_CUTOFF, m_spotCutoff);        
        GL11.glLightf(m_currentLight, GL11.GL_SPOT_EXPONENT, m_spotExponent);
    }
}
