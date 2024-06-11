package bancodados;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import models.Item;

public class ItemDao {
	SessionFactory fabrica = new Configuration().configure().buildSessionFactory();
	Session sessao;
	Transaction t;

	public void save(Item item) {

		try {
			sessao = fabrica.openSession();
			t = sessao.beginTransaction();
			sessao.save(item);
			t.commit();
			System.out.println("Salvo");
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public Vector<Item> pegarTodosItens() {

		try {
			sessao = fabrica.openSession();
			List<Item> lista;
			Query<Item> query = sessao.createQuery("FROM Item");
			lista = query.list();
			System.out.println("Itens do DAO:"+lista);
			Vector<Item> realLista = new Vector<Item>(lista);
			return realLista;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return null;
	}
}
