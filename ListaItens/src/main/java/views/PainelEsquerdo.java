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

import presentations.PaineisPresentation;

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
	PaineisPresentation painelPresentation;

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
		nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						painelPresentation.enterClicado(nome);
					}
 			}
		});

		panelNome.setLayout(new BorderLayout());
		panelNome.add(nomeLabel, BorderLayout.NORTH);
		panelNome.add(nome, BorderLayout.CENTER);

		// config quantidade
		quantidade.setBackground(Color.RED);
		quantidade.setFont(arial);
		quantidade.setHorizontalAlignment(JTextField.CENTER);
		quantidade.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				painelPresentation.apenasNumeros(e, "0123456789.");
			}

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					painelPresentation.enterClicado(quantidade);
				}
			}
		});

		panelQuantidade.setLayout(new BorderLayout());
		panelQuantidade.add(quantidadeLabel, BorderLayout.NORTH);
		panelQuantidade.add(quantidade, BorderLayout.CENTER);

		// config descricao
		descricao.setFont(arial);
		descricao.setHorizontalAlignment(JTextField.CENTER);
		descricao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				painelPresentation.enviar();
				limparCaixasDeTexto();
				}
			}
		});

		panelDescricao.setLayout(new BorderLayout());
		panelDescricao.add(descricaoLabel, BorderLayout.NORTH);
		panelDescricao.add(descricao, BorderLayout.CENTER);
		panelDescricao.add(enviar, BorderLayout.SOUTH);

		// config botao enviar
		enviar.setAlignmentX(Component.LEFT_ALIGNMENT);
		enviar.setText("Enviar");
		enviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painelPresentation.enviar();
				limparCaixasDeTexto();
			}
		});

		// adicionando os elementos
		add(panelNome);
		add(panelQuantidade);
		add(panelDescricao);
		//System.out.println(painelPresentation.pegarTodosNomes()); 

	}
 public void setPainelPresentation(PaineisPresentation painelPresentation) {
	 this.painelPresentation=painelPresentation;
 }
 
	private void limparCaixasDeTexto() {
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
	

}
