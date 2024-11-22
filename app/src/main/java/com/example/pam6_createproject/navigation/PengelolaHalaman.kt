package com.example.pam6_createproject.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam6_createproject.ui.view.screen.MahasiswaFormView
import com.example.pam6_createproject.ui.view.screen.MatakuliahView
import com.example.pam6_createproject.ui.view.screen.SplashView
import com.example.pam6_createproject.ui.view.screen.TampilView
import com.example.pam6_createproject.ui.view.viewmodel.MahasiswaViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
    }

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uistate by viewModel.statusUI.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        // Splash Screen
        composable(
            route = Halaman.Splash.name
        ) {
            SplashView(
                onMulaiButton = {
                    navController.navigate(Halaman.Mahasiswa.name)
                }
            )
        }

        // Mahasiswa Form Screen
        composable(
            route = Halaman.Mahasiswa.name
        ) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    viewModel.setMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }


