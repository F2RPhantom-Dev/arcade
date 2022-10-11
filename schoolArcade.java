/*
 * Made by -
 * Prateek Swarup Pradhan(roll 30)
 * Ansuman Patra(roll 10)
 * class 10 B
 */
import java.util.*;
public class schoolArcade
{
    Scanner obj = new Scanner(System.in);
    static int w=0,l=0,d=0;//to count no. of wins , loses and draws in rps
    static int decide,c_decide,c_score,c_bat;//used in hand cricket
    static int choose,player1Choice,player2Choice;//used in tic tac toe
    RockPaperScissors rpsobject = new RockPaperScissors();//object of class rockpaperscissors
    handcricket2 hcobject = new handcricket2();//object of hand cricket class
    TicTacToe tttobject = new TicTacToe();//object of tictactoe class
    Hangman hgobjext = new Hangman();
    public class RockPaperScissors
    {
        Scanner obj = new Scanner(System.in);

        int rps,c_rps; String RPS,C_RPS;//rps = player's number ; c_rps = computer's number; RPS & C_RPS = their respective choices of rock, paper or scissors
        public void welcomeRPS()
        {
            System.out.println("Press \n1 for rock \n2 for paper \n3 for scissors \n(please enter a single integer)");
        }

        public void userChoice()
        {
            RockPaperScissors ob = new RockPaperScissors();
            int choice = obj.nextInt();
            if(choice ==1)
            {RPS = "Rock";System.out.println("You chose - "+RPS); }
            else if(choice ==2) 
            {RPS = "Paper";System.out.println("You chose - "+RPS);}
            else if(choice ==3)
            {RPS = "Scissor";System.out.println("You chose - "+RPS);}
            else
            {System.out.println("WRONG CHOICE!! \nWe are taking you back to welcome screen."); ob.welcomeRPS();ob.userChoice();}
        }

        public void computerChoice()
        {
            int c_choice = (int)(Math.random()*3)+1;
            if(c_choice ==1)
            {C_RPS = "Rock";System.out.println("The computer chose - "+C_RPS); }
            else if(c_choice ==2) 
            {C_RPS = "Paper";System.out.println("The computer chose - "+C_RPS);}
            else if(c_choice ==3)
            {C_RPS = "Scissor";System.out.println("The computer chose - "+C_RPS);}
        }

        public void gameplay()
        {
            if(RPS == "Rock")//when we choose rock
            {
                if(C_RPS=="Rock")
                {System.out.println("DRAW");d++;}
                else if(C_RPS == "Paper")
                {System.out.println("DEFEAT");l++;}
                else if(C_RPS=="Scissor")
                {System.out.println("VICTORY!!");w++;}
            }

            else if(RPS == "Paper")//when we choose paper
            {
                if(C_RPS=="Rock")
                {System.out.println("VICTORY!!");w++;}
                else if(C_RPS == "Paper")
                {System.out.println("DRAW");d++;}
                else if(C_RPS=="Scissor")
                {System.out.println("DEFEAT");l++;}
            }
            else//When we choose scissor
            {
                if(C_RPS=="Rock")
                {System.out.println("DEFEAT");l++;}
                else if(C_RPS == "Paper")
                {System.out.println("VICTORY!!");w++;}
                else if(C_RPS=="Scissor")
                {System.out.println("DRAW");d++;}
            }
        }

        public void mainrps()
        {
            RockPaperScissors ob = new RockPaperScissors();
            char userchoice;
            System.out.println("HELLO THERE! \tWELCOME TO ROCK PAPER SCISSORS \nYou are playing against the computer\n");
            do{

                ob.welcomeRPS();ob.userChoice();ob.computerChoice();ob.gameplay();
                System.out.println("\nTo play again press R \nPress any other key to exit");
                userchoice = obj.next().charAt(0);
            }while(userchoice=='R'||userchoice=='r');

            System.out.println("THANKS A LOT FOR PLAYING ROCK PAPER SCISSORS. HERE ARE YOUR STATS - ");
            System.out.println("You won - " + w + " times");
            System.out.println("You lost - " + l + " times");
            System.out.println("You tied - " + d + " times");
        }
    }

