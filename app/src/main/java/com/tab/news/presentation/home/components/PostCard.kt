package com.tab.news.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tab.news.R
import com.tab.news.domain.model.Content
import com.tab.news.ui.theme.Charcoal
import com.tab.news.ui.theme.CharcoalLighter

@Composable
fun PostCard(
    post: Content
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = CharcoalLighter,
                shape = RoundedCornerShape(8.dp)
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Charcoal)
                .padding(horizontal = 25.dp, vertical = 20.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = post.username,
                    color = Color.White,
                    fontSize = 15.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_comment),
                        tint = Color.White,
                        contentDescription = null,
                        modifier = Modifier
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = post.childrenDeepCount.toString(),
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = post.title,
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 3.dp)
            )
        }
    }
}

@Preview
@Composable
fun previewPostCard() {
    PostCard(
        post = Content(
            id = "1",
            ownerId = "1",
            slug = "abc",
            title = "abc",
            body = "abc",
            createdAt = "abc",
            updatedAt = "abc",
            publishedAt = "abc",
            username = "abc",
            childrenDeepCount = 3
        )
    )
}