package TP8;

import org.lwjgl.opengl.GL11;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

/**
 * Write a description of class Materiau here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Materiau
{

    private FloatBuffer m_buffAmt;
    private FloatBuffer m_buffDiff;
    private FloatBuffer m_buffSpec;
    
    private float m_shininess;
    
    /**
     * Constructor for objects of class Materiau
     */
    public Materiau(float _AmbR, float _AmbG, float _AmbB, float _DiffR, float _DiffG, float _DiffB, float _SpecR, float _SpecG, float _SpecB, float _Shin  )
    {
        float[] amb = {_AmbR,_AmbG,_AmbB};
        m_buffAmt = BufferUtils.createFloatBuffer(4).put(amb);
        m_buffAmt.position(0);
        
        float[] diff = {_DiffR,_DiffG,_DiffB};
        m_buffDiff = BufferUtils.createFloatBuffer(4).put(diff);
        m_buffDiff.position(0);

        float[] spec = {_SpecR,_SpecG,_SpecB};
        m_buffSpec = BufferUtils.createFloatBuffer(4).put(spec);
        m_buffSpec.position(0);
        
        m_shininess = _Shin;
        
    }

    public FloatBuffer getAmbient(){
        return m_buffAmt;
    }
    public FloatBuffer getDiff(){
        return m_buffDiff;
    }
    public FloatBuffer getSpec(){
        return m_buffSpec;
    }
    public float getShinisess(){
        return m_shininess;
    }

    
}
