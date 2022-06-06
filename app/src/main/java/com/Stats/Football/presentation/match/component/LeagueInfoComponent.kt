package com.Stats.Football.presentation.match.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.Stats.Football.common.MyDateTimeFormat
import com.Stats.Football.domain.model.MatchModel
import com.Stats.Football.presentation.ui.theme.TealColor

@Composable
fun LeagueInfoComponent(match: MatchModel) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = match.league.name,
            style = MaterialTheme.typography.subtitle1
        )
        Row {
            Text(
                text = MyDateTimeFormat.timeFormat(match.time.toLong() * 1000),
                style = MaterialTheme.typography.subtitle1
                    .copy(color = TealColor)
            )
            Text(
                text = MyDateTimeFormat.dateFormat(match.time.toLong() * 1000),
                style = MaterialTheme.typography.body1
                    .copy(color = TealColor),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }
}