package br.com.joao.listadeitens.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JTextField;

import bancodados.ItemDao;
import br.com.joao.listadeitens.model.Item;
import br.com.joao.listadeitens.model.PainelDireitoModel;
import br.com.joao.listadeitens.view.PainelDireito;
import br.com.joao.listadeitens.view.PainelEsquerdo;

public class PaineisControlador {
	PainelEsquerdo painelEsquerdo;
	PainelDireito painelDireito;
	ItemDao itemDao = new ItemDao();
	PainelDireitoModel painelDireitoModel= new PainelDireitoModel();

	public PaineisControlador(PainelEsquerdo painelEsquerdo, PainelDireito painelDireito) {
		this.painelEsquerdo = painelEsquerdo;
		this.painelDireito = painelDireito;
 		AdicionarTodosOsItensAoModel();
 		adicionarTodosItensATabela();
		adicionarListeners();
	}

	public void enterClicado(JTextField campoAtual) {
		campoAtual.transferFocus();
	}
	public void focusParaNome() {
		painelEsquerdo.getNome().requestFocus();
	}

	public void apenasNumeros(KeyEvent e, String sequenciaPermitida) {
		if (!sequenciaPermitida.contains(e.getKeyChar() + "")) {
			e.consume();
		}
	}

	public void enviar() {
		Item ultimoItem = new Item(painelEsquerdo.getNomeText(), painelEsquerdo.getDescricaoText(),
		painelEsquerdo.getQuantidadeText());
		itemDao.save(ultimoItem);
		painelDireitoModel.setUltimoItem(ultimoItem);
		painelDireito.adicionarUltimoItemATabela(ultimoItem.getNome(),ultimoItem.getQuantidade(),ultimoItem.getDescricao());
	}

	private void adicionarListeners() {
		painelEsquerdo.addNomekeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enterClicado(painelEsquerdo.getNome());
				}
			}
		});
		painelEsquerdo.addQuantidadekeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				apenasNumeros(e, "0123456789.");
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enterClicado(painelEsquerdo.getQuantidade());
				}
			}
		});
		painelEsquerdo.addDescricaokeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enviar();
					painelEsquerdo.limparCaixasDeTexto();
					focusParaNome();

				}
			}
		});
		painelEsquerdo.addBotaoActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enviar();
				painelEsquerdo.limparCaixasDeTexto();
				focusParaNome();
			}
		});
	}

	private void AdicionarTodosOsItensAoModel() {
		
		painelDireitoModel.adicionarTodos(itemDao.pegarTodosItens());
	}

	private Vector<Item> pegarItensDoModel() {
		System.out.println("Itens do presentation:" + painelDireitoModel.getItens());
		return painelDireitoModel.getItens();

	}
	private void adicionarTodosItensATabela() {
 		painelDireito.adicionarTodosATabela(pegarTodosOsNomes(), pegarTodasAsQuantidades(), pegarTodosAsDescricoes());
	}

	public Vector<String> pegarTodosOsNomes() {

		Vector<String> nomes = new Vector<String>(pegarItensDoModel().stream().map(x -> x.getNome()).toList()); // (Vector<String>)
																											// pegarItens().stream().map(x->x.getNome()).toList();
		return nomes;
	}

	public Vector<Double> pegarTodasAsQuantidades() {
		Vector<Double> quantidades = new Vector<Double>(pegarItensDoModel().stream().map(x -> x.getQuantidade()).toList());
		return quantidades;
	}

	public Vector<String> pegarTodosAsDescricoes() {
		Vector<String> descricoes = new Vector<String>(pegarItensDoModel().stream().map(x -> x.getDescricao()).toList());
		return descricoes;
	}

}
