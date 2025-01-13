package com.example.questfirebase.repo
import kotlinx.coroutines.flow.Flow
import com.example.questfirebase.model.Mahasiswa

interface RepoMhs {
    suspend fun getAllMahasiswa(): Flow<List<Mahasiswa>>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)
    suspend fun getMahasiswaByNim(nim: String): Flow<Mahasiswa>
}