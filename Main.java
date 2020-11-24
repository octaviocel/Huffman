/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("BIENVENIDO AL HUFFMAN");
        String fi = obtenerDoc();
        Lista lista = contaLetras(fi);
        //lista.contaLetras(fi);
        lista.reducir();
        lista.recorrerArbolUnico();
        
        lista.recorrer();
        
                
    }
    
    public static Lista contaLetras(String cad) {        
        int[] letras = new int[1000000];
        Lista regreso = new Lista();
        for (int i = 0; i < cad.length(); ++i) {
            letras[(int) cad.charAt(i)]++;
        }

        for (int i = 0; i < cad.length(); ++i) {
            if (letras[i] != 0) {
                char temp =(char) i;
                int temp2 = letras[i];                
                regreso.insertarOrdenada(creaArbol(temp, temp2));                
            }
        }
       return  regreso;
    }
    
    public static Arbol creaArbol(Character i, int frec){
        Arbol nuevo = new Arbol();
        nuevo.caracter=i;
        nuevo.frecuencia=frec;
        nuevo.derecha=null;
        nuevo.izquierda=null;
        
        return nuevo;
    }
    
    public static String obtenerDoc() throws FileNotFoundException, IOException {
        Scanner pen = new Scanner(System.in);
        System.out.println("Ingresa la ruta del archivo ejemplo(C:\\Users\\DELL\\Desktop\\)");
        String leer = pen.next();
        System.out.println("Ingresa el nombre del archivo, ejemplo(input.txt)");
        String nombre = pen.next();

        File file = new File(leer + nombre);
        try ( FileReader reader = new FileReader(file)) {
            BufferedReader li = new BufferedReader(reader);
            String linea, fin = "";

            while ((linea = li.readLine()) != null) {
                fin = fin + linea + "'"; //Cuando encuentre un ' significa salto de linea
            }
            //System.out.println(fin);
            return fin;
        }
    }


}
