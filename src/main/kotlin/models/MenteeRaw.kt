package models
/**
 * Data class representing raw mentee data from CSV
 * @property menteeId Unique identifier for the mentee
 * @property name Name of the mentee
 * @property teamId Team identifier the mentee belongs to
 */
data class MenteeRaw(
    val menteeId: String,
    val name: String,
    val teamId: String
)

