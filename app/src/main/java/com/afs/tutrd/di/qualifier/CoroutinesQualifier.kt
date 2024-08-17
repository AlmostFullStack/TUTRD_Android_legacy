package com.afs.tutrd.di.qualifier

import javax.inject.Qualifier

/**
 * 디스패처 주입을 구분하기 위해 사용되는 qualifier
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher