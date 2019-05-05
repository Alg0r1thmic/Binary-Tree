/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;
import binarytree.Node;
/**
 *
 * @author raul
 */
public class BinaryTree {

    Node root;
    private Node addNewNode(Node current, int value,String nombre,String apellido, String direccion,String tipoSangre) {
        if (current == null) {
            return new Node(value,nombre,apellido,direccion,tipoSangre);
        }

        if (value < current.value) {
            current.left = addNewNode(current.left, value,nombre,apellido,direccion,tipoSangre);
        } else if (value > current.value) {
            current.right = addNewNode(current.right, value,nombre,apellido,direccion,tipoSangre);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    public void add(int value,String nombre,String apellido, String direccion,String tipoSangre) {
        root = addNewNode(root,value,nombre,apellido,direccion,tipoSangre);
    }
    private Node find(Node current, int value) {
        if (current == null) {
            Node n=new Node();
            return n;
        } 
        if (value == current.value) {
            return current;
        } 
        return value < current.value
          ? find(current.left, value)
          : find(current.right, value);
    }
    public Node findNode(int value) {
        return find(root, value);
    }
    private boolean updateNodeRecursive(Node current,int value,String nombre,String apellido, String direccion,String tipoSangre)
    {
        if (current == null) {
            return false;
        } 
        if (value == current.value) {
            current.setNombre(nombre);
            current.setApellido(apellido);
            current.setDireccion(direccion);
            current.setTipoSangre(tipoSangre);
            return true;
        } 
        return value < current.value
          ? updateNodeRecursive(current.left,value,nombre,apellido,direccion,tipoSangre)
          : updateNodeRecursive(current.right,value,nombre,apellido,direccion,tipoSangre);
    }
    public boolean update(int value,String nombre,String apellido, String direccion,String tipoSangre)
    {
        return updateNodeRecursive(root, value, nombre, apellido, direccion, tipoSangre);
    }

    public boolean deleteNode(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.value!=id){
			parent = current;
			if(current.value>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
	
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
                }
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

}
