package binaryTree;

public class MeuItem implements Item {
	private int chave;
	
	public MeuItem(int chave) {
		this.chave = chave;
	}
	
	public int compara(Item it) {
		MeuItem item = (MeuItem) it;
		if(this.chave < item.chave) {
			return -1;
		} else if(this.chave > item.chave) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public void alteraChave(int chave) {
		Integer ch= (Integer) chave;		//altera o tipo para inteiro 
		this.chave = ch.intValue();
	}
	public int recuperaChave() {
		return this.chave;
	}
}

