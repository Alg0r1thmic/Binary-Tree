/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author raul
 */
public class Node {
    int value;
    String nombre;
    String apellido;
    String direccion;
    String tipoSangre;
    boolean empty;
    Node left;
    Node right;
    
    public Node()
    {
        empty=true;
    }
    public Node(int value,String nombre,String apellido, String direccion,String tipoSangre) {
        this.value=value;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.tipoSangre=tipoSangre;
        right = null;
        left = null;
        empty=false;
    }
    public void setNumero(int n)
    {
        this.value=n;
    }
    public void setNombre(String name)
    {
        this.nombre=name;
    }
    
    public void setApellido(String a)
    {
        this.apellido=a;
    }
    
    public void setDireccion(String d)
    {
        this.direccion=d;
    }
    public void setTipoSangre(String s)
    {
        this.tipoSangre=s;
    }
    
    public int getNumero()
    {
        return this.value;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public String getApellido()
    {
        return this.apellido;
    }
    public String getDireccion()
    {
        return this.direccion;
    }
    
    public String getTipoSangre()
    {
        return this.tipoSangre;
    }
    public boolean isEmpty(){
        return empty;
    }
    
}
