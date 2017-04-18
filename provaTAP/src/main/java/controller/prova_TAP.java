package controller;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Veiculo;

@WebServlet(urlPatterns = "/controller")

public class prova_TAP extends HttpServlet {

	private ArrayList<Object> lista = new ArrayList<Object>();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		String placa = req.getParameter("placa");
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		double valor = Double.parseDouble(req.getParameter("valor"));
		
		Veiculo veic = new Veiculo(lista.size()+1,placa, nome, marca, valor);
		lista.add(veic);
		resp.getWriter().println("{ id:" + veic.getId() + " , Placa: " +
				veic.getPlaca() + ", Nome: " 
				+ veic.getNome() +", Marca: " + veic.getMarca() + ", Valor: "+ veic.getValor() + " } ");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		for(int i=0;i<lista.size();i++){
			if(id == ((Veiculo) lista.get(i)).getId()){	
				lista.remove(i);
			}
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String placa = req.getParameter("placa");
		String nome = req.getParameter("nome");
		String marca = req.getParameter("marca");
		double valor = Double.parseDouble(req.getParameter("valor"));
		
	
		for(int i=0;i<lista.size();i++){
			if(id == ((Veiculo) lista.get(i)).getId()){
				((Veiculo) lista.get(i)).setPlaca(placa);
				((Veiculo) lista.get(i)).setNome(nome);
				((Veiculo) lista.get(i)).setMarca(marca);
				((Veiculo) lista.get(i)).setValor(valor);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
	
		String buscaPlaca = req.getParameter("buscaPlaca");
		String qtd = req.getParameter("qtd");
		String caro = req.getParameter("maisCaro");
		String barato = req.getParameter("maisBarato");
		
		for(int i=0;i<lista.size();i++){
			if(buscaPlaca.equals(((Veiculo) lista.get(i)).getPlaca())){
				resp.getWriter().println("{ id:" + ((Veiculo) lista.get(i)).getId() + " , Placa: " +
						((Veiculo) lista.get(i)).getPlaca() + ", Nome: " 
						+ ((Veiculo) lista.get(i)).getNome() +", Marca: " 
						+ ((Veiculo) lista.get(i)).getMarca() + ", Valor: "
						+ ((Veiculo) lista.get(i)).getValor()  + " } ");
			}else{
				resp.getWriter().println(" ");
			}
		}
		
		resp.getWriter().println("{ qtd:" + lista.size() + " } ");	
		
		double maisBarato = ((Veiculo) lista.get(0)).getValor();
		double maisCaro = ((Veiculo) lista.get(0)).getValor();
		
		for(int i=0;i<lista.size();i++){
			resp.getWriter().println("{ id:" + ((Veiculo) lista.get(i)).getId() + " , Placa: " +
				((Veiculo) lista.get(i)).getPlaca() + ", Nome: " 
				+ ((Veiculo) lista.get(i)).getNome() +", Marca: " 
				+ ((Veiculo) lista.get(i)).getMarca() + ", Valor: "
				+ ((Veiculo) lista.get(i)).getValor()  + " } ");
			if(((Veiculo) lista.get(i)).getValor() < maisBarato){
				maisBarato = ((Veiculo) lista.get(i)).getValor();
			}
			if(((Veiculo) lista.get(i)).getValor()> maisCaro){
				maisCaro = ((Veiculo) lista.get(i)).getValor();
			}
		}
		
	}
}