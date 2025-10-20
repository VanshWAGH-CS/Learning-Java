public class Runner {
	public static void main(String[] args){
		Singli_Linked_list list = new Singli_Linked_list();
		list.insert(5);
		list.insert(10);
		list.insert(15);
		//list.show();
        list.insertAtStart(25);
        //list.show();
        list.insertAt(2, 20);
        list.show();
        list.deleteAt(2);
        list.show();
	}
}
