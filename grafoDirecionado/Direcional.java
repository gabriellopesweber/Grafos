package grafoDirecionado;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Direcional {

	public static void main(String[] args) throws InterruptedException {
		String resultados = "";

		Graph g = new SingleGraph("orientado");

		for (int i = 0; i < 13; i++) {
			g.addNode("" + (i + 1));
		}

		g.addEdge("2-1", "2", "1", true);
		g.addEdge("3-2", "3", "2", true);
		g.addEdge("4-2", "4", "2", true);
		g.addEdge("3-4", "3", "4", true);
		g.addEdge("8-5", "8", "5", true);
		g.addEdge("2-6", "2", "6", true);
		g.addEdge("1-7", "1", "7", true);
		g.addEdge("3-8", "3", "8", true);
		g.addEdge("4-8", "4", "8", true);
		g.addEdge("6-8", "6", "8", true);
		g.addEdge("2-9", "2", "9", true);
		g.addEdge("8-9", "8", "9", true);
		g.addEdge("6-10", "6", "10", true);
		g.addEdge("11-10", "11", "10", true);
		g.addEdge("6-12", "6", "12", true);
		g.addEdge("13-12", "13", "12", true);
		g.addEdge("8-13", "8", "13", true);

		g.display();

		g.getNode("1").addAttribute("ui.label", "programação para web");
		g.getNode("2").addAttribute("ui.label", "poo");
		g.getNode("3").addAttribute("ui.label", "algoritimos 1");
		g.getNode("4").addAttribute("ui.label", "algoritimos 2");
		g.getNode("5").addAttribute("ui.label", "grafos");
		g.getNode("6").addAttribute("ui.label", "topicos avançados de programação");
		g.getNode("7").addAttribute("ui.label", "programação a dispositivos moveis");
		g.getNode("8").addAttribute("ui.label", "estrutura de dados");
		g.getNode("9").addAttribute("ui.label", "banco de dados");
		g.getNode("10").addAttribute("ui.label", "processamento de digital de imagens");
		g.getNode("11").addAttribute("ui.label", "noções de algebra linear");
		g.getNode("12").addAttribute("ui.label", "tradução de linguagens formais");
		g.getNode("13").addAttribute("ui.label", "teoria das linguagens formais");

		while (g.getNodeCount() > 0) {

			for (Node n : g.getEachNode()) {
				if (n.getInDegree() == 0) {

					// System.out.println(n.getInDegree());

					resultados += n.getAttribute("ui.label") + "\n";
					g.removeNode(n.getId());
					Thread.sleep(1000);
				}

			}
		}

		System.out.println(resultados);

		/*
		 * 1 programação para web 2 poo 3 algoritmo 1 4 algoritmo 2 5 grafos 6 topicos
		 * avançados de programação 7 programação a dispositivos moveis 8 estrutura de
		 * dados 9 banco de dados 10 processamento digital de imagens 11 noções de
		 * algebra linear 12 tradução de linguagens formais 13 teoria das linguagens
		 * formais
		 */

	}

}
