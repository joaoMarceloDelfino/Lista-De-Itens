package presentations;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.JTextField;

import models.Item;
import models.ItemDao;
import models.PainelDireitoModel;
import views.PainelDireito;
import views.PainelEsquerdo;

public class PaineisPresentation {
	PainelEsquerdo painelEsquerdo;
	PainelDireito painelDireito;
	ItemDao itemDao = new ItemDao();
	PainelDireitoModel painelDireitoModel;
	
 
 
	public PaineisPresentation(PainelEsquerdo painelEsquerdo, PainelDireito painelDireito) {
		this.painelEsquerdo = painelEsquerdo;
		this.painelDireito = painelDireito;
		painelDireitoModel= painelDireito.getPainelDireitoModel();
		AdicionarTodosOsItensAoModel();

	}

	public void enterClicado(JTextField campoAtual) {
		campoAtual.transferFocus();
	}

	public void apenasNumeros(KeyEvent e, String sequenciaPermitida) {
		if (!sequenciaPermitida.contains(e.getKeyChar() + "")) {
			e.consume();
		}
	}

	public void enviar() {
		Item ultimoItem=new Item(painelEsquerdo.getNomeText(), painelEsquerdo.getDescricaoText(),
				painelEsquerdo.getQuantidadeText());
		itemDao.save(ultimoItem);
		painelDireitoModel.setUltimoItem(ultimoItem);
		painelDireito.adicionarUltimoItemATabela();

	}

	/*public List<String> pegarTodosNomes() {
		List<String>nomes=new ArrayList<String>();
		for(Item item :itemDao.pegarTodosItens()) {
			nomes.add(item.getNome());
			}
		return nomes;
	}*/
	private void AdicionarTodosOsItensAoModel() {
		painelDireitoModel.adicionarTodos(itemDao.pegarTodosItens()); 
	}
	private Vector<Item>pegarItens(){
		System.out.println("Itens do presentation:"+painelDireitoModel.getItens());
		return painelDireitoModel.getItens();
		
	}
	public Vector<String> pegarTodosOsNomes() {
		
		Vector<String> nomes=new Vector<String>(pegarItens().stream().map(x->x.getNome()).toList());  //(Vector<String>) pegarItens().stream().map(x->x.getNome()).toList();
		return nomes;
	}
	public Vector<Double> pegarTodosAsQuantidades() {
		Vector<Double> quantidades= new Vector<Double>(pegarItens().stream().map(x->x.getQuantidade()).toList());
		return quantidades;
	}
	public Vector<String> pegarTodosAsDescricoes() {
		Vector<String> descricoes= new Vector<String>(pegarItens().stream().map(x->x.getDescricao()).toList());  	
		return descricoes;
	}
	 
}
