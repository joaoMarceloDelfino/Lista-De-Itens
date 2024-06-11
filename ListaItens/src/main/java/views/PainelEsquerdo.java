package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.PaineisControlador;

public class PainelEsquerdo extends JPanel {
	JTextField nome = new JTextField();
	JTextField quantidade = new JTextField();
	JTextField descricao = new JTextField();
	JLabel nomeLabel = new JLabel("Insira o nome");
	JLabel quantidadeLabel = new JLabel("Insira a quantidade");
	JLabel descricaoLabel = new JLabel("Insira a descricao");
	JPanel panelNome = new JPanel();
	JPanel panelQuantidade = new JPanel();
	JPanel panelDescricao = new JPanel();
	Font arial = new Font("Arial", Font.PLAIN, 40);
	JButton enviar = new JButton();
 
	/*public PainelEsquerdo( ) {
  	}*/

	public void inicializar() {
		// config instancia
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// config nome
		nome.setBackground(Color.BLUE);
		nome.setFont(arial);
		nome.setHorizontalAlignment(JTextField.CENTER);
		 
		panelNome.setLayout(new BorderLayout());
		panelNome.add(nomeLabel, BorderLayout.NORTH);
		panelNome.add(nome, BorderLayout.CENTER);

		// config quantidade
		quantidade.setBackground(Color.RED);
		quantidade.setFont(arial);
		quantidade.setHorizontalAlignment(JTextField.CENTER);
		 

		panelQuantidade.setLayout(new BorderLayout());
		panelQuantidade.add(quantidadeLabel, BorderLayout.NORTH);
		panelQuantidade.add(quantidade, BorderLayout.CENTER);

		// config descricao
		descricao.setFont(arial);
		descricao.setHorizontalAlignment(JTextField.CENTER);
		 

		panelDescricao.setLayout(new BorderLayout());
		panelDescricao.add(descricaoLabel, BorderLayout.NORTH);
		panelDescricao.add(descricao, BorderLayout.CENTER);
		panelDescricao.add(enviar, BorderLayout.SOUTH);

		// config botao enviar
		enviar.setAlignmentX(Component.LEFT_ALIGNMENT);
		enviar.setText("Enviar");
		 
		// adicionando os elementos
		add(panelNome);
		add(panelQuantidade);
		add(panelDescricao);
		//System.out.println(painelPresentation.pegarTodosNomes()); 

	}
 
 public void addNomekeyListener(KeyAdapter e) {
	 nome.addKeyListener(e);
}
 public void addQuantidadekeyListener(KeyAdapter e) {
	 quantidade.addKeyListener(e);
}
 public void addDescricaokeyListener(KeyAdapter e) {
	 descricao.addKeyListener(e);
}
public void addBotaoActionListener(ActionListener e) {
	enviar.addActionListener(e);
}
 
	public void limparCaixasDeTexto() {
		nome.setText("");
		quantidade.setText("");
		descricao.setText("");

	}

	public String getNomeText() {
		return nome.getText();
	}

	public double getQuantidadeText() {	
		return Double.parseDouble(quantidade.getText());
	}

	public String getDescricaoText() {
		return descricao.getText();
	}
	public JTextField getNome() {
		return nome;
	}
	public JTextField getQuantidade() {
		return quantidade;
	}
	public JTextField getDescricao() {
		return descricao;
	}
	

}
