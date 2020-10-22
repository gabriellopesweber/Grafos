package dijkstra;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class OrientadoComDijikstra {
	
	public static Graph exampleGraph() {
		
	Graph g = new SingleGraph("example");

	g.addNode("a");
	g.addNode("b");
	g.addNode("c");
	g.addNode("d");
	g.addNode("e");
	g.addNode("f");
	g.addNode("g");
	g.addNode("h");
	
	g.addEdge("a - b", "a", "b").addAttribute("custo", 3);
	g.addEdge("a - c", "a", "c").addAttribute("custo", 5);
	g.addEdge("a - d", "a", "d").addAttribute("custo", 2);
	g.addEdge("a - h", "a", "h").addAttribute("custo",10);
	//

	g.addEdge("b - c", "b", "c").addAttribute("custo", 5);
	g.addEdge("b - d", "b", "d").addAttribute("custo", 8);
	g.addEdge("b - e", "b", "e").addAttribute("custo", 4);
	g.addEdge("b - g", "b", "g").addAttribute("custo", 6);
	g.addEdge("b - h", "b", "h").addAttribute("custo", 6);
	//
	g.addEdge("c - e", "c", "e").addAttribute("custo", 1);
	g.addEdge("c - f", "c", "f").addAttribute("custo", 7);
	g.addEdge("c - g", "c", "g").addAttribute("custo", 9);
	//
	g.addEdge("d - e", "d", "e").addAttribute("custo", 15);
	g.addEdge("d - h", "d", "h").addAttribute("custo", 14);
	//
	g.addEdge("e - g", "e", "g").addAttribute("custo", 15);
	//
	g.addEdge("f - h", "f", "h").addAttribute("custo", 9);
	//
	g.addEdge("g - h", "g", "h").addAttribute("custo", 3);
/*
	g.addEdge("01", "0", "1",true).addAttribute("custo", 5);
	g.addEdge("05", "0", "5",true).addAttribute("custo", 1);
	g.addEdge("54","5", "4",true).addAttribute("custo", 8);
	g.addEdge("43", "4", "3",true).addAttribute("custo", 2);
	g.addEdge("42", "4", "2",true).addAttribute("custo", 3);
	g.addEdge("35", "3", "5",true).addAttribute("custo", 1);
	g.addEdge("32", "3", "2",true).addAttribute("custo", 4);
	g.addEdge("20", "2", "0",true).addAttribute("custo", 7);
	g.addEdge("60", "6", "0",true).addAttribute("custo", 2);
	g.addEdge("64", "6", "4",true).addAttribute("custo", 3);
	g.addEdge("69", "6", "9",true).addAttribute("custo", 4);
	g.addEdge("9,10", "3", "10",true).addAttribute("custo", 3);
	g.addEdge("9,11", "3", "11",true).addAttribute("custo", 2);
	g.addEdge("10,12", "10", "12",true).addAttribute("custo", 2);
	g.addEdge("12,9", "12", "9",true).addAttribute("custo",4 );
	g.addEdge("8,7", "8", "7",true).addAttribute("custo", 2);
	g.addEdge("7,8", "7", "8",true).addAttribute("custo", 1);
	g.addEdge("7,6", "7", "6",true).addAttribute("custo", 3);
	
*/

	for (Node n : g)
		n.addAttribute("label", n.getId());

	for (Edge e : g.getEachEdge())
		e.addAttribute("label", "" + (int) e.getNumber("custo"));

	return g;
}
	public static void main(String[] args) {
		
		Graph g = exampleGraph();
		g.display(true);
		g.addAttribute("ui.stylesheet", estilos());

		// Atributo "custo" tem o custo das arestas
		Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "custo");

		// O caminho mais curto partindo de A para todos os outros vértices
		dijkstra.init(g);
		dijkstra.setSource(g.getNode("0"));
		dijkstra.compute();

		// comprimento de todos os caminhos mais curtos
		for (Node node : g)
			System.out.printf("%s->%s:%10.2f%n", dijkstra.getSource(), node, dijkstra.getPathLength(node));

		// Pinte em azul todos os nós no caminho mais curto de A a B
		for (Node node : dijkstra.getPathNodes(g.getNode("6")))
			node.addAttribute("ui.style", "fill-color: blue;");


	}
	
	public static String estilos() {
		return "edge {  " + "fill-color: black;" + "size: 4px;" + "text-size: 20;"+"}"

				+ "edge.percorrida {  " + "fill-color: rgb(200,39,65);" + "size: 5px;" + "}"

				+ "node{" + "fill-color: rgb(0,100,255);" + "size: 30px, 30px;" + "text-color: black;"
				+ "text-size: 30;" + "text-style:bold;" + "}"

				+ "node.visitado{" + "fill-color: red;" + "size: 30px, 30px;" + "text-color: black;" + "text-size: 30;"
				+ "text-style:bold;" + "}";
	}

}
