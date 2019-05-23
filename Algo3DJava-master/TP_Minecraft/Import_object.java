package TP_Minecraft;

import TP4.*;
import TP6.*;
import java.util.*;
import java.io.*;
import org.lwjgl.opengl.GL11;
import java.awt.image.BufferedImage;


/**
 * Cette classe permet de créer des objects importés par fichier .obj.
 *
 * @author (CASTEL Brandon)
 * @version (14/05/2019)
 */
public class Import_object extends Objet
{
    //Contenu du fichier
    Vector<Integer> vertexIndices = new Vector<Integer>(50);
    Vector<Integer> uvIndices = new Vector<Integer>(50);
    Vector<Integer> normalIndices = new Vector<Integer>(50);
    Vector<Vecteur3D> temp_vertices = new Vector<Vecteur3D>(50);
    Vector<Vecteur2D> temp_uvs = new Vector<Vecteur2D>(50);
    Vector<Vecteur3D> temp_normals = new Vector<Vecteur3D>(50);
    
    //Chemin du fichier
    private String chaine;
    private String pathfile;
    private String pathMtlFile;
    private String pathTexture;
    private int m_textureID;

    /**
     * Ce constructeur s'occupe de lire un fichier .obj et d'en récupérer les
     * coordonnées pour l'affichage.
     * @param _parent Noeud parent dans le graphe de scène.
     * @param _pathfile Chemin du fichier .obj
     */
    public Import_object(Noeud _parent, String _pathfile)
    {
        super(_parent);
        openFile(_pathfile);
    }
    
    /**
     * Ce constructeur s'occupe de lire un fichier .obj et d'en récupérer les
     * coordonnées pour l'affichage.
     * @param _parent Noeud parent dans le graphe de scène.
     * @param _pathfile Chemin du fichier .obj
     * @param _pathfile Chemin de la texture du model (.png).
     */
    public Import_object(Noeud _parent, String pathfile, String pathtexture) {
        super(_parent);
        //On récupère la texture
        TextureLoader myTextureLoader;
        BufferedImage image = TextureLoader.loadImage(pathtexture);//The path is inside the jar file
        m_textureID = TextureLoader.loadTexture(image);
        //On ouvre le fichier
        openFile(pathfile);
    }
    
