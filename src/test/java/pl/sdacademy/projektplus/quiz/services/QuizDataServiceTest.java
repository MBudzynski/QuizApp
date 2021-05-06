package pl.sdacademy.projektplus.quiz.services;

import org.junit.jupiter.api.Test;
import pl.sdacademy.projektplus.quiz.frontend.Difficulty;
import pl.sdacademy.projektplus.quiz.question.CategoryQuestionCountInfoDto;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuizDataServiceTest {

    @Test
    void calculateEachDifficultyQuestionCount() {
        CategoryQuestionCountInfoDto categoryQuestionCount = new CategoryQuestionCountInfoDto(5, 17, 13);
        Map<Difficulty, Integer> result = QuizDataService.calculateEachDifficultyQuestionCount(20, Difficulty.EASY, categoryQuestionCount);

        assertEquals(5, result.get(Difficulty.EASY));
        assertEquals(15, result.get(Difficulty.MEDIUM));
        assertNull(result.get(Difficulty.HARD));
    }

    @Test
    void shouldAddQuestionDifficultyMediumAndHardToTotalCount20() {
        CategoryQuestionCountInfoDto categoryQuestionCount = new CategoryQuestionCountInfoDto(5, 10, 5);
        Map<Difficulty, Integer> result = QuizDataService.calculateEachDifficultyQuestionCount(20, Difficulty.EASY, categoryQuestionCount);

        assertEquals(5, result.get(Difficulty.EASY));
        assertEquals(10, result.get(Difficulty.MEDIUM));
        assertEquals(5, result.get(Difficulty.HARD));
    }

    @Test
    void shouldAddTheSameCountQuestionAtDifficultyEasyAndHard() {
        CategoryQuestionCountInfoDto categoryQuestionCount = new CategoryQuestionCountInfoDto(18, 10, 18);
        Map<Difficulty, Integer> result = QuizDataService.calculateEachDifficultyQuestionCount(24, Difficulty.MEDIUM, categoryQuestionCount);

        assertEquals(7 , result.get(Difficulty.EASY));
        assertEquals(10, result.get(Difficulty.MEDIUM));
        assertEquals(7, result.get(Difficulty.HARD));
    }



    @Test
    void shouldOnlyAddQuestionAtDifficultyHard() {
        CategoryQuestionCountInfoDto categoryQuestionCount = new CategoryQuestionCountInfoDto(20, 20, 20);
        Map<Difficulty, Integer> result = QuizDataService.calculateEachDifficultyQuestionCount(20, Difficulty.HARD, categoryQuestionCount);

        assertNull(result.get(Difficulty.EASY));
        assertNull(result.get(Difficulty.MEDIUM));
        assertEquals(20, result.get(Difficulty.HARD));
    }

    @Test
    void shouldAddQuestionAtDifficultyHardAndMedium() {
        CategoryQuestionCountInfoDto categoryQuestionCount = new CategoryQuestionCountInfoDto(20, 10, 10);
        Map<Difficulty, Integer> result = QuizDataService.calculateEachDifficultyQuestionCount(20, Difficulty.HARD, categoryQuestionCount);

        assertNull(result.get(Difficulty.EASY));
        assertEquals(10, result.get(Difficulty.MEDIUM));
        assertEquals(10, result.get(Difficulty.HARD));
    }
}