    class handcricket2
    {
        Scanner obj = new Scanner(System.in);
        String toss_result,c_tossResult,message;

        int nb,c_bowl,score =0,bat=0;//these variables are for the case when user chooses to bat first/computer bowls first
        int userBowl,compBat,userBat,compBowl,compScore,userScore;
        public void odd_or_eve()
        {
            System.out.println("Enter 1 for odd and 2 for eve");
            int toss = obj.nextInt();
            toss_result=null;
            if(toss==1)
                toss_result="ODD";
            else if(toss==2)
                toss_result="EVE";
            else
            {System.out.println("WRONG CHOICE!");System.exit(0);}

            c_tossResult=null;
            int c_toss;
            if(toss==1)
                c_toss=2;
            else
                c_toss = 1;
            if(c_toss==1)
                c_tossResult="ODD";
            else if(c_toss==2)
                c_tossResult="EVE";

            System.out.println("You chose - " + toss_result + " and \nThe Computer chose - " +c_tossResult);
        }

        public void Toss()
        {
            System.out.println("Enter your number for the toss");
            System.out.println("The number you enter should be only from 1 to 6");
            message=null;
            int input=obj.nextInt();
            if(input<1||input>6)
            {System.out.println("*EXIT*");}
            int c_input =  (int)(Math.random()*6)+1;
            System.out.println("You entered - " +input + " and \nThe computer entered - " +c_input);
            int result = input+c_input;
            System.out.println("The result is - "+result);
            if(result%2==1)//first we check the possibilty for odd
            {
                if(toss_result=="ODD")
                    message = "YOU WON THE TOSS! :)";
                else 
                    message = "YOU LOST THE TOSS! :(";
            }
            else if(result%2==0)//next we check the possibilty for eve
            {
                if(toss_result=="EVE")
                    message = "YOU WON THE TOSS! :)";
                else 
                    message = "YOU LOST THE TOSS! :(";
            }
            System.out.println(message);
        }

        public void decision()
        {
            decide=0;
            if(message == "YOU WON THE TOSS! :)")//when we won the toss
            {
                System.out.println("Select 1 to bowl first and 2 to bat first");
                decide = obj.nextInt();
                if(decide == 1)
                    System.out.println("SO YOU CHOSE TO BOWL FIRST. NICE CHOICE!");
                else if(decide ==2)
                    System.out.println("SO YOU CHOSE TO BAT FIRST. NICE CHOICE!");
                else
                    System.out.println("WRONG CHOICE!*EXIT*");
            }

            else//when we lost the toss
            {
                System.out.println("Since you have lost the computer shall choose");
                for(int i =1;i<=1000;i++);//time delay loop
                c_decide = 0;
                c_decide =(int)Math.random()*2+1;
                if(c_decide == 1)
                    System.out.println("THE COMPUTER CHOSE TO BOWL FIRST. NICE CHOICE!");
                else if(c_decide ==2)
                    System.out.println("THE COMPUTER CHOSE TO BAT FIRST. NICE CHOICE!");
            }
        }

        //The following 2 methods are when the user chooses to bat first OR the computer chooses to bowl first
        public void bat()//when we bat
        {

            do
            {
                System.out.println("Enter your number for batting(only from 1 to 6) :");
                bat = obj.nextInt();
                if(bat<0||bat>6)
                {System.out.println("WRONG CHOICE \n*EXIT*");System.exit(0);}
                c_bowl = (int)(Math.random()*6)+1;
                System.out.println("You chose : "+bat);
                System.out.println("The computer chose "+c_bowl);
                if(bat!=c_bowl)
                {score+=bat;
                    System.out.println("\nCurrent Score - "+score);}       
            }while(bat!=c_bowl);
            System.out.println("OUT!!");
            System.out.println("The score for the computer to beat is : " +(score+1));
        }

