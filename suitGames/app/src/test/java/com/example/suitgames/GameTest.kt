package com.example.suitgames

import org.junit.Assert
import org.junit.Test

class GameTest {
    @Test
    fun testPickRandomOption() {
        val options = listOf("SCISSORS", "ROCK", "PAPER")
        Assert.assertTrue(options.contains(Game.pickRandomOption()))
    }

    @Test
    fun testPickDrawable() {
        Assert.assertEquals(R.drawable.paper, Game.pickDrawable("PAPER"))
        Assert.assertEquals(R.drawable.rock, Game.pickDrawable("ROCK"))
        Assert.assertEquals(R.drawable.scissors, Game.pickDrawable("SCISSORS"))
    }

    @Test
    fun testIsDraw() {
        Assert.assertTrue(Game.isDraw("PAPER", "PAPER"))
        Assert.assertTrue(Game.isDraw("ROCK", "ROCK"))
        Assert.assertTrue(Game.isDraw("SCISSORS", "SCISSORS"))

        Assert.assertFalse(Game.isDraw("PAPER", "ROCK"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "PAPER"))
    }

    @Test
    fun testIsWin() {
        Assert.assertTrue(Game.isWin("PAPER", "ROCK"))
        Assert.assertTrue(Game.isWin("SCISSORS", "PAPER"))
        Assert.assertTrue(Game.isWin("ROCK", "SCISSORS"))

        Assert.assertFalse(Game.isDraw("PAPER", "SCISSORS"))
        Assert.assertFalse(Game.isDraw("ROCK", "PAPER"))
        Assert.assertFalse(Game.isDraw("SCISSORS", "ROCK"))
    }
}