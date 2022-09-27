import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
* class Conversation has one method, main(), which executes
* the code necessary to facilitate a conversation between
* a chatbot and the user. 
*/
class Conversation{
  /**
   * Executes the conversation
   * @param arguments
   */
  public static void main(String[] arguments){
    //starts conversation
    var user_input = new Scanner(System.in);
    System.out.println("How many rounds?");

    //stores input from user (number of rounds)
    int numRounds = user_input.nextInt();

    //creates a list in which to store the transcript
    ArrayList <String> transcript = new ArrayList<>();

    //generates a random num (for alternating between set canned/conversation starters)
    Random randomNum = new Random(); 

    //list of conversation starters
    ArrayList <String> conversation_starters = new ArrayList<String>();
    conversation_starters.add("What's up?");
    conversation_starters.add("How is your day going?");
    conversation_starters.add("What's on your mind?'");
    conversation_starters.add("How are you?");
    conversation_starters.add("What do you want to talk about?");

    //list of canned responses
    ArrayList <String> canned_responses = new ArrayList<String>();
    canned_responses.add("Interesting.");
    canned_responses.add("WOW :O");
    canned_responses.add("Okay!!");
    canned_responses.add("Same.");
    canned_responses.add("I don't even know what to say...");
    canned_responses.add("Cool dude!");

    //prints line one before the loop
    int index = randomNum.nextInt(conversation_starters.size()-1);
    String line_one = conversation_starters.get(index); 
    System.out.println(line_one);

    //adds line one to transcript
    transcript.add(line_one);

    //creates scanner for user responses
    Scanner response = new Scanner(System.in);

    //loops through conversation according to the number of rounds selected by the user
    for (int i=0; i<numRounds; i++){
      String user_response = response.nextLine();
      user_response = user_response + " ";
      transcript.add(user_response);

      //First response
      String bot_response = "";

      String [] words = user_response.split(" ");
      //iterates user response (word by word), replaces mirror words
      for (int j=0; j < words.length; j++){
        if (words[j].equals("you")){
          words[j] = "I";
          bot_response = bot_response + words[j] +" ";
        }
          
        else if (words[j].equals("I")||words[j].equals("i")){
          words[j] = "you";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("are")){
          words[j] = "am";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("was")){
          words[j] = "were";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("am")){
          words[j] = "are";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("my")){
          words[j] = "your";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("your")){
          words[j] = "my";
          bot_response = bot_response + words[j] +" ";
        }

        else if (words[j].equals("me")){
          words[j] = "you";
          bot_response = bot_response + words[j] +" ";
        }

        else{
          bot_response = bot_response + words[j] +" ";
        }
      }

      //prints a canned response if user_response has no mirror words
      if (user_response.equals(bot_response)){
        int index2 = randomNum.nextInt(canned_responses.size()-1);
        String canned_response = canned_responses.get(index2);
        System.out.println(canned_response);
        transcript.add(canned_response);
      }

      else{
        System.out.println(bot_response);
        transcript.add(bot_response);
      }  

  }

  //ends conversation, prints transcript
  System.out.println("Good talk! See you l8tr!! :) <3");
  System.out.println("TRANSCRIPT");
  System.out.println(transcript);

  //closes scanners (avoids resource leak)
  user_input.close();
  response.close();
  }
}