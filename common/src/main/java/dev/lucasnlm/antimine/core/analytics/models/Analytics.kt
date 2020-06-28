package dev.lucasnlm.antimine.core.analytics.models

import dev.lucasnlm.antimine.common.level.models.Difficulty
import dev.lucasnlm.antimine.common.level.models.Score
import dev.lucasnlm.antimine.common.level.models.Minefield

sealed class Analytics(
    val title: String,
    val extra: Map<String, String> = mapOf()
) {
    class Open : Analytics("Open game")

    class NewGame(
        minefield: Minefield,
        difficulty: Difficulty,
        seed: Long,
        useAccessibilityMode: Boolean
    ) : Analytics(
        "New Game",
        mapOf(
            "Seed" to seed.toString(),
            "Difficulty Preset" to difficulty.text,
            "Width" to minefield.width.toString(),
            "Height" to minefield.height.toString(),
            "Mines" to minefield.mines.toString(),
            "Accessibility" to useAccessibilityMode.toString()
        )
    )

    class RetryGame(
        minefield: Minefield,
        difficulty: Difficulty,
        seed: Long,
        useAccessibilityMode: Boolean,
        firstOpen: Int
    ) : Analytics(
        "Retry Game",
        mapOf(
            "Seed" to seed.toString(),
            "Difficulty Preset" to difficulty.text,
            "Width" to minefield.width.toString(),
            "Height" to minefield.height.toString(),
            "Mines" to minefield.mines.toString(),
            "Accessibility" to useAccessibilityMode.toString(),
            "First Open" to firstOpen.toString()
        )
    )

    class ResumePreviousGame : Analytics("Resume previous game")

    class OpenTile(index: Int) : Analytics("Open Tile", mapOf("Index" to index.toString()))

    class SwitchMark(index: Int) : Analytics("Switch Mark", mapOf("Index" to index.toString()))

    class HighlightNeighbors(index: Int) : Analytics("Highlight Neighbors", mapOf("Index" to index.toString()))

    class OpenNeighbors(index: Int) : Analytics("Open Neighbors", mapOf("Index" to index.toString()))

    class GameOver(time: Long, score: Score) : Analytics(
        "Game Over",
        mapOf(
            "Time" to time.toString(),
            "Right Mines" to score.rightMines.toString(),
            "Total Mines" to score.totalMines.toString(),
            "Total Area" to score.totalArea.toString()
        )
    )

    class Victory(time: Long, score: Score, difficulty: Difficulty) : Analytics(
        "Victory",
        mapOf(
            "Time" to time.toString(),
            "Difficulty" to difficulty.text,
            "Right Mines" to score.rightMines.toString(),
            "Total Mines" to score.totalMines.toString(),
            "Total Area" to score.totalArea.toString()
        )
    )

    class Resume : Analytics("Back to the game")

    class Quit : Analytics("Quit game")

    class OpenDrawer : Analytics("Opened Drawer")

    class CloseDrawer : Analytics("Closed Drawer")

    class OpenAbout : Analytics("Open About")

    object OpenThemes : Analytics("Open Themes")

    class OpenStats : Analytics("Open Stats")

    class OpenSettings : Analytics("Open Settings")

    class OpenSaveHistory : Analytics("Open Save History")

    class ShowRatingRequest(usages: Int) : Analytics("Shown Rating Request", mapOf("Usages" to usages.toString()))

    class TapRatingRequest(from: String) : Analytics("Rating Request", mapOf("From" to from))

    class TapGameReset(resign: Boolean) : Analytics("Game reset", mapOf("Resign" to resign.toString()))
}
