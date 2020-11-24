/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

/**
 *
 * @author DELL
 */
public class Lista {

    Nodo inicio = null;

    public void insertarOrdenada(Arbol dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.siguiente = null;
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo ant = null;
            Nodo aux = inicio;
            while ((aux != null) && (aux.dato.frecuencia < nuevo.dato.frecuencia)) {
                ant = aux;
                aux = aux.siguiente;
            }
            if (ant == null) {
                nuevo.siguiente = inicio;
                inicio = nuevo;
            } else if (aux == null) {
                ant.siguiente = inicio;
            } else {
                ant.siguiente = nuevo;
                nuevo.siguiente = aux;
            }
        }
    }

    public void recorrer() {
        if (inicio != null) {
            Nodo aux = inicio;
            while (aux != null) {
                System.out.println(String.format("%c : %d", aux.dato.caracter, aux.dato.frecuencia));
                aux = aux.siguiente;
            }
        }
    }

    public void reducir() {
        if (inicio != null) {
            Arbol izquierda;
            Arbol derecha;
            while (((izquierda = this.obtener()) != null) && (derecha = this.obtener()) != null) {
                Arbol nuevo = new Arbol();
                nuevo.caracter = null;
                nuevo.frecuencia = izquierda.frecuencia + derecha.frecuencia;
                nuevo.izquierda = izquierda;
                nuevo.derecha = derecha;
                this.insertarOrdenada(nuevo);
            }
            this.insertarOrdenada(izquierda);
        }
    }

    public void recorrerArbolUnico() {
        recorrerArbol(inicio.dato);
    }

    Arbol obtener() {
        if (inicio != null) {
            Nodo aux = inicio;
            inicio = inicio.siguiente;
            return aux.dato;
        }
        return null;
    }

    void recorrerArbol(Arbol arbol) {
        if (arbol != null) {
            recorrerArbol(arbol.izquierda);
            System.out.println(String.format("%c : %d", arbol.caracter, arbol.frecuencia));
            recorrerArbol(arbol.derecha);
        }
    }
    
    
}
