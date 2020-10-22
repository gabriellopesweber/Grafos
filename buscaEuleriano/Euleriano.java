package buscaEuleriano;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Euleriano {

	public static void main(String[] args) {

		Graph g = new SingleGraph("grau");

		int par = 0, impar = 0;

		for (int i = 0; i < 9; i++) {
			g.addNode("" + (i + 1));
		}

		g.addEdge("1-2", "1", "2");
		g.addEdge("1-4", "1", "4");
		g.addEdge("1-6", "1", "6");
		g.addEdge("2-3", "2", "3");
		g.addEdge("3-4", "3", "4");
		g.addEdge("3-5", "3", "5");
		g.addEdge("3-8", "3", "8");
		g.addEdge("4-6", "4", "6");
		g.addEdge("5-7", "5", "7");
		g.addEdge("5-8", "5", "8");
		g.addEdge("7-9", "7", "9");
		g.addEdge("8-9", "8", "9");

		g.getNode("1").addAttribute("ui.label", "1");
		g.getNode("2").addAttribute("ui.label", "2");
		g.getNode("3").addAttribute("ui.label", "3");
		g.getNode("4").addAttribute("ui.label", "4");
		g.getNode("5").addAttribute("ui.label", "5");
		g.getNode("6").addAttribute("ui.label", "6");
		g.getNode("7").addAttribute("ui.label", "7");
		g.getNode("8").addAttribute("ui.label", "8");
		g.getNode("9").addAttribute("ui.label", "9");

		g.display();

		for (Node n : g.getEachNode()) {

			System.out.println("Vertice - " + n.getId() + " arestas - " + n.getInDegree());
		}

		for (Node n : g.getEachNode()) {

			if (n.getInDegree() % 2 == 0) {
				par++;
			} else {
				impar++;
			}
		}

		if (par == g.getNodeCount()) {
			System.out.println("é um ciclo euleriano");
		}

		if (impar == 2 || impar == 0) {
			System.out.println("é um semi euleriano");
		}

	}

}
