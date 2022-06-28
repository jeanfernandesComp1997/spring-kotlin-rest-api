package br.com.localdemo.forum.domain.interfaces.repositories

import br.com.localdemo.forum.domain.entities.Course

interface CourseRepository {

    fun getById(id: Long): Course
}