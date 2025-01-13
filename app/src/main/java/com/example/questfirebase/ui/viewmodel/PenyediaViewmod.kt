package com.example.questfirebase.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questfirebase.MhsApp

object PenyediaViewmod {
    val Factory = viewModelFactory {
        initializer {
            HomeViewMod(
                aplikasiMahasiswa().container.repoMhs
            )
        }
        initializer {
            InsertViewMod(
                aplikasiMahasiswa().container.repoMhs
            )
        }
    }
    fun CreationExtras.aplikasiMahasiswa(): MhsApp =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MhsApp)
}