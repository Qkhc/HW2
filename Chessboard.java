import java.util.*;
import java.io.*;

// @author Elijah Holmberg Bobby Mushkot
public class Chessboard {
    public static PrintWriter writer;
    
    //sets start of linked list to null
    public static ChessPiece head;
    public static void ChessBoard(){
        head = null;
    }
    
    //inserts a piece into the linked list
    public static void insert(ChessPiece toIns){
        ChessPiece latest = toIns;
        latest.next = head;
        head = latest;
    
    }
    
    //prints every item in the linked list
    public static void Traverse(){
        ChessPiece current = head;
        while (current != null){
            current = current.next;
            writer.println(current);
        }
    }
   
    //finds a piece in the linked list
    public static String find(int col, int row){
        ChessPiece current = head;
        while(current != null)
            if(current.col == col && current.row == row)
                return current.color+" ";
            else
                current = current.next;
        return "-";
    }
   
    //checks if any pieces attack each other
    public static String attackCheck(){
        ChessPiece one = head;
        ChessPiece two = head.next;
        while(one != null){
            two = one.next;
            while(two != null){
                if(one.col == two.col && one.row == two.row)
                    return "Invalid";
                if(one.isAttacking(two))
                    return one.toString() +" "+two.toString();
                two = two.next;
            }
            one = one.next;
        }
        return "-";
    }
   
    //removes an item from the linked list
    public static ChessPiece Delete(ChessPiece toDel){
        ChessPiece prev = null;
        ChessPiece current = head;
        while(current != toDel && current != null)
            prev = current.next;
        if (current == null)
            return current;
        if (prev == null)
            head = head.next;
        else
            prev.next = current.next;
        return current;
    }
   
    //main method(sorry)
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(new File("input.txt"));
        
        //generates analysis.txt and sets it to be ouput
        writer = new PrintWriter(new FileWriter("analysis.txt"));
        
        int lineNumber = 0;
        int whiteKings = 0;
        int blackKings = 0;
        
        // read lines from in, extract and print tokens from each line
        while(in.hasNextLine() ){
            lineNumber++;
            
            // trim leading and trailing spaces, then add one trailing space so 
            // split works on blank lines
            String line = in.nextLine().trim() + " "; 

            // split line around white space 
            String[] token = line.split("\\s+");  

              
            int n = token.length;
            int boardSize;
            
            //if the lineNumber is odd insert all the pieces on that line
            if(lineNumber%2 != 0){
                boardSize = Integer.parseInt(token[0]);
                for(int i =1; i<n; i+=3){
                    int col = Integer.parseInt(token[i+1]);
                    int row = Integer.parseInt(token[i+2]); 
                    char color = token[i].charAt(0);
                    switch (token[i]) {
                        case "q":
                        case "Q":
                            insert(new Queen(col,row,color));
                            break;
                        case "k":
                            insert(new King(col,row,color));
                            whiteKings++;
                            break;
                        case "K":
                            insert(new King(col,row,color));
                            blackKings++;
                            break;
                        case "n":
                        case "N":
                            insert(new Knight(col,row,color));
                            break;
                        case "b":
                        case "B":
                            insert(new Bishop(col,row,color));
                            break;
                        case "r":
                        case "R":
                            insert(new Rook(col,row,color));
                            break;
                        default:
                            break;
                    }
                }
            }
            
            //if the line number is even check for validity and check query
            else{
                if(whiteKings > 1 || blackKings > 1){
                    writer.println("Invalid");
                    continue;
                }
                whiteKings = 0;
                blackKings = 0;
                
                int col = Integer.parseInt(token[0]);
                int row = Integer.parseInt(token[1]);
                if(attackCheck().equals("Invalid"))
                    writer.println("Invalid");
                else
                    writer.println(find(col, row)+attackCheck());
                
            }
        }
	writer.close();
    }
}
