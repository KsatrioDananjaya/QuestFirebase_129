package com.example.questfirebase.di

import com.example.questfirebase.repo.NetworkRepoMhs
import com.example.questfirebase.repo.RepoMhs
import com.google.firebase.firestore.FirebaseFirestore

interface  AppContainer{
    val repoMhs: RepoMhs
}
class MhsContainer {
    private  val firebase: FirebaseFirestore = FirebaseFirestore.getInstance()
    override val repoMhs : RepoMhs by lazy {
        NetworkRepoMhs(firebase)
    }
}