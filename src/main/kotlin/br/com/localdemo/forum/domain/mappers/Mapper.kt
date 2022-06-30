package br.com.localdemo.forum.domain.mappers

interface Mapper<T, U> {

    fun map(t: T): U
}