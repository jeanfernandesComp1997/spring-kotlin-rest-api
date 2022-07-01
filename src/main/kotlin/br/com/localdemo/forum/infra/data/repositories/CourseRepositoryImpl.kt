package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.Course
import org.springframework.stereotype.Service

//@Service
//class CourseRepositoryImpl : CourseRepository {
//
//    private val courses: List<Course> get() = data.toList()
//
//    companion object {
//        private val data = mutableListOf<Course>()
//    }
//
//    init {
//        data.add(
//            Course(
//                id = 1,
//                name = "Kotlin",
//                category = "Software Development"
//            )
//        )
//    }
//
//    override fun getById(id: Long): Course {
//        return courses.first { course ->
//            course.id == id
//        }
//    }
//}