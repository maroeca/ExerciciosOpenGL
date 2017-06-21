package br.pucpr.cg;

import org.joml.Vector3f;

import br.pucpr.mage.Mesh;
import br.pucpr.mage.MeshBuilder;

public class MeshFactory {
    
    public static Mesh createCube() {
        return createCube(
            new Vector3f(1.0f, 0.0f, 0.0f),
            new Vector3f(0.0f, 0.0f, 1.0f),
            new Vector3f(0.0f, 1.0f, 0.0f),
            new Vector3f(0.5f, 0.0f, 0.5f),
            new Vector3f(0.5f, 0.5f, 0.5f),
            new Vector3f(0.5f, 0.5f, 1.0f)
        );
    }   
    
    public static Mesh createCube(Vector3f color) {
        return createCube(color, color, color, color, color, color);
    }
    
    public static Mesh createCube(Vector3f frontColor, Vector3f backColor, Vector3f topColor, Vector3f bottomColor, Vector3f rightColor, Vector3f leftColor) {
        return new MeshBuilder()
        .addVector3fAttribute("aPosition", 
            //Face próxima
             -0.5f,  0.5f,  0.5f,  //0
              0.5f,  0.5f,  0.5f,  //1
             -0.5f, -0.5f,  0.5f,  //2
              0.5f, -0.5f,  0.5f,  //3
            //Face afastada
             -0.5f,  0.5f, -0.5f,  //4
              0.5f,  0.5f, -0.5f,  //5
             -0.5f, -0.5f, -0.5f,  //6
              0.5f, -0.5f, -0.5f,  //7
            //Face superior
             -0.5f,  0.5f,  0.5f,  //8
              0.5f,  0.5f,  0.5f,  //9
             -0.5f,  0.5f, -0.5f,  //10
              0.5f,  0.5f, -0.5f,  //11
            //Face inferior
             -0.5f, -0.5f,  0.5f,  //12
              0.5f, -0.5f,  0.5f,  //13
             -0.5f, -0.5f, -0.5f,  //14
              0.5f, -0.5f, -0.5f,  //15 
            //Face direita
              0.5f, -0.5f,  0.5f,  //16
              0.5f,  0.5f,  0.5f,  //17
              0.5f, -0.5f, -0.5f,  //18
              0.5f,  0.5f, -0.5f,  //19
            //Face esquerda
             -0.5f, -0.5f,  0.5f,   //20
             -0.5f,  0.5f,  0.5f,   //21
             -0.5f, -0.5f, -0.5f,  //22
             -0.5f,  0.5f, -0.5f)  //23
        .addVector3fAttribute("aColor",
            //Face próxima
              frontColor, 
              frontColor,
              frontColor,
              frontColor,
            //Face afastada
              backColor, 
              backColor, 
              backColor, 
              backColor, 
            //Face superior
              topColor, 
              topColor, 
              topColor, 
              topColor, 
            //Face inferior
              bottomColor,
              bottomColor,
              bottomColor,
              bottomColor,
            //Face direita
              rightColor, 
              rightColor, 
              rightColor, 
              rightColor, 
            //Face esquerda
              leftColor, 
              leftColor,
              leftColor,
              leftColor)
        .setIndexBuffer(
            //Face próxima
              0,  2,  3,
              0,  3,  1,
            //Face afastada
              4,  7,  6,
              4,  5,  7,
            //Face superior
              8, 11, 10,
              8,  9, 11,
            //Face inferior
             12, 14, 15,
             12, 15, 13,
            //Face direita
             16, 18, 19,
             16, 19, 17,
            //Face esquerda
             20, 23, 22,
             20, 21, 23)
        .loadShader("/br/pucpr/resource/basic")
        .create();        
    }
    
}
