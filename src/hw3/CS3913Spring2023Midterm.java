/* Decompiler 10ms, total 193ms, lines 11 */
package hw3;

public class CS3913Spring2023Midterm {
   public static void main(String[] args) {
      String[] questions = new String[]{"The Sky is blue", "The air is 21% oxygen", "This exam is in C++", "5+5 = 55", "Spring break was last week", "Charlie Chaplain is President of the USA"};
      boolean[] answers = new boolean[]{true, true, false, false, false, false};
      ExamQ e2 = new ExamQ(questions, answers);
      e2.startQuiz();
   }
}
