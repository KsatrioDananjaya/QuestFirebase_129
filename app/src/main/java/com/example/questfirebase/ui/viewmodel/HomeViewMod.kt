package com.example.questfirebase.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.example.questfirebase.model.Mahasiswa
import com.example.questfirebase.repo.RepoMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

sealed class HomeUiState {
    data class Success(val mahasiswa: List<Mahasiswa>) : HomeUiState()
    data class Error(val exception: Throwable) : HomeUiState()
    object Loading : HomeUiState()
}

class HomeViewMod(
    private val mhs: RepoMhs
):ViewModel() {
    var mhsUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
    private set
    init {
        getMhs()
    }
    fun getMhs() {
        viewModelScope.launch {
            mhs.getAllMahasiswa()
                .onStart{
                    mhsUiState = HomeUiState.Loading
                }
                .catch{
                    mhsUiState = HomeUiState.Error(it)
                }
                .collect{
                    mhsUiState = if (it.isEmpty()) {
                        HomeUiState.Error(Exception("Belum ada daftar mahasiswa"))
                    }else{
                        HomeUiState.Success(it)
                    }
                }
        }
    }
    fun deleteMahasiswa(mahasiswa: Mahasiswa){
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(mahasiswa)
            }catch (e: Exception){
                mhsUiState = HomeUiState.Error(e)
            }
        }

    }
}

