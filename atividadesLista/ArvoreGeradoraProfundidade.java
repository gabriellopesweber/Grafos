package atividadesLista;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class ArvoreGeradoraProfundidade {

	public static void main(String[] args) {
		Graph g = new SingleGraph("Buscas");
		/*
		 1- a
		 2- b
		 3- c
		 4- d
		 5- e
		 6- f
		 7- g
		 8- h
		 9- i
		 
		 */
		for (int i = 0; i < 9; i++) {
			g.addNode("" + (i + 1));
		}


		g.addEdge("1-2","1", "2");
		g.addEdge("1-3","1", "3");
		g.addEdge("1-4","1", "4");
		g.addEdge("1-6","1", "6");
		g.addEdge("3-5","3", "5");
		g.addEdge("5-7","5", "7");
		g.addEdge("7-9","7", "9");
		g.addEdge("9-8","9", "8");
	

		
		
		
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
		g.addAttribute("ui.stylesheet", estilos());

		
		/*
		//DepthFirstIterator<Node> it = new DepthFirstIterator<Node>(g.getNode("1"));// profundidade
	    BreadthFirstIterator<Node> it = new BreadthFirstIterator<Node>(g.getNode("1"));//largura
		while (it.hasNext()) {

			Node n = it.next();
			n.addAttribute("ui.class", "visitado");
			System.out.print(n.getLabel("ui.label") + "\t");
			
			if(n.getLabel("ui.label").equals("11")) {
				break;
			}
			

			for (Edge e : n.getEachEdge()) {
				
				e.addAttribute("ui.class", "percorrida");
				Thread.sleep(1000);
			}
		}*/
	}

	public static String estilos() {
	   return "edge {  " + "fill-color: black;" + "size: 4px;" + "}"

			+ "edge.percorrida {  " + "fill-color: rgb(200,39,65);" + "size: 5px;" + "}"

			+ "node{" + "fill-color: rgb(0,100,255);" + "size: 30px, 30px;" + "text-color: black;"
			+ "text-size: 30;" + "text-style:bold;" + "}"

			+ "node.visitado{" + "fill-color: red;" + "size: 30px, 30px;" + "text-color: black;" + "text-size: 30;"
			+ "text-style:bold;" + "}";
		}
}
