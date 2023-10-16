package com.duongvn.politicalpreparedness.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class VoterInfoResponse (
    val election: ElectionRemote,
    val pollingLocations: String? = null, //TODO: Future Use
    val contests: String? = null, //TODO: Future Use
    val state: List<State>? = null,
    val electionElectionOfficials: List<ElectionOfficial>? = null
)