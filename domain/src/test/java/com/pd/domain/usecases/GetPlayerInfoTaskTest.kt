package com.pd.domain.usecases

import com.pd.domain.entities.PlayerEntity
import com.pd.domain.repository.PlayerInfoRepository
import com.pd.domain.utils.TestDataGenerator
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPlayerInfoTaskTest {
    private lateinit var SUT: GetPlayerInfoTask
    private val playerName: String = "Messi"

    @Mock
    private lateinit var playerInfoRepository: PlayerInfoRepository

    @Throws(Exception::class)
    @Before
    fun setup() {
        SUT = GetPlayerInfoTask(playerInfoRepository,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )
    }

    @Test
    fun generateObservable_success_successReturned() {
        // Arrange
        val playerEntity = TestDataGenerator.generatePlayerEntity()
        Mockito.`when`(playerInfoRepository.playerInfo(playerName)).thenReturn(Observable.just(playerEntity))
        val argumentCaptor: ArgumentCaptor<String> = ArgumentCaptor.forClass(String::class.java)
        // Act
        SUT.buildUseCase(playerName)
        // Assert
        Mockito.verify(playerInfoRepository).playerInfo(argumentCaptor.capture())
        Assert.assertThat(argumentCaptor.value, CoreMatchers.`is`(playerEntity.playerName))
    }

    @Test
    fun generateObservable_failure_failureReturned() {
        // Arrange
        // Act
        // Assert
    }

    private fun success(){

    }
}