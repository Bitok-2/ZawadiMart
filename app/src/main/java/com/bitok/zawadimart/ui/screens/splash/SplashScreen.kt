package com.bitok.zawadimart.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitok.zawadimart.R
import com.bitok.zawadimart.navigation.ROUT_LOGIN
import com.bitok.zawadimart.navigation.ROUT_START
import com.bitok.zawadimart.ui.theme.newBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){
    //Navigation
    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(3000)
        navController.navigate(ROUT_LOGIN)
    }

    //End of Navigation
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(newBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(R.drawable.cart),
            contentDescription = "shopping",
            modifier = Modifier.size(300.dp)
        )

    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
   SplashScreen(rememberNavController())

}