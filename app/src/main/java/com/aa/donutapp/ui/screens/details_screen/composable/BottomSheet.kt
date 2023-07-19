package com.aa.donutapp.ui.screens.details_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.donutapp.R
import com.aa.donutapp.ui.screens.details_screen.DetailsUiState
import com.aa.donutapp.ui.screens.details_screen.DetailsViewModel
import com.aa.donutapp.ui.theme.Background
import com.aa.donutapp.ui.theme.Inter
import com.aa.donutapp.ui.theme.OnPrimary
import com.aa.donutapp.ui.theme.Secondary
import com.aa.donutapp.ui.theme.textSize14
import com.aa.donutapp.ui.theme.textSize18
import com.aa.donutapp.ui.theme.textSize20
import com.aa.donutapp.ui.theme.textSize22
import com.aa.donutapp.ui.theme.textSize30
import com.aa.donutapp.ui.theme.textSize32

@Composable
fun BottomSheet(
    state: DetailsUiState,
    viewModel: DetailsViewModel
) {
    Box(
        modifier = Modifier.size(width = 428.dp, height = 513.dp)

    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .size(width = 428.dp, height = 490.dp)
                .background(Background)
                .align(Alignment.BottomCenter)

        ) {

            Text(
                text = state.title,
                    fontSize = textSize30,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = OnPrimary,
                    modifier = Modifier.padding(top = 35.dp, start = 16.dp)
                )

            Text(
                text = "About Gonut",
                    fontSize = textSize18,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xCC000000),
                    modifier = Modifier.padding(top = 33.dp, start = 16.dp)
            )

            Text(
                text = state.description,
                    fontSize = textSize14,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Secondary,
                    letterSpacing = 0.7.sp,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                text = "Quantity",
                    fontSize = textSize18,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xCC000000),
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp)
            )
            Row() {
                Box(
                    Modifier
                        .clickable { viewModel.reduceDonutQuantity() }
                        .padding(top = 20.dp, start = 16.dp)
                        .width(45.dp)
                        .height(45.dp)
                        .background(color = Background, shape = RoundedCornerShape(size = 16.dp))

                ) {

                    Text(
                        text = "-",
                        fontSize = textSize32,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Box(
                    Modifier
                        .padding(top = 20.dp, start = 16.dp)
                        .width(45.dp)
                        .height(45.dp)
                        .background(color = Background, shape = RoundedCornerShape(size = 16.dp))

                ) {

                    Text(
                        text = state.quantity.toString(),
                        fontSize = textSize22,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Box(
                    Modifier
                        .clickable { viewModel.addDonut() }
                        .padding(top = 20.dp, start = 16.dp)
                        .width(45.dp)
                        .height(45.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(size = 16.dp))

                ) {

                    Text(
                        text = "+",
                        fontSize = textSize22,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = "£ ${state.price.toString()}",
                    fontSize = 30.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 44.dp, start = 16.dp, end = 26.dp)
                        .align(CenterVertically)
                )

                Button( onClick = { },
                    modifier = Modifier.padding(top = 44.dp, start = 16.dp)
                        .width(268.dp)
                        .height(67.dp),
                    colors = ButtonDefaults.buttonColors(OnPrimary)
                ) {
                    Text(
                        text = "Add to Cart",
                            fontSize = textSize20,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                        )
                }
            }


        }

        Box(
            Modifier
                .padding(end = 20.dp)
                .shadow(
                    elevation = 20.dp,
                )
                .width(45.dp)
                .height(45.dp)
                .background(Background, shape = RoundedCornerShape(16.dp))
                .align(Alignment.TopEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "Fav",
                tint = OnPrimary ,
                modifier = Modifier.align(Alignment.Center),
            )

        }

    }
}


//@Preview
//@Composable
//fun PreviewBottomSheet() {
//    BottomSheet()
//}