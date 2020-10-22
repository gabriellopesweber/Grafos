package atividadesLista;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class GrauDosVertices {

	public static void main(String[] args) {
		Graph g = new SingleGraph("grau");

		for (int i = 0; i < 9; i++) {
			g.addNode("" + (i + 1));
		}

		g.addEdge("1 - 2", "1", "2");
		g.addEdge("1 - 4", "1", "4");
		g.addEdge("1 - 6", "1", "6");
		g.addEdge("2 - 3", "2", "3");
		g.addEdge("3 - 4", "3", "4");
		g.addEdge("3 - 5", "3", "5");
		g.addEdge("3 - 8", "3", "8");
		g.addEdge("4 - 6", "4", "6");
		g.addEdge("5 - 7", "5", "7");
		g.addEdge("5 - 8", "5", "8");
		g.addEdge("7 - 9", "7", "9");
		g.addEdge("8 - 9", "8", "9");

		g.getNode("1").addAttribute("ui.label", "a");
		g.getNode("2").addAttribute("ui.label", "b");
		g.getNode("3").addAttribute("ui.label", "c");
		g.getNode("4").addAttribute("ui.label", "d");
		g.getNode("5").addAttribute("ui.label", "e");
		g.getNode("6").addAttribute("ui.label", "f");
		g.getNode("7").addAttribute("ui.label", "g");
		g.getNode("8").addAttribute("ui.label", "h");
		g.getNode("9").addAttribute("ui.label", "i");

		g.display();

		for (Node n : g.getEachNode()) {
			System.out.println("Vertice " + n.getAttribute("ui.label") + " - Grau: " + n.getInDegree());
		}
	}
}