        public void c_bat()//when computer bats (this method is post to bat() method)
        {

            c_bat=0;
            do
            {
                System.out.println("Enter your number for bolwing (AS TOLD BEFORE 0<NUMBER<7)");
                nb = obj.nextInt();
                if(nb<=0&&nb>6)
                {System.out.println("WRONG ENTRY");System.exit(0);}
                c_score = (int)(Math.random()*6)+1;
                System.out.println("You chose : "+nb);
                System.out.println("The computer chose "+c_score);
                if(nb!=c_score&&c_bat<score)
                {
                    c_bat+=c_score;
                    System.out.println("\nCurrent Score - "+c_bat);
                    System .out.println("\nThe score to beat ="+ (score+1-c_bat));
                }            
            }while(nb!=c_score&&c_bat<score);

            if(c_bat>score)
                System.out.println("You lost. Better luck next time");

            else if(c_bat<score)
                System.out.println("OUT!!\nYOU WON");
            else
                System.out.println("The game is a draw");
        }

        public void bowl()//we bowl
        {
            compScore=0;
            do
            {
                System.out.println("Enter your number for bolwing (AS TOLD BEFORE 0<NUMBER<7)");
                userBowl=obj.nextInt();
                if(userBowl<=0&&userBowl>6)
                {System.out.println("WRONG ENTRY");System.exit(0);}
                compBat = (int)(Math.random()*6)+1;

                System.out.println("You chose : "+userBowl);
                System.out.println("The computer chose "+compBat);

                if(userBowl!=compBat)
                {
                    compScore+=compBat;
                    System.out.println("Current Score - "+compScore);
                }

            }while(userBowl!=compBat);
            System.out.println("OUT!!");
            System.out.println("The score for you to beat is : " +(compScore+1));
        }

        public void c_bowl()
        {
            do
            {
                System.out.println("Enter your number for batting (AS TOLD BEFORE 0<NUMBER<7)");
                userBat=obj.nextInt();
                if(userBat<0||userBat>6)
                {System.out.println("WRONG CHOICE \n*EXIT*");System.exit(0);}
                compBowl = (int)(Math.random()*6)+1;
                System.out.println("You chose : "+userBat);
                System.out.println("The computer chose "+compBowl);

                if(userBat!=compBowl&&userScore<compScore)
                {
                    userScore+=userBat;
                    System.out.println("\nCurrent Score - "+userScore);
                    System .out.println("\nThe score to beat ="+ (compScore+1-userBat));
                }            
            }while(userBat!=compBowl&&userScore<compScore);        

            if(userScore>compScore)
                System.out.println("OUT!!\nYOU WON!!");
            else if(userScore<compScore)
                System.out.println("You lost! Better luck next time.");
            else
                System.out.println("The game is a draw");
        }

        public void mainhandcricket()
        {
            char replay;
            do
            {
                System.out.println("WELCOME TO HAND CRICKET!! \nBe very careful while entering a number.");
                System.out.println("If its a wrong input the entire game would stop and there might be chances of errors.");
                System.out.println("So please enter the correct input and \nENJOY THE GAME :)");
                handcricket2 ob = new handcricket2();
                ob.odd_or_eve(); System.out.println("\n");
                ob.Toss();System.out.println("\n");
                ob.decision();System.out.println("\n");
                if(decide ==2||c_decide==1)
                {
                    ob.bat();System.out.println("\n");
                    ob.c_bat();System.out.println("\n");
                }
                else if(decide == 1|| c_decide ==2)
                {
                    ob.bowl();System.out.println("\n");
                    ob.c_bowl();System.out.println("\n");
                }

                System.out.println("To play again press r\n press any other letter to exit");
                replay = obj.next().charAt(0);
            }while (replay== 'r'||replay=='R');
            System.out.println("Thanks for playing Hand Cricket\nDont forget to try out the other games.");
        }
    }

