
// Parser functions for reading CSV files and converting to data objects

import models.PerformanceRaw
import models.TeamRaw
import models.MenteeRaw
import java.io.File
// Constants: read CSV files once
val teamFileLines = File("src/main/resources/teams.csv").readLines()
val menteeFileLines = File("src/main/resources/mentees.csv").readLines()
val performanceFileLines = File("src/main/resources/performance.csv").readLines()

// Utility function to check if file lines are empty
fun validateFile(lines: List<String>, fileName: String): Boolean {
    if (lines.isEmpty()) {
        println("File $fileName does not exist or is empty.")
        return false
    }
    return true
}
/**
 * Parses teams.csv file and returns list of TeamRaw objects
 * @return List of TeamRaw objects
 */
fun parseTeamData(): List<TeamRaw> {
    val lines = File("src/main/resources/teams.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { lines ->
            val parts = lines.split(",")
            if (parts.size >= 3) {
                TeamRaw(
                    teamId = parts[0].trim(),
                    teamName = parts[1].trim(),
                    mentorLead = parts[2].trim()
                )
            } else {
                null // Skip invalid rows
            }
        }
}

/**
 * Parses mentees.csv file and returns list of MenteeRaw objects
 * @return List of MenteeRaw objects
 */


// This function to parse mentee data.
fun parseMenteeData(): List<MenteeRaw> {
    val lines = File("src/main/resources/mentees.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { line ->
            val parts = line.split(",")
            if (parts.size >= 3) {
                val (id, name, team) = parts.map { it.trim() }
                MenteeRaw(id, name, team)
            } else {
                null // Skip invalid rows
            }
        }
}

 // Parse performance data from performance.csv
fun parsePerformanceData(): List<PerformanceRaw>? {
    if (!validateFile(performanceFileLines, "performance.csv")) return emptyList()

    return performanceFileLines.drop(1) // Skip header row
        .map { line ->
            val parts = line.split(",")
            if (parts.size >= 4) {
                PerformanceRaw(
                    menteeId = parts[0].trim(),
                    submissionId = parts[1].trim(),
                    submissionType = parts[2].trim(),
                    score = parts[3].trim()
                )
            } else {
                null
            }
        }
}



