package br.com.localdemo.forum.infra.data.repositories

//@Service
//class UserRepositoryImpl : UserRepository {
//
//    private val users: List<User> get() = data.toList()
//
//    companion object {
//        private val data = mutableListOf<User>()
//    }
//
//    init {
//        data.add(
//            User(
//                id = 1,
//                name = "Jean Fernandes",
//                email = "jean@email.com.br"
//            )
//        )
//    }
//
//    override fun getById(id: Long): User {
//        return users.first { user ->
//            user.id == id
//        }
//    }
//}