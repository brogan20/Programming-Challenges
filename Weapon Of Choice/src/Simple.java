import java.util.Scanner;

public class Simple {
	
	public static void main(String[] args){
	    //Input
		Scanner scan = new Scanner(System.in);
		String get = scan.next();
		//Output
		System.out.println(get);
		
		//Array in 2d
		int[][] arr2d = new int[(int)(Math.random()*100)][(int)(Math.random()*100)];
		for(int i = 0; i < arr2d.length; i++){
		    for(int j = 0; j < arr2d[i].length; j++){
		        arr2d[i][j] = (int)(Math.random()*100)+1;
		    }
		}
		//Sentinel
		for(int i = 0; i < arr2d.length; i++){
		    for(int j = 0; j < arr2d[i].length; j++){
		        System.out.println(arr2d[i][j]);
		    }
		}
		
	}
	//Record/Structure
	public static class struc{
	    //Constants
	    final int a;
	    final int b;
	    
	    public struc(int a, int b){
	        this.a = a;
	        this.b = b;
	    }
	    
	    //Methods
	    public int geta(){
	        return a;
	    }
	    public int getb(){
	        return b;
	    }
	}
}
