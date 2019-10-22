import java.util.*;
import java.lang.*;
import java.io.*;


public class FloydWarshall
{
    static final int INF = 9999;

    public static void main (String[] args)
    {

        int matriz_pesos [][] = { {0, 5, 3, INF, 9},
                                  {5, 0, 7, 2, 6},
                                  {3, 7, 0, INF, INF},
                                  {INF, 2, INF, 0, 3},
                                  {9, 6, INF, 3, 0},
                                };

        FloydWarshall FW = new FloydWarshall();

        FW.algoritmo_FloydWarshall(matriz_pesos);
    }

   public void algoritmo_FloydWarshall(int[][] matriz_pesos)
    {
        int matriz_distancia [][] = new int[matriz_pesos.length][matriz_pesos.length];

        for (int i = 0; i < matriz_pesos.length; i++)
        {
            for (int j = 0; j < matriz_pesos.length; j++)
            {
                matriz_distancia[i][j] = matriz_pesos[i][j];
            }
        }

        for(int k = 0; k < matriz_pesos.length; k++)
        {
          for(int i=0; i < matriz_pesos.length;i++)
          {
            for(int j=0; j < matriz_pesos.length;j++)
            {
              if(matriz_pesos[i][k] + matriz_pesos[k][j] < matriz_pesos[i][j])
              {
                matriz_distancia[i][j] = matriz_pesos[i][k] + matriz_pesos[k][j];
              }
            }
          }
        }
        imprimirMatriz(matriz_distancia);
    }

    public void imprimirMatriz(int [][] matriz_distancias)
    {
        System.out.print("\t");
        for (int i = 0; i < matriz_distancias.length; i++)
        {
            System.out.print(letras(String.valueOf(i)) + "|\t");
        }

        System.out.println();

        for(int i = 0; i < matriz_distancias.length; i++)
        {
            System.out.print(letras(String.valueOf(i)) + "|\t");
            for(int j = 0; j < matriz_distancias.length; j++)
            {
                if (matriz_distancias[i][j]==INF)
                    System.out.print("INF \t");
                else
                    System.out.print(matriz_distancias[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public String letras (String indice)
    {
        String letra = "";
        switch(indice)
        {
            case "0":
                letra = "A";
                break;
            case "1":
                letra = "B";
                break;
            case "2":
                letra = "C";
                break;
            case "3":
                letra = "D";
                break;
            case "4":
                letra = "E";
                break;
        }
        return letra;
    }
}
