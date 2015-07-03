package br.senai.sc.ti20132n1.sa.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ti20132n1.sa.Dao.ClienteDao;
import br.senai.sc.ti20132n1.sa.model.Cidade;
import br.senai.sc.ti20132n1.sa.model.Cliente;
import br.senai.sc.ti20132n1.sa.model.Estado;
@ManagedBean
public class ClienteMB {
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Estado> estado;
	private List<Cidade> cidade;
	private ClienteDao clienteDao;
	
	@PostConstruct
	public void initMB(){
		this.cliente = new Cliente();
		clienteDao = new ClienteDao();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		if(clientes == null){
			clientes = clienteDao.listarTodos();
		}
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public List<Estado> getEstado() {
		return estado;
	}

	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidade() {
		return cidade;
	}

	public void setCidade(List<Cidade> cidade) {
		this.cidade = cidade;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public String salvar(){
		clienteDao.salvar(cliente);
		return "/login";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		clienteDao.excluir(id);
		return "formcliente";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		cliente = clienteDao.buscarPorId(id);
		return "cadastrocliente";
	}
	
	

}