    class TicTacToe
    {
        Scanner obj=new Scanner(System.in);
        char player;int i;

        char positions[] = new char[9];int winDecide;
        public void welcome()
        {
            System.out.println("Hello there! \nWelcome to tic tac toe \n\nPlease dont enter wrong input as it will exit the game\n\n");
            System.out.println("\nPlayer 1 -X \t Player 2 - O");
            char j='1';
            for(i=0;i<9;i++)
            {
                positions[i]=j;j++;
            }
        }

        public void board()
        {

            System.out.println(  "     |     |     " );
            System.out.println(  "  " + positions[0] + "  |  " + positions[1] + "  |  " + positions[2] );
            System.out.println(  "_____|_____|_____" );
            System.out.println(  "     |     |     " );
            System.out.println( "  " + positions[3] + "  |  " + positions[4] + "  |  " + positions[5] );
            System.out.println(  "_____|_____|_____" );
            System.out.println(  "     |     |     " );
            System.out.println(  "  " + positions[6] + "  |  " + positions[7]+ "  |  " + positions[8] );
            System.out.println( "     |     |     " );
            System.out.println( );

        }

        public int winGame()
        {
            if (positions[0] == positions[1] && positions[1] == positions[2])
                return 1;
            else if (positions[3] == positions[4] && positions[4] == positions[5])
                return 1;
            else if (positions[6] == positions[7] && positions[7] == positions[8])
                return 1;
            else if (positions[0] == positions[3] && positions[3] == positions[6])
                return 1;
            else if (positions[1] == positions[4] && positions[4] == positions[7])
                return 1;
            else if (positions[2] == positions[5] && positions[5] == positions[8])
                return 1;
            else if (positions[0] == positions[4] && positions[4] == positions[8])
                return 1;
            else if (positions[2] == positions[4] && positions[4] == positions[6])
                return 1;
            else if (positions[0] != '1' && positions[1] != '2' && positions[2] != '3' && positions[3] != '4' && positions[4] != '5' && positions[5] != '6' && positions[6] != '7' && positions[7] != '8' && positions[8] != '9')
                return 0    ;//this works when the game is a draw
            else 
                return -1;            
        }

        public void player1Gameplay()
        {
            char B = 'X';
            player1Choice=obj.nextInt();
            if (player1Choice == 1 && positions[0] == '1')
                positions[0] = B;
            else if (player1Choice == 2 &&positions[1] == '2')
                positions[1] = B;
            else if (player1Choice == 3 && positions[2] == '3')
                positions[2] = B;
            else if (player1Choice == 4 && positions[3] == '4')
                positions[3] = B;
            else if (player1Choice == 5 && positions[4] == '5')
                positions[4] = B;
            else if (player1Choice == 6 && positions[5] == '6')
                positions[5] = B;
            else if (player1Choice == 7 && positions[6] == '7')
                positions[6] = B;
            else if (player1Choice == 8 && positions[7] == '8')
                positions[7] = B;
            else if (player1Choice == 9 && positions[8] == '9')
                positions[8] = B;
            else
            {System.out.println("INVALID MOVE");}
        }

        public void player2Gameplay()
        {

            player2Choice=obj.nextInt();char A ='O';
            if (player2Choice == 1 && positions[0] == '1')
                positions[0] = A;
            else if (player2Choice == 2 &&positions[1] == '2')
                positions[1] = A;
            else if (player2Choice == 3 && positions[2] == '3')
                positions[2] = A;
            else if (player2Choice == 4 && positions[3] == '4')
                positions[3] = A;
            else if (player2Choice == 5 && positions[4] == '5')
                positions[4] = A;
            else if (player2Choice == 6 && positions[5] == '6')
                positions[5] = A;
            else if (player2Choice == 7 && positions[6] == '7')
                positions[6] = A;
            else if (player2Choice == 8 && positions[7] == '8')
                positions[7] = A;
            else if (player2Choice == 9 && positions[8] == '9')
                positions[8] = A;
            else
            {System.out.println("INVALID MOVE");}

        }

