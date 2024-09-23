public class LinkedList {
    private Node head;  // Head of the linked list
    private Node tail = null;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty(){
        return(this.head == null);
    }
    // Method to insert a new node at the end
    public void insertAtEnd(String data) {
        Node newest = new Node(data);
        if(isEmpty())
            head = newest;
        else{
            tail.setNext(newest);
        }
        tail = newest;
        // To be implemented
    }

    // Method to update a specific position in the list
    public void updatePosition(int position, String data) {
        Node current = head;
        while(current != null){
            try {
                    if (position == Integer.parseInt(current.data)) {
                        current.data = data;
                    }
                }
            catch (NumberFormatException e) {
                    System.out.println("The value is not an integer");
                }
                current = current.next;
        }
        // To be implemented
    }

    // Method to get the value at a specific position
    public String getPositionValue(int position) {
        Node current = head;
        String output = null;
        output = "Please reenter value";
        while(current != null){
            try{
                if (position == Integer.parseInt(current.data)) {
                    output = "";
                    break;
                }
            }
            catch(NumberFormatException e){
                    System.out.println("Value is not an integer");
            }
            current = current.next;
        }
        return output;
        // To be implemented
    }

    // Method to display the Tic Tac Toe board
    public void displayBoard() {
        Node current = head;
        int count = 0;
        while(current != null){
            count = count + 1;
            System.out.print(current.data + "\t");
            if((count == 3) || (count == 9) || (count == 6)){
                System.out.println();
            }
            current = current.next;
        }
        // To be implemented
    }

    // Method to check for a win
    public boolean checkWinCondition() {
        Node box1 = head;
        Node box2 = box1.next;
        Node box3 = box2.next;
        Node box4 = box3.next;
        Node box5 = box4.next;
        Node box6 = box5.next;
        Node box7 = box6.next;
        Node box8 = box7.next;
        Node box9 = box8.next;

        if(box1.data.equals(box2.data) && box1.data.equals(box3.data)){
            return true;
        }
        else if(box4.data.equals(box5.data) && box4.data.equals(box6.data)){
            return true;
        }
        else if(box7.data.equals(box8.data) && box7.data.equals(box9.data)){
            return true;
        }
        else if(box1.data.equals(box4.data) && box1.data.equals(box7.data)){
            return true;
        }
        else if (box2.data.equals(box5.data) && box2.data.equals(box8.data)) {
            return true;
        }
        else if(box3.data.equals(box6.data) && box3.data.equals(box9.data)){
            return true;
        }
        else if(box1.data.equals(box5.data) && box1.data.equals(box9.data)){
            return true;
        }
        else return box3.data.equals(box5.data) && box3.data.equals(box7.data);
        // To be implemented
    }

    // Method to check if the board is full (for draw condition)
    public boolean isBoardFull() {
        Node current = head;
        int count = 0;
        boolean output = true;
        while(current != null){
            if(!(current.data.equals("X")) && !(current.data.equals("O"))){
                output = false;
                break;
            }
            current =current.next;
        }
        return output;
        // To be implemented
    }

    // Method to reset the board
    public void resetBoard() {
        Node current = head;
        int count = 0;
        for(int i = 0; i<9; i++){
            count = count +1;
            current.data = String.valueOf(count);
            current = current.next;
        }
        // To be implemented
    }
}