    /**
     * Cette méthode ouvre et traite le fichier .obj pour récupérer les coordonnées des vertex, UV (textures), et de normals.
     * Il stocke ensuite ces coordonnées dans différentes tableaux.
     */
    public void openFile(String path){
        //Lecture du fichier
        try{
            File file = new File(path);
            
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String ligne;
            while((ligne = br.readLine())!=null){
                if(ligne.startsWith("v")) {
                    if(ligne.startsWith("vn")) {
                     //On récupère les coordonnées, puis on les stocks dans un Vecteur3D
                     String[] vnCoord = ligne.split(" ");
                     Vecteur3D normal = new Vecteur3D(Float.parseFloat(vnCoord[1]),Float.parseFloat(vnCoord[2]),Float.parseFloat(vnCoord[3]));
                     //On stocke le Vecteur3D dans le vector
                     temp_normals.addElement(normal);
                    }
                    if(ligne.startsWith("v ")) {
                     //On récupère les coordonnées, puis on les stocks dans un Vecteur3D
                     String[] vCoord = ligne.split(" ");
                     Vecteur3D vertex = new Vecteur3D(Float.parseFloat(vCoord[1]),Float.parseFloat(vCoord[2]),Float.parseFloat(vCoord[3]));
                     //On stocke le Vecteur3D dans le vector
                     temp_vertices.addElement(vertex);
                    }
                    if(ligne.startsWith("vt")) {
                     //On récupère les coordonnées, puis on les stocks dans un Vecteur3D
                     String[] uvCoord = ligne.split(" ");
                     Vecteur2D uv = new Vecteur2D(Float.parseFloat(uvCoord[1]),Float.parseFloat(uvCoord[2]));
                     //On stocke le Vecteur3D dans le vector
                     temp_uvs.addElement(uv);
                    }
                }
                
                if(ligne.startsWith("f ")) {
                    //On récupère les groupes de coordonnées
                    String[] fgroup = ligne.split(" ");
                    String[] group1 = fgroup[1].split("/");
                    String[] group2 = fgroup[2].split("/");
                    String[] group3 = fgroup[3].split("/");
                    
                    //On range les différents type de coordonnées dans leurs vectors
                    vertexIndices.addElement(Integer.parseInt(group1[0])-1);
                    vertexIndices.addElement(Integer.parseInt(group2[0])-1);
                    vertexIndices.addElement(Integer.parseInt(group3[0])-1);
                    
                    uvIndices.addElement(Integer.parseInt(group1[1])-1);
                    uvIndices.addElement(Integer.parseInt(group2[1])-1);
                    uvIndices.addElement(Integer.parseInt(group3[1])-1);
                    
                    normalIndices.addElement(Integer.parseInt(group1[2])-1);
                    normalIndices.addElement(Integer.parseInt(group2[2])-1);
                    normalIndices.addElement(Integer.parseInt(group3[2])-1);
                }
                
                //On gère les informations de matériaux
                if(ligne.startsWith("mtllib")){
                    String[] mtlgroup = ligne.split(" ");
                    pathMtlFile = mtlgroup[1];
                    
                    System.out.println("chemin: "+file.getParent() + "/" + pathMtlFile);
                    
                    System.out.println(file.getParentFile().getAbsolutePath());
                    
                    File mtl = new File( file.getParentFile().getAbsolutePath() + "\\" + pathMtlFile);
                    BufferedReader brMtl = new BufferedReader(new FileReader(mtl));
                    
                    String ligneMtl;
                    while((ligneMtl = brMtl.readLine())!=null) {
                        if(ligneMtl.startsWith("map_Kd")) {
                            String[] textGroup = ligneMtl.split(" ");
                            
                            //On récupère le chemin de la texture
                            pathTexture = textGroup[1];
                        }
                    }
                    
                    //On récupère la texture
                    TextureLoader myTextureLoader;
                    System.out.println("\\" + file.getParent() + "\\" + pathTexture);
                    BufferedImage image = TextureLoader.loadImage("/" + file.getParent() + "/" + pathTexture);//The path is inside the jar file
                    m_textureID = TextureLoader.loadTexture(image);
                }
                chaine+=ligne+"\n";
            }
            br.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.toString());
        }
        catch(IOException e) {
            System.out.println(e.toString());
        }
    }
    
    
    /**
     * Cette méthode utilise une suite d'instructions OpenGL permettant d'afficher le fichier .obj chargé précédemment.
     * Vous trouverez ces instructions dans la clase OpenGL en vrac du package TP2.
     */
    public void dessine() {     
        // On désactive le mode d'éclairage pour afficher des lignes
        GL11.glDisable(GL11.GL_LIGHTING);
        
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, m_textureID);
        
        GL11.glBegin(GL11.GL_TRIANGLES);
        
        for(int i = 0; i < vertexIndices.size(); i=i+3) {
            GL11.glNormal3f(temp_normals.elementAt(normalIndices.elementAt(i)).getX(),    temp_normals.elementAt(normalIndices.elementAt(i)).getY(),    temp_normals.elementAt(normalIndices.elementAt(i)).getZ());
           
            GL11.glTexCoord2f(temp_uvs.elementAt(uvIndices.elementAt(i)).getU(),          temp_uvs.elementAt(uvIndices.elementAt(i)).getV());
            GL11.glVertex3f(temp_vertices.elementAt(vertexIndices.elementAt(i)).getX(),   temp_vertices.elementAt(vertexIndices.elementAt(i)).getY(),   temp_vertices.elementAt(vertexIndices.elementAt(i)).getZ());
            
            GL11.glTexCoord2f(temp_uvs.elementAt(uvIndices.elementAt(i+1)).getU(),        temp_uvs.elementAt(uvIndices.elementAt(i+1)).getV());
            GL11.glVertex3f(temp_vertices.elementAt(vertexIndices.elementAt(i+1)).getX(), temp_vertices.elementAt(vertexIndices.elementAt(i+1)).getY(), temp_vertices.elementAt(vertexIndices.elementAt(i+1)).getZ());
            
            GL11.glTexCoord2f(temp_uvs.elementAt(uvIndices.elementAt(i+2)).getU(),        temp_uvs.elementAt(uvIndices.elementAt(i+2)).getV());
            GL11.glVertex3f(temp_vertices.elementAt(vertexIndices.elementAt(i+2)).getX(), temp_vertices.elementAt(vertexIndices.elementAt(i+2)).getY(), temp_vertices.elementAt(vertexIndices.elementAt(i+2)).getZ());
        }
        
        GL11.glEnd(); 
        
        // On résactive le mode d'éclairage pour afficher ke cube
        GL11.glEnable(GL11.GL_LIGHTING); 
    }
}
