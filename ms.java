
public class MineSweeper {

	public static void main (String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		int cols = ap.nextInt("How many columns?");
		int rows = ap.nextInt("How many rows?");
		double percent = ap.nextDouble("What is the probability of a bomb?");

		String[][] board = new String[cols+2][rows+2];	
				
		for (int row = 0; row < board.length; row++){
			for (int column = 0; column < board[row].length; column++){
				double r = Math.random() * 100;
				boolean bomb = r < percent;
				if (bomb){
					String temp = board[row][column] = "*";
				} else{
					String temp = board[row][column] = ".";
				}
			
			}
		}
	

		for (int row = 1; row < board.length-1; row++){
				for (int column = 1; column < board[row].length-1; column++){
						System.out.print(board[row][column] + "  ");	
				}
			
			System.out.println();
		}

		
		//
		
		for (int row = 0; row < board.length; row++){
			for (int column = 0; column < board[row].length; column++){
				if (row == 0 || row == rows+1){
					board[row][column] = "0";
				}else if (column == 0 || column == cols+1){
					board[row][column] = "0";
				}
		}
		
		System.out.println();
		for (int row = 1; row < board.length-1; row++){
			for (int column = 1; column < board[row].length-1; column++){
				if (board[row][column] == "*"){
					System.out.print("*  ");
				} 
				else {
					int tempCount = 0;
	
					if (board[row + 1][column] == "*"){
						tempCount++;	
					} 
					if (board[row][column - 1] == "*"){
						tempCount++;	
					} 
					if (board[row - 1][column] == "*"){
						tempCount++;	
					}
					if (board[row][column + 1] == "*"){
						tempCount++;	
					} 
					if (board[row + 1][column - 1] == "*"){
						tempCount++;	
					} 
					if (board[row - 1][column - 1] == "*"){
						tempCount++;	
					} 
					if (board[row - 1][column + 1] == "*"){
						tempCount++;	
					} 
					if (board[row + 1][column + 1] == "*"){
						tempCount++;	
					}
					String nowString = Integer.toString(tempCount);
					board[row][column] = nowString;
					System.out.print(board[row][column] + "  ");
				}
			}
		System.out.println();
		}
	}
}
