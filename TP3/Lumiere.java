package TP3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Classe lumiere. Cette classe est abstraite.
 * Elle sert à factoriser les attributs communs à toutes les lumieres :
 * la composante ambiente, la composante speculaire et la composante diffuse.
 *
 * @author (Marc Rouillet)
 * @version (06/02/2019)
 */
public abstract class Lumiere
{
    private float[] m_ambientComponent = {0.0f,0.0f,0.0f,0.0f};
    private float[] m_diffuseComponent = {0.0f,0.0f,0.0f,0.0f};
    private float[] m_specularComponent = {0.0f,0.0f,0.0f,0.0f};
    
    protected int m_currentLight = -1;
    
    private static int m_nextFreeLight = GL11.GL_LIGHT0;
    
   /**
    * Ce constructeur assigne une parmi les 8 lumieres
    * disponnibles dans OpenGL 1.1. le compteur m_currentLight
    * est statique, c'est a dire que toutes les instances de
    * la classe lumiere partagent la valeur de m_currentLight.
    * Chaque instance connait donc le nombre de lumieres deja 
    * instanciees. 
    */ 
   public Lumiere(){
        m_currentLight = m_nextFreeLight;
        m_nextFreeLight ++;
    }
   
    /**
     * Constructeur de la classe lumiere prenant en paramatres trois
     * instances de Vecteur3D pour les composantes ambientes, diffuses
     * et speculaires de la lumiere.
     * 
     * @param _vecteurAmbient la composante ambiente de la lumiere (Vecteur3D)
     * @param _vecteurDiffus la composante diffuse de la lumiere (Vecteur3D)
     * @param _vecteurSpeculaire la composante speculaire de la lumiere (Vecteur3D)
     */
    public Lumiere(Vecteur3D _vecteurAmbient, Vecteur3D _vecteurDiffus, Vecteur3D _vecteurSpeculaire)
    {
        this(); //Appeler le constructeur de la classe, mais sans argument.
        
        m_ambientComponent[0] = _vecteurAmbient.getU();
        m_ambientComponent[1] = _vecteurAmbient.getV();
        m_ambientComponent[2] = _vecteurAmbient.getW();
        m_ambientComponent[3] = 1.0f;
        
        m_diffuseComponent[0] = _vecteurDiffus.getU();
        m_diffuseComponent[1] = _vecteurDiffus.getV();
        m_diffuseComponent[2] = _vecteurDiffus.getW();
        m_diffuseComponent[3] = 1.0f;
        
        m_specularComponent[0] = _vecteurSpeculaire.getU();
        m_specularComponent[1] = _vecteurSpeculaire.getV();
        m_specularComponent[2] = _vecteurSpeculaire.getW();
        m_specularComponent[3] = 1.0f;       
    }    
    
    /**
     * Initialisation de la lumiere courante
     */
   public void initialise()
   {
       FloatBuffer buffAmbient = BufferUtils.createFloatBuffer(4).put(m_ambientComponent);
        buffAmbient.position(0);
                
       FloatBuffer buffDiffuse = BufferUtils.createFloatBuffer(4).put(m_diffuseComponent);
        buffDiffuse.position(0);       
        
       FloatBuffer buffSpecular = BufferUtils.createFloatBuffer(4).put(m_specularComponent);
        buffSpecular.position(0);
        
                
       GL11.glLight(GL11.GL_LIGHT1, GL11.GL_AMBIENT, buffAmbient);
       GL11.glLight(GL11.GL_LIGHT1, GL11.GL_DIFFUSE, buffDiffuse);
       GL11.glLight(GL11.GL_LIGHT1, GL11.GL_SPECULAR, buffSpecular);
       
       
   }
    
   /**
    * Active la lumiere courante
    */
   public void allumer()
   {
       GL11.glEnable(m_currentLight);
    }
   
   /**
    * Desactive la lumiere courante
    * (on suppose que GL_LIGHTING est egalement active)
    */
   public void eteindre()
   {
     GL11.glDisable(m_currentLight);  
   }
    



}