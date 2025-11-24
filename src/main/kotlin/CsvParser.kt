
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


// Parse team data from teams.csv
fun parseTeamData(): List<TeamRaw>? {
    if (!validateFile(teamFileLines, "teams.csv")) return emptyList()

    return teamFileLines.drop(1) // Skip header row
        .map { line ->
            val teamParts = line.split(",")
            if (teamParts.size >= 3) {
                TeamRaw(
                    id = teamParts[0].trim(),
                    name = teamParts[1].trim(),
                    mentorLead = teamParts[2].trim()
                )
            } else {
                null
            }
        }
}

// Parse team data from teams.csv
fun parseMenteeData(): List<MenteeRaw>? {
    if (!validateFile(menteeFileLines, "mentees.csv")) return emptyList()

    return menteeFileLines.drop(1) // Skip header row
        .map { line ->
            val menteeParts = line.split(",")
            if (menteeParts.size >= 3) {
                MenteeRaw(
                    id = menteeParts[0].trim(),
                    name = menteeParts[1].trim(),
                    teamId = menteeParts[2].trim()
                )
            } else {
                null
            }
        }
}


 // Parse performance data from performance.csv
fun parsePerformanceData(): List<PerformanceRaw>? {
    if (!validateFile(performanceFileLines, "performance.csv")) return emptyList()

    return performanceFileLines.drop(1) // Skip header row
        .map { line ->
            val performanceParts = line.split(",")
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



