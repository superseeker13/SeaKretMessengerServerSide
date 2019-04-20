import java.util.Scanner;

public class driver {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String choice;
        String msg;
        String dest;

        System.out.print("Would you like to send or delete?: ");
        choice = input.nextLine();
        TextConverter tc = new TextConverter("jpeg");
        if(choice.equals("send")){
            try{
                System.out.print("Enter your message: ");
                msg = input.nextLine();
                System.out.print("Username to send to: ");
                dest = input.nextLine();
                tc.toImage(msg, dest);
            }catch(Exception e){
                System.out.println("It didn't work for some reason.");
            }
        }

        if(choice.equals("delete")){
            System.out.print("Enter a username: ");
            tc.scrubFiles(input.nextLine());
        }
    }
}