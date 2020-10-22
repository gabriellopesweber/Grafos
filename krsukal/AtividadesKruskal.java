package krsukal;

import org.graphstream.algorithm.Kruskal;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class AtividadesKruskal {

	public static void main(String[] args) {

		Graph g = new SingleGraph("Simples");
		 int soma = 0;
		g.addNode("a");
		g.addNode("b");
		g.addNode("c");
		g.addNode("d");
		g.addNode("e");
		g.addNode("f");
		g.addNode("g");

		g.addEdge("a-b", "a", "b").addAttribute("custo", 110);
		g.addEdge("b-c", "b", "c").addAttribute("custo", 31);
		g.addEdge("c-g", "c", "g").addAttribute("custo", 92);
		g.addEdge("g-f", "g", "f").addAttribute("custo", 11);
		g.addEdge("f-e", "f", "e").addAttribute("custo", 3);
		g.addEdge("e-a", "e", "a").addAttribute("custo", 5);
		g.addEdge("d-e", "d", "e").addAttribute("custo", 6);
		g.addEdge("d-a", "d", "a").addAttribute("custo", 4);
		g.addEdge("d-b", "d", "b").addAttribute("custo", 2);
		g.addEdge("d-c", "d", "c").addAttribute("custo", 63);
		g.addEdge("d-f", "d", "f").addAttribute("custo", 8);
		
		for (Node n : g)
			n.addAttribute("label", n.getId());
		
		for (Edge e : g.getEachEdge())
			e.addAttribute("label", "" + (int) e.getNumber("custo"));

		
		g.display();
		g.addAttribute("ui.stylesheet", estilos());
		
		
		Kruskal kruskal = new Kruskal("ui.class", "intree", "notintree","custo");
		kruskal.init(g);
		kruskal.compute();
		
		for (Edge e : kruskal.getTreeEdges()) {
			e.addAttribute("ui.style","fill-color: red;");
			soma += Integer.parseInt(e.getAttribute("custo").toString());
			System.out.println(soma);
		}
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
