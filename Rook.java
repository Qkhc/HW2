//@author Elijah Holmberg and Bobby Mushkot
public class Rook extends ChessPiece {
    
    public Rook(int col, int row, char color){
        super (col, row, color);
    }

    @Override
     public boolean isAttacking(ChessPiece c){
        return row == c.row || col == c.col;
    }
}