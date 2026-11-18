class Solution{
    public int numRookCaptures(char[][] board){
        int x=-1, y=-1;

        // Finding the position of the rook
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(board[i][j]=='R')
                {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        int pawns = 0; // No of pawns the rook can take


        // Now, moving down, up, right, left and following the rules provided
        for(int i=x; i<8; i++) // from the current position(x,y) on chess board, moving towards down 
        {
            if(board[i][y]=='p')
            {
                pawns++;
                break;
            }
            if(board[i][y]=='B') break;
        }

        for(int i=x; i>=0; i--) // from the current position(x,y) on chess board, moving towards up
        {
            if(board[i][y]=='p') // black pawn encountered first
            {
                pawns++;
                break;
            }
            if(board[i][y]=='B') break; // white bishop encountered first
        }


        for(int j=y; j<8; j++) // from the current position(x,y) on chess board, moving towards right
        {
            if(board[x][j]=='p')
            {
                pawns++;
                break;
            }
            if(board[x][j]=='B') break;
        }

        for(int j=y; j>=0; j--) // from the current position(x,y) on chess board, moving left
        {
            if(board[x][j]=='p')
            {
                pawns++;
                break;
            }
            if(board[x][j]=='B') break;
        }
        return pawns;
    }
}