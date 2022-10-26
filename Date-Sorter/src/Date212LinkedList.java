
public abstract class Date212LinkedList {
	protected Date212Node first = new Date212Node(null);
	protected Date212Node last = first.next;
	protected int length = 0;
	
	private void Date212LinkedList() {						//Make Linked List method
		first = new Date212Node(null);
		last = first.next;
		length = 0;
	}
	
	public Date212Node rNode() {  //this will return the node
		return first.next;
	}
	
	
	protected void append(Date212 a) {
		Date212Node appendTo = new Date212Node(a);			//Node being appended, taking Date212 object
		if(length == 0) {									//If no nodes exist, append from first.next
			first.next = appendTo;
			last = appendTo;
			length++;
		}
		else {												//Normal append
			last.next = appendTo;
			last = appendTo;
			length++;
		}
	}
	
	
}
