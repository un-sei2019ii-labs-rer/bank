package algoritobellmanford;

import java.io.*;
import java.util.*;

public class BellmanFord {

    private LinkedList<Aristas> aristas;
    private float etiquetas[];
    private int predecesor[];
    private int numeroVertices, totalAristas, nodoOrigen;
    private final int INFINITY = 999;

    

    public BellmanFord() throws IOException {
        float item;
        aristas = new LinkedList();
        DataInputStream in = new DataInputStream(System.in);
        System.out.print("Introduce numero de vertices ");
        numeroVertices = Integer.parseInt(in.readLine());
        System.out.println("Matriz de costes");
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if (i != j) {
                    System.out.println("Introduce coste del nodo " + (i + 1) + " al nodo " + (j + 1));
                    item = Float.parseFloat(in.readLine());
                    if (item != 0) {
                        aristas.add(new Aristas(i, j, item));
                    }
                }
            }
        }
        totalAristas = aristas.size();
        etiquetas = new float[numeroVertices];
        predecesor = new int[numeroVertices];
        System.out.print("Introduce el vertice origen");
        nodoOrigen = Integer.parseInt(in.readLine()) - 1;
    }

    private void relajoArista() {
        int i, j;
        for (i = 0; i < numeroVertices; ++i) {
            etiquetas[i] = INFINITY;
        }
        etiquetas[nodoOrigen] = 0;
        for (i = 0; i < numeroVertices - 1; ++i) {
            for (j = 0; j < totalAristas; ++j) {
                System.out.println(aristas.get(j));
                if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
                    etiquetas[aristas.get(j).destino] = etiquetas[aristas.get(j).origen] + aristas.get(j).coste;
                    predecesor[aristas.get(j).destino] = aristas.get(j).origen;
                }
            }
            for (int p = 0; etiquetas.length < p; p++) {
                System.out.println("\t" + etiquetas[p]);
            }
        }
    }


    private boolean ciclo() {
        int j;
        for (j = 0; j < totalAristas; ++j) {
            if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        BellmanFord bellman = new BellmanFord();
        bellman.relajoArista();
        if (bellman.ciclo()) {
            for (int i = 0; i < bellman.numeroVertices; i++) {
                System.out.println("Coste desde " + bellman.nodoOrigen + " a " + (i + 1) + " =>" + bellman.etiquetas[i]);
            }
            for (int i = 0; i < bellman.numeroVertices; i++) {
                System.out.println("El predecesor de " + (i + 1) + " es " + (bellman.predecesor[i] + 1));
            }
        } else {
            System.out.println("Hay un ciclo negativo");
        }
    }
}
