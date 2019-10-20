package algoritobellmanford;

public class Aristas {
	public int origen, destino;
    public float coste;

    public Aristas(int a, int b, float c) {
        origen = a;
        destino = b;
        coste = c;
    }

    @Override
    public String toString() {
        return "Aristas{" + "origen=" + origen + ", destino=" + destino + ", coste=" + coste + '}';
    }

}