        public void mainttt()
        {
            char playagain;
            do
            {
                TicTacToe ob = new TicTacToe();
                ob.welcome();
                int k=0;
                int decider=0;

                inner:
                do
                {
                    ob.board();

                    System.out.println("Player 1 enter your number");
                    ob.player1Gameplay();decider=1;
                    k=ob.winGame();
                    if(k==1)
                        break;
                    ob.board();
                    System.out.println("Player 2 enter your number");
                    ob.player2Gameplay();decider=2;
                    k=ob.winGame();

                }while(k==-1);
                ob.board();
                if(k==1)//It means game has resulted in either the player or computer's victory
                {
                    System.out.println("player " + decider + " wins!");

                }
                else//game results in a draw
                    System.out.println("The game is a draw.");

                System.out.println("to play again press r");
                playagain = obj.next().charAt(0);
            } while(playagain=='r'||playagain=='R');
        }
    }

    class Hangman
    {
        void HangMan()
        {
            Scanner inp = new Scanner(System.in);
            System.out.println("Welcome to HangMan!");
            System.out.println("Here are the Rules to how to play hangman:");
            System.out.println("1Computer gives you a word which is converted to blanks which is equal the number of letters in the word");
            System.out.println("2)You have to guess a letter until you guess all the letters in the word");
            System.out.println("3)You have 6 Lives,if you lose all the 6 lives you lose the game");
            String 
            List[]={"funny","mummy","cat","dog","fish","nice","meme","pubg","school","elephant","grapes","horse","igloo","juice","kite","lemon","monkey",

                    "nut","onion","potato","queen","rice","sunny","tiger","umbrella","violet","well","xmas","yolk","zebra","aquaman","bees","coins","duck","eye","flush",

                    "girl","horse","island","joker","ketchup","lion","mice","needle","ocean","parrot","quit","ring","sting","tool","unicorn","van","word","xerox","yawn",
                    "zip"}; 
            String word="",blanks="",ans="",guesses="",temp="";
            char Letter='\u0000';
            int length=0,Lives_Left=6,numcheck=0;
            word=List[(int)(Math.random()*(55-0+1)+0)];
            length=word.length();
            blanks=word.replaceAll("[a-z]","_ ");
            while((Lives_Left!=0)&&(blanks.contains("_ ")))
            {

                System.out.println("***************************************************");
                System.out.println("Here is the board: ");
                System.out.println(blanks);
                System.out.println("Lives Left: "+Lives_Left);
                System.out.println();
                if(Lives_Left==6)
                {
                    System.out.println(" _________________");
                    System.out.println(" |/ |");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                else if(Lives_Left==5)
                {
                    System.out.println(" _________________ ");
                    System.out.println(" |/ | ");
                    System.out.println(" | (_) ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                else if(Lives_Left==4)
                {
                    System.out.println(" _________________ ");
                    System.out.println(" |/ | ");
                    System.out.println(" | (_) ");
                    System.out.println(" | | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                else if(Lives_Left==3)
                {
                    System.out.println(" _________________ ");
                    System.out.println(" |/ | ");
                    System.out.println(" | (_) ");
                    System.out.println(" | |- ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                else if(Lives_Left==2)
                {
                    System.out.println(" _________________ ");
                    System.out.println(" |/ | ");
                    System.out.println(" | (_) ");
                    System.out.println(" | -|- ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                else if(Lives_Left==1)
                {
                    System.out.println(" _________________ ");
                    System.out.println(" |/ | ");
                    System.out.println(" | (_) ");
                    System.out.println(" | -|- ");
                    System.out.println(" | | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println("_____|_____ ");
                }
                System.out.print("Guess a letter: ");
                ans=inp.next().trim().toLowerCase();
                Letter=ans.charAt(0);
                numcheck=Letter;

                if((numcheck<97)&&(numcheck>122))
                {
                    System.out.println();
                    System.out.println("Error!Wrong Input.");
                    System.out.println("'"+Letter+"' is not a letter.");
                    continue;
                }
                else if(guesses.indexOf(Letter)!=-1)
                {
                    System.out.println();
                    System.out.println("You Have Already Entered: "+Letter);
                }
                else if(word.indexOf(Letter)!=-1)
                {
                    System.out.println("Correct!'"+Letter+"' is there in the word");
                    for(int i=0;i<length;i++)
                    {
                        if(Letter==word.charAt(i)&&blanks.charAt(i)!=Letter)
                        {
                            blanks=blanks.replace("_ ","_");
                            temp= blanks.substring(0, i) + Letter + blanks.substring(i + 1 , blanks.length());
                            temp=temp.replaceAll("_","_ ");
                            blanks=temp;
                        }
                    }
                }
                else
                {
                    System.out.println();
                    System.out.println("'"+Letter+"' is not there in the word");
                    Lives_Left--;

                }
                guesses+=Letter; 
                System.out.println("***************************************************");
                System.out.println("///////////////////////////////////////////////////");
            }
            if(Lives_Left==0)
            {
                System.out.println(" _________________ ");
                System.out.println(" |/ | ");
                System.out.println(" | (_)");
                System.out.println(" | -|-");
                System.out.println(" | | |");
                System.out.println(" | ");
                System.out.println(" | ");
                System.out.println(" | ");
                System.out.println("_____|_____ ");
                System.out.println();
                System.out.println("Sorry,You Lost as you are out of Lives");
                System.out.println("The Word was: "+word);
                System.out.println("Game Over!");
            }
            else
            {

                System.out.println("***************************************************");
                System.out.println("RESULT: ");
                System.out.println("*---------------------------------*");
                System.out.println(" The Word is: "+blanks); 
                System.out.println(" CONGRATULATIONS,you solved it! ");
                System.out.println("*---------------------------------*");
                System.out.println("***************************************************");
                System.out.println("///////////////////////////////////////////////////");
            }
        } 
    }
    public void welcomeScreen()
    {
        System.out.println("\nHELLO THERE!!");

        System.out.println("\nWELCOME TO SCHOOL ARCADE\n");

        System.out.println("\nHere you will find a variety of games which I am sure you would have played in school during free periods, breaks and sometimes in between classes too.");
        System.out.println("\nWe have tried to re-create some of the most popular ones. This might not be as good as the actual ones, but we have tried to do our best.");
        System.out.println("\nNow, enjoy the games --");

        System.out.println("\nWhich game would you like to play first?You have the option to return to the menu at the end of each game.");

        System.out.println("\nPress the following numbers to choose your game - ");
        System.out.println("\n1-Rock Paper Scissors(a classic)");
        System.out.println("\n2-Hand Cricket(popular among both boys and girls)");
        System.out.println("\n3- Tic Tac Toe(The game which almost everytime resuts in a draw)");
        System.out.println("\n4-Hangman(The word wizard)");

        System.out.println("\n\nTo exit -press any other number");
    }

    public  void Main()
    {
        char game;
        do
        {
            schoolArcade abc = new schoolArcade();
            abc.welcomeScreen();
            int userchoice =obj.nextInt();
            if(userchoice==1)
                rpsobject.mainrps();
            else if(userchoice==2)
                hcobject.mainhandcricket();
            else if(userchoice==3)
                tttobject.mainttt();
            else if(userchoice==4)
                hgobjext.HangMan();
            else
            {System.out.println("WRONG INPUT. \n*EXIT");}

            System.out.println("Press R to go back to menu screen and press any other letter/number to exit");
            game = obj.next().charAt(0);
        }while(game=='R'||game=='r');

        System.out.println("Thanks for playing.We hope you had a great time!");
    }
}//end of program