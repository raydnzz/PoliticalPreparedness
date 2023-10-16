package com.duongvn.politicalpreparedness.network.models

import androidx.room.*
import com.squareup.moshi.*

@Entity(tableName = "election_table")
data class Election(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "electionDay") val electionDay: String,
    @ColumnInfo(name = "ocdDivisionId") val ocdDivisionId: String,
    @Embedded(prefix = "division_") @Json(name = "ocdDivisionId") val division: Division,
)