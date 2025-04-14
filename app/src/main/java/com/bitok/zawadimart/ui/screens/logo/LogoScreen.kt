package com.bitok.zawadimart.ui.screens.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitok.zawadimart.R
import com.bitok.zawadimart.ui.theme.ddblue
import com.bitok.zawadimart.ui.theme.newOrange
import com.bitok.zawadimart.ui.theme.newWhite

@Composable
fun LogoScreen(navController: NavController){
     Column(
          modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).background(ddblue),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center,



          ) {

          Spacer(modifier = Modifier.height(40.dp))

          Row {
               Image(

                    painter = painterResource(R.drawable.img_4),
                    contentDescription = "home",
                    modifier = Modifier
                         .width(50.dp)
                         .height(50.dp),

                    contentScale = ContentScale.FillWidth
               )
               Spacer(modifier = Modifier.width(10.dp))


               Text(text = "Logo App",
                    fontSize = 30.sp,
                    color = Color.White,
               )
          }

          Spacer(modifier = Modifier.height(20.dp))


          Image(
               painter = painterResource(R.drawable.img_5),
               contentDescription = "home",
               modifier = Modifier.size(200.dp)
          )



          Spacer(modifier = Modifier.height(100.dp))


          // box
          Box() {
               Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,

                    ){
                    //card
                    Card (
                         modifier = Modifier.fillMaxWidth().height(500.dp),

                         shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                         colors = CardDefaults.cardColors(newWhite),


                         ) {

                         Text(
                              modifier = Modifier.padding(start = 80.dp, end = 80.dp),
                              text = "The Most Worth ",
                              fontSize = 30.sp,
                              color = Color.Red,
                              textAlign = TextAlign.Center
                         )


                         Text(text = "Grocery App ",
                              fontSize = 30.sp,
                              color = Color.Red,
                              modifier = Modifier.padding(start = 100.dp, end = 100.dp),
                         )

                         //variables

                         var username by remember { mutableStateOf("") }
                         var  password by remember { mutableStateOf("") }



                         Spacer(modifier = Modifier.height(10.dp))

                         Column (
                              horizontalAlignment = Alignment.CenterHorizontally,
                              verticalArrangement = Arrangement.Center,){

                              OutlinedTextField(
                                   value = username,
                                   onValueChange = {username = it},
                                   modifier = Modifier.fillMaxWidth().padding(20.dp, end = 20.dp),
                                   label = { Text(text = "Username",modifier = Modifier.fillMaxWidth().padding(start =100.dp, end = 100.dp),

                                        )},
                                   colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = newOrange,
                                        focusedLabelColor = newOrange,
                                        unfocusedBorderColor = Color.Black
                                   ),
                                   shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp , bottomEnd = 30.dp , bottomStart = 30.dp),
                                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                              )
                              //end
                              Spacer(modifier = Modifier.height(10.dp))

                              //password
                              OutlinedTextField(
                                   value = password,
                                   onValueChange =  {password = it},
                                   modifier = Modifier.fillMaxWidth().padding(20.dp, end = 20.dp),
                                   label = { Text(text = "password", modifier = Modifier.fillMaxWidth().padding(start =100.dp, end = 100.dp)
                                   ) },


                                   colors = OutlinedTextFieldDefaults.colors(
                                        focusedBorderColor = newOrange,
                                        focusedLabelColor = newOrange,
                                        unfocusedBorderColor = Color.Black,

                                        ),
                                   shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp , bottomEnd = 30.dp , bottomStart = 30.dp),
                                   keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                                   visualTransformation = PasswordVisualTransformation()
                              )
                              //end
                              Spacer(modifier = Modifier.height(10.dp))

                         }



                         Spacer (modifier = Modifier.height(10.dp))

                         Button (onClick = {

                         },
                              colors = ButtonDefaults.buttonColors(newOrange),
                              shape = RoundedCornerShape(100.dp),
                              modifier = Modifier.fillMaxWidth().padding(start =50.dp, end = 50.dp),


                              ) {
                              Text( text = "Sign up")
                         }
                         Spacer (modifier = Modifier.height(10.dp))




                         Column(
                              modifier = Modifier.fillMaxSize(),
                              horizontalAlignment = Alignment.CenterHorizontally,
                         ){


                              Text(text = " Already are Members?  ",
                                   fontSize = 10.sp,



                              )
                              Text(text = "Log in",
                                   fontSize = 10.sp,
                                   color = Color.Red
                                   )

                         }



                    }
               }


          }
     }

}

@Preview(showBackground = true)
@Composable
fun LogoScreenPreview(){
     LogoScreen(rememberNavController())

}