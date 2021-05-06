package pl.sdacademy.projektplus.quiz.frontend;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyTest {


    @Test
    void calculateNextDifficulty_easy() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.EASY);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.MEDIUM, result);
    }

    @Test
    void calculateNextDifficulty_null() {
        EnumSet<Difficulty> given = null;
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertNull(result);
    }

    @Test
    void calculateNextDifficulty_none() {
        EnumSet<Difficulty> given = EnumSet.noneOf(Difficulty.class);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertNull(result);
    }


    @Test
    void calculateNextDifficulty_medium() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.MEDIUM);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.HARD, result);
    }

    @Test
    void calculateNextDifficulty_hard() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.HARD);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.MEDIUM, result);
    }

    @Test
    void calculateNextDifficulty_easy_medium() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.EASY, Difficulty.MEDIUM);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.HARD, result);
    }

    @Test
    void calculateNextDifficulty_medium_hard() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.MEDIUM, Difficulty.HARD);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.EASY, result);
    }

    @Test
    void calculateNextDifficulty_hard_easy() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.HARD, Difficulty.EASY);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertEquals(Difficulty.MEDIUM, result);
    }

    @Test
    void calculateNextDifficulty_all() {
        EnumSet<Difficulty> given = EnumSet.of(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD);
        Difficulty result = Difficulty.calculateNextDifficulty(given);
        assertNull(result);
    }

}