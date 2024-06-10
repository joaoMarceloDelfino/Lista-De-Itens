package views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import models.PainelDireitoModel;
import presentations.PaineisPresentation;

public class PainelDireito extends JPanel {

	private DefaultTableModel modelo;
	JTable itens;
	JScrollPane scroll;
	JToolBar barra = new JToolBar();
 	JPanel painelToolBar = new JPanel();
	PaineisPresentation painelPresentation;
	private PainelDireitoModel painelDireitoModel = new PainelDireitoModel();

	public void inicializar() {
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int linha, int coluna) {
				return false;
			}
		};
		setLayout(new BorderLayout());
		adicionarTodosATabela();
	    scroll = new JScrollPane(itens);
		add(scroll, BorderLayout.CENTER);
		add(barra, BorderLayout.NORTH);
		barra.add(painelToolBar);
  

	}
	
	private void adicionarTodosATabela() {
	    itens=new JTable(modelo);
		modelo.addColumn("nome",painelPresentation.pegarTodosOsNomes());
		System.out.println("Nomes da view"+painelPresentation.pegarTodosOsNomes());
		modelo.addColumn("quantidade",painelPresentation.pegarTodosAsQuantidades());
		System.out.println("quantidades da view"+painelPresentation.pegarTodosAsQuantidades());
		modelo.addColumn("descrição",painelPresentation.pegarTodosAsDescricoes());
		System.out.println("descricao da view"+painelPresentation.pegarTodosAsDescricoes());
 
	}
	public void adicionarUltimoItemATabela() {
		Object[]linha= {painelDireitoModel.getUltimoItem().getNome(),painelDireitoModel.getUltimoItem().getQuantidade(),painelDireitoModel.getUltimoItem().getDescricao()};
		modelo.addRow(linha);
	}

	public void setPainelPresentation(PaineisPresentation painelPresentation) {
		this.painelPresentation = painelPresentation;
	}

	public PainelDireitoModel getPainelDireitoModel() {
		return painelDireitoModel;
	}
	

}
