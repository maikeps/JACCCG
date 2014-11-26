package BD;

import java.util.List;

import Batalha.Oponente;
import Cartas.Carta;
import Cartas.CartaDeColecao;
import Colecao.Colecao;
import Colecao.Loja;
import Colecao.RegistroDeBaralho;
import Colecao.Usuario;

public class DAOController {

	private static DAOController daoController;
	private DAOFactory daoFactory;
	
	private DAOController(){
		daoFactory = DAOFactory.getInstance();
	}
	
	public static DAOController getInstance(){
		if(daoController == null) daoController = new DAOController();
		return daoController;
	}
	
	public Carta getCarta(int id){
		CartaDAO cartaDAO = daoFactory.getCartaDAO();
		CartaDeColecao carta = (CartaDeColecao) cartaDAO.load(id);
		return carta;
	}
	
	public Colecao getColecao(int id){
		ColecaoDAO colecaoDAO = daoFactory.getColecaoDAO();
		Colecao colecao = (Colecao) colecaoDAO.loadColecao(id);
		return colecao;
	}
	
	public Oponente getOponente(int id){
		OponenteDAO oponenteDAO = daoFactory.getOponenteDAO();
		Oponente oponente = (Oponente) oponenteDAO.load(id);
		return oponente;
	}
	
	public Usuario getUsuario(int id){
		UsuarioDAO usuarioDAO = daoFactory.getUsuarioDAO();
		Usuario usuario = (Usuario) usuarioDAO.load(id);
		return usuario;
	}

	public List<Oponente> getOponentes() {
		OponenteDAO oponenteDAO = daoFactory.getOponenteDAO();
		List<Oponente> oponentes = oponenteDAO.loadOponentes();
		return oponentes;
	}

	public Loja getLoja(int idUsuario) {
		CartaDAO cartaDAO = daoFactory.getCartaDAO();
		List<CartaDeColecao> cartas = cartaDAO.loadCartasLiberadas(idUsuario);
		return new Loja(cartas);
	}

	public void updateOponente(Oponente oponente) {
		OponenteDAO oponenteDAO = DAOFactory.getInstance().getOponenteDAO();
		oponenteDAO.update(oponente, oponente.getId());
	}
	
	public void updateCartaLiberada(int idCarta, int idUsuario){
		CartaDAO cartaDAO = DAOFactory.getInstance().getCartaDAO();
		cartaDAO.storeCartaLiberada(idCarta, idUsuario);
	}

	public void updateDinheirosUsuario(int idUsuario, int dinheiros) {
		UsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
		usuarioDAO.updateDinheiros(idUsuario, dinheiros);
	}

	public void storeCartaNaColecao(int idColecao, int idCarta) {
		ColecaoDAO colecaoDAO = DAOFactory.getInstance().getColecaoDAO();
		colecaoDAO.storeCartaNaColecao(idColecao, idCarta);
	}

	public void storeBaralho(int idColecao, RegistroDeBaralho baralho) {
		BaralhoDAO baralhoDAO = DAOFactory.getInstance().getBaralhoDAO();
		baralhoDAO.storeBaralho(idColecao, baralho);
	}

	public void deleteCartaColecao(int idColecao, int idCarta) {
		ColecaoDAO colecaoDAO = DAOFactory.getInstance().getColecaoDAO();
		colecaoDAO.deleteCartaColecao(idColecao, idCarta);
	}

	public List<Oponente> getOponentesLiberados(int idUsuario) {
		OponenteDAO oponenteDAO = DAOFactory.getInstance().getOponenteDAO();
		List<Oponente> oponentes = oponenteDAO.loadOponentesLiberados(idUsuario);
		return oponentes;
	}

	public void liberaOponente(int idUsuario, int idProxOponente) {
		OponenteDAO oponenteDAO = DAOFactory.getInstance().getOponenteDAO();
		oponenteDAO.liberaOponente(idUsuario, idProxOponente);
	}

	public int novoJogo(String nome, int dinheiros) {
		UsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
		return usuarioDAO.newUsuario(nome, dinheiros);
	}

	public void deleteBaralho(RegistroDeBaralho baralho, int idUsuario) {
		BaralhoDAO baralhoDAO = DAOFactory.getInstance().getBaralhoDAO();
		baralhoDAO.updateCartasDoBaralho(baralho, idUsuario);
	}
}
