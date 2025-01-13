package com.example.questfirebase.ui.viewmodel

import com.example.questfirebase.model.Mahasiswa
import java.lang.Exception

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    data class Error(val exception: Throwable) : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewMod {

}