package Q1E2;

public class MateriaArray<Type> {
	private int size;
	private int lastElement;
	private Type[] array;
	
	public void add(Type valor) {
		if(this.lastElement == this.size - 1) {
			this.increaseSize();
			this.array[this.lastElement] = valor;
		}else {
			this.array[this.lastElement] = valor;
		}
		this.lastElement ++;
	}

	private void increaseSize() {
		@SuppressWarnings("unchecked")
		Type novo[] = (Type[]) new Object[this.size + 3];
		for(int i = 0; i < this.size; i++) {
			novo[i] = this.array[i];
		}
		this.size += 3;
		this.array = novo;
	}
	
	public void remove(Type valor) {
		for(int i = 0; i < this.lastElement; i++) {
			if(this.array[i] == valor) {
				for(int j = i; j < lastElement; j++) {
					this.array[j] = this.array[j+1];
				}
				break;
			}
		}
		this.lastElement--;
	}
	
	@SuppressWarnings("unchecked")
	public MateriaArray(int size) {
		this.size = size;
		this.lastElement = 0;
		this.array = (Type[]) new Object[size];
	}
	
	public int getSize( ) {return size;}
	public void setSize(int size) {this.size = size;}
	
	public int getLastElement() {return lastElement;}
	public void setLastElement(int lastElement) {this.lastElement = lastElement;}
	
	public Type getElement(int i) {return this.array[i];}


	
}
