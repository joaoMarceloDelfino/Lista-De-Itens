package br.com.joao.listadeitens.model;

 
 import java.util.Vector;

public class PainelDireitoModel {
private Vector<Item>itens=new Vector<Item>();
private Item ultimoItem;

public void adicionarItem(Item item) {
	itens.add(item);
}
public void adicionarTodos(Vector<Item>itens) {
	//itens.addAll(itens);
	this.itens.addAll(itens);
}
public Vector<Item> getItens(){
	System.out.println("Itens do model:"+itens);
	return itens;
} 
public void setUltimoItem(Item ultimoItem) {
	this.ultimoItem=ultimoItem;
}
public Item getUltimoItem() {
	return ultimoItem;
}

}
