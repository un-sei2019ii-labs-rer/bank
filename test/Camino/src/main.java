import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


public static void main(String[] args) extends Grafo {
    Grafo g = new Grafo("abcdef");
    g.agregarRuta('a','b', 3);
    g.agregarRuta('a','e', 6);
    g.agregarRuta('a','f',10);
    g.agregarRuta('b','c', 5);
    g.agregarRuta('b','e', 2);
    g.agregarRuta('c','d', 8);
    g.agregarRuta('c','e', 9);
    g.agregarRuta('c','f', 7);
    g.agregarRuta('d','f', 4);
    g.agregarRuta('e','f', 4);
    char inicio = 'a';
    char fin    = 'd';
    String respuesta = g.encontrarRutaMinimaDijkstra(inicio, fin);
    System.out.println(respuesta);
}