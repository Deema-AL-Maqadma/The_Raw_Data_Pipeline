/**
 * Parser functions for reading CSV files and converting to data objects
 */
import models.PerformanceRaw
import models.TeamRaw
import models.MenteeRaw
import java.io.File

val csvfiles = File("src/main/resources/teams.csv").readLines()

// This function to parse team data.
fun parseTeamData(): List<TeamRaw>? {

    // Check if the file isExists or not.
    if (!csvfiles.isEmpty()){
        println("This file not exists.")
        return emptyList()
    }

    // Read the file  and data processing.
    return csvfiles.drop(1) // Skip header row
        .map { line ->
            val teamParts = line.split(",")
            if (teamParts.size >= 3) {
                TeamRaw(
                    teamId = teamParts[0].trim(),
                    teamName = teamParts[1].trim(),
                    mentorLead = teamParts[2].trim()
                )
            } else {
                return null
            }
        }
}

/**
 * Parses mentees.csv file and returns list of MenteeRaw objects
 * @return List of MenteeRaw objects
 */

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



/**
 * Parses performance.csv file and returns list of PerformanceRaw objects
 * @return List of PerformanceRaw objects
 */
fun parsePerformanceData(): List<PerformanceRaw> {
    val lines = File("src/main/resources/performance.csv").readLines()
    return lines.drop(1) // Skip header row
        .mapNotNull { line ->
            val parts = line.split(",")
            if (parts.size >= 4) {
                PerformanceRaw(
                    menteeId = parts[0].trim(),
                    submissionId = parts[1].trim(),
                    submissionType = parts[2].trim(),
                    score = parts[3].trim() // Keep as String per requirements
                )
            } else {
                null // Skip invalid rows
            }
        }
}