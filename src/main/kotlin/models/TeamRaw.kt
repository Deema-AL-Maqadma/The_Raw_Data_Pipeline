package models
/**
 * Data class representing raw team data from CSV
 * @property teamId Unique identifier for the team
 * @property teamName Name of the team
 * @property mentorLead Lead mentor for the team
 */
data class TeamRaw(
    val teamId: String,
    val teamName: String,
    val mentorLead: String
)

