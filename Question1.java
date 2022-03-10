package javaProgramming;

import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Multiple Question trivia game!");
        System.out.println("You will be asked a question and you will have 5 answers to choose from.");
        System.out.println("You will be asked to type the correct answer and hit enter.");
        System.out.println("You will be notified whether you got the correct answer or not and the amount of time taken to answer the question.");
        System.out.println("You will be asked whether you want to keep playing or not.");
        System.out.println("If you type a yes, another question will be displayed and a set of answers will be provided.");
        System.out.println("If you type a no, the game will end.\n");

        MQTGame triviaGame = new MQTGame();
        triviaGame.start();
    }

    public static class MQTGame {
        private boolean keepPlaying = true;
        private int score = 0;
        private int questionNumber = 0;

        public void start() throws Exception {
            while (keepPlaying) {
                Question question = new Question();
                question.askQuestion();
                question.getAnswer();
                question.gradeAnswer();
                question.displayScore();
                question.displayQuestionNumber();
                question.displayTimeTaken();
                question.displayPlayAgain();
                keepPlaying = question.playAgain();
                questionNumber++;
            }
            System.out.println("Thank you for playing, see you!");
        }
    }

    public static class Question {
        private String question;
        private String[] answers;
        private String correctAnswer;
        private String userAnswer;
        private long startTime;
        private long endTime;
        private long timeTaken;

        public void askQuestion() {
            int questionNumber = 0;
            questionNumber = 0;
            
			System.out.println("Question " + (questionNumber) + ": " + question);
        }

        public void getAnswer() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type the correct answer and hit enter: ");
            userAnswer = scanner.nextLine();
        }

        public void gradeAnswer() {
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        public void displayScore() {
            System.out.println("Your score is: " + score);
        }

        public void displayQuestionNumber() {
            System.out.println("Question " + (questionNumber + 1) + " was answered.");
        }

        public void displayTimeTaken() {
            endTime = System.currentTimeMillis();
            timeTaken = endTime - startTime;
            System.out.println("It took you " + timeTaken + " milliseconds to answer the question.");
        }

        public void displayPlayAgain() {
            System.out.println("Do you want to play again? (yes/no)");
        }

        public boolean playAgain() {
            Scanner scanner = new Scanner(System.in);
            String playAgain = scanner.nextLine();
            if (playAgain.equals("yes")) {
                startTime = System.currentTimeMillis();
                return true;
            } else {
                return false;
            }
        }
    }

    public static class QuestionFactory {
        private String[] questions = {
                "What is the capital of Cameroon?",
                "What is the capital of France?",
                "What is the capital of Canada?",
                "What is the capital of Senegal?",
                "What is the capital of Rwanda?"
        };

        private String[] answers = {
                "Kigali",
                "Ottawa",
                "Yaounde",
                "Paris",
                "Dakar"
        };

        private String[] correctAnswers = {
                "Yaounde",
                "Paris",
                "Ottawa",
                "Dakar",
                "Paris"
        };

        public Question createQuestion() {
            Question question = new Question();
            question.question = questions[questionNumber];
            question.answers = answers;
            question.correctAnswer = correctAnswers[questionNumber];
            question.startTime = System.currentTimeMillis();
            return question;
        }
    } 
}
