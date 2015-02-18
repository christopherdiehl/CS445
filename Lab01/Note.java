public class Note{
 public static void main(String[] args)
	{
	 System.out.println("");
	 System.out.println("");
	 System.out.println("Hey!");
	 pause();
	 System.out.println("Hey YOU!");
	 System.out.println("");
	 pause();
	 System.out.println("Yea you.");
	 pause();
	 System.out.println("");
	 System.out.println("Guess What?!");
	 pause();
	 for(int i=0; i< 5; i++){
	  System.out.println("...");
	  pause();
	  }
	 System.out.println("I LOVE YOU!");
	 
	 }
  public static void pause(){
   try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
  }
 }