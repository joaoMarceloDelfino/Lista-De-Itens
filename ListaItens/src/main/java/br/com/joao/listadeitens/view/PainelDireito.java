package br.com.joao.listadeitens.view;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class PainelDireito extends JPanel {

	private DefaultTableModel modelo;
	JTable itens;
	JScrollPane scroll;
	JToolBar barra = new JToolBar();
	JPanel painelToolBar = new JPanel();

	public void inicializar() {
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		setLayout(new BorderLayout());
		itens = new JTable(modelo);
		scroll = new JScrollPane(itens);
		add(scroll, BorderLayout.CENTER);
		add(barra, BorderLayout.NORTH);
		barra.add(painelToolBar);

	}

	public void adicionarTodosATabela(Vector<String> nomes, Vector<Double> quantidades, Vector<String> descricoes) {
		modelo.addColumn("nome", nomes);
		modelo.addColumn("quantidade", quantidades);
		modelo.addColumn("descrição", descricoes);

	}

	public void adicionarUltimoItemATabela(String nome, Double quantidade, String descricao) {
		Object[] linha = { nome, quantidade, descricao };
		modelo.addRow(linha);
	}

}
