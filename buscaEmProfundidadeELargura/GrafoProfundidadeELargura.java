package buscaEmProfundidadeELargura;

import javax.swing.JOptionPane;

import org.graphstream.graph.BreadthFirstIterator;
import org.graphstream.graph.DepthFirstIterator;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class GrafoProfundidadeELargura {

	public static void main(String[] args) throws InterruptedException {

		Graph g = new SingleGraph("Buscas");
		boolean option = false;
		Object[] options_JO = { "Pronfundidade", "Largura" };

		/* 1 */ g.addNode("Garopaba").addAttribute("xy", 5, 4);
		/* 2 */ g.addNode("Imbituba").addAttribute("xy", 2, 3);
		/* 3 */ g.addNode("Barranceira").addAttribute("xy", 2, 0);
		/* 4 */ g.addNode("Sao tomas").addAttribute("xy", 1, 2);
		/* 5 */ g.addNode("Imarui").addAttribute("xy", 5, 1);
		/* 6 */ g.addNode("Rio Sete").addAttribute("xy", 0, 4);
		/* 7 */ g.addNode("Sao Binofacio").addAttribute("xy", 1, 6);
		/* 8 */ g.addNode("Santo Amaro da Imperatriz").addAttribute("xy", 3, 7);
		/* 9 */ g.addNode("Palhoca").addAttribute("xy", 4, 8);
		/* 10 */ g.addNode("Sao Jose").addAttribute("xy", 5, 9);
		/* 11 */ g.addNode("Paulo Lopes").addAttribute("xy", 4, 5);

		g.addEdge("Garopaba - Paulo Lopes", "Garopaba", "Paulo Lopes", true);
		g.addEdge("Garopaba - Imbituba", "Garopaba", "Imbituba", true);
		g.addEdge("Imbituba - Garopaba", "Imbituba", "Garopaba", true);
		g.addEdge("Imbituba - Imarui", "Imbituba", "Imarui", true);
		g.addEdge("Imbituba - Barranceira", "Imbituba", "Barranceira", true);
		g.addEdge("Barranceira - Sao tomas", "Barranceira", "Sao tomas", true);
		g.addEdge("Barranceira - Imarui", "Barranceira", "Imarui", true);
		g.addEdge("Imarui - Imbituba", "Imarui", "Imbituba", true);
		g.addEdge("Imarui - Sao tomas", "Imarui", "Sao tomas", true);
		g.addEdge("Rio Sete - Sao tomas", "Rio Sete", "Sao tomas", true);
		g.addEdge("Rio Sete - São Binofacio", "Rio Sete", "Sao Binofacio", true);
		g.addEdge("Sao Binofacio - Sao tomas", "Sao Binofacio", "Rio Sete", true);
		g.addEdge("Sao Binofacio - Santo Amaro da Imperatriz", "Sao Binofacio", "Santo Amaro da Imperatriz", true);
		g.addEdge("Santo Amaro da Imperatriz - Sao Binofacio", "Santo Amaro da Imperatriz", "Sao Binofacio", true);
		g.addEdge("Santo Amaro da Imperatriz - Palhoca", "Santo Amaro da Imperatriz", "Palhoca", true);
		g.addEdge("Palhoca - Santo Amaro da Imperatriz", "Palhoca", "Santo Amaro da Imperatriz", true);
		g.addEdge("Palhoca - Sao Jose", "Palhoca", "Sao Jose", true);
		g.addEdge("Palhoca - Paulo Lopes", "Palhoca", "Paulo Lopes", true);
		g.addEdge("Sao Jose - Paulo Lopes", "Sao Jose", "Palhoca", true);
		g.addEdge("Paulo Lopes - Sao Jose", "Paulo Lopes", "Sao Jose", true);
		g.addEdge("Paulo Lopes - Garopaba", "Paulo Lopes", "Garopaba", true);

		g.getNode("Garopaba").addAttribute("ui.label", "Garopaba");
		g.getNode("Imbituba").addAttribute("ui.label", "Imbituba");
		g.getNode("Barranceira").addAttribute("ui.label", "Barranceira");
		g.getNode("Sao tomas").addAttribute("ui.label", "Sao tomas");
		g.getNode("Imarui").addAttribute("ui.label", "Imarui");
		g.getNode("Rio Sete").addAttribute("ui.label", "Rio Sete");
		g.getNode("Sao Binofacio").addAttribute("ui.label", "Sao Binofacio");
		g.getNode("Santo Amaro da Imperatriz").addAttribute("ui.label", "Santo Amaro da Imperatriz");
		g.getNode("Palhoca").addAttribute("ui.label", "Palhoca");
		g.getNode("Sao Jose").addAttribute("ui.label", "Sao Jose");
		g.getNode("Paulo Lopes").addAttribute("ui.label", "Paulo Lopes");

		g.display(false);
		g.addAttribute("ui.stylesheet", estilos());

		/* Lista de conexãos */
//		1 - Garopaba					-> 11, 2
//		2 - Imbituba					-> 1, 5, 3
//		3 - Barranceira					-> 4, 2
//		4 - São tomas					-> 3, 5
//		5 - Imarui						-> 4, 2
//		6 - Rio Sete					-> 4, 7
//		7 - São Binofacio				-> 6, 8
//		8 - Santo Amaro da Imperatriz	-> 7, 9
//		9 - Palhoça						-> 8, 10, 11
//		10- São José					-> 9
//		11- Paulo Lopes					-> 10, 1

		option = Boolean.parseBoolean(JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar",
				"Realizar a busca via Profundidade ou Largura?", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options_JO, options_JO[0]) + "");

		if (option) {
			DepthFirstIterator<Node> buscaProfundidade = new DepthFirstIterator<Node>(g.getNode("Garopaba"));
			while (buscaProfundidade.hasNext()) {
				Node n = buscaProfundidade.next();
				n.addAttribute("ui.class", "visitado");
				System.out.print(n.getLabel("ui.label") + "-> ");

				if (n.getLabel("ui.label").equals("Santo Amaro da Imperatriz")) {
					System.out.println(".");
					break;
				} else {
					System.out.print("-> ");
				}

				for (Edge e : n.getEachEdge()) {
					e.addAttribute("ui.class", "percorrida");
					Thread.sleep(500);
				}
			}
		} else {
			BreadthFirstIterator<Node> buscaLargura = new BreadthFirstIterator<Node>(g.getNode("Garopaba"));
			while (buscaLargura.hasNext()) {
				Node n = buscaLargura.next();
				n.addAttribute("ui.class", "visitado");
				System.out.print(n.getLabel("ui.label"));

				if (n.getLabel("ui.label").equals("Santo Amaro da Imperatriz")) {
					System.out.println(".");
					break;
				} else {
					System.out.print("-> ");
				}

				for (Edge e : n.getEachEdge()) {
					e.addAttribute("ui.class", "percorrida");
					Thread.sleep(500);
				}
			}
		}
	}

	public static String estilos() {
		return "edge {  " + "fill-color: black;" + "size: 4px;" + " text-size: 30px; }"

				+ "edge.percorrida {  " + "fill-color: rgb(200,39,65);" + "size: 5px;" + "}"

				+ "node{" + "fill-color: rgb(0,100,255);" + "size: 30px, 30px;" + "text-color: black;"
				+ "text-size: 30;" + "text-style:bold;" + "}"

				+ "node.visitado{" + "fill-color: red;" + "size: 30px, 30px;" + "text-color: black;" + "text-size: 30;"
				+ "text-style:bold;" + "}";
	}
}
