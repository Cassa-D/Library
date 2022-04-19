package Amigo;
import java.util.ArrayList;

public class ListaAmigos {
	private final ArrayList<Amigo> alAmigos;

	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}
	
	public int addAmigo (String nome, String celular) {
		int idAmigo = alAmigos.size() + 1; 
		Amigo amigo = new Amigo(idAmigo, nome, celular);
		alAmigos.add(amigo);
		return idAmigo;
	}
	
	public int getListaAmigosSize(){
		return alAmigos.size();
	}

	public Amigo getAmigo(int id){
		return alAmigos.get(id - 1);
	}
}
