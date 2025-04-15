package com.bitok.zawadimart.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bitok.zawadimart.data.UserDatabase
import com.bitok.zawadimart.repository.UserRepository
import com.bitok.zawadimart.ui.screens.about.AboutScreen
import com.bitok.zawadimart.ui.screens.auth.LoginScreen
import com.bitok.zawadimart.ui.screens.auth.RegisterScreen
import com.bitok.zawadimart.ui.screens.crypto.CryptoScreen
import com.bitok.zawadimart.ui.screens.dashboard.DashboardScreen
import com.bitok.zawadimart.ui.screens.form.FormScreen
import com.bitok.zawadimart.ui.screens.home.HomeScreen
import com.bitok.zawadimart.ui.screens.intent.IntentScreen
import com.bitok.zawadimart.ui.screens.item.ItemScreen
import com.bitok.zawadimart.ui.screens.service.ServiceScreen
import com.bitok.zawadimart.ui.screens.splash.SplashScreen
import com.bitok.zawadimart.ui.screens.start.StartScreen
import com.bitok.zawadimart.viewmodel.AuthViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }
        composable(ROUT_START) {
            StartScreen(navController)
        }
        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }
        composable(ROUT_SERVICE) {
            ServiceScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_CRYPTO) {
            CryptoScreen(navController)
        }
        composable(ROUT_FORM) {
           FormScreen(navController)
        }

        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }



    }
}